package es.cylicon.yourcommitment.activity;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.adapter.DonationAdapter;
import es.cylicon.yourcommitment.model.Proyect;
import es.cylicon.yourcommitment.model.User;

@ContentView(R.layout.activity_user)
public class UserActivity extends RoboFragmentActivity implements
		OnItemClickListener {

	private static final String MONEDA = " EUROS";
	private static final int DETALLE_PROYECTO = 0;

	@InjectView(R.id.userName)
	private TextView userName;

	@InjectView(R.id.saldo)
	private TextView amount;

	@InjectView(R.id.amountLeft)
	private TextView amountLeft;

	@InjectView(android.R.id.list)
	private ListView listView;

	@InjectView(R.id.seekBar1)
	protected SeekBar selector;

	private User user;
	private DonationAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final YourCommitmentApplication application = (YourCommitmentApplication) getApplication();
		user = application.getCurrentUser();
		if (user != null) {
			userName.setText(user.getUsername());

			final Double cantidad = user.getAmount();
			amount.setText((cantidad == null ? 0 : cantidad.toString())
					+ MONEDA);
			amountLeft
					.setText(user.getAmountLeft() + getString(R.string.euros));

			selector.setProgress(user.getAmount().intValue());

		}
		selector.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(final SeekBar seekBar) {
				final ParseQuery query = new ParseQuery("user");
				query.getInBackground(user.getId(), new GetCallback() {
					@Override
					public void done(final ParseObject object,
							final ParseException e) {
						if (e == null) {
							object.put("amount",
									Double.valueOf(seekBar.getProgress()));
							object.saveInBackground();
						}
					}
				});
				user.getUserObject().saveInBackground(new SaveCallback() {
					@Override
					public void done(final ParseException e) {
						user.getUserObject().put("amount",
								Double.valueOf(seekBar.getProgress()));
						user.getUserObject().saveInBackground();
					}
				});
			}

			@Override
			public void onStartTrackingTouch(final SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(final SeekBar seekBar,
					final int progress, final boolean fromUser) {
				amount.setText(progress + MONEDA);
				user.setAmount(Double.valueOf(seekBar.getProgress()));
				amountLeft.setText(user.getAmountLeft()
						+ getString(R.string.euros));
			}
		});

		adapter = new DonationAdapter(this, user.getDonations());
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(final AdapterView<?> arg0, final View arg1,
			final int posicion, final long arg3) {
		final Intent intent = new Intent(this, DetailProyectActivity.class);
		final ParseQuery query = new ParseQuery("Proyect");
		ParseObject proyect;
		try {
			proyect = query.whereEqualTo("objectId",
					user.getDonations().get(posicion).getProyect().getId())
					.getFirst();
			intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
			intent.putExtra("proyect", new Proyect(proyect));
			startActivityForResult(intent, DETALLE_PROYECTO);
		} catch (final ParseException e) {
			Toast.makeText(this, "No se ha podido recuperar el proyecto",
					Toast.LENGTH_SHORT).show();
		}
	}

}

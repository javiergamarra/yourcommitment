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
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.adapter.DonationAdapter;
import es.cylicon.yourcommitment.model.User;

@ContentView(R.layout.activity_user)
public class UserActivity extends RoboFragmentActivity implements
		OnItemClickListener {

	private static final String MONEDA = " EUROS";
	private static final int DETALLE_PROYECTO = 0;

	@InjectView(R.id.userName)
	private TextView userName;

	@InjectView(R.id.userEmail)
	private TextView userEmail;

	@InjectView(R.id.userAmount)
	private TextView amount;

	@InjectView(R.id.userAmountLeft)
	private TextView amountLeft;

	@InjectView(android.R.id.list)
	private ListView listView;

	// @InjectView(R.id.selector)
	protected SeekBar selector;

	private User user;
	private DonationAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final YourCommitmentApplication application = (YourCommitmentApplication) getApplication();
		user = application.getCurrentUser();

		userName.setText(user.getUsername());
		userEmail.setText(user.getEmail());

		final Double cantidad = user.getAmount();
		amount.setText((cantidad == null ? 0 : cantidad.toString()) + MONEDA);
		amountLeft.setText(user.getAmountLeft().toString() + MONEDA);

		selector.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(final SeekBar seekBar) {
			}

			@Override
			public void onStartTrackingTouch(final SeekBar seekBar) {
			}

			@Override
			public void onProgressChanged(final SeekBar seekBar,
					final int progress, final boolean fromUser) {
				amount.setText(progress + MONEDA);
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
		intent.putExtra("proyectId", user.getDonations().get(posicion)
				.getProyect().getId());
		startActivityForResult(intent, DETALLE_PROYECTO);
	}

}

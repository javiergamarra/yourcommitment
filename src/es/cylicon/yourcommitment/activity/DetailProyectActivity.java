package es.cylicon.yourcommitment.activity;

import roboguice.inject.InjectView;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.UpdateActivity;
import es.cylicon.yourcommitment.model.Donation;
import es.cylicon.yourcommitment.model.Proyect;
import es.cylicon.yourcommitment.model.User;

public class DetailProyectActivity extends MenuActivity implements
		android.view.View.OnClickListener {

	private Proyect proyect;
	@InjectView(R.id.amountLeft)
	private TextView amountLeft;
	@InjectView(R.id.address)
	private TextView address;
	@InjectView(R.id.proyectName)
	private TextView name;
	@InjectView(R.id.description)
	private TextView description;
	@InjectView(R.id.terminado)
	private TextView terminado;
	@InjectView(R.id.recaudado)
	private TextView recaudado;
	@InjectView(R.id.total)
	private TextView total;
	@InjectView(R.id.progressBar)
	private ProgressBar progressBar;
	@InjectView(R.id.updates)
	private Button updates;
	@InjectView(R.id.donateButton)
	private Button donateButton;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_proyect);

		proyect = (Proyect) getIntent().getExtras().getSerializable("proyect");
		address.setText(proyect.getAddress());
		name.setText(proyect.getName());
		description.setText(proyect.getDescription());
		progressBar.setProgress(proyect.getDoublePercentage().intValue());
		terminado.setText(proyect.getPercentage() + "%");
		recaudado.setText(proyect.getAmount() == null ? "0.0" : proyect
				.getAmount().toString() + getString(R.string.euros));
		total.setText(proyect.getTotalAmount() == null ? "0.0" : proyect
				.getTotalAmount().toString() + getString(R.string.euros));

		updates.setOnClickListener(this);
		donateButton.setOnClickListener(this);

	}

	private void insertDonation(final Double amount, final User currentUser) {
		final Donation donation = new Donation("Donación", proyect.getName(),
				proyect.getId(), currentUser.getId());
		donation.setAmount(amount);
		donation.setProyect(proyect);
		try {
			donation.getDonationObject().save();
			currentUser.getDonations().add(donation);
			currentUser.setAmount(currentUser.getAmount() - amount);
			final ParseQuery query = new ParseQuery("user");
			query.getInBackground(currentUser.getId(), new GetCallback() {
				@Override
				public void done(final ParseObject object,
						final ParseException e) {
					if (e == null) {
						object.increment("amount", -amount);
						object.saveInBackground();
						amountLeft.setText(currentUser.getAmount()
								+ getString(R.string.euros));
					}
				}
			});
			final ParseQuery proyectQuery = new ParseQuery("Proyect");
			proyect.setAmount(proyect.getAmount() + amount);
			proyectQuery.getInBackground(proyect.getId(), new GetCallback() {
				@Override
				public void done(final ParseObject object,
						final ParseException e) {
					if (e == null) {
						object.increment("amount", amount);
						object.saveInBackground();
						terminado.setText(proyect.getPercentage() + "%");
						recaudado.setText(proyect.getAmount() == null ? "0.0"
								: proyect.getAmount().toString()
										+ getString(R.string.euros));
					}
				}
			});
		} catch (final ParseException e1) {
			Toast.makeText(this, "No se ha podido guardar el usuario",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onClick(final View v) {
		switch (v.getId()) {
		case R.id.donateButton:

			// custom dialog
			final YourCommitmentApplication application = (YourCommitmentApplication) getApplication();
			final Dialog dialogNew = new Dialog(DetailProyectActivity.this);
			dialogNew.setContentView(R.layout.donate_dialog);
			dialogNew.setTitle("Donar ...");
			final TextView donateProjectName = (TextView) dialogNew
					.findViewById(R.id.donateProjectName);
			donateProjectName.setText(proyect.getName());

			final TextView donateUserBudget = (TextView) dialogNew
					.findViewById(R.id.donateUserBudget);
			final User currentUser = application.getCurrentUser();
			donateUserBudget.setText("Tienes disponibles..."
					+ currentUser.getAmountLeft() + " euros");

			final Button confirmDonateButton = (Button) dialogNew
					.findViewById(R.id.confirmDonateButton);

			// if button is clicked, close the custom dialog
			confirmDonateButton.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(final View v) {
					final EditText donateUserDonation = (EditText) dialogNew
							.findViewById(R.id.donateUserDonation);
					final String textAmount = donateUserDonation.getText()
							.toString();
					final Double amount = Double.parseDouble(textAmount);
					if (currentUser.validAmount(amount)) {
						insertDonation(amount, currentUser);
						application.registerForPushForChannelAndActivity(
								proyect.getName(), ProyectsActivity.class);
						dialogNew.dismiss();
					} else {
						Toast.makeText(DetailProyectActivity.this,
								"No tienes tanto dinero reservado",
								Toast.LENGTH_SHORT).show();
					}
				}
			});

			dialogNew.show();
			break;

		default:

			final Intent intent = new Intent(this, UpdateActivity.class);
			intent.putExtra("projectId", proyect.getId());
			startActivity(intent);
			break;
		}

	}
}
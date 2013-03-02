package es.cylicon.yourcommitment.activity;

import roboguice.inject.InjectView;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.UpdateActivity;
import es.cylicon.yourcommitment.model.Donation;
import es.cylicon.yourcommitment.model.Proyect;

public class DetailProyectActivity extends MenuActivity implements
		android.view.View.OnClickListener {

	@InjectView(R.id.address)
	private TextView address;
	@InjectView(R.id.proyectName)
	private TextView name;
	@InjectView(R.id.description)
	private TextView description;

	@InjectView(R.id.donateUserDonation)
	private EditText donateUserDonation;

	private Proyect proyect;

	@InjectView(R.id.updates)
	private Button updates;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_proyect);

		proyect = (Proyect) getIntent().getExtras().getSerializable("proyect");
		address.setText(proyect.getAddress());
		name.setText(proyect.getName());
		description.setText(proyect.getDescription());
		updates.setOnClickListener(this);

		// Donate
		Button button = (Button) findViewById(R.id.donateButton);
		// add button listener
		button.setOnClickListener(this);

	}

	private void insertDonation() {

		String proyectId = proyect.getId();
		Double amount = Double.parseDouble(donateUserDonation.getText()
				.toString());

		Donation donation = new Donation("Name", "Description", proyectId);
		donation.setAmount(amount);
		donation.setProyect(proyect);

		try {
			donation.getDonationObject().save();
		} catch (final ParseException e1) {
			Toast.makeText(this, "No se ha podido guardar el usuario",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.donateButton:

			// custom dialog
			final Dialog dialogNew = new Dialog(DetailProyectActivity.this);
			dialogNew.setContentView(R.layout.donate_dialog);
			dialogNew.setTitle("Donar ...");

			// set the custom dialog components - text, image and button
			TextView donateProjectName = (TextView) dialogNew
					.findViewById(R.id.donateProjectName);
			donateProjectName.setText("Projecto");

			TextView donateUserBudget = (TextView) dialogNew
					.findViewById(R.id.donateUserBudget);

			YourCommitmentApplication application = (YourCommitmentApplication) getApplication();
			// donateUserBudget.setText(Double.toString(application.getCurrentUser().getAmount()));
			donateUserBudget.setText("345");

			EditText donateUserDonation = (EditText) dialogNew
					.findViewById(R.id.donateUserDonation);

			Button confirmDonateButton = (Button) dialogNew
					.findViewById(R.id.confirmDonateButton);

			// if button is clicked, close the custom dialog
			confirmDonateButton.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					insertDonation();
					dialogNew.dismiss();
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
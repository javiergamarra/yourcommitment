package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import roboguice.inject.InjectView;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.adapter.UpdateAdapter;
import es.cylicon.yourcommitment.model.Donation;
import es.cylicon.yourcommitment.model.Proyect;
import es.cylicon.yourcommitment.model.Update;
import es.cylicon.yourcommitment.model.User;

public class DetailProyectActivity extends MenuActivity {

	private final List<Update> updates = new ArrayList<Update>();
	private UpdateAdapter adapter;

	@InjectView(R.id.address)
	private TextView address;
	@InjectView(R.id.proyectName)
	private TextView name;
	@InjectView(R.id.description)
	private TextView description;
	@InjectView(android.R.id.list)
	private ListView listView;
	@InjectView(R.id.donateUserDonation)
	private EditText donateUserDonation;
	
	
	final Context context = this;
	private Proyect proyect;
	
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_proyect);

		proyect = (Proyect) getIntent().getExtras()
				.getSerializable("proyect");
		loadUpdates(proyect.getId());
		address.setText(proyect.getAddress());
		name.setText(proyect.getName());
		description.setText(proyect.getDescription());

		adapter = new UpdateAdapter(this, android.R.layout.simple_list_item_1,
				updates);
		listView.setAdapter(adapter);

		// Donate
		Button button = (Button) findViewById(R.id.donateButton);

		
		// add button listener
		button.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				// custom dialog
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.donate_dialog);
				dialog.setTitle("Donar ...");

				// set the custom dialog components - text, image and button
				TextView donateProjectName = (TextView) dialog
						.findViewById(R.id.donateProjectName);
				donateProjectName.setText("Projecto");
				
				TextView donateUserBudget = (TextView) dialog
						.findViewById(R.id.donateUserBudget);
				
				YourCommitmentApplication application = (YourCommitmentApplication) getApplication();
				//donateUserBudget.setText(Double.toString(application.getCurrentUser().getAmount()));
				donateUserBudget.setText("345");
				
				EditText donateUserDonation = (EditText) dialog
						.findViewById(R.id.donateUserDonation);
				
				Button confirmDonateButton = (Button) dialog
						.findViewById(R.id.confirmDonateButton);

				// if button is clicked, close the custom dialog
				confirmDonateButton.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						insertDonation();
						dialog.dismiss();
					}
				});

				dialog.show();
			}


		});

	}

	private void insertDonation() {
		
		String proyectId = proyect.getId();
		Double amount = Double.parseDouble(donateUserDonation.getText().toString());
		
		Donation donation = new Donation("Name","Description",proyectId);
		donation.setAmount(amount);
		donation.setProyect(proyect);
		
		try {
			donation.getDonationObject().save();
		} catch (final ParseException e1) {
			Toast.makeText(this, "No se ha podido guardar el usuario",
					Toast.LENGTH_SHORT).show();
		}
	}
	
	private void loadUpdates(final String proyectId) {
		final ParseQuery query = new ParseQuery("Update");
		query.whereEqualTo("proyectId", proyectId).findInBackground(
				new FindCallback() {
					@Override
					public void done(final List<ParseObject> parseUpdates,
							final ParseException e) {
						if (e == null) {
							for (final ParseObject parseUpdate : parseUpdates) {
								updates.add(new Update(parseUpdate));
								adapter.notifyDataSetChanged();
							}
						} else {
							Toast.makeText(DetailProyectActivity.this,
									"Error al buscar proyectos: ",
									Toast.LENGTH_SHORT).show();
						}
					}
				});
	}

}

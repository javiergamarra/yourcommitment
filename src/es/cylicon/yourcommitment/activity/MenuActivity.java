package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboFragmentActivity;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import es.cylicon.yourcommitment.model.Donation;
import es.cylicon.yourcommitment.model.Proyect;

public class MenuActivity extends RoboFragmentActivity {

	protected final static String TAG = "YOURCOMMITMENT";

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, 0);
	}

	protected Proyect getProjectForADonation(final String projectId) {
		final ParseQuery proyectQuery = new ParseQuery("Proyect");
		try {
			return new Proyect(proyectQuery.whereEqualTo("objectId", projectId)
					.getFirst());
		} catch (final ParseException e1) {
			Toast.makeText(this,
					"No se ha podido recuperar la informaci�n de proyectos",
					Toast.LENGTH_SHORT).show();
		}
		return new Proyect();
	}

	protected List<Donation> getDonations(final String userId) {
		final ParseQuery donationsQuery = new ParseQuery("Donation");
		try {
			final List<Donation> donations = new ArrayList<Donation>();
			for (final ParseObject object : donationsQuery.whereEqualTo(
					"userId", userId).find()) {
				final Donation donation = new Donation(object);
				final Proyect proyect = getProjectForADonation(donation
						.getProyectId());
				donation.setProyect(proyect);
				donations.add(donation);
			}
			return donations;
		} catch (final ParseException e1) {
			Toast.makeText(this,
					"No se ha podido recuperar la informaci�n de donaciones",
					Toast.LENGTH_SHORT).show();
		}
		return new ArrayList<Donation>();
	}

}

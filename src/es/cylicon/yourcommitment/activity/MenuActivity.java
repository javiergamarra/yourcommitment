package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboFragmentActivity;
import android.widget.Toast;

import com.parse.ParseException;
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

	protected List<Proyect> getProyects(final String userId) {
		final ParseQuery userProyectQuery = new ParseQuery("UserProyect");
		try {
			return Proyect.createProyects(userProyectQuery.whereEqualTo(
					"user_id", userId).find());
		} catch (final ParseException e1) {
			Toast.makeText(this,
					"No se ha podido recuperar la información de proyectos",
					Toast.LENGTH_SHORT).show();
		}
		return new ArrayList<Proyect>();
	}

	protected List<Donation> getDonations(final String userId,
			final List<Proyect> proyects) {
		final ParseQuery donationsQuery = new ParseQuery("Donation");
		try {
			return Donation.createDonations(
					donationsQuery.whereEqualTo("user_id", userId).find(),
					proyects);
		} catch (final ParseException e1) {
			Toast.makeText(this,
					"No se ha podido recuperar la información de donaciones",
					Toast.LENGTH_SHORT).show();
		}
		return new ArrayList<Donation>();
	}

}

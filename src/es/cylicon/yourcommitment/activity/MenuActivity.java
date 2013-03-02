package es.cylicon.yourcommitment.activity;

import roboguice.activity.RoboFragmentActivity;

public class MenuActivity extends RoboFragmentActivity {

	protected final static String TAG = "YOURCOMMITMENT";

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		overridePendingTransition(0, 0);
	}

}

package es.cylicon.yourcommitment.activity;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.R.layout;
import es.cylicon.yourcommitment.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class LoginFailedActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_failed);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login_failed, menu);
		return true;
	}

}

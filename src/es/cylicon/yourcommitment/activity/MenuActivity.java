package es.cylicon.yourcommitment.activity;

import android.app.Activity;
import android.view.Menu;
import es.cylicon.yourcommitment.R;

public class MenuActivity extends Activity {

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

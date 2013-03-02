package es.cylicon.yourcommitment;

import android.os.Bundle;
import android.view.Menu;
import es.cylicon.yourcommitment.activity.MenuActivity;

public class MapActivity extends MenuActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mapa);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mapa, menu);
		return true;
	}

}

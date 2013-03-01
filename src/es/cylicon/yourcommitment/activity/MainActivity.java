package es.cylicon.yourcommitment.activity;

import android.os.Bundle;
import es.cylicon.yourcommitment.R;

public class MainActivity extends ParseActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// final ParseObject testObject = new ParseObject("TestObject");
		// testObject.put("foo", "bar");
		// testObject.saveInBackground();
	}

}

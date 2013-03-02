package es.cylicon.yourcommitment.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import es.cylicon.yourcommitment.R;

public class ProfileActivity extends MenuActivity {

	private static final String TAG = "YOUR_COMMITMENT";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}

	private void getSomething() {
		final ParseObject gameScore = new ParseObject("GameScore");
		gameScore.put("score", 1337);
		gameScore.put("playerName", "Sean Plott");
		gameScore.put("cheatMode", false);
		gameScore.saveInBackground(new SaveCallback() {

			@Override
			public void done(final ParseException arg0) {
				Log.e(TAG, "done");
			}
		});
	}

}

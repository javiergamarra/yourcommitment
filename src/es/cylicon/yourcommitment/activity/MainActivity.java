package es.cylicon.yourcommitment.activity;

import java.util.List;

import android.os.Bundle;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import es.cylicon.yourcommitment.R;

public class MainActivity extends MenuActivity {

	private static final String TAG = "YOUR_COMMITMENT";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		saveSomething();
		// // searchSomething();
		// ParseFacebookUtils.logIn(this, new LogInCallback() {
		// @Override
		// public void done(final ParseUser user, final ParseException err) {
		// if (user == null) {
		// Log.e(TAG, "Uh oh. The user cancelled the Facebook login.");
		// } else if (user.isNew()) {
		// Log.e(TAG, "User signed up and logged in through Facebook!");
		// } else {
		// Log.e(TAG,
		// "User logged in through Facebook!"
		// + user.getUsername() + user.getEmail());
		// }
		// }
		// });

	}

	private void searchSomething() {
		final ParseQuery query = new ParseQuery("GameScore");
		try {
			final List<ParseObject> objects = query.find();
			Log.e(TAG, objects.toString());
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	private void saveSomething() {
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

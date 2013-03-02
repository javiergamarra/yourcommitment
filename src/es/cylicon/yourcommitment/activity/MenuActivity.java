package es.cylicon.yourcommitment.activity;

import java.util.List;

import roboguice.activity.RoboFragmentActivity;
import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

public class MenuActivity extends RoboFragmentActivity {

	protected static final String TAG = "YOUR_COMMITMENT";

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

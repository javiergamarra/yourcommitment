package es.cylicon.yourcommitment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.model.User;

public class LoginActivity extends MenuActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ParseFacebookUtils.logIn(this, new LogInCallback() {
			@Override
			public void done(final ParseUser user, final ParseException err) {
				if (user == null) {
					Log.e(TAG, "Uh oh. The user cancelled the Facebook login.");
					startActivity(new Intent(LoginActivity.this,
							LoginFailedActivity.class));
				} else {
					login(user);
				}
			}
		});

	}

	private void login(final ParseUser user) {
		Log.e(TAG, "User logged in through Facebook!" + user.getUsername()
				+ user.getEmail());

		final ParseQuery query = new ParseQuery("user");
		query.whereEqualTo("username", user.getUsername())
				.getFirstInBackground(new GetCallback() {
					@Override
					public void done(final ParseObject userFound,
							final ParseException e) {
						final User currentUser;
						if (userFound == null) {
							currentUser = new User(user.getUsername());
							try {
								currentUser.getUserObject().save();
							} catch (final ParseException e1) {
								e1.printStackTrace();
							}
						} else {
							currentUser = new User(userFound);
						}

						final YourCommitmentApplication application = (YourCommitmentApplication) getApplication();

						application.setCurrentUser(currentUser);
						startActivity(new Intent(LoginActivity.this,
								ProyectsActivity.class));
					}
				});
	}

	@Override
	protected void onActivityResult(final int requestCode,
			final int resultCode, final Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

}

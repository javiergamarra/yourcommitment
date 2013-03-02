package es.cylicon.yourcommitment.activity;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseInstallation;
import com.parse.PushService;

import es.cylicon.yourcommitment.R;

public class YourCommitmentApplication extends android.app.Application {

	private static final String KEY = "3pa0rYzCvwJkXcrWXPxCjnSOwPlFgW6NTZ8NOBsM";
	private static final String TOKEN = "PM0jwmEJo3cgKtMMmuYPc1Qtrlvuso8JodvtdMxg";

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, TOKEN, KEY);
		ParseFacebookUtils.initialize(getString(R.string.app_id));
		registerForPushForChannelAndActivity("Example", MainActivity.class);

	}

	private void registerForPushForChannelAndActivity(final String channel,
			final Class activity) {
		PushService.subscribe(this, channel, activity);
		PushService.setDefaultPushCallback(this, activity);
		ParseInstallation.getCurrentInstallation().saveInBackground();
	}

}

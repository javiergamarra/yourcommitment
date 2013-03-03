package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import com.parse.Parse;
import com.parse.ParseFacebookUtils;
import com.parse.ParseInstallation;
import com.parse.PushService;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.model.Category;
import es.cylicon.yourcommitment.model.User;

public class YourCommitmentApplication extends android.app.Application {

	private static final String KEY = "3pa0rYzCvwJkXcrWXPxCjnSOwPlFgW6NTZ8NOBsM";
	private static final String TOKEN = "PM0jwmEJo3cgKtMMmuYPc1Qtrlvuso8JodvtdMxg";

	private User currentUser;
	private List<Category> categories = new ArrayList<Category>();

	@Override
	public void onCreate() {
		super.onCreate();
		Parse.initialize(this, TOKEN, KEY);
		ParseFacebookUtils.initialize(getString(R.string.app_id));
		registerForPushForChannelAndActivity("todos", ProyectsActivity.class);
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(final User currentUser) {
		this.currentUser = currentUser;
	}

	public void registerForPushForChannelAndActivity(final String channel,
			final Class activity) {
		final String newChannel = channel.replace(" ", "");
		PushService.subscribe(this, newChannel, activity);
		PushService.setDefaultPushCallback(this, activity);
		ParseInstallation.getCurrentInstallation().saveInBackground();
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(final List<Category> categories) {
		this.categories = categories;
	}

}

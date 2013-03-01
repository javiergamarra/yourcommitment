package es.cylicon.yourcommitment.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.parse.Parse;

import es.cylicon.yourcommitment.R;

public class ParseActivity extends Activity {

	private static final String KEY = "3pa0rYzCvwJkXcrWXPxCjnSOwPlFgW6NTZ8NOBsM";
	private static final String TOKEN = "PM0jwmEJo3cgKtMMmuYPc1Qtrlvuso8JodvtdMxg";

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Parse.initialize(this, TOKEN, KEY);
	}

	@Override
	public boolean onCreateOptionsMenu(final Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

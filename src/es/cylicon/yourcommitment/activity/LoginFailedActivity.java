package es.cylicon.yourcommitment.activity;

import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import es.cylicon.yourcommitment.R;

public class LoginFailedActivity extends MenuActivity implements
		OnClickListener {

	@InjectView(R.id.tryToLogin)
	private Button tryToLogin;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login_failed);
		tryToLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(final View v) {
		startActivity(new Intent(this, LoginActivity.class));
	}

}

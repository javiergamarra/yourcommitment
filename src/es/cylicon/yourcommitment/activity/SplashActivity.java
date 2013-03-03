package es.cylicon.yourcommitment.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import es.cylicon.yourcommitment.R;

public class SplashActivity extends RoboActivity implements OnClickListener {

	@InjectView(R.id.splash)
	private RelativeLayout layout;
	private Animation zoomAnimation;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		layout.setOnClickListener(this);
		startAnimate();
	}

	private void startAnimate() {
		final ImageView logotipoAndroid = (ImageView) findViewById(R.id.ImagenViewLogo);
		zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_anim);
		logotipoAndroid.startAnimation(zoomAnimation);

		zoomAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(final Animation animation) {
			}

			@Override
			public void onAnimationRepeat(final Animation animation) {
			}

			public void onAnimationEnd(final Animation animation) {
				startLoginActivity();
			}

		});

	}

	private void startLoginActivity() {
		final Intent intent = new Intent(this, LoginActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivity(intent);
	}

	@Override
	public void onClick(final View v) {
		zoomAnimation.cancel();
		startLoginActivity();
	}

}

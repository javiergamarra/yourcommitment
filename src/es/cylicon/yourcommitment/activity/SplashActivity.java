package es.cylicon.yourcommitment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import es.cylicon.yourcommitment.R;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);

		startAnimate();
	}

	private void startAnimate() {
		final ImageView logotipoAndroid = (ImageView) findViewById(R.id.ImagenViewLogo);
		final Animation zoomAnimation = AnimationUtils.loadAnimation(this,
				R.anim.zoom_anim);
		logotipoAndroid.startAnimation(zoomAnimation);

		zoomAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(final Animation animation) {
			}

			@Override
			public void onAnimationRepeat(final Animation animation) {
			}

			public void onAnimationEnd(final Animation animation) {
				final Intent intent = new Intent(SplashActivity.this,
						LoginActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(intent);
			}
		});

	}

}

package es.cylicon.yourcommitment.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
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
		// Zoom logotipo
		final ImageView logotipoAndroid = (ImageView) findViewById(R.id.ImagenViewLogo);
		final Animation zoomAnimation = AnimationUtils.loadAnimation(this,
				R.anim.zoom_anim);
		logotipoAndroid.startAnimation(zoomAnimation);

	}

}

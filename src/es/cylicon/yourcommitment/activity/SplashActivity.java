package es.cylicon.yourcommitment.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
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
		ImageView logotipoAndroid = (ImageView) findViewById(R.id.ImagenViewLogo);
		Animation zoomAnimation = AnimationUtils.loadAnimation(this,
				R.anim.zoom_anim);
		logotipoAndroid.startAnimation(zoomAnimation);


		// Animacion tiempo final
		TextView pie = (TextView) findViewById(R.id.TextViewPie);
		Animation fadeFinal = AnimationUtils.loadAnimation(this,
				R.anim.fade_final);
		pie.startAnimation(fadeFinal);

		fadeFinal.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(final Animation animation) {
			}

			@Override
			public void onAnimationRepeat(final Animation animation) {
			}

			public void onAnimationEnd(final Animation animation) {
				startActivity(new Intent(SplashActivity.this,
						LoginActivity.class));
				finish();
			}
		});


	}

}

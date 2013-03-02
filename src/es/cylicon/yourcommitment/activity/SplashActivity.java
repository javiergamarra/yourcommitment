package es.cylicon.yourcommitment.activity;

import es.cylicon.yourcommitment.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class SplashActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_splash);
		
		startAnimating();
	}


	private void startAnimating() {
		
		//Movimiento barra colores
		ImageView barraColores = (ImageView) findViewById(R.id.ImagenViewTop);
		Animation movimientoVertical = AnimationUtils.loadAnimation(this, R.anim.translate_anim);
		barraColores.startAnimation(movimientoVertical);
		
		//Zoom logotipo
    	ImageView logotipoAndroid = (ImageView) findViewById(R.id.ImagenViewLogo);
    	Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom_anim);
    	logotipoAndroid.startAnimation(zoomAnimation);
    	
    	//Fade Titulo
    	TextView tituloPrincipal = (TextView) findViewById(R.id.TextViewTitulo);
    	Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
    	tituloPrincipal.startAnimation(fade1);

    	//Fade subTitulo
        TextView subtitulo = (TextView) findViewById(R.id.TextViewSubtitulo);
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        subtitulo.startAnimation(fade2);

        
      //Animacion tiempo final
        TextView pie = (TextView) findViewById(R.id.TextViewPie);
        Animation fadeFinal = AnimationUtils.loadAnimation(this, R.anim.fade_final);
        pie.startAnimation(fadeFinal);
        
        
        
        fadeFinal.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {}
			
			@Override
			public void onAnimationRepeat(Animation animation) {}
			
			@Override
			public void onAnimationEnd(Animation animation) { 
				startActivity(new Intent(SplashActivity.this , LoginActivity.class));
				finish();
			}
		});

        
        //animaciones para TableView
        Animation spinin = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        LayoutAnimationController control = new LayoutAnimationController(spinin);
        
        TableLayout tabla = (TableLayout) findViewById(R.id.TableLayout01);
        
        for(int i=0; i< tabla.getChildCount(); i++){
        	
        	TableRow row = (TableRow) tabla.getChildAt(i);
        	row.setLayoutAnimation(control);
        }
		
	}

	

}



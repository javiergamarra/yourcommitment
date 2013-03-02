package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.adapter.ProyectAdapter;
import es.cylicon.yourcommitment.model.Proyect;

public class ProyectsActivity extends ListActivity {

	private static final String TAG = "ProyectsActivity";
	private static final int DETALLE_PROYECTO = 0;

	private List<Proyect> proyects = new ArrayList<Proyect>();
	private ProyectAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proyects);

		loadProyects();
		adapter = new ProyectAdapter(this, android.R.layout.simple_list_item_1,
				proyects);
		setListAdapter(adapter);
	}

	private void loadProyects() {
		ParseQuery query = new ParseQuery("Proyect");
		query.findInBackground(new FindCallback() {
			public void done(List<ParseObject> parseProyects, ParseException e) {
				if (e == null) {
					for (ParseObject parseProyect : parseProyects) {
						proyects.add(new Proyect(parseProyect));
						adapter.notifyDataSetChanged();
					}
				} else {
					Log.e(TAG, "Error al buscar proyectos: " + e.getMessage());
				}
			}
		});
	}

	@Override
	protected void onListItemClick(final ListView lista, final View vista,
			final int posicion, final long id) {
		super.onListItemClick(lista, vista, posicion, id);
		final Intent intent = new Intent(this, DetailProyectActivity.class);
		startActivityForResult(intent, DETALLE_PROYECTO);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.proyects, menu);
		return true;
	}

}

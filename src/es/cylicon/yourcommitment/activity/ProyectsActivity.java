package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.adapter.ProyectAdapter;
import es.cylicon.yourcommitment.model.Proyect;

public class ProyectsActivity extends MenuActivity implements
		OnItemClickListener {

	private static final int DETALLE_PROYECTO = 0;

	private final List<Proyect> proyects = new ArrayList<Proyect>();
	private ProyectAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proyects);

		loadProyects();
		adapter = new ProyectAdapter(this, android.R.layout.simple_list_item_1,
				proyects);
		final ListView listView = (ListView) findViewById(android.R.id.list);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}

	private void loadProyects() {
		final ParseQuery query = new ParseQuery("Proyect");
		query.findInBackground(new FindCallback() {
			@Override
			public void done(final List<ParseObject> parseProyects,
					final ParseException e) {
				if (e == null) {
					for (final ParseObject parseProyect : parseProyects) {
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
	public void onItemClick(final AdapterView<?> arg0, final View arg1,
			final int posicion, final long arg3) {
		final Intent intent = new Intent(this, DetailProyectActivity.class);
		intent.putExtra("proyectId", proyects.get(posicion).getId());
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
		startActivityForResult(intent, DETALLE_PROYECTO);
	}

}

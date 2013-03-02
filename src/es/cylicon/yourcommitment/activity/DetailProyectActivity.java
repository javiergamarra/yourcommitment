package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.adapter.UpdateAdapter;
import es.cylicon.yourcommitment.model.Proyect;
import es.cylicon.yourcommitment.model.Update;

public class DetailProyectActivity extends MenuActivity {

	private final List<Update> updates = new ArrayList<Update>();
	private UpdateAdapter adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_proyect);

		final Proyect proyect = (Proyect) getIntent().getExtras()
				.getSerializable("proyect");
		loadUpdates(proyect.getId());

		final ListView listView = (ListView) findViewById(android.R.id.list);
		adapter = new UpdateAdapter(this, android.R.layout.simple_list_item_1,
				updates);
		listView.setAdapter(adapter);

	}

	private void loadUpdates(final String proyectId) { 
		final ParseQuery query = new ParseQuery("Update");
		query.whereEqualTo("proyectId", proyectId).findInBackground(
				new FindCallback() {
					@Override
					public void done(final List<ParseObject> parseUpdates,
							final ParseException e) {
						if (e == null) {
							for (final ParseObject parseUpdate : parseUpdates) {
								updates.add(new Update(parseUpdate));
								adapter.notifyDataSetChanged();
							}
						} else {
							Toast.makeText(DetailProyectActivity.this,
									"Error al buscar proyectos: ",
									Toast.LENGTH_SHORT).show();
						}
					}
				});
	}

}

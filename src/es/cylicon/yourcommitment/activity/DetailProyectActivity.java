package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import android.app.ListActivity;
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.R.layout;
import es.cylicon.yourcommitment.R.menu;
import es.cylicon.yourcommitment.adapter.ProyectAdapter;
import es.cylicon.yourcommitment.adapter.UpdateAdapter;
import es.cylicon.yourcommitment.model.Proyect;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import es.cylicon.yourcommitment.model.Update;



public class DetailProyectActivity extends ListActivity {

	private static final String TAG = "ProyectsActivity";
	private List<Update> updates = new ArrayList<Update>();
	private UpdateAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_proyect);

		Bundle extras = getIntent().getExtras();
		int proyectId = extras.getInt("proyectId");
		
		
		loadUpdates();
		adapter = new UpdateAdapter(this, android.R.layout.simple_list_item_1,
				updates);
		setListAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_detail_proyect, menu);
		return true;
	}

	private void loadUpdates() {
		ParseQuery query = new ParseQuery("Update");
		query.findInBackground(new FindCallback() {
			public void done(List<ParseObject> parseUpdates, ParseException e) {
				if (e == null) {
					for (ParseObject parseUpdate : parseUpdates) {
						updates.add(new Update(parseUpdate));
						adapter.notifyDataSetChanged();
					}
				} else {
					Log.e(TAG, "Error al buscar proyectos: " + e.getMessage());
				}
			}
		});
	}

}

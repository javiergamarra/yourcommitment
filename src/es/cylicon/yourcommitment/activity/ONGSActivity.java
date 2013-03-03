package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Organization;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import es.cylicon.yourcommitment.R;

@ContentView(R.layout.activity_organizations)
public class ONGSActivity extends MenuActivity {

	@InjectView(android.R.id.list)
	private ListView listView;

	private final List<es.cylicon.yourcommitment.model.Organization> organizations = new ArrayList<es.cylicon.yourcommitment.model.Organization>();
	private ArrayAdapter<Organization> adapter;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		loadOrganizations();
		adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
				organizations);
		listView.setAdapter(adapter);
	}

	private void loadOrganizations() {
		final ParseQuery query = new ParseQuery("ONGCountry");
		query.setLimit(100);
		query.findInBackground(new FindCallback() {
			@Override
			public void done(final List<ParseObject> parseProyects,
					final ParseException e) {
				if (e == null) {
					for (final ParseObject parseProyect : parseProyects) {
						organizations
								.add(new es.cylicon.yourcommitment.model.Organization(
										parseProyect));
						adapter.notifyDataSetChanged();
					}
				} else {
					Log.e(TAG, "Error al buscar ONGs: " + e.getMessage());
				}
			}
		});
	}

}

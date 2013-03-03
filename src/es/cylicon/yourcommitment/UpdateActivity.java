package es.cylicon.yourcommitment;

import java.util.ArrayList;
import java.util.List;

import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;

import es.cylicon.yourcommitment.activity.MenuActivity;
import es.cylicon.yourcommitment.adapter.UpdateAdapter;
import es.cylicon.yourcommitment.model.Update;

public class UpdateActivity extends MenuActivity implements OnClickListener {

	@InjectView(android.R.id.list)
	private ListView listView;
	@InjectView(R.id.push)
	private Button pushButton;

	private UpdateAdapter adapter;
	private final List<Update> updates = new ArrayList<Update>();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_update);

		adapter = new UpdateAdapter(this, android.R.layout.simple_list_item_1,
				updates);
		listView.setAdapter(adapter);
		loadUpdates(getIntent().getStringExtra("projectId"));
		pushButton.setOnClickListener(this);

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
							Toast.makeText(UpdateActivity.this,
									"Error al buscar proyectos: ",
									Toast.LENGTH_SHORT).show();
						}
					}
				});
	}

	@Override
	public void onClick(final View v) {
		final ParsePush push = new ParsePush();
		push.setChannel("todos");
		push.setMessage("Hola!");
		push.sendInBackground();
		Toast.makeText(this, "Enviada notificación!", Toast.LENGTH_SHORT)
				.show();
	}

}

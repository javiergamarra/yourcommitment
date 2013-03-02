package es.cylicon.yourcommitment.activity;

import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.UpdateActivity;
import es.cylicon.yourcommitment.model.Proyect;

public class DetailProyectActivity extends MenuActivity implements
		OnClickListener {

	@InjectView(R.id.address)
	private TextView address;
	@InjectView(R.id.proyectName)
	private TextView name;
	@InjectView(R.id.description)
	private TextView description;
	@InjectView(R.id.updates)
	private Button button;
	private Proyect proyect;

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_proyect);

		proyect = (Proyect) getIntent().getExtras().getSerializable("proyect");
		address.setText(proyect.getAddress());
		name.setText(proyect.getName());
		description.setText(proyect.getDescription());
		button.setOnClickListener(this);

	}

	@Override
	public void onClick(final View v) {
		final Intent intent = new Intent(this, UpdateActivity.class);
		intent.putExtra("projectId", proyect.getId());
		startActivity(intent);
	}
}

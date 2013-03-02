package es.cylicon.yourcommitment.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.model.Proyect;
import es.cylicon.yourcommitment.model.Update;

public class UpdateAdapter extends ArrayAdapter<Update> {

	public UpdateAdapter(final Context context, final int resource,
			final List<Update> objects) {
		super(context, resource, objects);
	}

	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {
		if (convertView == null) {
			final LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.activity_proyects_fila, null);
		}

		setValuesFromUpdateInRow(getItem(position), convertView);

		return convertView;
	}

	private void setValuesFromUpdateInRow(final Update update, final View vista) {
		final TextView titulo = (TextView) vista.findViewById(R.id.titulo);
		titulo.setText(update.getDescription());
		final TextView descripcion = (TextView) vista
				.findViewById(R.id.descripcion);
		descripcion.setText(update.getDescription());
	}

}

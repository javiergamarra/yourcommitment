package es.cylicon.yourcommitment.adapter;

import java.io.IOException;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.model.Update;

public class UpdateAdapter extends ArrayAdapter<Update> {

	Context context;

	public UpdateAdapter(final Context context, final int resource,
			final List<Update> objects) {
		super(context, resource, objects);
		this.context = context;
	}

	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {
		if (convertView == null) {
			final LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.activity_detail_proyects_fila,
					null);
		}
		setValuesFromUpdateInRow(getItem(position), convertView);
		return convertView;
	}

	private void setValuesFromUpdateInRow(final Update update, final View vista) {
		Drawable drawable;
		final TextView descripcion = (TextView) vista
				.findViewById(R.id.descriptionUpdate);
		final ImageView image = (ImageView) vista
				.findViewById(R.id.imageUpdate);

		try {
			drawable = Drawable.createFromStream(
					context.getAssets().open("test/" + update.getImagen()),
					null);
			image.setImageDrawable(drawable);
			descripcion.setText(update.getDescription());

		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}

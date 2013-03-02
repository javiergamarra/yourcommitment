package es.cylicon.yourcommitment.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.model.Donation;

public class DonationAdapter extends ArrayAdapter<Donation> {

	public DonationAdapter(final Context context, final List<Donation> donations) {
		super(context, R.layout.item_donation, donations);
	}

	@Override
	public View getView(final int position, final View convertView,
			final ViewGroup parent) {
		View row = convertView;
		if (row == null) {
			final LayoutInflater vi = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = vi.inflate(R.layout.item_donation, null);
		}

		final Donation dato = getItem(position);
		final TextView nombre = (TextView) row.findViewById(R.id.name_donation);
		nombre.setText(dato.getName());
		final TextView proyecto = (TextView) row
				.findViewById(R.id.name_proyect);
		proyecto.setText(dato.getProyect().getName());

		return row;
	}

}

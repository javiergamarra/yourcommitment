package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.adapter.DonationAdapter;
import es.cylicon.yourcommitment.model.Donation;

@ContentView(R.layout.activity_user)
public class UserActivity extends RoboFragmentActivity {

	@InjectView(R.id.userAmountDonation)
	private TextView amountLeft;

	@InjectView(android.R.id.list)
	private ListView listView;

	private final List<Donation> listaDonaciones = new ArrayList<Donation>();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// amountLeft.setText(user.getAmountLeft().toString());

		final ListView listView = (ListView) findViewById(android.R.id.list);
		listView.setAdapter(new DonationAdapter(this, listaDonaciones));

	}

}

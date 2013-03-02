package es.cylicon.yourcommitment.activity;

import java.util.ArrayList;
import java.util.List;

import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import es.cylicon.yourcommitment.R;
import es.cylicon.yourcommitment.adapter.DonationAdapter;
import es.cylicon.yourcommitment.model.Donation;
import es.cylicon.yourcommitment.model.User;

public class UserActivity extends MenuActivity {

	@InjectView(R.id.userAmount)
	private TextView amount;

	@InjectView(R.id.userAmountDonation)
	private TextView amountLeft;

	private final List<Donation> listaDonaciones = new ArrayList<Donation>();

	@Override
	protected void onCreate(final Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user);

		final User user = new User();
		user.setAmount((double) 25);

		amount.setText(user.getAmount().toString());
		// amountLeft.setText(user.getAmountLeft().toString());

		final ListView listView = (ListView) findViewById(android.R.id.list);
		listView.setAdapter(new DonationAdapter(this, listaDonaciones));

	}
}

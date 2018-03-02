package android.example.com.portfoliomanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PortfolioDetailsActivity extends AppCompatActivity {
    Portfolio portfolio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_details);

        Bundle b = getIntent().getExtras();
        Portfolio portfolio = (Portfolio)b.getSerializable("portfolio");

//        portfolio=(Portfolio) i.getSerializableExtra("portfolio");

//        getSupportActionBar().setTitle(portfolio.getName().toString());

        TextView name_portfolio = (TextView) findViewById(R.id.name_portfolio);
        name_portfolio.setText(portfolio.getName().toString());


        ArrayList<MutualFund> arrayOfMF = portfolio.getMfsList();
        // Create the adapter to convert the array to views
       MutualFundListAdapter adapter = new MutualFundListAdapter(this, arrayOfMF);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.portfolio_details_mf_list);
        listView.setAdapter(adapter);




    }
}

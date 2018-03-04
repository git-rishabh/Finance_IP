package android.example.com.portfoliomanager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PortfolioListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_list);
//        Bundle b = getIntent().getExtras();
        getSupportActionBar().setTitle("Possible Investment Options");
        ArrayList<Portfolio> pfs = MainActivity.portfolio_list;
//        ArrayList<Portfolio> pfs = (ArrayList<Portfolio>)b.getSerializable("portfolios");
//        System.out.println(pfs);
        populatePortfolioList(pfs);

    }
    @Override
    public void onResume(){
        super.onResume();
        ArrayList<Portfolio> pfs = MainActivity.portfolio_list;
        populatePortfolioList(pfs);
    }
    private void populatePortfolioList(ArrayList<Portfolio> pfs) {
        // Construct the data source
        ArrayList<Portfolio> arrayOfPortfolio = pfs;
        // Create the adapter to convert the array to views
        PortfolioListAdapter adapter = new PortfolioListAdapter(this, arrayOfPortfolio);
        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.portfolio_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Portfolio p = (Portfolio)parent.getAdapter().getItem(position);

                Intent intent = new Intent(getApplicationContext(),PortfolioDetailsActivity.class);
                // pass the item information
                Bundle b = new Bundle();
                b.putSerializable("portfolio",p);
                intent.putExtras(b);
                startActivity(intent);

            }
        });
    }
}

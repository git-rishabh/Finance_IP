package android.example.com.portfoliomanager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by Rishabh on 3/1/2018.
 */
public class PortfolioListAdapter extends ArrayAdapter<Portfolio> {

    public PortfolioListAdapter(Context context, ArrayList<Portfolio> portfolio) {
        super(context, 0, portfolio);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Portfolio portfolio = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.portfolio_item, parent, false);
        }
        // Lookup view for data population
        TextView name_portfolio = (TextView) convertView.findViewById(R.id.name_portfolio);
        TextView mfs_portfolio = (TextView) convertView.findViewById(R.id.mfs_portfolio);


        // Populate the data into the template view using the data object
        name_portfolio.setText(portfolio.getName());
        mfs_portfolio.setText(portfolio.getmfs());

        // Return the completed view to render on screen
        return convertView;
    }
}



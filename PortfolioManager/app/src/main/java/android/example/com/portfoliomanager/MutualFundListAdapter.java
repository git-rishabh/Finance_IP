package android.example.com.portfoliomanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rishabh on 3/2/2018.
 */
public class MutualFundListAdapter extends ArrayAdapter<MutualFund> {

    public MutualFundListAdapter(Context context, ArrayList<MutualFund> mutualfund) {
        super(context, 0, mutualfund);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MutualFund mutualFund = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mutualfund_item, parent, false);
        }
        // Lookup view for data population
        TextView name_mutualfund = (TextView) convertView.findViewById(R.id.name_mutualfund);
        TextView id_mutualfund = (TextView) convertView.findViewById(R.id.id_mutualfund);


        // Populate the data into the template view using the data object
        name_mutualfund.setText(mutualFund.getName().toString());
        id_mutualfund.setText(mutualFund.getCode().toString());

        // Return the completed view to render on screen
        return convertView;
    }
}

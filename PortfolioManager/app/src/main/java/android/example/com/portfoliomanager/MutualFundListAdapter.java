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
public class MutualFundListAdapter extends ArrayAdapter<Pair<MutualFund, Float>> {

    public MutualFundListAdapter(Context context, ArrayList<Pair<MutualFund, Float>> mutualfund) {
        super(context, 0, mutualfund);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Pair<MutualFund, Float> mutualFundPair = getItem(position);
        MutualFund mutualFund = mutualFundPair.getL();
        String mf_weight=String.valueOf(mutualFundPair.getR());
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mutualfund_item, parent, false);
        }
        // Lookup view for data population
        TextView name_mutualfund = (TextView) convertView.findViewById(R.id.name_mutualfund);
        TextView id_mutualfund = (TextView) convertView.findViewById(R.id.id_mutualfund);
        TextView weight_mutualfund = (TextView) convertView.findViewById(R.id.weight_mutualfund);
        TextView mean_mutualfund = (TextView) convertView.findViewById(R.id.mean_mutualfund);
        TextView risk_mutualfund = (TextView) convertView.findViewById(R.id.risk_mutualfund);

        // Populate the data into the template view using the data object
        name_mutualfund.setText(mutualFund.getName().toString());
        id_mutualfund.setText(mutualFund.getCode().toString());
        weight_mutualfund.setText(mf_weight.toString());
        mean_mutualfund.setText(mutualFund.getMean().toString());
        risk_mutualfund.setText(mutualFund.getStd().toString());
        // Return the completed view to render on screen
        return convertView;
    }
}

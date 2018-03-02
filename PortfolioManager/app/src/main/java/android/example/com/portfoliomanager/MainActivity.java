package android.example.com.portfoliomanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public ArrayList<Portfolio> getPortfolios(int exp_return,int risk,int maturity){
        ArrayList<Portfolio> pfs = new ArrayList<>();
        MutualFund mf1 = new MutualFund(12,"icici");
        MutualFund mf2 = new MutualFund(13,"hdfc");
        MutualFund mf3 = new MutualFund(14,"sbi");
        MutualFund mf4 = new MutualFund(15,"uco");
        ArrayList<MutualFund> mf_list1 = new ArrayList<>();
        mf_list1.add(mf1);mf_list1.add(mf2);
        ArrayList<MutualFund> mf_list2 = new ArrayList<>();
        mf_list2.add(mf3);mf_list2.add(mf4);
        ArrayList<MutualFund> mf_list3 = new ArrayList<>();
        mf_list3.add(mf2);mf_list3.add(mf4);

        Portfolio p1 = new Portfolio("P11",mf_list1);
        Portfolio p2 = new Portfolio("P22",mf_list2);
        Portfolio p3 = new Portfolio("P33",mf_list3);

        pfs.add(p1);pfs.add(p2);pfs.add(p3);

        return pfs;

    }
    public void find_mf(View view) throws Exception{
        EditText expected_return_field = (EditText) findViewById(R.id.expected_return);
        EditText risk_field = (EditText) findViewById(R.id.risk);
        EditText maturity_field = (EditText) findViewById(R.id.maturity);
        try {
            int expected_return = Integer.parseInt(expected_return_field.getText().toString());
            int risk = Integer.parseInt(risk_field.getText().toString());
            int maturity = Integer.parseInt(maturity_field.getText().toString());
            if(expected_return<0 || expected_return>100 || risk<0 || risk>100){
                throw new NumberFormatException();
            }

            expected_return = expected_return/100;
            risk = risk/100;
            ArrayList<Portfolio> portfolios = getPortfolios(expected_return,risk,maturity);

            Intent intent = new Intent(this,PortfolioListActivity.class);
            Bundle b = new Bundle();
            b.putSerializable("portfolios",portfolios);
            intent.putExtras(b);
            startActivity(intent);

        }catch(NumberFormatException e){
            Toast toast=Toast.makeText(getApplicationContext(),"Fill in All Fields Correctly and in required range", Toast.LENGTH_LONG);
            toast.setMargin(50,50);
            toast.show();

        }






    }
}

package android.example.com.portfoliomanager;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Portfolio> portfolio_list = new ArrayList<Portfolio>();
    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public ArrayList<Portfolio> getPortfolios(float exp_return,float risk,float maturity){
        try{
            AssetManager assetManager = getAssets();
            Manager.LoadDetails(assetManager);
            portfolio_list = Manager.getPortfolios(exp_return,risk);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        MutualFund mf1 = new MutualFund("12","icici");mf1.setStats(1f,1.0f,1.0f,1.0f);
//        MutualFund mf2 = new MutualFund("13","hdfc");mf1.setStats(1f,1.0f,1.0f,1.0f);
//        MutualFund mf3 = new MutualFund("14","sbi");mf1.setStats(1f,1.0f,1.0f,1.0f);
//        MutualFund mf4 = new MutualFund("15","uco");mf1.setStats(1f,1.0f,1.0f,1.0f);
//        ArrayList<Pair<MutualFund,Float>> mf_list1 = new ArrayList<>();
//        Pair pair1=new Pair(mf1,"0.4");
//        Pair pair2=new Pair(mf2,"0.6");
//        Pair pair3=new Pair(mf3,"0.5");
//        Pair pair4=new Pair(mf4,"0.5");
//        mf_list1.add(pair1);mf_list1.add(pair2);
//        ArrayList<Pair<MutualFund,Float>> mf_list2 = new ArrayList<>();
//        mf_list2.add(pair3);mf_list2.add(pair4);
//        ArrayList<Pair<MutualFund,Float>> mf_list3 = new ArrayList<>();
//        mf_list3.add(pair2);mf_list3.add(pair4);
//        Portfolio p1 = new Portfolio("P11",mf_list1,0.3f,0.6f);
//        Portfolio p2 = new Portfolio("P22",mf_list2,0.1f,0.4f);
//        Portfolio p3 = new Portfolio("P33",mf_list3,0.8f,0.7f);
//
//        portfolio_list.add(p1);portfolio_list.add(p2);portfolio_list.add(p3);

        return portfolio_list;

    }
    public void find_mf(View view) throws Exception{
        EditText expected_return_field = (EditText) findViewById(R.id.expected_return);
        EditText risk_field = (EditText) findViewById(R.id.risk);
        EditText maturity_field = (EditText) findViewById(R.id.maturity);
        try {
            float expected_return = Integer.parseInt(expected_return_field.getText().toString());
            float risk = Integer.parseInt(risk_field.getText().toString());
            float maturity = Integer.parseInt(maturity_field.getText().toString());
            if(expected_return<0 || expected_return>100 || risk<0 || risk>100){
                throw new NumberFormatException();
            }

            expected_return = expected_return/100;
            risk = risk/100;
            ArrayList<Portfolio> portfolios = getPortfolios(expected_return,risk,maturity);

            Intent intent = new Intent(this,PortfolioListActivity.class);
            startActivity(intent);

        }catch(NumberFormatException e){
            Toast toast=Toast.makeText(getApplicationContext(),"Fill in All Fields Correctly and in required range", Toast.LENGTH_LONG);
            toast.setMargin(50,50);
            toast.show();

        }






    }
}

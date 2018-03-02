package android.example.com.portfoliomanager;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Rishabh on 3/1/2018.
 */
public class Portfolio implements Serializable {
    String name;
    int beta;
    int alpha;
    ArrayList<MutualFund> mf_list;

    public Portfolio(String name,ArrayList<MutualFund> mf){
        this.mf_list = new ArrayList<MutualFund>();
        this.mf_list=mf;
        this.name=name;
        this.alpha=0;
        this.beta=0;
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<MutualFund> getMfsList(){
        return this.mf_list;
    }
    public String getmfs(){
        StringBuilder mfs=new StringBuilder();
        ArrayList<MutualFund> l = this.mf_list;
        for(int i=0;i<l.size();i++){
            mfs.append(l.get(i).toString());
            mfs.append(" ");
        }
        System.out.println(mfs);
        return mfs.toString();
    }

//    public static ArrayList<Portfolio> getPortfolios() {
//        ArrayList<Portfolio> users = new ArrayList<User>();
//        users.add(new User("Harry", "San Diego"));
//        users.add(new User("Marla", "San Francisco"));
//        users.add(new User("Sarah", "San Marco"));
//        return users;
//    }
}

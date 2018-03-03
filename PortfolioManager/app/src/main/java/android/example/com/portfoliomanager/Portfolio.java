package android.example.com.portfoliomanager;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by Rishabh on 3/1/2018.
 */
public class Portfolio implements Comparator,Serializable {
//    String name;
    public ArrayList <Pair<MutualFund, Float>> mutual_funds = new ArrayList<Pair<MutualFund, Float>>();
    public Float returns, risk;
    public Portfolio(){}
    public Portfolio(String name,ArrayList <Pair<MutualFund, Float>> mf,Float risk,Float ret){
        this.mutual_funds = new ArrayList <Pair<MutualFund, Float>>();
        this.mutual_funds=mf;
//        this.name=name;
        this.returns=0f;
        this.risk=0f;
    }
    @Override
    public String toString() {
        String output = "\nReturn: " + returns + " Risk: "+risk + " Returns/Risk: "+ returns/risk +";\n";
        for (Pair<MutualFund, Float> e: mutual_funds) {
            output += e.getL() + ": " + e.getR() + "; ";
        }
        return output;
    }
    @Override
    public int compare(Object o1, Object o2) {
        Portfolio p1 = (Portfolio) o1;
        Portfolio p2 = (Portfolio) o2;
        float v1 = p1.returns/p1.risk, v2 = p2.returns/p2.risk;
        return (int)(v2 - v1)*1000;
    }

//    public String getName(){
//        return this.name;
//    }
    public ArrayList <Pair<MutualFund, Float>>  getMfsList(){

        return this.mutual_funds;
    }
   public String getReturn(){
       return String.valueOf(this.returns);
   }
    public String getRisk(){
        return String.valueOf(this.risk);
    }

}



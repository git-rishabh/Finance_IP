package android.example.com.portfoliomanager;

import java.io.Serializable;

/**
 * Created by Rishabh on 3/1/2018.
 */
public class MutualFund implements Serializable {
    public String code;
    public String name;
    public Float mean, std, alpha, beta;

    public MutualFund(String code,String name){
        this.code=code;
        this.name=name;
    }
    public void setStats(Float mean, Float std, Float alpha, Float beta) {
        this.mean = mean;
        this.std = std;
        this.alpha = alpha;
        this.beta = beta;
    }
    @Override
    public String toString() {
        return "MutualFund [code=" + code + ", name=" + name + ", mean=" + mean + ", std=" + std + "]\n";
    }

    public String getCode(){

        return this.code;
    }

    public String getName(){

        return this.name;
    }

    public String getMean(){

        return String.valueOf(this.mean);
    }

    public String getStd(){
       return String.valueOf(this.std);
    }
}

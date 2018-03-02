package android.example.com.portfoliomanager;

import java.io.Serializable;

/**
 * Created by Rishabh on 3/1/2018.
 */
public class MutualFund implements Serializable {
    int id;
    String name;

    public MutualFund(int id,String name){
        this.id=id;
        this.name=name;
    }
    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}

import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;


public class DataBroker extends PApplet {
    PApplet p;
    Table data;
    ArrayList<Data> Datalist = new ArrayList<Data>();

    DataBroker(PApplet p, Table data){
        this.p = p;
        this.data = data;
    }

    public void loadData(){

        for(int i = 1; i < data.getRowCount(); ++i){
            for(int j = 2; j < data.getColumnCount(); ++j){

            Datalist.add(new Data(data.getString( i ,1),data.getInt(1, j) ,data.getInt(i, j) ));
            println("land: " + data.getString( i ,1) + " år: " + data.getInt(0, j) + " døde: " + data.getInt(i, j));
            }
        }
    }
    public int getData(String ContryName, int Year){
        int a = 0;
        for(int i = 0; i < Datalist.size(); ++i){
            if( ContryName == Datalist.get(i).name && Year == Datalist.get(i).Year){ a = Datalist.get(i).Death; }
        }
        return a;
    }

}

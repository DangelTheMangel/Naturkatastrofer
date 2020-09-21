import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class landeogkatastrofer extends PApplet {

DataBroker data;
Table table;

    public static void main(String[] args) { PApplet.main("landeogkatastrofer"); }

    @Override
    public void setup() {
        table = loadTable("csv-deaths-natural-disasters.csv");
        data = new DataBroker(this, table );

        data.loadData();

        println(data.getData("ALBANIA",table.getInt(1,(int)random(4,table.getColumnCount()))));

    }
}

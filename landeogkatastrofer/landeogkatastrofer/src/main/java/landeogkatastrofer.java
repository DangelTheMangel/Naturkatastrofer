import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class landeogkatastrofer extends PApplet {

DataBroker data;
TextFlet text;
Table table;
Table table2;

    public static void main(String[] args) { PApplet.main("landeogkatastrofer"); }

    @Override
    public void settings() {
        size(500,500);
    }

    @Override
    public void setup() {
        table = loadTable("csv-deaths-natural-disasters.csv");
        data = new DataBroker(this, table );

        data.loadData();
        text = new TextFlet(this,  width / 4, (int) (height / 12 + height / 6 + (((width / 13)))), width / 2, height / 12, "Play");
        println(data.getData("ALBANIA",table.getInt(1,(int)random(4,table.getColumnCount()))));



    }

    @Override
    public void draw() {
       text.tegnTextFlet();

    }

    @Override
    public void mouseClicked() {
        text.KlikTjek(mouseX,mouseY);
    }

    @Override
    public void keyPressed() {
        text.keyindput(key);
        //print(key);
    }
}

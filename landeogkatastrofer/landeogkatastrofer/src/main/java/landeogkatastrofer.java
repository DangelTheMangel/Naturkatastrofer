import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class landeogkatastrofer extends PApplet {

DataBroker data;
TextFlet lande;
TextFlet aar;
Table table;


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
        lande = new TextFlet(this,  width / 4, (int) (height / 12 + height / 6 ), width / 2, height / 12, "Land");
        aar = new TextFlet(this,  width / 4, (int) (height / 12 + height / 6 + (((width / 13)+ height / 12))), width / 2, height / 12, "År");
        aar.setAcceptLetter(false);
        println(data.getData("AFGHANISTAN", 2014));
    }

    @Override
    public void draw() {
        clear();
        background(200);
        lande.tegnTextFlet();
        aar.tegnTextFlet();

        //text(myString);
        int aarInt = 0;
        if (aar.indput.length() > 0)
            aarInt = Integer.parseInt(aar.indput);

        text("Land: " + lande.indput + "\nÅR: " + aar.indput + "\nDøde: " + data.getData(lande.indput, aarInt),width / 4, (height / 12 + height / 6)*3 );

    }

    @Override
    public void mouseClicked() {
        lande.KlikTjek(mouseX,mouseY);
        aar.KlikTjek(mouseX,mouseY);
    }

    @Override
    public void keyTyped() {
        lande.keyindput(key);
        aar.keyindput(key);
       // if (lande.indput == ENDENMÅVÆRE)
        //    myString = text("Land: " + lande.indput + "\nÅR: " + aar.indput + "\nDøde: " + data.getData(lande.indput, Integer.parseInt(aar.indput)),width / 4, (height / 12 + height / 6)*3 );
    }
}

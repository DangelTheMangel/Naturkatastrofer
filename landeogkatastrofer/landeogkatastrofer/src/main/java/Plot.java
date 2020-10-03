import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class Plot {
    PApplet p;
    Table table;
    int xSize, ySize , posX, posY;
    Graph GraphCases;
    Graph GraphDeath;
    Axis xAxis;
    Axis yAxis;
    ArrayList<Data> dataArrayList = Datalist;


    Plot(PApplet app, int posX, int posY, int xSize, int ySize){
        p = app;
        this.table = table;
        this.xSize = xSize;
        this.ySize = ySize;
        this.posX = posX;
        this.posY = posY;

    }

    void  draw(){
        p.fill(218, 228, 245);
        p.rect(posX  - 50, posY - 100, xSize + 100, ySize + 270 );
        p.fill(255);
        p.rect(posX, posY - 10, xSize + 10 , ySize + 10);

    }

    void  checkMouseCoordinates(int mouseX, int mouseY) {


        }


    }


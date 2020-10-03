import processing.core.PApplet;
import processing.data.Table;

import java.applet.Applet;

public class Graph  {
    PApplet pApplet;
    Table table;
    int xSize, ySize , posX, posY;
    int maxY = Integer.MIN_VALUE;
    float xInt;
    float yInt;
    int colon;

    Graph(PApplet app, Table table,  int posX, int posY, int xSize, int ySize, int colon){
        pApplet = app;
        this.colon = colon;
        this.table = table;
        this.xSize = xSize;
        this.ySize = ySize;
        this.posX = posX;
        this.posY = posY;

        for (int i=0; i<table.getRowCount(); ++i)
            maxY = Math.max(table.getInt(i,1), maxY);

        xInt = xSize/table.getRowCount();
        yInt = (float) ySize/maxY;
    }

    void draw(){
        pApplet.fill(0);
        int x1, y1, x2,  y2;
        x1 = 0;
        y1 = ySize;

        for (int i=0; i<table.getRowCount(); ++i) {
            x2 = (int) xInt * i;
            y2 = ySize - ((int) (table.getInt(i,colon) * yInt));

           // pApplet.println("x1 " + x1 + " y1 " + y1 + " x2 " + x2 + " y2 " + y2);
            pApplet.line(posX + x1, posY + y1, posX + x2, posY + y2);

            x1 = x2;
            y1 = y2;

        }

    }

    int getRowFromMouse(int mouseX, int mouseY){
        if (mouseX < posX || mouseX > posX + xSize || mouseY < posY || mouseY > posY + ySize)
            return -1;

        return (int) ((mouseX - posX)/xInt);
    }

    float getXInt() {

        return xInt;
    }

    float getYInt() {
        return yInt;
    }

}

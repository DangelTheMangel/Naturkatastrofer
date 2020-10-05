import processing.core.PApplet;
import processing.data.Table;

import java.applet.Applet;
import java.util.ArrayList;

public class Graph  {
    PApplet pApplet;
    Table table;
    int xSize, ySize , posX, posY;
    int maxY = Integer.MIN_VALUE;
    float xInt;
    float yInt;
    int colon;
    ArrayList<Data> IndputList;
    boolean linesOn = true;
    Graph(PApplet app, int posX, int posY, int xSize, int ySize, int colon) {
        pApplet = app;
        this.colon = colon;
        this.table = table;
        this.xSize = xSize;
        this.ySize = ySize;
        this.posX = posX;
        this.posY = posY;
        this.IndputList = IndputList;



    }

    void draw(){
        pApplet.fill(0);
        int x1, y1, x2,  y2;
        x1 = 0;
        y1 = ySize;

        for (int i=0; i<IndputList.size(); ++i) {
            if(IndputList == null) {}else{
                int maxList = 0;
                for (int j = 0; j < IndputList.size(); ++j) {
                    if (IndputList.get(j).Death > maxList) {
                        maxList = IndputList.get(j).Death;
                        maxY = Math.max(maxList, maxY);
                    }
                }
                xInt = xSize/IndputList.size();
                yInt = (float) ySize/maxY;

            }
            x2 = (int) xInt * i;
            y2 = ySize - ((int) (IndputList.get(i).Death * yInt));
            pApplet.stroke(0);
           // pApplet.println("x1 " + x1 + " y1 " + y1 + " x2 " + x2 + " y2 " + y2);
            if(linesOn) {
                pApplet.line(posX + x1, posY + y1, posX + x2, posY + y2);
            }
            pApplet.ellipse(posX+x1,posY+y1, 2,2);

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

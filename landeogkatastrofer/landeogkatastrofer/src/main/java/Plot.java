import processing.core.PApplet;
import processing.data.Table;

import java.util.ArrayList;

public class Plot {
    PApplet p;
    Table table;
    int xSize, ySize , posX, posY;
    ProcGraph deathGraph;
    Axis xAxis;
    Axis yAxis;
    AlmindeligKnap btnShowProcGraph, btnShowBarCharts, btnShowLines;

    public ArrayList<Data> Datalist = new ArrayList<Data>() ;
    public ArrayList<Data> selectetContryList = new ArrayList<Data>();
    PillarChart pillarChart;
    String cName;

    Plot(PApplet app, int posX, int posY, int xSize, int ySize){
        p = app;
        this.table = table;
        this.xSize = xSize;
        this.ySize = ySize;
        this.posX = posX;
        this.posY = posY;
        Datalist.add(new Data("1",1,1));
        pillarChart = new PillarChart(p,this.posX, this.posY, this.xSize, this.ySize);
        deathGraph = new ProcGraph(p,this.posX, this.posY, this.xSize, this.ySize, 1);
        btnShowProcGraph = new AlmindeligKnap(p,posX - 50, (int) (p.height / 12  + ( p.height / 9)), p.width / 12, p.height / 12, "Proc graph");
        btnShowBarCharts = new AlmindeligKnap(p,posX - 50 + p.width / 12 + 20, (int) (p.height / 12  + ( p.height / 9)), p.width / 12, p.height / 12, "Bar charts");
        btnShowLines = new AlmindeligKnap(p,posX, posY+ySize + 20,p.width / 12 +20, p.height / 12 ,"Turn off lines");
        xAxis = new Axis (p, this.posX , this.posY + this.ySize, this.posX + this.xSize, this.posY + this.ySize, false, Datalist, deathGraph.xInt, deathGraph.yInt , 5);
        yAxis = new Axis (p, this.posX , posY + ySize , posX, posY, true, Datalist, deathGraph.xInt, deathGraph.yInt, 50000);
        btnShowProcGraph.klikket = true;
    }

    void  draw(){

        p.fill(218, 228, 245);
        p.rect(posX  - 50, posY - 100, xSize + 100, ySize + 270 );
        if(btnShowProcGraph.klikket){
            xAxis.maxY = deathGraph.maxY;
            yAxis.maxY = deathGraph.maxY;
            deathGraph.IndputList = selectetContryList;
            p.fill(255);
            p.rect(posX, posY - 10, xSize + 10 , ySize + 10);
            p.stroke(0);
            deathGraph.draw();
            xAxis.draw();
            yAxis.draw();
            btnShowLines.tegnKnap();
            if(btnShowLines.klikket){
                deathGraph.linesOn = !deathGraph.linesOn;
                btnShowLines.registrerRelease();
            }
            checkMouseCoordinates();

        }
        if(btnShowBarCharts.klikket){
            xAxis.maxY = deathGraph.maxY;
            yAxis.maxY = deathGraph.maxY;

            p.fill(255);
            p.rect(posX, posY - 10, xSize + 10 , ySize + 10);
            p.stroke(0);
            p.fill(0);
            pillarChart.drawPillarChart(selectetContryList,cName);
            xAxis.draw();
            yAxis.draw();
            checkMouseCoordinates();
        }




        btnShowProcGraph.tegnKnap();
        btnShowBarCharts.tegnKnap();


    }

    public void setArraylist(ArrayList<Data> IndputList, String countryName){
        if(IndputList == null){} else{
           selectetContryList.clear();
        }


        Datalist = IndputList;

        for(int i = 0; i < Datalist.size(); ++i) {
            Data data = Datalist.get(i);
             if(countryName.equalsIgnoreCase(data.name)) {
                Data input = Datalist.get(i);
                selectetContryList.add(new Data(data.name, data.Year, data.Death));
                cName = countryName;

            }
        }
    }

    public void clicked(float mx, float my){


        btnShowBarCharts.registrerKlik(mx,my);
        if(btnShowBarCharts.klikket){
            btnShowProcGraph.klikket = false;
        }
        btnShowProcGraph.registrerKlik(mx,my);
        if(btnShowProcGraph.klikket){
            btnShowBarCharts.klikket = false;
            btnShowLines.registrerKlik(mx, my);
        }

        if(deathGraph.linesOn){
            btnShowLines.text = "Turn off lines";
        }else {
            btnShowLines.text = "Turn on lines";
        }
    }

    void checkMouseCoordinates(){

       int row = deathGraph.getRowFromMouse(p.mouseX, p.mouseY);
        if(row > 0 && row < selectetContryList.size()) {
            p.stroke(1, 46, 74);
            p.fill(174, 200, 245);
            p.rect(p.mouseX, p.mouseY, 200,100);
            p.fill(1, 46, 74);

            int msgDeaths = selectetContryList.get(row).Death;
            int msgDate = selectetContryList.get(row).Year;
            String msgName = selectetContryList.get(row).name;

            p.text("Year: " + msgDate , p.mouseX + 10, p.mouseY + 30);
            p.text("Name: " + msgName, p.mouseX + 10, p.mouseY + 50);
            p.text("Deaths: " + msgDeaths, p.mouseX + 10, p.mouseY + 70);

            int x1 = (int) deathGraph.getXInt() * row;
            int y1 = ySize - ((int) (selectetContryList.get(row).Death * deathGraph.getYInt()));

            p.ellipse(x1 + posX, y1 + posY,10,10);

        }

    }
    }


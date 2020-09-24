import processing.core.PApplet;

public class TextFlet {

    //variabler
    float positionX, positionY, sizeX, sizeY;
    float mouseX, mouseY;
    String textFletNavn;
    String indput = ""; //dit navn består af en masse bogstaver <3

    boolean klikket = false;


    PApplet p;

    TextFlet(PApplet papp, int posX, int posY, int sizeX, int sizeY, String text ) {
        p = papp;
        positionX = posX;
        positionY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.textFletNavn = text;

    }

    void KlikTjek(float mouseX, float mouseY) {
        this.mouseX = mouseX;
        this.mouseY = mouseY;
        if (mouseX > positionX &&
                mouseX < positionX + sizeX &&
                mouseY > positionY &&
                mouseY < positionY + sizeY) {
            klikket = !klikket;
        }
    }


    void tegnTextFlet() {
        p.stroke(1, 46, 74, 100);
        p.fill(227, 225, 252, 250);
        p.rect(positionX, positionY, sizeX, sizeY);

    }

    void keyindput(char key){

        if(klikket){
            indput = indput + key;
        }
        p.println(indput);
    }




}

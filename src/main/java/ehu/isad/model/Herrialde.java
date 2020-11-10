package ehu.isad.model;

import javafx.scene.image.Image;

public class Herrialde {

    private String izena;
    private Image bandera;
    private String tv;

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public Herrialde(String izena, String bandera, String tv) {
        this.izena = izena;
        this.bandera = new Image("banderak/"+bandera+".png");
        this.tv = tv;
    }
}

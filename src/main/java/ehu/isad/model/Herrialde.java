package ehu.isad.model;

public class Herrialde {

    private String izena;
    private String bandera;
    private String tv;

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
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
        this.bandera = bandera;
        this.tv = tv;
    }
}

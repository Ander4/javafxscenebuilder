package ehu.isad.model;

public class Top3Herri {

    private String izena;
    private String bandera;
    private int puntuGuztiak;

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

    public int getPuntuGuztiak() {
        return puntuGuztiak;
    }

    public void setPuntuGuztiak(int puntuGuztiak) {
        this.puntuGuztiak = puntuGuztiak;
    }

    public Top3Herri(String izena, String bandera, int puntuGuztiak) {
        this.izena = izena;
        this.bandera = bandera;
        this.puntuGuztiak = puntuGuztiak;
    }
}

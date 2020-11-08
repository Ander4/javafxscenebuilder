package ehu.isad.model;

import javafx.scene.image.Image;

public class HerrialdeaBozkatu {

    private Image bandera;
    private String herrialdea;
    private String artista;
    private String abesti;
    private int puntoak;

    public Image getBandera() {
        return bandera;
    }

    public void setBandera(Image bandera) {
        this.bandera = bandera;
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String izena) {
        this.herrialdea = izena;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAbesti() {
        return abesti;
    }

    public void setAbesti(String abesti) {
        this.abesti = abesti;
    }

    public int getPuntoak() {
        return puntoak;
    }

    public void setPuntoak(int puntoak) {
        this.puntoak = puntoak;
    }

    public HerrialdeaBozkatu(String bandera, String izena, String artista, String abesti) {
        this.bandera = new Image("banderak/"+bandera+".png");
        this.herrialdea = izena;
        this.artista = artista;
        this.abesti = abesti;
        this.puntoak = 0;
    }
}

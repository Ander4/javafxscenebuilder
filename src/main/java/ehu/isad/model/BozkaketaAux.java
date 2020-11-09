package ehu.isad.model;

public class BozkaketaAux {

    String herrialdea;
    int puntuak;

    @Override
    public boolean equals(Object obj) {
        return herrialdea == obj.toString();
    }

    public String getHerrialdea() {
        return herrialdea;
    }

    public void setHerrialdea(String herrialdea) {
        this.herrialdea = herrialdea;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    public BozkaketaAux(String herrialdea, int puntuak) {
        this.herrialdea = herrialdea;
        this.puntuak = puntuak;
    }
}

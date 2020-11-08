package ehu.isad.controller.db;


import ehu.isad.model.Herrialde;
import ehu.isad.model.HerrialdeaBozkatu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BozkaketaDBKud {

    private static BozkaketaDBKud instantzia = new BozkaketaDBKud();

    public static BozkaketaDBKud getInstantzia(){
        return instantzia;
    };

    private BozkaketaDBKud(){}


    public String bozkatuDu(String Herri) throws SQLException {
        String emaitza = "";
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
        String query = ("SELECT bandera FROM Bozkaketa b, Herrialde h WHERE b.bozkatuDu = '"+Herri+"' AND b.bozkatuDu = h.izena") ;
        ResultSet rs = dbkud.execSQL(query);
        if(rs.next()){

            emaitza = rs.getString("bandera");

        }
        return emaitza;
    }

    public List<HerrialdeaBozkatu> lortuBozkatzeko(){

        List<HerrialdeaBozkatu> emaitza = new ArrayList<>();
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

        String query = "SELECT o.artista, o.herrialdea, o.abestia, o.puntuak, h.bandera FROM Ordezkaritza o, Herrialde h WHERE o.herrialdea = h.izena";
        ResultSet rs = dbkud.execSQL(query);

        try {
            while (rs.next()) {

                String artista = rs.getString("artista");
                String herrialdea = rs.getString("herrialdea");
                String abestia = rs.getString("abestia");
                String bandera = rs.getString("bandera");

                HerrialdeaBozkatu datua = new HerrialdeaBozkatu(bandera, herrialdea, artista, abestia);
                emaitza.add(datua);
            }
        }catch (SQLException e){
            System.err.println(e);
        }


        return emaitza;

    }

}

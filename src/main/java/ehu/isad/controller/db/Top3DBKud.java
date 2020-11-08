package ehu.isad.controller.db;

import ehu.isad.model.HerrialdeaBozkatu;
import ehu.isad.model.Top3Herri;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Top3DBKud {

    // singleton patroia

    private static Top3DBKud instantzia = new Top3DBKud();

    public static Top3DBKud getInstantzia() {
        return instantzia;
    }

    ;

    private Top3DBKud() {
    }

    public List<Top3Herri> lortuTop3() {

        List<Top3Herri> emaitza = new ArrayList<>();
        DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

        String query = "select h.izena, h.bandera, o.puntuak FROM Ordezkaritza o, Herrialde h WHERE o.herrialdea=h.izena ORDER BY(o.puntuak) DESC LIMIT 3";
        ResultSet rs = dbkud.execSQL(query);

        try {
            while (rs.next()) {

                String izena = rs.getString("izena");
                String bandera = rs.getString("bandera");
                int puntuak = rs.getInt("puntuak");

                Top3Herri herri = new Top3Herri(izena, bandera, puntuak);
                emaitza.add(herri);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }


        return emaitza;
    }
}

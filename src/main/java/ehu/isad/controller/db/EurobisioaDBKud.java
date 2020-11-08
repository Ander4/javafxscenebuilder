package ehu.isad.controller.db;

import ehu.isad.model.Herrialde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EurobisioaDBKud {

  // singleton patroia

  private static EurobisioaDBKud instantzia = new EurobisioaDBKud();

  public static EurobisioaDBKud getInstantzia(){
      return instantzia;
  };

  private EurobisioaDBKud(){}

  public List<Herrialde> lortuHerrialdeak(){

    List<Herrialde> emaitza = new ArrayList<>();
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

    String query = "select * from Herrialde";
    ResultSet rs = dbkud.execSQL(query);

    try {
      while (rs.next()) {

        String izena = rs.getString("izena");
        String bandera = rs.getString("bandera");
        String tv = rs.getString("tv");

        Herrialde herrialdea = new Herrialde(izena,bandera,tv);
        emaitza.add(herrialdea);
      }
    }catch (SQLException e){
      System.err.println(e);
    }


    return emaitza;
  }

}

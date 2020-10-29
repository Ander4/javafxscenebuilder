package ehu.isad.controller.db;

import ehu.isad.model.Herrialde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EzarpenakDBKud {

  // singleton patroia

  private static EzarpenakDBKud instantzia = new EzarpenakDBKud();

  public static EzarpenakDBKud getInstantzia(){
      return instantzia;
  };

  private EzarpenakDBKud (){}

  public List<Herrialde> lortuEzarpenak(){

    List<Herrialde> emaitza = new ArrayList<>();
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();

    String query = "select * from Herrialde";
    ResultSet rs = dbkud.execSQL(query);

    try {
      while (rs.next()) {

        String izena = rs.getString("izena");
        String bandera = rs.getString("bandera");
        String tv = rs.getString("tv");

        Herrialde ezarpena = new Herrialde(izena,bandera,tv);
        emaitza.add(ezarpena);
      }
    }catch (SQLException e){
      System.err.println(e);
    }


    return emaitza;
  }

  public void eguneratu() {
    DBKudeatzaile dbkud = DBKudeatzaile.getInstantzia();
    dbkud.execSQL("INSERT INTO properties ('userid', 'key', 'value') values ('5','6','7')");

  }
}

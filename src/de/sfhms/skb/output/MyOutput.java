package de.sfhms.skb.output;

import de.sfhms.skb.SkbConfig;
import de.sfhms.skb.model.MyCell;
import de.sfhms.skb.model.MyDatamodel;
import de.sfhms.skb.model.MyRow;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author rbe
 */
public class MyOutput {

    private static SkbConfig config;
    private static Connection verbindung;

    public static void toDatabase(MyDatamodel model,MyCell date) throws SQLException {
        //Übertragung des Model in die Datenbank
        PreparedStatement pstmt = null;
        //verbindung = openDB();
        //
        MyRow row0 = model.getRow(0);
        StringBuilder builder = new StringBuilder("INSERT INTO ");
        builder.append(model.getName()).append(" (");
        for (int i = 0; i < row0.getCellCount(); i++) {
            builder.append(row0.getCell(i).getName());
            if (i < row0.getCellCount() - 1) {
                builder.append(", ");
            }
        }
        builder.append(") VALUES (");
        for (int i = 0; i < row0.getCellCount(); i++) {
            builder.append("?");
            if (i < row0.getCellCount() - 1) {
                builder.append(", ");
            }
        }
        builder.append(")");
        System.out.println(builder.toString());
        for (MyRow row : model.getRows()) {
            for (int i = 0; i < row.getCellCount(); i++) {
                System.out.println((i + 1) + " " + row.getCell(i).getName() + ": " + row.getCell(i).getValue().toString());
            }
        }
//        pstmt = verbindung.prepareStatement(" Values (NULL, ?, ?, ?, ?, ?, ?, ?);");
//        for (MyRow row : model.getRows()) {
//            for (int i=0;i<row.getCellCount();i++){
//                pstmt.setObject(i+1, row.getCell(i).getValue());
//            }
////            pstmt.setString(1, row.getCell(0).getValueAsString());
////            pstmt.setDouble(2, row.getCell(1).getValueAsDouble());
////            pstmt.setDouble(3, row.getCell(2).getValueAsDouble());
////            pstmt.setDouble(4, row.getCell(3).getValueAsDouble());
////            pstmt.setDouble(5, row.getCell(4).getValueAsDouble());
////            pstmt.setDate(6, row.getCell(5).getValue().);
////            pstmt.setString(7,"");
//         //   pstmt.executeQuery();
//        }
//        pstmt.close();


        //PPR

    }

    public static Connection openDB() {
        String treiber = "com.mysql.jdbc.Driver";
        config = SkbConfig.getInstance();
        String url = config.getDatasourceByName(config.getActualJob(), "mysql").getUrl() + "?user=root&password=toor";
        try {
            Class.forName(treiber).newInstance();
            verbindung = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return verbindung;
    }
    /*
    public static <T> void toDatabase(Class<T> clazz, MyDatamodel model) {
    // Check arguments
    if (null == model || (null != model && model.getRowCount() == 0)) {
    throw new IllegalArgumentException("Null or empty argument");
    }
    ColumnPositionMappingStrategy<T> strat = new ColumnPositionMappingStrategy<T>();
    strat.setType(clazz);
    // Get column names from first row
    List<MyCell> cell = model.getRow(0).getCells();
    String[] columns = new String[cell.size()];
    int i = 0;
    for (MyCell c : cell) {
    System.out.println("" + c.getName());
    columns[i++] = c.getName();
    }
    strat.setColumnMapping(columns);
    //
    CsvToBean<T> csv = new CsvToBean<T>();
    List<T> list = csv.parse(strat, new StringReader(s));
    }
     */
}

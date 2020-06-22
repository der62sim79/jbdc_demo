package at.ta.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        //Datenbank angabe
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/dcv_demo?user=root";

        //try catch mit Verbindungsaufbau zur Datenbank
        try {
            //Verbindung zur Datenbank
            connection = DriverManager.getConnection(url);
            System.out.println("Connectet to DB!");

            //Statment für MYSQL befehl
            String sql = "Select * from socks";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            //einzelne Zeilen ausgabe
            while (rs.next()){
                String name = rs.getString("nameSocks");
                String lastUse = rs.getDate("lastUse").toString();
                int size = rs.getInt("size");
                String comment = rs.getString("comment");
                System.out.println(name + " " + lastUse + " " + size + " " + comment + " ");
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}

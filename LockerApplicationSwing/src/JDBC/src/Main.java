import java.sql.*;

public class Main {
    public static void main(String[] args) {

        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306","root","pwd123");


            String query = "CREATE TABLE Product(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200), " +
                    "price_per_unit DOUBLE, active_for_sell BIT);";

            Statement statement = con.createStatement();
            statement.execute(query);


            statement =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String select = "SELECT * FROM Product;";

            ResultSet rs = statement.executeQuery(select);

            rs.moveToInsertRow();
            rs.updateString("name", "Cookie");
            rs.updateDouble("price_per_unit", 4000);
            rs.updateBoolean("active_for_sell", true);
            rs.insertRow();

            rs.updateString("name", "String");
            rs.updateDouble("price_per_unit", 2000);
            rs.updateBoolean("active_for_sell", true);
            rs.insertRow();

            rs.updateString("name", "Pepiz");
            rs.updateDouble("price_per_unit", 8000);
            rs.updateBoolean("active_for_sell", true);
            rs.insertRow();

            rs.updateString("name", "Coca Cola");
            rs.updateDouble("price_per_unit", 9000);
            rs.updateBoolean("active_for_sell", true);
            rs.insertRow();


            System.out.println(String.format("%-5s %-10s %-10s %-10s", "Id", "Name", "price_per_unit", "active_for_sell"));
            while (rs.next()){
                System.out.println(String.format("%-5s %-10s %-14s %-10s", rs.getInt(1),
                        rs.getString(2), rs.getDouble(3), rs.getBoolean(4)));
            }

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
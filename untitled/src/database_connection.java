import java.sql.*;
import java.util.Scanner;

public class database_connection {
    Connection con;
    Statement statement;
    ResultSet resultSet;
    String query;
    Scanner sc = new Scanner(System.in);

    public database_connection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:MySql://localhost:4001/parcel", "root", "");
            statement = con.createStatement();

        }

        catch (Exception e){
            System.out.println(e);
        }
    }

    public void search(int orderId){
        try{
            query = "SELECT * from parcel_tracking WHERE id="+orderId;
            resultSet = statement.executeQuery(query);
            System.out.format("%10s%25s%25s%25s%25s\n", "Order Id", "Source_Location", "Destination_Location", "Current_Location", "Status");

            if(resultSet.next()) {
                System.out.format("%10d%25s%25s%25s%25s\n", resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(4), resultSet.getString(6), resultSet.getString(7));
                System.out.println();
            }
            System.out.println("\t1. More info");
            System.out.print("\t2. Not Required\n\t➡ ");
            int inp = sc.nextInt();
            if(inp == 1){
                query = "SELECT * FROM parcel_details WHERE id="+orderId;
                resultSet = statement.executeQuery(query);

                if(resultSet.next()){
                    System.out.format("%25s%25s%25s%25s\n", "Source Address", "Source Pin Code", "Source City", "Source Contact No.");
                    System.out.printf("%25s%25d%25s%25s\n\n", resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));

                    System.out.format("%25s%25s%25s%25s\n", "Destination Address", "Destination Pin Code", "Destination City", "Destination Contact No.");
                    System.out.printf("%25s%25d%25s%25s\n\n", resultSet.getString(6), resultSet.getInt(7), resultSet.getString(8), resultSet.getString(9));
                }
                else
                    System.out.println("\tRecord Not Found..!");
            }
        }
        catch (Exception e){
            System.out.println(e+"\nWrong Order Id...!");
        }
    }

    public int newOrder(String src_add, int src_pinCode, String src_city, long src_contact,
                        String dst_add, int dst_pinCode, String dst_city, long dst_contact)
    {
        int order_id = 0;
        try{
            query = "INSERT INTO parcel_details" +
                    "(src_add, src_pinCode, src_city, src_contact," +
                    " dst_add, dst_pinCode, dst_city, dst_contact)" +
                    " VALUES('" +
                    src_add +"',"+ src_pinCode+",'"+src_city+"',"+src_contact+",'"+
                    dst_add+"',"+dst_pinCode+",'"+dst_city+"',"+ dst_contact+")";

            statement.executeUpdate(query);

            resultSet = statement.executeQuery("SELECT MAX( id ) FROM parcel_details");
            while(resultSet.next()) {
                order_id = resultSet.getInt(1);
            }

            query = "INSERT INTO parcel_tracking" +
                    "(id, src_add, src_pinCode, dst_add, dst_pinCode, curr_loc, delivery_status)"+
                    "VALUES("+
                    order_id+",'"+
                    src_city+"',"+src_pinCode+",'"+
                    dst_city+"',"+dst_pinCode+",'"+src_city+"','In-Transit')";

            statement.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return order_id;
    }

    public void adminLogin(int id, String password) {

        String url = "SELECT * from admin where id=" + id + " and password='" + password + "';";
        try {
            resultSet = statement.executeQuery(url);
            if (resultSet.next()) {
                System.out.println("\t✅Logged In Successfully");
                System.out.println("\t1. Place orders");
                System.out.println("\t2. Update location of orders");
                System.out.println("\t3. View location of orders");
                System.out.println("\t4. Mark Status");
                System.out.println("\tEnter your choice");
                System.out.print("\t🖋 ");
                int inp = sc.nextInt();
                System.out.println();
                switch (inp) {
                    case 1 :
                        NewOrder NOrderObj = new NewOrder();
                        NOrderObj.placeOrder();
                        break;
                    case 2 :
                        Admin AObj = new Admin();
                        AObj.updateLocation();
                        break;
                    case 3 :
                        viewLocation();
                        break;
                    case 4:
                        status();
                        break;
                    default :
                        System.out.println("\t❌Wrong input");
                }
            }
            else
                System.out.println("\t❌Wrong Credentials");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateLocation(int oid, String loc) throws Exception {
        query = "UPDATE parcel_tracking SET curr_loc='" + loc + "' where id='" + oid + "';";
        statement.executeUpdate(query);
        System.out.println("\tLocation updated!!");
    }

    public void viewLocation() throws Exception{
        System.out.println("\tEnter order id to check status");
        System.out.print("\t➡ ");
        String oid = sc.next();
        System.out.println();

        query = "SELECT curr_loc FROM parcel_tracking where id ='"+oid+"';";
        resultSet = statement.executeQuery(query);
        if (resultSet.next()){
            System.out.println("\tCurrent Location: "+resultSet.getString(1));
        }
        else {
            System.out.println("\tWrong Order Id..!");
        }
    }

    public void status() throws Exception {
        query = "UPDATE parcel_tracking SET delivery_status='Delivered' WHERE (curr_loc = dst_add)";
        statement.executeUpdate(query);
        System.out.println("\t\tUpdated..!");
    }
}


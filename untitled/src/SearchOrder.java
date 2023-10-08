import java.util.Scanner;

public class SearchOrder {

    int orderId;

    database_connection object = new database_connection();
    public void search(){
        System.out.println("\nEnter Order ID...");
        System.out.print("\t\t🖋 ");
        Scanner sc = new Scanner(System.in);
        orderId = sc.nextInt();
        object.search(orderId);
        //sc.close();
    }

}

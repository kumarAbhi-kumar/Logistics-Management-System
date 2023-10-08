import java.util.Scanner;

public class NewOrder {
    database_connection object = new database_connection();
    Scanner sc = new Scanner(System.in);

    int option;
    String garbage_string;

    public void placeOrder(){
        int validation = 0;
        while (validation != 1)
        {
//            garbage_string = sc.nextLine();

            System.out.println("\t<#>Enter Source Address");
            System.out.print("\t\t->");
            String src_add = sc.nextLine();
            System.out.println();
            System.out.println("\t<#>Enter Source Pin Code");
            System.out.print("\t\t->");
            int src_pinCode = sc.nextInt();
            System.out.println();

            garbage_string = sc.nextLine();

            System.out.println("\t<#>Enter Source City");
            System.out.print("\t\t->");
            String src_city = sc.nextLine();
            System.out.println();
            System.out.println("\t<#>Enter Your Contact number");
            System.out.print("\t\t->");
            long src_contact = sc.nextLong();
            System.out.println();

            garbage_string = sc.nextLine();

            System.out.println("\n\t<#>Enter Destination Address\n");
            System.out.print("\t\t->");
            String dst_add = sc.nextLine();
            System.out.println();
            System.out.println("\t<#>Enter Destination Pin Code");
            System.out.print("\t\t->");
            int dst_pinCode = sc.nextInt();
            System.out.println();

            garbage_string = sc.nextLine();

            System.out.println("\t<#>Enter Destination City");
            System.out.print("\t\t->");
            String dst_city = sc.nextLine();
            System.out.println();
            System.out.println("\t<#>Enter Receiver Contact number");
            System.out.print("\t\t->");
            long dst_contact = sc.nextLong();
            System.out.println();

            System.out.format("%25s%25s%25s%25s\n", "Source Address", "Source Pin Code", "Source City", "Source Contact No.");
            System.out.printf("%25s%25d%25s%25s\n\n", src_add, src_pinCode, src_city, src_contact);

            System.out.format("%25s%25s%25s%25s\n", "Destination Address", "Destination Pin Code", "Destination City", "Destination Contact No.");
            System.out.printf("%25s%25d%25s%25s\n\n", dst_add, dst_pinCode, dst_city, dst_contact);

            System.out.println("\t✅1. Confirm");
            System.out.println("\t🌀2. Re-Enter");
            option = sc.nextInt();

            if(option == 1){
                System.out.println("Order Received");
                try {
                    //int order_id = object.newOrder(src_add, src_pinCode, src_city, src_contact, dst_add, dst_pinCode, dst_city, dst_contact);
                    int order_id = object.newOrder(src_add, src_pinCode, src_city, src_contact,
                                                    dst_add, dst_pinCode, dst_city, dst_contact);
                    System.out.println("Order Id: "+order_id);
                }
                catch (Exception e){
                    System.out.println(e);
                }
                validation = 1;
            }


        }
    }
}


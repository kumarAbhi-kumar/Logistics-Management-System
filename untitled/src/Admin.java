import java.util.Scanner;

public class Admin {
    Scanner sc = new Scanner(System.in);
    database_connection object = new database_connection();
    String garbage_string;
    int option;

    public void adminLogin(){
        int validation = 0;
        while (validation != 1){



            System.out.print("\tEnter your ID ➡ ");
            int id = sc.nextInt();
            System.out.println();

            garbage_string = sc.nextLine();

            System.out.print("\tEnter your Password ➡ ");
            String pwd = sc.nextLine();
            System.out.println();

            System.out.println("\t✅1. Login");
            System.out.println("\t🌀2. Re-Enter");
            System.out.print("\n\t👉");
            option = sc.nextInt();
            System.out.println();

            if(option == 1){
                validation = 1;
                object.adminLogin(id, pwd);
            }
        }
    }

    public void updateLocation() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\tEnter order id:");
        System.out.print("\t➡ ");
        int oid = sc.nextInt();

        System.out.println("\nEnter order location:");
        System.out.print("➡ ");
        String loc = sc.next();
        object.updateLocation(oid, loc);
    }

}

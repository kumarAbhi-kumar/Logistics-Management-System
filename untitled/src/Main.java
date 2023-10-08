import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println("🚚🚚🚚🚚🚚🚚🚚🚚🚚");
            System.out.println("1. Search🔎");
            System.out.println("2. Place order📝");
            System.out.println("3. Admin Login🎫");
            System.out.println("🚚🚚🚚🚚🚚🚚🚚🚚🚚");

            System.out.print("\t➡ ");
            
            option = sc.nextInt();
            System.out.println();

            if(option == 1){
                SearchOrder search = new SearchOrder();
                search.search();
                break;
            }

            if(option == 2) {
                NewOrder newOrder = new NewOrder();
                newOrder.placeOrder();
                break;
            }

            if(option == 3){
                Admin ALogin = new Admin();
                ALogin.adminLogin();
                break;
            }

            if(option == 4){
                break;
            }
        }
    }
}
import java.util.Scanner;


public class Login{
    User user = new User();
    Scanner scan = new Scanner(System.in);

    String dataName = "someName";
    String dataPass = "kk";

    System.out.println("enter Username");
    user.setName(scan.nextLine());
    String enteredName = user.getName();

    while (!enteredName.equals(dataName)) {
        System.out.println("Invalid user, please try again");
        System.out.println("enter Username");
        user.setName(scan.nextLine());
        enteredName = user.getName();
    }

    System.out.println("enter Password");
    user.setPassword(scan.nextLine());

    String enteredPassword = user.getPassword();
        while (!enteredPassword.equals(dataPass)){
        System.out.println("Invalid Password");
        System.out.println("enter Password");
        user.setPassword(scan.nextLine());
        enteredPassword = user.getPassword();
    }
        System.out.println("Login successful!");
}

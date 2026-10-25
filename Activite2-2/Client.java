import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Opérande 1 : ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.print("Opérateur (+ - * /) : ");
        char op = sc.nextLine().trim().charAt(0);
        System.out.print("Opérande 2 : ");
        double b = Double.parseDouble(sc.nextLine());

        try (Socket s = new Socket("localhost", 1234);
             ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())) {
            out.flush();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());

            out.writeObject(new Operation(a, op, b));
            out.flush();
            System.out.println("Résultat : " + in.readObject());
        }
    }
}

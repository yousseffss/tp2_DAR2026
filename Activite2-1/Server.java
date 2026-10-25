import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket ss = new ServerSocket(1234)) {
            System.out.println("Serveur en attente sur le port 1234...");
            while (true) {
                try (Socket s = ss.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                     PrintWriter out = new PrintWriter(s.getOutputStream(), true)) {

                    double x = Double.parseDouble(in.readLine());
                    String op = in.readLine();
                    double y = Double.parseDouble(in.readLine());
                    System.out.println("Reçu : " + x + " " + op + " " + y);

                    String res;
                    switch (op) {
                        case "+": res = String.valueOf(x + y); break;
                        case "-": res = String.valueOf(x - y); break;
                        case "*": res = String.valueOf(x * y); break;
                        case "/": res = (y == 0) ? "Erreur : division par zéro" : String.valueOf(x / y); break;
                        default:  res = "Erreur : opérateur invalide";
                    }
                    out.println(res);
                    System.out.println("Résultat envoyé : " + res);
                } catch (Exception e) {
                    System.out.println("Erreur : " + e.getMessage());
                }
            }
        }
    }
}

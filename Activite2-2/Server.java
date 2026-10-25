import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        try (ServerSocket ss = new ServerSocket(1234)) {
            System.out.println("Serveur en attente sur le port 1234...");
            while (true) {
                try (Socket s = ss.accept();
                     ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream())) {
                    out.flush();
                    ObjectInputStream in = new ObjectInputStream(s.getInputStream());

                    Operation o = (Operation) in.readObject();
                    double x = o.getOperande1(), y = o.getOperande2();
                    System.out.println("Objet reçu : " + x + " " + o.getOperateur() + " " + y);

                    String res;
                    switch (o.getOperateur()) {
                        case '+': res = String.valueOf(x + y); break;
                        case '-': res = String.valueOf(x - y); break;
                        case '*': res = String.valueOf(x * y); break;
                        case '/': res = (y == 0) ? "Erreur : division par zéro" : String.valueOf(x / y); break;
                        default:  res = "Erreur : opérateur invalide";
                    }
                    out.writeObject(res);
                    out.flush();
                    System.out.println("Résultat envoyé : " + res);
                } catch (Exception e) {
                    System.out.println("Erreur : " + e.getMessage());
                }
            }
        }
    }
}

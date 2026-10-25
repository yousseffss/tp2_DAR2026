import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.regex.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("^\\s*(-?\\d+(?:\\.\\d+)?)\\s*([+\\-*/])\\s*(-?\\d+(?:\\.\\d+)?)\\s*$");
        Matcher m;
        do {
            System.out.print("Entrez une opération (ex: 55 * 25) : ");
            m = p.matcher(sc.nextLine());
            if (!m.matches()) System.out.println("Syntaxe invalide (ex: 25 ** 55 ou abc + 3 refusés).");
        } while (!m.matches());

        try (Socket s = new Socket("localhost", 1234);
             PrintWriter out = new PrintWriter(s.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
            out.println(m.group(1));
            out.println(m.group(2));
            out.println(m.group(3));
            System.out.println("Résultat : " + in.readLine());
        }
    }
}

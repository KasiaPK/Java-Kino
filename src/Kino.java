package src;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Kino {

    public static void zapiszDoPliku(String filename, String dane) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(filename));
        out.write(dane);
        out.close();
    }

    public static String odczytajZPliku(String filename) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        StringBuilder dane = new StringBuilder();
        String strLine;
        while ((strLine = r.readLine()) != null) {
            dane.append(strLine).append("\n");
        }
        r.close();
        return dane.toString();
    }

    public static void serializujObiekt(String filename, Object obj) throws IOException {
        ObjectOutputStream wy = new ObjectOutputStream(new FileOutputStream(filename));
        wy.writeObject(obj);
        wy.close();
    }

    public static Object deserializujObiekt(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream we = new ObjectInputStream(new FileInputStream(filename));
        Object obj = we.readObject();
        we.close();
        return obj;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Seans seans = new Seans("Avengers", "2025-05-10", "18:00", 12, 5, 10);
        List<String> miejsca = Arrays.asList("A1", "A2");
        seans.rezerwujMiejsca(miejsca);
        Klient klient = new Klient("Kowalski", "Jan", "jan.kowalski@example.com", "123456789", seans, miejsca);

        // Zapis do pliku tekstowego
        zapiszDoPliku("seans.txt", seans.toString());
        System.out.println("Zapisano seans do pliku");

        // Odczyt z pliku
        System.out.println("Odczytano seans: \n" + odczytajZPliku("seans.txt"));

        // Serializacja obiektu
        serializujObiekt("klient.dat", klient);
        System.out.println("Zserializowano obiekt klienta");

        // Deserializacja obiektu
        Klient odczytanyKlient = (Klient) deserializujObiekt("klient.dat");
        System.out.println("Odczytany obiekt: " + odczytanyKlient);
    }
}

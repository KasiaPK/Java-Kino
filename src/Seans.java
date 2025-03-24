package src;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Seans implements Serializable {

    private static final long serialVersionUID = 1L;
    private String tytul;
    private String dzien;
    private String godzina;
    private int wiek;
    HashMap<Character, HashMap<Integer,Boolean>> miejsca;

    public Seans(String tytul, String dzien, String godzina, int wiek, int liczbaRzedow, int miejscaWRzedzie) {
        this.tytul = tytul;
        this.dzien = dzien;
        this.godzina = godzina;
        this.wiek = wiek;
        this.miejsca = new HashMap<>();

        for (char rzad = 'A'; rzad < 'A' + liczbaRzedow; rzad++) {
            HashMap<Integer, Boolean> rzadMiejsca = new HashMap<>();
            for (int i = 1; i <= miejscaWRzedzie; i++) {
                rzadMiejsca.put(i, false);
            }
            miejsca.put(rzad, rzadMiejsca);
        }
    }
    public boolean rezerwujMiejsca(List<String> wybraneMiejsca) {
        for (String miejsce : wybraneMiejsca) {
            char rzad = miejsce.charAt(0);
            int numer = Integer.parseInt(miejsce.substring(1));
            if (miejsca.containsKey(rzad) && miejsca.get(rzad).containsKey(numer) && !miejsca.get(rzad).get(numer)) {
                miejsca.get(rzad).put(numer, true);
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return tytul + " (" + dzien + " " + godzina + ")";
    }
}


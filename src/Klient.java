package src;

import java.io.Serializable;
import java.util.List;

public class Klient  implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nazwisko;
    private String imie;
    private String mail;
    private String telefon;
    private Seans seans;
    List<String> miejsca;

    public Klient(String nazwisko, String imie, String mail, String telefon, Seans seans, List<String> miejsca) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.mail = mail;
        this.telefon = telefon;
        this.seans = seans;
        this.miejsca = miejsca;
    }

    @Override
    public String toString() {
        return "Klient: " + imie + " " + nazwisko + ", Email: " + mail + ", Telefon: " + telefon + ", Seans: " + seans + ", Miejsca: " + miejsca;
    }
}


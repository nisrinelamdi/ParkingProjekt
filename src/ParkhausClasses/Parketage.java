/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkhausClasses;

import java.util.ArrayList;
import java.util.List;

public class Parketage {

    private int id;
    private String etagenName;
    private List<Parkplatz> parkplaetze = new ArrayList<>();

    // Konstruktor korrigiert, um etagenName zu initialisieren
    public Parketage(int id, String etagenName) {
        this.id = id;
        this.etagenName = etagenName;

    }

    // Methode findeFreienParkplatz
    public Parkplatz findeFreienParkplatz() {
        return parkplaetze.stream().filter(p -> !p.istBelegt()).findFirst().orElse(null);
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtagenName() {
        return etagenName;
    }

    public void setEtagenName(String etagenName) {
        this.etagenName = etagenName;
    }

    public List<Parkplatz> getParkplaetze() {
        return parkplaetze;
    }

    // Hier könnten weitere Methoden folgen, z.B. zum Hinzufügen oder Entfernen von Parkplätzen
}

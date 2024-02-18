/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkhausClasses;

/**
 *
 * @author tn
 */
public abstract class Fahrzeug {

    private int parkplatzId;
    private String besitzerNachname;
    private String besitzerVorname;
    private String fahrzeugtyp;
    private String nummernschild;
    private String parkzeitpunkt;
    private String ausfahrzeitpunkt;

    public Fahrzeug(int parkplatzId, String besitzer, String fahrzeugtyp, String nummernschild,
            String parkzeitpunkt, String ausfahrzeitpunkt) {
        this.parkplatzId = parkplatzId;
        this.besitzerNachname = besitzer;
        this.fahrzeugtyp = fahrzeugtyp;
        this.nummernschild = nummernschild;
        this.parkzeitpunkt = parkzeitpunkt;
        this.ausfahrzeitpunkt = ausfahrzeitpunkt;
    }

    public int getParkplatzId() {
        return parkplatzId;
    }

    public void setParkplatzId(int parkplatzId) {
        this.parkplatzId = parkplatzId;
    }

    public String getBesitzerVorname() {
        return besitzerVorname;
    }

    public void setBesitzerVorname(String besitzerVorname) {
        this.besitzerVorname = besitzerVorname;
    }

    public String getFahrzeugtyp() {
        return fahrzeugtyp;
    }

    public void setFahrzeugtyp(String fahrzeugtyp) {
        this.fahrzeugtyp = fahrzeugtyp;
    }

    public String getNummernschild() {
        return nummernschild;
    }

    public void setNummernschild(String nummernschild) {
        this.nummernschild = nummernschild;
    }

    public void setBesitzerNachname(String besitzerNachname) {
        this.besitzerNachname = besitzerNachname;
    }

    public String getParkzeitpunkt() {
        return parkzeitpunkt;
    }

    public void setParkzeitpunkt(String parkzeitpunkt) {
        this.parkzeitpunkt = parkzeitpunkt;
    }

    public String getAusfahrzeitpunkt() {
        return ausfahrzeitpunkt;
    }

    public void setAusfahrzeitpunkt(String ausfahrzeitpunkt) {
        this.ausfahrzeitpunkt = ausfahrzeitpunkt;
    }
}

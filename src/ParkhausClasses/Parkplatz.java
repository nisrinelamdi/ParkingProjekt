/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ParkhausClasses;

/**
 *
 * @author tn
 */
public class Parkplatz {

    private int id;
    private String parkplatzname;
    private String etagenname;

    ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkplatzname() {
        return parkplatzname;
    }

    public void setParkplatzname(String parkplatzname) {
        this.parkplatzname = parkplatzname;
    }

    public String getEtagenname() {
        return etagenname;
    }

    public void setEtagenname(String etagenname) {
        this.etagenname = etagenname;
    }

    public boolean isIstBelegt() {
        return istBelegt;
    }

    public void setIstBelegt(boolean istBelegt) {
        this.istBelegt = istBelegt;
    }
    private boolean istBelegt = false;
    private Fahrzeug parkendesFahrzeug;

    public boolean istBelegt() {
        return istBelegt;

    }

    public void parken(Fahrzeug fahrzeug) {
        this.istBelegt = true;
        this.parkendesFahrzeug = fahrzeug;
    }

    public void verlassen() {
        this.istBelegt = false;
        this.parkendesFahrzeug = null;
    }

    public Fahrzeug getParkendesFahrzeug() {
        return parkendesFahrzeug;
    }
}

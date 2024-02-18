package Dao;

import ParkhausClasses.Parketage;
import ParkhausClasses.Parkplatz;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    // Ein Auto im Parkhaus parken.
    public static boolean parkFahrzeug(int parkplatzId, String besitzerVorname, String nachname, String fahrzeugtyp, String nummernschild, String parkzeitpunkt) {
        String parkQuery = "INSERT INTO parkdaten (parkplatz_id, besitzerVorname, nachname, fahrzeugtyp, nummernschild, parkzeitpunkt) VALUES (?, ?, ?, ?, ?, ?)";
        String updateQuery = "UPDATE parkplaetze SET istBelegt = 'Ja' WHERE parkplatz_id = ?";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement parkPstmt = con.prepareStatement(parkQuery);  PreparedStatement updatePstmt = con.prepareStatement(updateQuery)) {

            // Parken
            parkPstmt.setInt(1, parkplatzId);
            parkPstmt.setString(2, besitzerVorname);
            parkPstmt.setString(3, nachname);
            parkPstmt.setString(4, fahrzeugtyp);
            parkPstmt.setString(5, nummernschild);
            parkPstmt.setString(6, parkzeitpunkt);
            parkPstmt.executeUpdate();

            // Parkplatzstatus aktualisieren
            updatePstmt.setInt(1, parkplatzId);
            updatePstmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
// Ein Auto aus dem Parkhaus entfernen.

    public static boolean entfernenFahrzeug(int parkdatenId) {
        String query = "UPDATE parkdaten SET ausfahrtszeitpunkt = CURRENT_TIMESTAMP WHERE parkdaten_id = ? AND ausfahrtszeitpunkt IS NULL";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, parkdatenId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
// Liste aller Autos, die gerade geparkt sind, bekommen.

    public static List<Parkplatz> getAktuelleParkdaten() {
        List<Parkplatz> parkplaetze = new ArrayList<>();
        String query = "SELECT * FROM parkdaten WHERE ausfahrtszeitpunkt IS NULL";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query);  ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {

                Parkplatz parkplatz = new Parkplatz();

                parkplaetze.add(parkplatz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkplaetze;
    }
// Liste aller freien Parkplätze bekommen.

    public static List<Parkplatz> getVerfuegbareParkplaetze() {
        List<Parkplatz> verfuegbareParkplaetze = new ArrayList<>();
        String query = "SELECT p.parkplatz_id, p.parkplatz_name, e.etagen_name FROM parkplaetze p "
                + "JOIN etagen e ON p.etagen_id = e.etagen_id WHERE p.istBelegt = 'nein'";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query);  ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Parkplatz parkplatz = new Parkplatz();
                parkplatz.setId(rs.getInt("parkplatz_id"));
                parkplatz.setParkplatzname(rs.getString("parkplatz_name"));
                parkplatz.setEtagenname(rs.getString("etagen_name"));
                verfuegbareParkplaetze.add(parkplatz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return verfuegbareParkplaetze;
    }

    // Ein Auto aus dem Parkhaus fahren lassen.
    public static boolean verlassenParkplatz(String nummernschild, String ausfahrtzeitpunkt) {

        String findVehicleQuery = "SELECT parkplatz_id FROM parkdaten WHERE nummernschild = ? AND ausfahrtszeitpunkt IS NULL";
        String updateParkdatenQuery = "UPDATE parkdaten SET ausfahrtszeitpunkt = ? WHERE nummernschild = ? AND ausfahrtszeitpunkt IS NULL";
        String updateParkplaetzeQuery = "UPDATE parkplaetze SET istBelegt = 'Nein' WHERE parkplatz_id = ?";

        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement findVehiclePstmt = con.prepareStatement(findVehicleQuery);  PreparedStatement updateParkdatenPstmt = con.prepareStatement(updateParkdatenQuery);  PreparedStatement updateParkplaetzePstmt = con.prepareStatement(updateParkplaetzeQuery)) {

            // Überprüfen, ob das Fahrzeug existiert
            findVehiclePstmt.setString(1, nummernschild);
            ResultSet rs = findVehiclePstmt.executeQuery();
            if (rs.next()) {
                int parkplatzId = rs.getInt("parkplatz_id");

                updateParkdatenPstmt.setString(1, ausfahrtzeitpunkt);
                updateParkdatenPstmt.setString(2, nummernschild);
                updateParkdatenPstmt.executeUpdate();

                updateParkplaetzePstmt.setInt(1, parkplatzId);
                updateParkplaetzePstmt.executeUpdate();

                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Wie viele freie Parkplätze gibt es?
    public static int anzahlFreieParkplaetze() {
        String query = "SELECT COUNT(*) AS freieParkplaetze FROM parkplatz WHERE istBelegt = false";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query);  ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("freieParkplaetze");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Einen Administrator anmelden. // email und Passwort finden Sie in sql Datei =>testdaten
    public static boolean authentifiziereAdmin(String email, String kennwort) {
        String query = "SELECT * FROM administratoren WHERE email = ? AND kennwort = ?";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, email);
            pstmt.setString(2, kennwort); // Hier sollte der Hash des Kennworts verwendet werden

            try ( ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Einen Parkplatz zur Datenbank hinzufügen.

    public static boolean addParkplatz(String parkplatzName, int etagenId, String istBelegt) {
        String query = "INSERT INTO parkplaetze (parkplatz_name, etagen_id, istBelegt) VALUES (?, ?, ?)";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, parkplatzName);
            pstmt.setInt(2, etagenId);
            pstmt.setString(3, istBelegt);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Überprüfen, ob ein Kennzeichen schon im Parkhaus ist.

    public static boolean istSchildnummerVerfuegbar(String nummernschild) {
        String query = "SELECT COUNT(*) FROM parkdaten WHERE nummernschild = ? AND ausfahrtszeitpunkt IS NULL";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, nummernschild);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Eine Etage zum Parkhaus hinzufügen.

    public static boolean addEtage(String etagenName) {
        String query = "INSERT INTO etagen (etagen_name) VALUES (?)";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, etagenName);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Eine Etage aus dem Parkhaus entfernen.

    public static boolean deleteEtage(int etagenId) {
        Connection con = null;
        try {
            con = ConnectionProvider.getCon();

            con.setAutoCommit(false);

            String deleteParkplaetzeQuery = "DELETE FROM parkplaetze WHERE etagen_id = ?";
            try ( PreparedStatement pstmt = con.prepareStatement(deleteParkplaetzeQuery)) {
                pstmt.setInt(1, etagenId);
                pstmt.executeUpdate();
            }

            String deleteEtageQuery = "DELETE FROM etagen WHERE etagen_id = ?";
            try ( PreparedStatement pstmt = con.prepareStatement(deleteEtageQuery)) {
                pstmt.setInt(1, etagenId);
                int affectedRows = pstmt.executeUpdate();

                con.commit();
                return affectedRows > 0;
            }
        } catch (SQLException e) {
            if (con != null) {
                try {

                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
            return false;
        } finally {
            if (con != null) {
                try {
                    con.setAutoCommit(true);
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // Einen Parkplatz mit einem bestimmten Namen hinzufügen.

    public static boolean addParkplatz(String parkplatzName, String etagenName, String istBelegt) {

        int etagenId = getEtageIdByName(etagenName);

        if (etagenId == -1) {

            return false;
        }

        String query = "INSERT INTO parkplaetze (parkplatz_name, etagen_id, istBelegt) VALUES (?, ?, ?)";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, parkplatzName);
            pstmt.setInt(2, etagenId);
            pstmt.setString(3, istBelegt);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Alle Etagennamen bekommen.

    public static List<String> getAlleEtagenNamen() {
        List<String> etagenNamen = new ArrayList<>();
        String query = "SELECT etagen_name FROM etagen";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query);  ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                etagenNamen.add(rs.getString("etagen_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etagenNamen;
    }
    // Die ID einer Etage durch ihren Namen bekommen.

    public static int getEtageIdByName(String etagenName) {
        String query = "SELECT etagen_id FROM etagen WHERE etagen_name = ?";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, etagenName);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("etagen_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Wenn keine passende Etage gefunden wurde
    }
    // Den Namen einer Etage durch ihre ID bekommen.

    public static String getEtageNameById(int etagenId) {
        String query = "SELECT etagen_name FROM etagen WHERE etagen_id = ?";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, etagenId);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("etagen_name");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // Liste aller Etagen bekommen.

    public static List<Parketage> getAlleEtagen() {
        List<Parketage> etagenListe = new ArrayList<>();
        String query = "SELECT etagen_id, etagen_name FROM etagen";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query);  ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("etagen_id");
                String name = rs.getString("etagen_name");
                etagenListe.add(new Parketage(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etagenListe;
    }

    // Liste aller Parkplätze bekommen.
    public static List<Parkplatz> getAllParkplaetze() {
        List<Parkplatz> parkplaetze = new ArrayList<>();
        String query = "SELECT p.parkplatz_id, p.parkplatz_name, e.etagen_name, p.istBelegt "
                + "FROM parkplaetze p "
                + "JOIN etagen e ON p.etagen_id = e.etagen_id";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query);  ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Parkplatz parkplatz = new Parkplatz();
                parkplatz.setId(rs.getInt("parkplatz_id"));
                parkplatz.setParkplatzname(rs.getString("parkplatz_name"));
                parkplatz.setEtagenname(rs.getString("etagen_name"));
                parkplatz.setIstBelegt(rs.getString("istBelegt").equals("Ja"));

                parkplaetze.add(parkplatz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkplaetze;
    }
    // Die ID eines Parkplatzes durch seinen Namen bekommen.

    public static int getParkplatzIdByName(String parkplatzName) {
        String query = "SELECT parkplatz_id FROM parkplaetze WHERE parkplatz_name = ?";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, parkplatzName);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("parkplatz_id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Wenn keine passende ID gefunden wurde:)))
    }
    // Einen Parkplatz aus der Datenbank entfernen.

    public static boolean deleteParkplatz(int parkplatzId) {
        String query = "DELETE FROM parkplaetze WHERE parkplatz_id = ?";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, parkplatzId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    // Einen Parkplatz aktualisieren.

    public static boolean updateParkplatz(int id, String parkplatzName, String istBelegt) {
        // Überprüfen, ob der String-Wert korrekt ist ('Ja' oder 'Nein')
        if (!istBelegt.equals("Ja") && !istBelegt.equals("Nein")) {
            System.out.println("istBelegt muss entweder 'Ja' oder 'Nein' sein.");
            return false;
        }

        String query = "UPDATE parkplaetze SET parkplatz_name = ?, istBelegt = ? WHERE parkplatz_id = ?";
        try ( Connection con = ConnectionProvider.getCon();  PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, parkplatzName);
            pstmt.setString(2, istBelegt);
            pstmt.setInt(3, id);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

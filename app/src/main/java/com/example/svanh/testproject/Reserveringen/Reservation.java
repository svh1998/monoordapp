package com.example.svanh.testproject.Reserveringen;

/**
 * Created by svanh on 3-10-2017.
 */

public class Reservation {
    private String begintijd, eindtijd, datum, zaal;
    private int reserveringsnummer;

    public Reservation(String begintijd, String eindtijd, String datum, String zaal, int reserveringsnummer) {
        this.begintijd = begintijd;
        this.eindtijd = eindtijd;
        this.datum = datum;
        this.zaal = zaal;
        this.reserveringsnummer = reserveringsnummer;
    }

    public String getBegintijd() {
        return begintijd;
    }

    public void setBegintijd(String begintijd) {
        this.begintijd = begintijd;
    }

    public String getEindtijd() {
        return eindtijd;
    }

    public void setEindtijd(String eindtijd) {
        this.eindtijd = eindtijd;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getZaal() {
        return zaal;
    }

    public void setZaal(String zaal) {
        this.zaal = zaal;
    }

    public int getReserveringsnummer() {
        return reserveringsnummer;
    }

    public void setReserveringsnummer(int reserveringsnummer) {
        this.reserveringsnummer = reserveringsnummer;
    }
}

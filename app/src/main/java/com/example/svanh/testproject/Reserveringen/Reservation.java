package com.example.svanh.testproject.Reserveringen;

/**
 * Created by svanh on 3-10-2017.
 */

public class Reservation {
    private String begintijd, eindtijd, band, zaal, reserveringsnummer;

    public Reservation(String begintijd, String eindtijd, String band, String zaal, String reserveringsnummer) {
        this.begintijd = begintijd;
        this.eindtijd = eindtijd;
        this.zaal = zaal;
        this.reserveringsnummer = reserveringsnummer;
        this.band = band;
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

    public String getZaal() {
        return zaal;
    }

    public void setZaal(String zaal) {
        this.zaal = zaal;
    }

    public String getBand() {
        return zaal;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getReserveringsnummer() {
        return reserveringsnummer;
    }

    public void setReserveringsnummer(String reserveringsnummer) {
        this.reserveringsnummer = reserveringsnummer;
    }
}

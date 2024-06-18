package RA5.ejercicio2;

import java.util.Objects;

////country,city,latitude,longitude
public class Location {
    //atributos, constructor, getters y setters
    //toString tipo campo csv y separador ;
    //hashCode y Equals
    private String country;
    private String city;
    private double latitude;
    private double longitude;

    public Location(String country, String city, double latitude, double longitude) {
        this.country = country;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%.2f;%.2f", country, city, latitude, longitude);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(country, location.country) && Objects.equals(city, location.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}

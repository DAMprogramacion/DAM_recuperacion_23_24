package RA7;

public class Apartamento extends Alojamiento{

    private int numeroCamasIndividuales;
    private int numeroCamasDobles;

    public Apartamento(int id, String nombreAlojamiento, String direccionAlojamiento,
                       int numeroCamasIndividuales, int numeroCamasDobles) {
        super(id, nombreAlojamiento, direccionAlojamiento);
        this.numeroCamasIndividuales = numeroCamasIndividuales;
        this.numeroCamasDobles = numeroCamasDobles;
    }

    @Override
    public int obtenerAforo() {
        return numeroCamasIndividuales + 2 * numeroCamasDobles;
    }

    @Override
    public String toString() {
        return String.format("apartamento,%s,%d,%d", getNombreAlojamiento(),
                numeroCamasIndividuales,numeroCamasDobles);
    }
}

package RA7;
/* -nº habitaciones
    -nº huéspedes por habitación
    -nº estrellas*/

public class Hotel extends Alojamiento {
    private int numeroHabitaciones;
    private int numeroHuespedesPorHabitacion;
    private int numeroEstrellas;

    public Hotel(int id, String nombreAlojamiento, String direccionAlojamiento,
                 int numeroHabitaciones, int numeroHuespedesPorHabitacion, int numeroEstrellas) {
        super(id, nombreAlojamiento, direccionAlojamiento);
        this.numeroHabitaciones = numeroHabitaciones;
        this.numeroHuespedesPorHabitacion = numeroHuespedesPorHabitacion;
        this.numeroEstrellas = numeroEstrellas;
    }

    @Override
    public int obtenerAforo() {
        return numeroHabitaciones * numeroHuespedesPorHabitacion;
    }
    //hotel,paraiso,2,3,4
    @Override
    public String toString() {
        return  String.format("hotel,%s,%d,%d,%d", super.getNombreAlojamiento(),numeroHabitaciones,
                numeroHuespedesPorHabitacion, numeroEstrellas);
    }
}

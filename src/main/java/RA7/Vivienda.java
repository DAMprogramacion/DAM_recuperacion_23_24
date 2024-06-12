package RA7;

import java.util.List;

public interface Vivienda {
    int obtenerAforo();
    static Vivienda obtenerAlojamientoMayorAforo(List<Alojamiento> alojamientos) {
        int mayorAforo = 0;
        Alojamiento alojamientoMayorAforo = null;
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.obtenerAforo() > mayorAforo) {
                mayorAforo = alojamiento.obtenerAforo();
                alojamientoMayorAforo = alojamiento;
            }
        }
        return alojamientoMayorAforo;
    }
    static void escribirViviendas (List<? extends Vivienda> viviendas){
        String pathHoteles = "hoteles.csv";
        String pathApartamentos = "apartamentos.csv";
        for (Vivienda vivienda : viviendas) {
            if (vivienda instanceof Hotel) {
                //escribir en path hotel
            } else {
                //escribir en path apartamento
            }
        }
    }
}

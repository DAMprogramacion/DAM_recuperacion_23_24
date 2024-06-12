package RA7;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Alojamiento[] alojamientos = {new Hotel(1, "hotel1", "direccionHotel2",
                3,2,3), new Hotel(2, "hotel2", "direccionHotel2",
                3,1,4),
                new Apartamento(3, "apartamento1", "direccionApartamento1",
                        3,2),
                new Apartamento(4, "apartamento2", "direccionApartamento2",
                        3,5)
        };
        AgenciaViaje agenciaViaje = new AgenciaViaje("agencia");
        for (Alojamiento alojamiento : alojamientos)
            agenciaViaje.addAlojamiento(alojamiento);
        agenciaViaje.eliminarAlojamiento(alojamientos[0]);
        agenciaViaje.actualizarY_O_Nombre_Direccion(2,"hotel1", "direccionHotel1");
        List<Alojamiento> alojamientosAgencia = agenciaViaje.getAlojamientos();
        alojamientosAgencia.forEach(System.out::println);
        System.out.println("--------Alojamiento de mayor aforo-------");
        System.out.println(Vivienda.obtenerAlojamientoMayorAforo(alojamientosAgencia));
       /* Alojamiento alojamiento1 = new Hotel(1, "hotel1", "direccionHotel2",
                3,2,3);
        Alojamiento alojamiento2 = new Hotel(2, "hotel2", "direccionHotel2",
                3,1,4);
        Alojamiento alojamiento3 = new Apartamento(3, "apartamento1", "direccionApartamento1",
                3,2);
        Alojamiento alojamiento4 = new Apartamento(4, "apartamento2", "direccionApartamento2",
                3,5);
        AgenciaViaje agenciaViaje = new AgenciaViaje("agencia");
        agenciaViaje.addAlojamiento(alojamiento1);
        agenciaViaje.addAlojamiento(alojamiento2);
        agenciaViaje.addAlojamiento(alojamiento3);
        agenciaViaje.addAlojamiento(alojamiento4);
        agenciaViaje.eliminarAlojamiento(alojamiento1);
        agenciaViaje.actualizarY_O_Nombre_Direccion(2,"hotel1", "direccionHotel1");
        List<Alojamiento> alojamientos = agenciaViaje.getAlojamientos();
        alojamientos.forEach(System.out::println);
        System.out.println("--------Alojamiento de mayor aforo-------");
        System.out.println(Vivienda.obtenerAlojamientoMayorAforo(alojamientos));*/
    }
}

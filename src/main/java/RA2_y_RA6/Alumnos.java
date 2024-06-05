package RA2_y_RA6;

import java.util.ArrayList;
import java.util.List;

public class Alumnos {
    private TipoClase tipoClase;
    private List<Persona> personas = new ArrayList<>();

    public Alumnos(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }
    public void addPersona(Persona persona) {
        personas.add(persona);
    }
    public boolean cambiarNombreAlumno(String dni, String nuevoNombre) {
        for (Persona persona : personas) {
            if (persona.getDni().equals(dni)) {
                persona.setNombrePersona(nuevoNombre);
                return true;  //localilzado y cambiado el nombre
            }
        }
        return false;  //no está ese DNI
    }
    public double obtenerEdadMedia () {
        int acumuladorEdades = 0;
        for (Persona persona : personas)
            acumuladorEdades +=  Helper.calcularEdad(persona.getFechaNacimiento());
        return acumuladorEdades / personas.size();
    }

    //método que nos devuelva el nº de alumnos mayores de edad.

    //método que nos devuelva un array con el alumno de mayor edad y el de menor alumno.

}

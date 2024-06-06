package RA2_y_RA6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alumnos {
    private TipoClase tipoClase;
    private List<Persona> personas = new ArrayList<>();

    public Alumnos(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
    }

    public TipoClase getTipoClase() {
        return tipoClase;
    }

    public List<Persona> getPersonas() {
        return personas;
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
       /* double acumuladorEdades = 0.0;
        for (Persona persona : personas)
            acumuladorEdades +=  Helper.calcularEdad(persona.getFechaNacimiento());
        return acumuladorEdades / personas.size();*/
        return personas.stream()
                .map(Persona::getFechaNacimiento)
                .mapToDouble(Helper::calcularEdad)
                .average()
                .orElse(0.0);
    }

    //método que nos devuelva el nº de alumnos mayores de edad.
    public int obtenerCantidadMayoresEdad() {
        /*int acumuladorMayoresEdad = 0;
        for (Persona persona : personas ) {
            if (Helper.calcularEdad(persona.getFechaNacimiento()) > 18)
                acumuladorMayoresEdad++;
        }
        return acumuladorMayoresEdad;*/
        return (int) personas.stream()
                .map(Persona::getFechaNacimiento)
                .map(Helper::calcularEdad)
                .filter(edad -> edad > 17)
                .count();
    }

    //método que nos devuelva un array con el alumno de mayor edad y el de menor alumno.
    public Persona[] obtenerPersonaMayorYPersonaMenor() {
        Persona[] array = new Persona[2];
        array[0] = obtenerAlumnoMayorEdad();
        array[1] = obtenerAlumnoMenorEdad();
        return array;
    }

    private Persona obtenerAlumnoMenorEdad() {
        if (personas.size() == 0)
            return null;
        Persona personaMenor = personas.get(0);
        for (int i = 1; i < personas.size(); i++) {
            if (personas.get(i).getFechaNacimiento().
                    isAfter(personaMenor.getFechaNacimiento())){
                personaMenor = personas.get(i);
            }
        }
        return personaMenor;
    }

    private Persona obtenerAlumnoMayorEdad() {
        Persona personaMayor = null;
        int mayorEdad = 0;
        for (Persona persona : personas) {
            if (Helper.calcularEdad(persona.getFechaNacimiento()) > mayorEdad){
                mayorEdad = Helper.calcularEdad(persona.getFechaNacimiento());
                personaMayor = persona;
            }
        }
        return personaMayor;
    }

    public static void main(String[] args) {
        Alumnos alumnos = new Alumnos(TipoClase.DAM);
        String fecha = "100-10-2000";
        String dni = "12345678";
        LocalDate fechaNacimiento =  Helper.obtenerFechas(fecha);
        if (fechaNacimiento != null)
            alumnos.addPersona(new Persona("juan", fechaNacimiento, "11111111h"));
        if (Helper.validarDNI(dni))
            alumnos.addPersona(new Persona("luis", LocalDate.of(2011,10,10), dni));
        alumnos.addPersona(new Persona("marisa", LocalDate.of(1990,10,10), "11111111h"));
        Persona[] personas = alumnos.obtenerPersonaMayorYPersonaMenor();
        System.out.println(Arrays.toString(personas));
        System.out.printf("Edad media: %.2f%n", alumnos.obtenerEdadMedia());
        System.out.println("Mayores de edad: " + alumnos.obtenerCantidadMayoresEdad());
    }
}

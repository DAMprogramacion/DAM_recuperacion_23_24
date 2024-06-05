package RA2_y_RA6;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Objects;

/*-nombre
  -fecha nacimiento
  -dni
  -constructor
  -getters y setters
  -toString (csv y fecha en formato xx-yy-dddd)
  -equals y hashCode*/
public class Persona {

    private String nombrePersona;
    private LocalDate fechaNacimiento;
    private String dni;

    public Persona(String nombrePersona, LocalDate fechaNacimiento, String dni) {
        this.nombrePersona = nombrePersona;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return String.format("%s,%d-%d-%d,%s", nombrePersona, fechaNacimiento.getDayOfMonth(),
                fechaNacimiento.getMonthValue(), fechaNacimiento.getYear(),dni);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dni);
    }

    public static void main(String[] args) {
        Persona persona = new Persona("jacinto garcía",
                LocalDate.of(2000, 10, 10), "11111111h");
        System.out.println(persona);
    }
}

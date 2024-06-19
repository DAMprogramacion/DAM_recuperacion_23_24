package RA8_y_RA9.ejercicio1;

import java.time.LocalDate;

//Renie Haward|39991829p|10/27/2023|4
public class Person {
    private String name;
    private String dni;
    private LocalDate birthDay;
    private int numberChilder;

    public Person(String name, String dni, LocalDate birthDay, int numberChilder) {
        this.name = name;
        this.dni = dni;
        this.birthDay = birthDay;
        this.numberChilder = numberChilder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

   /* public void setDni(String dni) {
        this.dni = dni;
    }*/

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public int getNumberChilder() {
        return numberChilder;
    }

    public void setNumberChilder(int numberChilder) {
        this.numberChilder = numberChilder;
    }
    //Renie Haward|39991829p|10/27/2023|4
    //Renie Haward,39991829p,10/27/2023,4

    @Override
    public String toString() {
        return String.format("%s,%s,%d/%d/%d,%d", name, dni,
                birthDay.getDayOfMonth(),birthDay.getMonthValue() ,
                birthDay.getYear(), numberChilder);
    }
}

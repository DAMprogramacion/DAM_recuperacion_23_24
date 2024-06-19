package RA8_y_RA9.ejercicio1;

import java.util.List;

public interface PersonDAO {
    //se definen las operaciones sobre la BD

    Person getPersonByDNI(String dni);
    //select *  from person;
    List<Person> getPeople();

    boolean deletePersonByDNI(String dni);
    boolean insertPerson(Person person);
    // update person set name="juanita" where dni = "38356379d";
    boolean updateNameByDNI(String dni, String newName);
}

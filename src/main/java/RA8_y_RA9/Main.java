package RA8_y_RA9;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //probar la conexión
        Connection connection1 = Conexion.getInstance().getConnection();
        System.out.println(connection1);
        //problamos singleton, miramos que tenga el mismo hashCode
        Connection connection2 = Conexion.getInstance().getConnection();
        System.out.println(connection2);
        //Crear un objeto Person, y comproba el toString
        String name = "Pedro Botera";
        String dni  = "12345678a";
        LocalDate date = LocalDate.of(2000,2,25);
        int nChildren = 4;
        Person person = new Person(name, dni, date, nChildren);
        System.out.println(person);
        System.out.println("===buscando persona===");
        //Buscamos una persona que está en la BD dni = 38356379d
        PersonDAO dao = new PersonDAOImp();
        person = dao.getPersonByDNI("38356379d");
        System.out.println(person);
        //Buscamos persona que no exista:
        person = dao.getPersonByDNI("99356379d");
        System.out.println(person);
        System.out.println("===toda la lista===");
        List<Person> people = dao.getPeople();
        people.forEach(System.out::println);
        System.out.println("===insertar persona===");
        person = new Person("juanito", "12345678a", LocalDate.of(1999,9,9), 5);
        boolean success = dao.insertPerson(person);
        System.out.println("Success: " + success);



    }
}

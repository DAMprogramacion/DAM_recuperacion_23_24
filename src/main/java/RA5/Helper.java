package RA5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<Persona> obtenerPersonasDesdeFichero(String sPath) throws IOException {
        List<Persona> personas = new ArrayList<>();
        //Crear un objeto Path (Path.of o Paths.get())
        Path path = Path.of(sPath);
        //Leer todas las líneas con readAllLines, devuelve List<String>
        List<String> lineas = Files.readAllLines(path);
        //troceamos en tokens usando split y separador la coma
        for (int i = 1; i < lineas.size() ; i++) {
            String[] tokens = lineas.get(i).split(",");
            //Solo se parsea el valor entero con Integer.parseInt
            int id = Integer.parseInt(tokens[0]);
            String firstName = tokens[1];
            String lastaName = tokens[2];
            String email = tokens[3];
            //creamos un método que dado el String, ejemplo Male devuelva Gender.MALE
            Gender gender = obtenterEnumGender(tokens[4]);
            //con cada trozo, lo usamos para el constructor
            Persona persona = new Persona(id, firstName, lastaName, email , gender);
            //añadimos a una lista, que es la que se devuelve
            personas.add(persona);
        }
        return personas;
    }
    public static long escribirFichero(String ruta, List<Persona> personas) {
        //creamos un builder
        //recorremos la lista
        //añadimos cada elemento usando el toString
        //usamos writeString
        return 0;
    }
    public static boolean validarEmail(String email) {

        return false;
    }
    private static Gender obtenterEnumGender(String gender) {
        switch (gender) {
            case "Male" -> {
                return Gender.MALE;
            }
            case "Female" ->  {
                return Gender.FEMALE;
            }
            case "Bigender" ->  {
                return Gender.BIGENDER;
            }
            case "Genderfluid" ->  {
                return Gender.GENDERFLUID;
            }
            case "Genderqueer" ->  {
                return Gender.GENDERQUEER;
            }
            case "non_binary" ->  {
                return Gender.NON_BINARY;
            }
            case "Agender" ->  {
                return Gender.AGENDER;
            }
            case "Polygender" ->  {
                return Gender.POLYGENDER;
            }



        }
        //usamos un switch, que viene Male devolvemos Gender.MALE
        //que viene Famele, devolvemos Gender.FAMALE
        return null;
    }

    public static void main(String[] args) {
        //mostramos la lista del csv usando el método correspondinte
        try {
            List<Persona> personas = obtenerPersonasDesdeFichero("files/output/personas_recp.csv");
            personas.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //escribir el fichero usando la lista anterior o parte de ella
        //probamos el validador del email
    }
}

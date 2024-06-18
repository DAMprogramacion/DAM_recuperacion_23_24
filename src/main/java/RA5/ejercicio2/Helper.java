package RA5.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List<Location> getLocation(String path) throws IOException {
        //Crear el objeto Path a partir del String
        Path path1 = Paths.get(path);
        //Creamos una lista vacía de objetos Location
        List<Location> locations = new ArrayList<>();
        //Leer todas las líneas del fichero con el método readAllLines de la clase Files
        List<String> lines = Files.readAllLines(path1);
        //omitimos la primera línea
        //recorremos el resto de líneas
        for (int i = 1; i < lines.size(); i++) {
            //dividimos cada línea en cuatro campos: country, city, latitude y longitude
            String[] tokens = lines.get(i).split(",");
            String country   = tokens[0];
            String city      = tokens[1];
            String sLatitude = tokens[2];
            //las dos últimas la pasamos a double, porque se leen como String
            double latitude  = Double.parseDouble(sLatitude);
            double longitude = Double.parseDouble(tokens[3]);
            //creamos un objeto Location
            Location location = new Location(country, city, latitude, longitude);
            //añadimos cada objeto a la lista
            locations.add(location);
        }
        //devolvemos la lista
        return locations;
    }

    public static void main(String[] args) {
        //leemos y mostramos los datos en consola
        try {
            List<Location> locations = Helper.getLocation("files/input/locations.csv");
            locations.forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

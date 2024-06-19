package RA5.ejercicio2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static void write10Location(String path, List<Location> locations) throws IOException {
        //Crear el path
        Path path1 = Path.of(path);

        //obtenemos un valor aleatorio y a partir de él cogemos diez valores
        Random random = new Random();
        int position = random.nextInt(locations.size());
        //ejemplo una lista de 100, sale el 10, cogemos 10, 11, 12 ... 19
        //ejemplo una lista de 100, sale el 98, cogemos 98, 99, 0, 1 ... 7
        //en el caso que superemos las posiciones, ejemplo 100 -> 0 101 -> 1
        //si supereamo la última posición usamos 100 % locations.size()
        //Creamos el fichero de salida y escribimos la primera posción:

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++)
            stringBuilder.append(locations.get((position + i) % locations.size()))
                    .append('\n');
        Files.writeString(path1, stringBuilder.toString().
                        substring(0, stringBuilder.toString().length() - 1),
                StandardOpenOption.CREATE);
    }

    public static void main(String[] args) {
        //leemos y mostramos los datos en consola
        try {
            List<Location> locations = Helper.getLocation("files/input/locations.csv");
            locations.forEach(System.out::println);
            String path = "files/output/diez.csv";
            Helper.write10Location(path, locations);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

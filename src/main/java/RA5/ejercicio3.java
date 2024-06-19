package RA5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;


public class ejercicio3 {
    public static void main(String[] args) {
        Path path = Paths.get("files/input/datos.txt");
        try {
            List<String> lineas = leerLineas (path);
            int numeroLineas = lineas.size();
            int numeroPalabras = calcularNumeroPalabras(lineas);
            List<String> palabras = buscarCincoPalabras(lineas);
            //en el main, crear un StringBuilder con el informe
            StringBuilder builder = new StringBuilder();
            /*INFORME DEL ARCHIVO:
            Nº líneas: 7
            Nº palabras: 125  (suposición)
            CINCO PALABRAS AL AZAR: eficacia, simplicidad, método, sino, nosotros
             */
            builder.append("INFORME DEL ARCHIVO\n");
            builder.append("Nº líneas: ").append(numeroLineas).append('\n');
            builder.append("Nº palabras: ").append(numeroPalabras).append('\n');
            builder.append("CINCO PALABRAS AL AZAR: ");
            for (String palabra : palabras)
                builder.append(palabra).append(", ");
            String datos = builder.toString().substring(0, builder.toString().length() - 2);
            escribirDatos(datos, "files/output/analisis_fichero.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void escribirDatos(String datos, String ruta) throws IOException {
        Path path = Path.of(ruta);
        Files.writeString(path, datos, StandardOpenOption.CREATE);
    }

    //método le pasamos List<String>, si tiene cinco líneas, eliges una al azar y haces split
    //y escoges aleatoriamente una palabra
    private static List<String> buscarCincoPalabras(List<String> lineas) {
        List<String> palabras = new ArrayList<>();
        Random random = new Random();
        do {
            int lineaAlAzar = random.nextInt(lineas.size());
            String[] tokens = lineas.get(lineaAlAzar).split("\s+");
            int palabraAlAzar =  random.nextInt(tokens.length);
            if (!palabras.contains(tokens[palabraAlAzar]))
                palabras.add(tokens[palabraAlAzar].replaceFirst("[\\., ]", ""));
        } while (palabras.size() < 4);
        return palabras;
    }

    //método le pasamos List<String> y buscamos palabras en cada línea y devolvemo el nº
    private static int calcularNumeroPalabras(List<String> lineas) {
        int contadorPalabras = 0;
        for (String linea : lineas) {
            String[] tokens = linea.split("\s+");
            contadorPalabras += tokens.length;
        }
        return contadorPalabras;
    }

    //método para leer fichero, devuelve el List<String>
    private static List<String> leerLineas(Path path) throws IOException {
        return Files.readAllLines(path);
    }
    //luego un método para escribir (files/output/analisis_fichero.txt)


}

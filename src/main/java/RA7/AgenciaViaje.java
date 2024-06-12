package RA7;

import java.util.ArrayList;
import java.util.List;

public class AgenciaViaje {
    private String nombreAgencia;
    private List<Alojamiento> alojamientos;

    public AgenciaViaje(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
        this.alojamientos  = new ArrayList<>();
    }

    public AgenciaViaje(String nombreAgencia, List<Alojamiento> alojamientos) {
        this.nombreAgencia = nombreAgencia;
        this.alojamientos = alojamientos;
    }
    public String getNombreAgencia() {
        return nombreAgencia;
    }
    //métodos CRUD:
    public boolean addAlojamiento(Alojamiento alojamiento) {
        return alojamientos.add(alojamiento);
    }
    public boolean eliminarAlojamiento(Alojamiento alojamiento) {
        return alojamientos.remove(alojamiento);
    }
    public List<Alojamiento> getAlojamientos() {
        return alojamientos;
    }
    public boolean actualizarY_O_Nombre_Direccion(int id, String nuevoNombre, String nuevaDirecion)  {
        for (Alojamiento alojamiento : alojamientos) {
            if(alojamiento.getId() == id) {
                alojamiento.setNombreAlojamiento(nuevoNombre);
                alojamiento.setDireccionAlojamiento(nuevaDirecion);
                return true;
            }
        }
        return false;
    }
}

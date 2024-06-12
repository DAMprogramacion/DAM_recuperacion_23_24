package RA7;

import java.util.Objects;

/*id : int
   -nombre: String
   -direccion: String*/
public abstract class Alojamiento implements Vivienda{
    private int id;
    private String nombreAlojamiento;
    private String direccionAlojamiento;

    public Alojamiento(int id, String nombreAlojamiento, String direccionAlojamiento) {
        this.id = id;
        this.nombreAlojamiento = nombreAlojamiento;
        this.direccionAlojamiento = direccionAlojamiento;
    }

    public int getId() {
        return id;
    }

  /*  public void setId(int id) {
        this.id = id;
    }*/

    public String getNombreAlojamiento() {
        return nombreAlojamiento;
    }

    public void setNombreAlojamiento(String nombreAlojamiento) {
        this.nombreAlojamiento = nombreAlojamiento;
    }

    public String getDireccionAlojamiento() {
        return direccionAlojamiento;
    }

    public void setDireccionAlojamiento(String direccionAlojamiento) {
        this.direccionAlojamiento = direccionAlojamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alojamiento that = (Alojamiento) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

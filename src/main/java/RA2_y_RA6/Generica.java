package RA2_y_RA6;

public class Generica<T extends Number> {
    private T valor;

    public Generica(T valor) {
        this.valor = valor;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }
    public  double getValorDoble() {
        return valor.doubleValue() * 2;
    }

    public static void main(String[] args) {
        Generica<Integer> entero = new Generica<>(2);
        Generica<Double>  real   = new Generica<>(2.2);
      //  Generica<String>  cadena = new Generica<String>("hola");
        System.out.println(entero.getValorDoble());
    }
}

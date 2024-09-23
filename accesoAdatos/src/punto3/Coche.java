package punto3;

public class Coche {
    private String marca;
    private String modelo;
    private int anio;

    public Coche(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Coche [Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio + "]";
    }
}

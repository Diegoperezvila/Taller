import java.util.ArrayList;
import java.util.Collection;

public class Vehiculo {
    private String matricula;
    private String color;
    private String marca;
    public Vehiculo(String matricula, String color, String marca){
        this.matricula=matricula;
        this.color=color;
        this.marca=marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void Reparar(){
        System.out.println("Vehiculo no seleccionado");
    }
    public void AnadirPieza(String pieza){
        System.out.println("Vehiculo no seleccionado");
    }

    public ArrayList<String> getPiezas() {
        return new ArrayList<>();
    }

}

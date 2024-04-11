import java.util.ArrayList;
public class Camion extends Vehiculo{
    ArrayList<String> Piezas = new ArrayList<>();
    public Camion(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }

    @Override
    public void Reparar() {
        System.out.println("Camión Reparado");
    }
    @Override
    public void AnadirPieza(String pieza){
        Piezas.add(pieza);
    }
    @Override
    public String toString() {
        return "Camión{" +
                "Matricula='" + this.getMatricula() + '\'' +
                ", Color='" + this.getColor() + '\'' +
                ", Marca='" + this.getMarca() + '\'' +
                ", Piezas=" + Piezas +
                '}';
    }
    @Override
    public ArrayList<String> getPiezas() {
        return Piezas;
    }

}

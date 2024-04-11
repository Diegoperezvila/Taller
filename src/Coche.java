import java.util.ArrayList;
public class Coche extends Vehiculo{
    ArrayList<String> Piezas = new ArrayList<>();
    public Coche(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }

    @Override
    public void Reparar() {
        System.out.println("Coche Reparado");
    }
    @Override
    public void AnadirPieza(String pieza){
        Piezas.add(pieza);
    }

    @Override
    public String toString() {
        return "Coche{" +
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

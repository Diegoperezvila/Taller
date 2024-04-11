import java.util.ArrayList;
public class Tractor extends Vehiculo{
    ArrayList<String> Piezas = new ArrayList<>();
    public Tractor(String matricula, String color, String marca) {
        super(matricula, color, marca);
    }

    @Override
    public void Reparar() {
        System.out.println("Tractor Reparado");
    }
    @Override
    public void AnadirPieza(String pieza){
        Piezas.add(pieza);
    }
    @Override
    public String toString() {
        return "Tractor{" +
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

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menú:\n" +
                            "1. Meter vehículo\n" +
                            "2. Reparar vehículo\n" +
                            "3. Salir\n" +
                            "Ingrese el número de la opción deseada:"
            ));

            switch (opcion) {
                case 1:
                    String matricula = JOptionPane.showInputDialog("Ingrese la matrícula del vehículo:");
                    String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
                    String marca = JOptionPane.showInputDialog("Ingrese la marca del vehículo:");
                    String tipo = JOptionPane.showInputDialog("Ingrese el tipo de vehículo (Coche, Moto, Camion, Tractor o Grua):");

                    Vehiculo vehiculo = null;
                    switch (tipo.toLowerCase()) {
                        case "coche":
                            vehiculo = new Coche(matricula, color, marca);
                            break;
                        case "moto":
                            vehiculo = new Moto(matricula, color, marca);
                            break;
                        case "camion":
                            vehiculo = new Camion(matricula, color, marca);
                            break;
                        case "tractor":
                            vehiculo = new Tractor(matricula, color, marca);
                            break;
                        case "grua":
                            vehiculo = new Grua(matricula, color, marca);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Tipo de vehículo no válido.");
                            continue;
                    }

                    // Añadir piezas al vehículo
                    String piezasString = JOptionPane.showInputDialog("Ingrese las piezas a reparar separadas por comas:");
                    String[] piezas = piezasString.split(",");
                    for (String pieza : piezas) {
                        vehiculo.AnadirPieza(pieza.trim());
                    }

                    vehiculos.add(vehiculo);
                    JOptionPane.showMessageDialog(null, "Vehículo agregado correctamente.");
                    break;

                case 2:
                    if (vehiculos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay vehículos para reparar.");
                    } else {
                        int index = Integer.parseInt(JOptionPane.showInputDialog(
                                "Lista de vehículos para reparar:\n" +
                                        obtenerListaVehiculos(vehiculos) +
                                        "Ingrese el número del vehículo que desea reparar:"
                        ));
                        if (index >= 0 && index < vehiculos.size()) {
                            Vehiculo vehiculoReparar = vehiculos.get(index);
                            // Mostrar piezas a reparar
                            String piezasVehiculo = obtenerPiezas(vehiculoReparar);
                            String piezaSeleccionada = JOptionPane.showInputDialog(
                                    "Piezas a reparar:\n" + piezasVehiculo + "\n" +
                                            "Ingrese el número de la pieza que desea reparar:"
                            );
                            int piezaIndex = Integer.parseInt(piezaSeleccionada);
                            if (piezaIndex >= 0 && piezaIndex < vehiculoReparar.getPiezas().size()) {

                                vehiculoReparar.getPiezas().remove(piezaIndex);
                                JOptionPane.showMessageDialog(null, "Pieza reparada correctamente.");

                                if (vehiculoReparar.getPiezas().isEmpty()) {
                                    vehiculos.remove(index);
                                    JOptionPane.showMessageDialog(null, "Vehículo reparado completamente.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Índice de pieza no válido.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Índice de vehículo no válido.");
                        }
                    }
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese una opción válida.");
                    break;
            }
        } while (opcion != 3);
    }

    public static String obtenerListaVehiculos(ArrayList<Vehiculo> vehiculos) {
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < vehiculos.size(); i++) {
            lista.append(i).append(". ").append(vehiculos.get(i)).append("\n");
        }
        return lista.toString();
    }

    public static String obtenerPiezas(Vehiculo vehiculo) {
        StringBuilder piezas = new StringBuilder();
        ArrayList<String> piezasVehiculo = vehiculo.getPiezas();
        for (int i = 0; i < piezasVehiculo.size(); i++) {
            piezas.append(i).append(". ").append(piezasVehiculo.get(i)).append("\n");
        }
        return piezas.toString();
    }
}

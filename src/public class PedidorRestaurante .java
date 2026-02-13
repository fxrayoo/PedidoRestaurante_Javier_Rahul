public class PedidoRestaurante {
  //-- Clase interna para representar los artículos
  private class Articulo {
      String nombre;
      int cantidad; 
      double precioUnidad;

      public Articulo(String nombre, int cantidad, double precioUnidad) {
          this.nombre = nombre;
          this.cantidad = cantidad;
          this.precioUnidad = precioUnidad;
      }

      public double getSubtotal() {
          return cantidad *
      }
  }
  // --- ATRIBUTOS DEL PEDIDO ---
  private static int contadorGlobal = 1;

  //Las variables propias de cada pedido (instancia)
  private int idPedido;
  private String nombreCliente;
  private Articulo[] listaArticulos; 
  private int cantidadArticulosActual; 
  private String estado; 

  // Constante para un límite máximo
  private final int MAX_ARTICULOS = 5;

  //CONSTRUCTOR
public PedidoRestaurante(String nombreCliente) {
    this.idPedido = contadorGlobal++;
    this.nombreCliente = nombreCliente;
    this.listaArticulos = new Articulo[MAX_ARTICULOS];
    this.cantidadArticulosActual = 0;
    this.estado = "Abierto";
  }
  // --- MÉTODOS ---
 public void agregarArticulo(String nombre, int cantidad, double precioUnidad) {
    if (cantidadArticulosActual < MAX_ARTICULOS) {
      listaArticulos[cantidadArticulosActual] = new Articulo(nombre, cantidad, precioUnidad);
      cantidadArticulosActual++;
    } else {
        System.out.println("No se pueden agregar más artículos al pedido" + nombreCliente + "ha alcanzado el máximo de 5 artículos");
    }
  }

public double calcularTotal() { 
    double total = 0; 
    for (int i = 0; i < cantidadArticulosActual; i++) {
         total += listaArticulos[i].getSubtotal();
         } 
         return total; 
    } 
    
    public void mostrarDetallePedido() {
        System.out.println("\n=================================")
        System.out.println(" PEDIDO #" + idPedido);
        System.out.println(" Cliente " + nombreCliente);
        System.out.println(" Estado: " + estado);
        System.out.println("-----------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Articulo", "Cant.", "P.Unit", "Subtotal"); 
        System.out.println("-----------------------------------");

        for (int i = 0; i < cantidadArticulosActual; i++) {
            Articulo item = listaArticulosActual[i]; 
            System.out.printf("%-15s %-10d $%-9.2f $%-9.2f%n", 
            item.nombre,
            item.cantidad,
            item.precioUnidad,
            item.getSubtotal());
        }
        System.out.println("-----------------------------------");
        System.out.printf(" TOTAL A PAGAR: $%.2f%n", calcularTotal());
        System.out.println("=================================\n"); 
    }
}


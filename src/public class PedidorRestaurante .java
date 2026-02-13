public class PedidoRestaurante {
    // Clase interna para artículos
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
            return cantidad * precioUnidad;
        }
    }

    private static int contadorGlobal = 1;
    private int idPedido;
    private String nombreCliente;
    private Articulo[] listaArticulos;
    private int cantidadArticulosActual;
    private Estado_pedido estado; // Cambio: Ahora usa el Enum
    private final int MAX_ARTICULOS = 5;

    public PedidoRestaurante(String nombreCliente) {
        this.idPedido = contadorGlobal++;
        this.nombreCliente = nombreCliente;
        this.listaArticulos = new Articulo[MAX_ARTICULOS];
        this.cantidadArticulosActual = 0;
        this.estado = Estado_pedido.ABIERTO; // Estado inicial
    }

    public void agregarArticulo(String nombre, int cantidad, double precioUnidad) {
        // Validación: No añadir si el pedido no está "Abierto"
        if (this.estado != Estado_pedido.ABIERTO) {
            System.out.println("Error: No se pueden añadir artículos a un pedido en estado " + estado);
            return;
        }

        if (cantidadArticulosActual < MAX_ARTICULOS) {
            listaArticulos[cantidadArticulosActual] = new Articulo(nombre, cantidad, precioUnidad);
            cantidadArticulosActual++;
        } else {
            System.out.println("No se pueden agregar más artículos. El pedido de " + nombreCliente + " ha alcanzado el máximo.");
        }
    }

    // Método para cambiar el estado con validaciones lógicas
    public void setEstado(Estado_pedido nuevoEstado) {
        if (this.estado == Estado_pedido.ENTREGADO) {
            System.out.println("El pedido ya está entregado y no puede cambiar.");
        } else if (this.estado == Estado_pedido.LISTO_PARA_ENTREGAR && nuevoEstado == Estado_pedido.EN_PREPARACION) {
            System.out.println("Error: No se puede volver a preparación si ya está listo.");
        } else {
            this.estado = nuevoEstado;
            System.out.println("Pedido #" + idPedido + " actualizado a: " + nuevoEstado);
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
        System.out.println("\n=================================");
        System.out.println(" PEDIDO #" + idPedido);
        System.out.println(" Cliente: " + nombreCliente);
        System.out.println(" Estado: " + estado);
        System.out.println("-----------------------------------");
        System.out.printf("%-15s %-10s %-10s %-10s%n", "Articulo", "Cant.", "P.Unit", "Subtotal");
        System.out.println("-----------------------------------");

        for (int i = 0; i < cantidadArticulosActual; i++) {
            Articulo item = listaArticulos[i]; 
            System.out.printf("%-15s %-10d $%-9.2f $%-9.2f%n", 
                item.nombre, item.cantidad, item.precioUnidad, item.getSubtotal());
        }
        System.out.println("-----------------------------------");
        System.out.printf(" TOTAL A PAGAR: $%.2f%n", calcularTotal());
        System.out.println("=================================\n");
    }
}
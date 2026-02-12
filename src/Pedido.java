public class Pedido {
    private static int contador_id = 0;
    private int id;
    private String nombre_cliente;
    private Estado_pedido estado;
    private String[] articulos = new String[5];
    private double[] precios = new double[5];
    private int total_articulos = 0;

    public Pedido(String nombre_cliente) {
        contador_id++;
        this.id = contador_id;
        this.nombre_cliente = nombre_cliente;
        this.estado = Estado_pedido.EN_PREPARACION;
    }

    public void agregarArticulo(String nombre, double precio) {
        if (total_articulos < 5) {
            articulos[total_articulos] = nombre;
            precios[total_articulos] = precio;
            total_articulos++;
            System.out.println("Añadido: " + nombre);
        } else {
            System.out.println("No se pueden añadir más de 5 artículos al pedido.");
        }
    }

    public void setEstado(Estado_pedido nuevo_estado) {
        if (this.estado == Estado_pedido.ENTREGADO) {
            System.out.println("El pedido ya está entregado y no puede cambiar.");
        } else if (this.estado == Estado_pedido.LISTO_PARA_ENTREGAR && nuevo_estado == Estado_pedido.EN_PREPARACION) {
            System.out.println("No se puede volver a preparación si ya está listo.");
        } else {
            this.estado = nuevo_estado;
            System.out.println("Estado actualizado a: " + nuevo_estado);
        }
    }

    public double calcular_total() {
        double suma = 0;
        for (int i = 0; i < total_articulos; i++) {
            suma += precios[i];
        }
        return suma;
    }

    public void mostrarResumen() {
        System.out.println("Cliente: " + nombre_cliente);
        System.out.println("Artículos: " + total_articulos + "/5");
        System.out.println("Estado: " + estado);
        System.out.println("PRECIO: " + calcular_total() + "€");
    }
}
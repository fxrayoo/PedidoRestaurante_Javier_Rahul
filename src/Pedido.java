public class Pedido {
    private static int contadorId = 0;
    private int id;
    private String nombreCliente;
    private Estado_pedido estado;
    private String[] articulos = new String[5];
    private double[] precios = new double[5];
    private int totalArticulos = 0;

    public Pedido(String nombreCliente) {
        contadorId++;
        this.id = contadorId;
        this.nombreCliente = nombreCliente;
        this.estado = Estado_pedido.EN_PREPARACION;
    }

    public void agregarArticulo(String nombre, double precio) {
        if (totalArticulos < 5) {
            articulos[totalArticulos] = nombre;
            precios[totalArticulos] = precio;
            totalArticulos++;
        } else {
            System.out.println("No puedes añadir más de 5 artículos.");
        }
    }

    public double calcularTotal() {
        double suma = 0;
        for (int i = 0; i < totalArticulos; i++) {
            suma += precios[i];
        }
        return suma;
    }

    public void mostrarResumen() {
        System.out.println("Pedido #" + id + " - Cliente: " + nombreCliente);
        System.out.println("Estado: " + estado + " | Total: " + calcularTotal() + "€");
    }
}
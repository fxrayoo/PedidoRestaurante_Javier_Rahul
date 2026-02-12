//Empezamos creando una clase "Pedido" donde estarán los artículos estados.  
public class Pedido {
    private static int contador_id = 0;
    private int id;
    private String nombre_cliente;
    private Estado_pedido estado;
    private String[] articulos = new String[5]; //El límite del array es de 5 elementos
    private double[] precios = new double[5];
    private int total_articulos = 0;

//Creamos el constructor para crear un objeto
    public Pedido(String nombre_cliente) {
        contador_id++; //Subimos el contador global con "++"
        this.id = contador_id; //Lo marcamos como un ID único
        this.nombre_cliente = nombre_cliente;
        this.estado = Estado_pedido.EN_PREPARACION; //Aquí es donde empieza el estado
    }

//Este método sirve para añadir productos (no supera el límite del array)
    public void agregar_articulo(String nombre, double precio) {
        if (total_articulos < 5) {
            articulos[total_articulos] = nombre;
            precios[total_articulos] = precio;
            total_articulos++; //Avanza el índice para el siguiente artículo
            System.out.println("Añadido: " + nombre);
        } else {
            //Esto es en caso de que supere el límite de artículos (marcado en el array)
            System.out.println("No se pueden añadir más de 5 artículos al pedido.");
        }
    }

//Creamos un nuevo método para que el usuario no pueda hacer cambios si ya está entregado.
    public void set_estado(Estado_pedido nuevo_estado) {
        if (this.estado == Estado_pedido.ENTREGADO) {
            System.out.println("El pedido ya está entregado y no puede cambiar.");
        } else if (this.estado == Estado_pedido.LISTO_PARA_ENTREGAR && nuevo_estado == Estado_pedido.EN_PREPARACION) {
            System.out.println("No se puede volver a preparación si ya está listo.");
        } else {
            this.estado = nuevo_estado;
            System.out.println("Estado actualizado a: " + nuevo_estado);
        }
    }
}
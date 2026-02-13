public class Main {
    public static void main(String[] args) {
        PedidoRestaurante pedido1 = new PedidoRestaurante("Rahul Sharma");
        pedido1.agregarArticulo("Pizza vegetariana", 1, 11.99);
        pedido1.agregarArticulo("Pan con ajo", 2, 3.50);
        
        // Cambiamos el estado
        pedido1.setEstado(Estado_pedido.EN_PREPARACION);
        
        // Intentamos agregar algo cuando ya no está "Abierto" (Dará error)
        pedido1.agregarArticulo("Coca Cola", 1, 1.99); 

        pedido1.mostrarDetallePedido();
       
        System.out.println("--- Probando límites con Maria Rodriguez ---");
        PedidoRestaurante pedido2 = new PedidoRestaurante("Maria Rodriguez");
        pedido2.agregarArticulo("Hamb. 1", 1, 8.0);
        pedido2.agregarArticulo("Hamb. 2", 1, 8.0);
        pedido2.agregarArticulo("Hamb. 3", 1, 8.0);
        pedido2.agregarArticulo("Hamb. 4", 1, 8.0);
        pedido2.agregarArticulo("Hamb. 5", 1, 8.0);
        
        // Sexto artículo (Dará error por límite de 5)
        pedido2.agregarArticulo("Hamb. Extra", 1, 8.0);

        pedido2.mostrarDetallePedido();
    }
}
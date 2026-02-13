public class Main {
    public static void main(String[] args) {
        //Crear el primer pedido 
        PedidoRestaurante pedido1 = new PedidoRestaurante("Rahul Sharma");
        
        pedido1.agregarArticulo("Pizza vegetariana", 1, 11.99);
        pedido1.agregarArticulo("Coca Cola zero", 1, 1.99);
        pedido1.agregarArticulo("Pan con ajo", 2, 3.50);

        pedido1.mostrarDetallePedido();
       
        //Crear el segundo pedido, le agregaremos 6 artículos para probar el límite
        PedidoRestaurante pedido2 = new PedidoRestaurante("Maria Rodriguez");
        pedido2.agregarArticulo("Hamburguesa con queso", 1, 8.99);
        pedido2.agregarArticulo("Agua mineral", 2, 1.50);
        pedido2.agregarArticulo("Ensalada César", 1, 7.99);
        pedido2.agregarArticulo("Tarta de manzana", 1, 4.99);
        pedido2.agregarArticulo("Queso fundido", 1, 5.50);
    
        //Este artículo deberia dar error y no incluirse:
        pedido2.agregarArticulo("Zumo de naranja", 1, 2.50);

        pedido2.mostrarDetallePedido();
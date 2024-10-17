package app;

import app.model.Product;
import app.model.dao.ProductDAO;

import java.sql.SQLException;

public class Main {
    /**
     * Query para listar productos
     */
    private static String query = "SELECT * FROM produtos";
    /**
     * Metodo principal
     * @param args
     */
    public static void main(String[] args) {
        //como no tengo el try-cacht en los metodos tengo que ponerlo en el main
        try {
            ProductDAO dao = new ProductDAO(query);
            dao.listarProductos();
            dao.actualizarProducto("p2", 8);
            dao.insertarProducto("p4", "martelo", 20);
            dao.borrarProducto("p3");
            dao.cerrar();
        } catch (SQLException e) {
            System.out.println("Error en la base de datos: " + e.getMessage());
        }
    }
}

package app;

import app.model.Product;
import app.model.dao.ProductDAO;

import java.sql.SQLException;

public class Main {
    private static String query = "SELECT * FROM produtos";
    public static void main(String[] args) {
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

//    public static void listarProdutos() {
//        for (Product p : ProductDAO.listaProdutos()) {
//            System.out.println(p.getCodigo() + " " + p.getDescricion() + " " + p.getPrezo() + " " + p.getDatac());
//        }
//    }
}

package app;

import app.model.Product;
import app.model.dao.ProductDAO;

import java.sql.ResultSetMetaData;
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
        try{
            ProductDAO productDAO = new ProductDAO(query);
            productDAO.listarProductos();
            ResultSetMetaData metaData = productDAO.obterMetadata();
            System.out.println("Numero de columnas: " +productDAO.obterColumnas(metaData));
            imprimirDatosColumnas(metaData, productDAO.obterColumnas(metaData));
        } catch (SQLException e) {
            System.out.println("Error en la conexion a la base de datos: " + e.getMessage());
        }
    }

    /**
     * Metodo para imprimir los datos de las columnas
     * @param metaData
     * @param numColumnas
     * @throws SQLException
     */
    public static void imprimirDatosColumnas(ResultSetMetaData metaData, int numColumnas) throws SQLException {
        for (int i = 1; i <= numColumnas; i++) {
            System.out.println("Nome da columna " + i + ": " + metaData.getColumnName(i));
            System.out.println("Tipo de dato da columna " + i + ": " + metaData.getColumnTypeName(i));
        }
    }
}

package app.model.dao;

import app.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO{
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    public ProductDAO(String query) throws SQLException {
        connection = DataBaseConnection.getConnection();
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );
        resultSet = statement.executeQuery(query);
    }
    public void listarProductos() throws SQLException {
        resultSet.beforeFirst();
        while (resultSet.next()) {
            String codigo = resultSet.getString("codigo");
            String nombre = resultSet.getString("descricion");
            int precio = resultSet.getInt("prezo");
            System.out.println("Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio);
        }
    }
    public void actualizarProducto(String codigo, Integer nuevoPrecio) throws SQLException {
        resultSet.beforeFirst();
        while (resultSet.next()) {
            if (resultSet.getString("codigo").equals(codigo)) {
                resultSet.updateInt("prezo", nuevoPrecio);
                resultSet.updateRow();
                System.out.println("Producto "+codigo+" actualizado con nuevo precio: "+nuevoPrecio);
                break;
            }
        }
    }
    public void insertarProducto(String codigo, String descripcion, Integer precio) throws SQLException {
        resultSet.moveToInsertRow();
        resultSet.updateString("codigo", codigo);
        resultSet.updateString("descricion", descripcion);
        resultSet.updateInt("prezo", precio);
        resultSet.insertRow();
        System.out.println("Producto "+codigo+" insertado: "+descripcion+", "+precio);
    }
    public void borrarProducto(String codigo) throws SQLException {
        resultSet.beforeFirst();
        while (resultSet.next()) {
            if (resultSet.getString("codigo").equals(codigo)) {
                resultSet.deleteRow();
                System.out.println("Producto "+codigo+" eliminado");
                break;
            }
        }
    }

    public void cerrar() throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}

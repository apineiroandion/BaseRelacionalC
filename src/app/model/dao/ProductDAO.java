package app.model.dao;

import app.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase con los metodos para acceder a la base de datos
 */
public class ProductDAO{
    /**
     * Conexion con la base de datos
     */
    private Connection connection;
    /**
     * Sentencia para ejecutar las consultas
     */
    private Statement statement;
    /**
     * Resultado de la consulta
     */
    private ResultSet resultSet;

    /**
     * Constructor con la consulta a ejecutar
     * @param query consulta
     * @throws SQLException
     */
    public ProductDAO(String query) throws SQLException {
        connection = DataBaseConnection.getConnection();
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE
        );
        resultSet = statement.executeQuery(query);
    }

    /**
     * Metodo para listar los productos
     * @throws SQLException
     */
    public void listarProductos() throws SQLException {
        resultSet.beforeFirst();
        while (resultSet.next()) {
            String codigo = resultSet.getString("codigo");
            String nombre = resultSet.getString("descricion");
            int precio = resultSet.getInt("prezo");
            System.out.println("Código: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio);
        }
    }

    /**
     * Metodo para actualizar el precio de un producto
     * @param codigo
     * @param nuevoPrecio
     * @throws SQLException
     */
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

    /**
     * Metodo para insertar un producto
     * @param codigo
     * @param descripcion
     * @param precio
     * @throws SQLException
     */
    public void insertarProducto(String codigo, String descripcion, Integer precio) throws SQLException {
        resultSet.moveToInsertRow();
        resultSet.updateString("codigo", codigo);
        resultSet.updateString("descricion", descripcion);
        resultSet.updateInt("prezo", precio);
        resultSet.insertRow();
        System.out.println("Producto "+codigo+" insertado: "+descripcion+", "+precio);
    }

    /**
     * Metodo para borrar un producto
     * @param codigo
     * @throws SQLException
     */
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

    /**
     * Metodo para cerrar la conexion
     * @throws SQLException
     */
    public void cerrar() throws SQLException {
        if (resultSet != null) resultSet.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }
}

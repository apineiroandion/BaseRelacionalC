package app.model.dao;

import app.model.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    /**
     * Metodo que introduce productos en la base de datos
     * @param product
     * @return true si fue correcto, false si no
     */
    public static boolean insireProduto(Product product) {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produtos VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, product.getCodigo());
            preparedStatement.setString(2, product.getDescricion());
            preparedStatement.setInt(3, product.getPrezo());
            preparedStatement.setDate(4, Date.valueOf(product.getDatac()));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que guarda en una lista todos los productos
     * @return List con los productos
     */
    public static List<Product> listaProdutos() {
        Connection connection = DataBaseConnection.getConnection();
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produtos");
            preparedStatement.executeQuery();
            while (preparedStatement.getResultSet().next()) {
                Product product = new Product();
                product.setCodigo(preparedStatement.getResultSet().getString("codigo"));
                product.setDescricion(preparedStatement.getResultSet().getString("descricion"));
                product.setPrezo(preparedStatement.getResultSet().getInt("prezo"));
                product.setDatac(preparedStatement.getResultSet().getDate("datac").toLocalDate());
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo que te devuelve una lista con los productos a traves del codigo
     * @param codigo
     * @return Lista de productos
     */
    public static List<Product> listaProdutoPorCodigo(String codigo){
        Connection connection = DataBaseConnection.getConnection();
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produtos WHERE codigo = ?");
            preparedStatement.setString(1, codigo);
            preparedStatement.executeQuery();
            while (preparedStatement.getResultSet().next()) {
                Product product = new Product();
                product.setCodigo(preparedStatement.getResultSet().getString("codigo"));
                product.setDescricion(preparedStatement.getResultSet().getString("descricion"));
                product.setPrezo(preparedStatement.getResultSet().getInt("prezo"));
                product.setDatac(preparedStatement.getResultSet().getDate("datac").toLocalDate());
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metodo que actualiza el precio del producto cuyo copdigo se le pasa
     * @param codigo del producto a actualizar
     * @param prezo nuevo prezo del producto
     * @return true si se completa la operacion y false si no
     */
    public static boolean actualizaPre(String codigo, Integer prezo) {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produtos SET prezo = ? WHERE codigo = ?");
            preparedStatement.setInt(1, prezo);
            preparedStatement.setString(2, codigo);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Metodo que elimina el producto de la base de datos cuyo codigo se el pasa
     * @param codigo del producto a eliminar
     * @return true si se completa la operacion y false si no
     */
    public static boolean eliminaProduto (String codigo) {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM produtos WHERE codigo = ?");
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

package app;

import app.model.Product;
import app.model.dao.ProductDAO;

public class Main {
    public static void main(String[] args) {

    }
    /**
     * Metodo que imprime la lista de productos obtenida de la base de datos
     */
    public static void listarProdutos() {
        for (Product p : ProductDAO.listaProdutos()) {
            System.out.println(p.getCodigo() + " " + p.getDescricion() + " " + p.getPrezo() + " " + p.getDatac());
        }
    }
}

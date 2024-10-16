package app.model;

import java.time.LocalDate;

public class Product {
    /**
     * Codigo de producto
     */
    private String codigo;
    /**
     * Descripcion del producto
     */
    private String descricion;
    /**
     * Precio del porducto
     */
    private Integer prezo;
    /**
     * Data de inseccion del producto
     */
    private LocalDate datac;

    /**
     * Constructor por defecto
     */
    public Product() {
    }

    /**
     * COnstructor parametrizado
     * @param codigo
     * @param descricion
     * @param prezo
     * @param datac
     */
    public Product(String codigo, String descricion, Integer prezo, LocalDate datac) {
        this.codigo = codigo;
        this.descricion = descricion;
        this.prezo = prezo;
        this.datac = datac;
    }

    /**
     * Metodos de acceso
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricion() {
        return descricion;
    }

    public void setDescricion(String descricion) {
        this.descricion = descricion;
    }

    public Integer getPrezo() {
        return prezo;
    }

    public void setPrezo(Integer prezo) {
        this.prezo = prezo;
    }

    public LocalDate getDatac() {
        return datac;
    }

    public void setDatac(LocalDate datac) {
        this.datac = datac;
    }
}

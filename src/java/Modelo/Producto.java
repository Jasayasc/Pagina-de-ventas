
package Modelo;

import java.io.InputStream;


public class Producto {
    int id; //PK
    String nom;
    double precio;
    int stock;
    String estado;
    InputStream image;
    public Producto () {
        
    }

    public Producto(int id, String nom, double precio, int stock, String estado, InputStream image) {
        this.id = id;
        this.nom = nom;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.image = image;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }

    

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}

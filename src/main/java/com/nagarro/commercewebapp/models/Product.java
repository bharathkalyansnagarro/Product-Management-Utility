package com.nagarro.commercewebapp.models;


import jakarta.persistence.*;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "size")
    private String size;

    @Column(name = "image")
    private String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public Product(String title, int quantity, String size, String image) {
        super();
        this.title = title;
        this.quantity = quantity;
        this.size = size;
        this.image = image;
    }

    public Product() {
        super();
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", title=" + title + ", quantity=" + quantity + ", size=" + size + ", image="
                + image + "]";
    }


}

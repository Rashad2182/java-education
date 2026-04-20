package Model;

import java.awt.*;

public class Product {
    private int id;
    private String name;
    private Image image;
    private String color;
    private double price;
    private double discountPrice;

    Product(int id, String name, Image image, String color, double price, double discountPrice) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.color = color;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return id + ". name => " + name + ", color => " + color + ", price => " + price + ", discount price => " + discountPrice;
    }
}

package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 * This is a class for the products.
 * We made this so we can create objects of the drinks.
 */
public class Product {
    private SimpleStringProperty name = null;
    private SimpleStringProperty color = null;
    private SimpleStringProperty type = null;
    private SimpleStringProperty price = null;


    public Product()
    {
        super();
    }

    public Product(String name)
    {
        this.name = new SimpleStringProperty(name);
    }

    public Product(String name, String color, String type, String price)
    {
        this.name = new SimpleStringProperty(name);
        this.color = new SimpleStringProperty(color);
        this.type= new SimpleStringProperty(type);
        this.price = new SimpleStringProperty(price);

    }


    public String getName()
    {
        return name.get();
    }


    public String getColor()
    {
        return color.get();
    }


    public void setName(String newName)
    {
        name = new SimpleStringProperty(newName);
    }

    public void setColor(String newColor)
    {
        color = new SimpleStringProperty(newColor);
    }



    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}

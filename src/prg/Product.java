package prg;


/**
 * Created by kaval on 04.04.2017.
 */
public class Product {
    private String name;
    private int id;
    private double price;

    public Product(String a, double b, int c) {
        this.setName(a);
        this.setPrice(b);
        this.setId(c);
    }

    @Override
    public String toString() {
        return name + " " + price + " " + id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 2)
            this.name = name;
        else throw new ExceptionInInitializerError("Incorrect name");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0)
            this.id = id;
        else throw new ExceptionInInitializerError("Incorrect id");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0)
            this.price = price;
        else throw new ExceptionInInitializerError("Incorrect price");
    }
}


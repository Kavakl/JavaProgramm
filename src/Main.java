/**
 * Created by kaval on 27.02.2017.
 */
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
    }
}

class Product {
    private String name;
    private int id;
    private double price;
    Product(String a,double b,int c) {
        this.setName(a);
        this.setPrice(b);
        this.setId(c);
    }
    @Override
    public String toString() {
        return name+" "+price+" "+id;
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
        if(name.length()>2)
            this.name = name;
        else throw new ExceptionInInitializerError("Incorrect name");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id>0)
            this.id = id;
        else throw new ExceptionInInitializerError("Incorrect id");
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price>0)
            this.price = price;
        else throw new ExceptionInInitializerError("Incorrect price");
    }
}

class Product_List {

    public ArrayList<Product> list =new ArrayList<Product>();

    public void add_product(String a, double b){
        list.add(new Product(a, b,list.size()+1));
    }

    public void remove_product(int c){
        if(c>0)
            for(Product i : list) {
                if (i.getId() == c){
                    list.remove(i);
                    break;
                }
            }
    }
    public double search_by_ID(int a){
        for(Product i : list)
            if (i.getId() == a)
                return i.getPrice();
        return -1;
    }
    public void change_name(int b, String a){
        for(Product i : list)
            if (i.getId() == b)
                i.setName(a);
    }
    public void change_price(int a, int b){
        for(Product i : list)
            if (i.getId() == a)
                i.setPrice(b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product_List)) return false;

        Product_List that = (Product_List) o;

        return list != null ? list.equals(that.list) : that.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}
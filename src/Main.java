/**
 * Created by kaval on 27.02.2017.
 */
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Product_List q = new Product_List();
        q.add_product("a",2.0);
        q.add_product("g",2.0);
        q.remove_product(0);
        System.out.print(q.list);
    }
}


class Product {
    public String Name;
    public int ID;
    public double price;
    Product(String a,double b,int c) {
        Name = a;
        price = b;
        ID = c;
    }
    @Override
    public String toString() {
        return Name+" "+price+" "+ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (ID != product.ID) return false;
        if (Double.compare(product.price, price) != 0) return false;
        return Name != null ? Name.equals(product.Name) : product.Name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Name != null ? Name.hashCode() : 0;
        result = 31 * result + ID;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
class Product_List {

    public ArrayList<Product> list =new ArrayList<Product>();


    public void add_product(String a,double b){
        list.add(new Product(a,b,list.size()+1));
    }
    public void remove_product(int c){
        if(c>0)
        list.remove(c-1);
        else throw new ExceptionInInitializerError();
    }
    public double search_by_ID(int a){
        for(Product i : list)
            if (i.ID==a)
                return i.price;
        return -1;
    }
    public void change_name(double b,String a){
        for(Product i : list)
            if (i.ID==b)
                i.Name = a;
    }
    public void change_price(int a,double b){
        for(Product i : list)
            if (i.ID==a)
                i.price = b;
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
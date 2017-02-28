/**
 * Created by kaval on 27.02.2017.
 */
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Product_List a = new Product_List();
        Product_List b = new Product_List();
        a.add_product("a",6);
        a.add_product("b",2);
        b.add_product("a",6);
        b.add_product("b",2);


        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());

        System.out.println(a.list);
        System.out.println(b.list);


    }
}


class Product {
    public String Name;
    public int ID;
    public int price;
    Product(String a,int b,int c) {
        Name = a;
        price = b;
        ID = c;
    }
    @Override
    public String toString() {
        return Name+" "+price+" "+ID;
    }
}
class Product_List {

    public ArrayList<Product> list =new ArrayList<Product>();


    public void add_product(String a,int b){
        list.add(new Product(a,b,list.size()+1));
    }
    public void remove_product(int c){
        list.remove(c);
    }
    public int search_by_ID(int a){
        for(Product i : list)
            if (i.ID==a)
                return i.price;
        return -1;
    }
    public void change_name(int b,String a){
        for(Product i : list)
            if (i.ID==b)
                i.Name = a;
    }
    public void change_price(int a,int b){
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
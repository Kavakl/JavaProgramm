package prg;


import java.util.ArrayList;

/**
 * Created by kaval on 04.04.2017.
 */
public class ProductList {

    public ArrayList<Product> list = new ArrayList<Product>();
    int index;

    public void addProduct(String a, double b) {
        list.add(new Product(a, b, index += 1));
    }

    public void removeProduct(int c) {
        if (c > 0)
            for (Product i : list) {
                if (i.getId() == c) {
                    list.remove(i);
                    break;
                }
            }
    }

    public double searchByID(int a) {
        for (Product i : list)
            if (i.getId() == a)
                return i.getPrice();
        return -1;
    }

    public void changeName(int b, String a) {
        for (Product i : list)
            if (i.getId() == b)
                i.setName(a);
    }

    public void changePrice(int a, int b) {
        for (Product i : list)
            if (i.getId() == a)
                i.setPrice(b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductList)) return false;

        ProductList that = (ProductList) o;

        return list != null ? list.equals(that.list) : that.list == null;
    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }
}


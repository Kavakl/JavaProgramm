import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import prg.*;

/**
 * Created by kaval on 27.02.2017.
 */

/**
 * Created by kaval on 13.02.2017.
 */
public class Product_ListTest {
    int delta = 1;

    @Test
    public void test_search_by_ID() throws Exception {
        ProductList v = new ProductList();
        v.addProduct("ads", 1.0);
        assertEquals(v.searchByID(0), -1, delta);
        assertEquals(v.searchByID(1), 1.0, delta);

    }

    @Test
    public void test_add_product() throws Exception {
        ProductList v = new ProductList();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("asda", 2.3, 1));
        v.addProduct("asda", 2.3);
        assertEquals(v.list, test_list);
    }

    @Test
    public void test_change_name() throws Exception {
        ProductList v = new ProductList();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("aewe", 1.5, 1));
        test_list.add(new Product("sawe", 2.5, 2));
        v.addProduct("aewe", 1.6);
        v.addProduct("sawe", 2.7);
        v.changeName(1, "cewa");
        v.changeName(2, "ggoo");
        assertNotEquals(v.list, test_list);
    }

    @Test
    public void test_change_price() throws Exception {
        ProductList v = new ProductList();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("awer", 1, 1));
        test_list.add(new Product("easd", 2, 2));
        v.addProduct("awer", 1);
        v.addProduct("easd", 2);
        v.changePrice(1, 10);
        v.changePrice(2, 100);
        assertNotEquals(v.list, test_list);
    }

    @Test
    public void test_remove_product() throws Exception {
        ProductList v = new ProductList();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("awer", 1, 1));
        test_list.add(new Product("asdf", 332, 3));
        v.addProduct("awer", 1);
        v.addProduct("easd", 2);
        v.addProduct("asdf", 332);
        v.removeProduct(2);
        v.removeProduct(2);
        assertEquals(v.list, test_list);
    }
}

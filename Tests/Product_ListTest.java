import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

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
        Product_List v = new Product_List();
        v.add_product("a", 1.0);
        v.add_product("b", 133.0);
        v.add_product("c", 34.0);
        v.add_product("d", 75.23);
        v.add_product("e", 566665567.987);

        assertEquals(v.search_by_ID(0), -1, delta);
        assertEquals(v.search_by_ID(1), 1, delta);
        assertEquals(v.search_by_ID(2), 133.0, delta);
        assertEquals(v.search_by_ID(5), 566665567.987, delta);
    }
    @Test
    public void test_add_product() throws Exception {
        Product_List v = new Product_List();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("a",2.3,1));
        v.add_product("a",2.3);
        assertEquals(v.list,test_list);
    }
    @Test
    public void test_change_name() throws Exception {
        Product_List v = new Product_List();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("a",1.5,1));
        test_list.add(new Product("e",2.5,2));
        v.add_product("a", 1.6);
        v.add_product("e", 2.7);
        v.change_name(1.6,"c");
        v.change_name(2.7,"g");
        assertNotEquals(v.list,test_list);
    }
    @Test
    public void test_change_price() throws Exception {
        Product_List v = new Product_List();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("a",1,1));
        test_list.add(new Product("e",2,2));
        v.add_product("a", 1);
        v.add_product("e", 2);
        v.change_price(1,10);
        v.change_price(2,100);
        assertNotEquals(v.list,test_list);
    }
}
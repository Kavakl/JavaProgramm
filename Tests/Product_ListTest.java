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
        v.add_product("ads", 1.0);
        assertEquals(v.search_by_ID(0), -1, delta);
        assertEquals(v.search_by_ID(1), 1.0, delta);

    }
    @Test
    public void test_add_product() throws Exception {
        Product_List v = new Product_List();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("asda",2.3,1));
        v.add_product("asda",2.3);
        assertEquals(v.list,test_list);
    }
    @Test
    public void test_change_name() throws Exception {
        Product_List v = new Product_List();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("aewe",1.5,1));
        test_list.add(new Product("sawe",2.5,2));
        v.add_product("aewe", 1.6);
        v.add_product("sawe", 2.7);
        v.change_name(1,"cewa");
        v.change_name(2,"ggoo");
        assertNotEquals(v.list,test_list);
    }
    @Test
    public void test_change_price() throws Exception {
        Product_List v = new Product_List();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("awer",1,1));
        test_list.add(new Product("easd",2,2));
        v.add_product("awer", 1);
        v.add_product("easd", 2);
        v.change_price(1,10);
        v.change_price(2,100);
        assertNotEquals(v.list,test_list);
    }
    @Test
    public void test_remove_product() throws Exception {
        Product_List v = new Product_List();
        ArrayList<Product> test_list = new ArrayList<>();
        test_list.add(new Product("awer",1,1));
        test_list.add(new Product("asdf",332,3));
        v.add_product("awer", 1);
        v.add_product("easd", 2);
        v.add_product("asdf", 332);
        v.remove_product(2);
        v.remove_product(2);
        assertEquals(v.list,test_list);
    }
}

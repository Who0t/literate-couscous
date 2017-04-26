package fi.taktik.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Juuso Ahtiainen on 12/04/2017.
 * 
 * Populates the database with sample data and assist functions to handle this data.
 */
@RestController
@RequestMapping(value = "/test/")
public class TestData {

    @Autowired
    ItemRepository database;

    /**
     * Creates 10 test instances of Items with only name value and saves them on database.
     */
    @RequestMapping(value = "/addAll", method = RequestMethod.GET)
    public void addAll() {

        Item test0 = new Item("test0");
        Item test1 = new Item("test1");
        Item test2 = new Item("test2");
        Item test3 = new Item("test3");
        Item test4 = new Item("test4");
        Item test5 = new Item("test5");
        Item test6 = new Item("test6");
        Item test7 = new Item("test7");
        Item test8 = new Item("test8");
        Item test9 = new Item("test9");

        database.save(test0);
        database.save(test1);
        database.save(test2);
        database.save(test3);
        database.save(test4);
        database.save(test5);
        database.save(test6);
        database.save(test7);
        database.save(test8);
        database.save(test9);
    }

    /**
     * Test URI for authenticating. Secured with US and PW
     *
     * @return simple string to indicate success.
     */
    @RequestMapping(value ="/testLogin")
    public String testLogn() {
        return "Login Succ";
    }
}

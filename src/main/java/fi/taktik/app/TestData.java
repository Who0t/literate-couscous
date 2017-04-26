package fi.taktik.app;

import fi.taktik.app.login.AccountCredentials;
import fi.taktik.app.login.AccountCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Populates the database with sample data and assist functions to handle this data.
 *
 * Created by Juuso Ahtiainen on 12/04/2017.
 */
@RestController
@RequestMapping(value = "/test/")
public class TestData {

    @Autowired
    ItemRepository database;
    @Autowired
    AccountCredentialsRepository accDB;

    /**
     * Creates 10 test instances of Items with only name value and saves them on database.
     *
     * Also adds 2 test accounts. They can be seen with ./getAll.
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

        AccountCredentials ac = new AccountCredentials("admin", "root");
        accDB.save(ac);
        AccountCredentials db = new AccountCredentials("user", "user");
        accDB.save(db);

    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Iterable<AccountCredentials> getAll() {
        return accDB.findAll();
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

package fi.taktik.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    ItemRepository database;

    @RequestMapping(value = "/items", method = RequestMethod.POST)
    public String saveItem(@RequestBody Item i) {
        database.save(i);
        return "saving to db successful";
    }

    @RequestMapping(value = "/items",method = RequestMethod.GET)
    public Iterable<Item> getItems() {
        return database.findAll();
    }

    @RequestMapping(value = "/items/{itemId}", method = RequestMethod.GET)
    public Item getItems(@PathVariable long itemId) {
        return database.findOne(itemId);
    }

    @RequestMapping(value = "/items/{itemId}", method = RequestMethod.DELETE)
    public String deleteItem(@PathVariable long itemId) {
        try {
            database.delete(itemId);
            return "delete was successful";
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
            return "delete failed, no id found";
        }
    }
}

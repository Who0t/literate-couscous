package fi.taktik.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Juuso Ahtiainen on 12/04/2017.
 *
 * Class to handle item updates from database.
 * Access with URI: .../update/{ updated item id }/
 */
@RestController
@RequestMapping(value = "/update")
public class UpdateItem {

    @Autowired
    ItemRepository database;

    /**
     * Updates a single Item with the values of new one. It keeps the ID of old item.
     *
     * @param item holds the Item to be copied.
     * @param oId holds id parametes from URI, used to find the Item from database to update.
     */
    @RequestMapping(value = "/{oId}", method = RequestMethod.POST)
    public void update(@RequestBody Item item, @PathVariable("oId") long oId) {

        Item oldItem = database.findOne(oId);
        oldItem.copyItem(item);
        database.save(oldItem);
    }

    /**
     * Updates name field of the item.
     *
     * @param i new value for field, taken from POST param "name".
     * @param oId holds id parameter from URI, used to find the Item from database to update.
     */
    @RequestMapping(value = "/{oId}/name", method = RequestMethod.POST)
    public void updateName(@RequestParam("name") String i, @PathVariable("oId") long oId ) {

        Item oldItem = database.findOne(oId);
        oldItem.setName(i);
        database.save(oldItem);

    }

    /**
     * Updates genre field of the item.
     *
     * @param i new value for field, taken from POST param "genre".
     * @param oId holds id parameter from URI, used to find the Item from database to update.
     */
    @RequestMapping(value = "/{oId}/genre", method = RequestMethod.POST)
    public void updateGenre(@RequestParam("genre") String i, @PathVariable("oId") long oId ) {

        Item oldItem = database.findOne(oId);
        oldItem.setGenre(i);
        database.save(oldItem);
    }

    /**
     * Updates description field of the item.
     *
     * @param i new value for field, taken from POST param "desc".
     * @param oId holds id parameter from URI, used to find the Item from database to update.
     */
    @RequestMapping(value = "/{oId}/desc", method = RequestMethod.POST)
    public void updateDesc(@RequestParam("desc") String i, @PathVariable("oId") long oId ) {

        Item oldItem = database.findOne(oId);
        oldItem.setDescription(i);
        database.save(oldItem);
    }

    /**
     * Updates price field of the item.
     *
     * @param i new value for field, taken from POST param "price".
     * @param oId holds id parameter from URI, used to find the Item from database to update.
     */
    @RequestMapping(value = "/{oId}/price", method = RequestMethod.POST)
    public void updatePrice(@RequestParam("price") double i, @PathVariable("oId") long oId ) {

        Item oldItem = database.findOne(oId);
        oldItem.setPrice(i);
        database.save(oldItem);
    }

    /**
     * Updates discount price field of the item.
     *
     * @param i new value for field, taken from POST param "discPrice".
     * @param oId holds id parameter from URI, used to find the Item from database to update.
     */
    @RequestMapping(value = "/{oId}/discPrice", method = RequestMethod.POST)
    public void updatediscprice(@RequestParam("discPrice") Double i, @PathVariable("oId") long oId ) {

        Item oldItem = database.findOne(oId);
        oldItem.setDiscountPrice(i);
        database.save(oldItem);
    }

    /**
     * Updates publisher field of the item.
     *
     * @param i new value for field, taken from POST param "publisher".
     * @param oId holds id parameter from URI, used to find the Item from database to update.
     */
    @RequestMapping(value = "/{oId}/publisher", method = RequestMethod.POST)
    public void updatePublisher(@RequestParam("publisher") String i, @PathVariable("oId") long oId ) {

        Item oldItem = database.findOne(oId);
        oldItem.setPublisher(i);
        database.save(oldItem);
    }

    /**
     * Updates developer field of the item.
     *
     * @param i new value for field, taken from POST param "developer".
     * @param oId holds id parameter from URI, used to find the Item from database to update.
     */
    @RequestMapping(value = "/{oId}/developer", method = RequestMethod.POST)
    public void updatedev(@RequestParam("developer") String i, @PathVariable("oId") long oId ) {

        Item oldItem = database.findOne(oId);
        oldItem.setDeveloper(i);
        database.save(oldItem);
    }
}

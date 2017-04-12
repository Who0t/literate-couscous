package fi.taktik.app;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Juuso Ahtiainen on 12/04/2017.
 *
 * Class to handle item updates from database.
 *
 * TODO:
 *
 * Single field updates.
 */

@RestController
public class UpdateItem {

    @Autowired
    ItemRepository database;

    /**
     * Updates a single Item with the values of new one. It keeps the ID of old item.
     *
     * @param item holds the new values for item in placeholder ui.
     * @param oId holds id parametes from URI, used to find the Item from database to update.
     */

    @RequestMapping(value = "/update/{ oId }", method = RequestMethod.POST)
    public void update(@RequestBody Item item, @PathVariable long oId) {

        Item oldItem = database.findOne(oId);
        oldItem.updateItem(item);
    }
}

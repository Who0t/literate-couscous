package fi.taktik.app.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles user accounts.
 *
 * Created by Juuso Ahtiainen on 26/04/2017.
 */
@RestController
@RequestMapping("/account")
public class AccountHandling {

    @Autowired
    private AccountCredentialsRepository accDB;

    /**
     * Creates new account to database.
     * @param acc JSON with "username": "XXX", "password": "XXX"
     * @return the credentials of created account.
     */
    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public AccountCredentials addAccount(@RequestBody AccountCredentials acc) {
        accDB.save(acc);

        return acc;
    }
}

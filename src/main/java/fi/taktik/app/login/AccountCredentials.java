package fi.taktik.app.login;

import javax.persistence.*;

/**
 * Simple class for Account details.
 *
 * Created by Juuso Ahtiainen on 26/04/2017.
 */
@Entity
@Table(name = "user")
public class AccountCredentials {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    /**
     * Builder for AccountCredentials.
     *
     * @param un given username
     * @param pw given password
     */
    public AccountCredentials(String un, String pw) {
        this.username = un;
        this.password = pw;
    }

    /**
     * Initializermethod for AccountCredentials.
     */
    public AccountCredentials() {
        this.username = null;
        this.password = null;
    }

    /**
     * Set Username for Account.
     *
     * @param i given String for username.
     */
    public void setUsername(String i) {
        this.username = i;
    }

    /**
     * Fetches the Account username
     *
     * @return acount username.
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets the account password
     *
     * @param i given String for Password.
     */
    public void setPassword(String i) {
        this.password = i;
    }

    /**
     * Fetches the account password
     *
     * @return the account password.
     */
    public String getPassword() {
        return this.password;
    }
}

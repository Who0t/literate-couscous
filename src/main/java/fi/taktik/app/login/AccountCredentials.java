package fi.taktik.app.login;

/**
 * Simple class for Account details.
 *
 * Created by Juuso Ahtiainen on 26/04/2017.
 */
public class AccountCredentials {

    private String username;
    private String password;

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

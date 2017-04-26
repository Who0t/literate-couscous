package fi.taktik.app.login;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for AccountCredentialsRepository
 *
 * Created by Juuso Ahtiainen on 26/04/2017.
 */
public interface AccountCredentialsRepository extends CrudRepository<AccountCredentials,Long> {
    public Iterable<AccountCredentials> findAll();
}

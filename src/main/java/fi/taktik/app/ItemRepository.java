package fi.taktik.app;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Integer>{

    public Iterable<Item> findAll();
    public void delete(Item entity);
    public void delete(Long id);
    public Workout findOne(Long id);

}

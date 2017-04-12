package fi.taktik.app;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long>{

    public Iterable<Item> findAll();
    public void delete(Item entity);
    public void delete(Long id);

    // What was this workout?
    //public Workout findOne(Long id);
}

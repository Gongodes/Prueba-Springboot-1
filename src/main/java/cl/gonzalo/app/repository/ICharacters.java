package cl.gonzalo.app.repository;

import cl.gonzalo.app.model.Characters;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICharacters extends CrudRepository<Characters,Integer> {

    Characters findById(int id);

    List<Characters> findAllByStatusAndGender(String status, String gender);

}

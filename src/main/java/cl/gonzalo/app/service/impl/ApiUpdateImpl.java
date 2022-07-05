package cl.gonzalo.app.service.impl;

import cl.gonzalo.app.model.Characters;
import cl.gonzalo.app.repository.ICharacters;
import cl.gonzalo.app.service.IApiUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiUpdateImpl implements IApiUpdate {

    @Autowired
    private ICharacters repo;

    @Override
    public void update(Characters characters, Integer id) {

        Characters character = new Characters();
        character.setId(id);
        character.setGender(characters.getGender());
        character.setName(characters.getName());
        character.setStatus(characters.getStatus());
        character.setImage(characters.getImage());

        repo.save(character);
    }
}

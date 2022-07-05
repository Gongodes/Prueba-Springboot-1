package cl.gonzalo.app.service.impl;

import cl.gonzalo.app.model.Characters;
import cl.gonzalo.app.model.Results;
import cl.gonzalo.app.repository.ICharacters;
import cl.gonzalo.app.service.IApiSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiSaveImpl implements IApiSave {

    @Autowired
    private ICharacters repo;

    @Override
    public void saveapi(Results results) {

        List<Characters> lista = results.getResults();

        for(int i =0; i< lista.size(); i++){

            repo.save(lista.get(i));

        }

    }
}

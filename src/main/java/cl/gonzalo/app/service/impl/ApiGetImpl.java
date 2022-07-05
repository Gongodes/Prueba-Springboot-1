package cl.gonzalo.app.service.impl;

import cl.gonzalo.app.model.Characters;
import cl.gonzalo.app.repository.ICharacters;
import cl.gonzalo.app.service.IApiGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiGetImpl implements IApiGet {

    @Autowired
    private ICharacters repo;

    @Override
    public Iterable<Characters> lista() {

        return repo.findAll();
    }

    @Override
    public Characters characters(int id) {
         return repo.findById(id);
    }

    @Override
    public List<Characters> filtro(String status, String gender) {
        return repo.findAllByStatusAndGender(status,gender);
    }
}

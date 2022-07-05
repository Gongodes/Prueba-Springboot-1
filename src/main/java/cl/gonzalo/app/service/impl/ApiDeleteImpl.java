package cl.gonzalo.app.service.impl;

import cl.gonzalo.app.repository.ICharacters;
import cl.gonzalo.app.service.IApiDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiDeleteImpl implements IApiDelete {

    @Autowired
    private ICharacters repo;

    @Override
    public void deleteApi(Integer id) {

        repo.deleteById(id);
    }


}

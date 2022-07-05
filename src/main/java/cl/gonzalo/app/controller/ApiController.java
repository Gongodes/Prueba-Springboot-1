package cl.gonzalo.app.controller;

import cl.gonzalo.app.model.Characters;
import cl.gonzalo.app.model.Results;
import cl.gonzalo.app.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ApiSaveImpl save;
    @Autowired
    private ApiServiceImpl api;

    @Autowired
    private ApiGetImpl list;

    @Autowired
    private ApiDeleteImpl delete;

    @Autowired
    private ApiUpdateImpl update;

    @PostMapping ("save")
    public String save() {

        Results characterList = api.getCharacters();
        save.saveapi(characterList);

        return "La lista de personajes se ha guardado correctamente.";
    }



    @GetMapping("getCharacters")
    public Iterable<Characters> list() {
        return list.lista();
    }


    @GetMapping("getCharacters/{id}")
    public List<Characters> getById(@PathVariable List<Integer> id) {

        List<Characters> lista = new ArrayList<>();

        for (int i = 0; i < id.size(); i++) {

            lista.add(list.characters(id.get(i)));
        }
        return lista;
    }


    @GetMapping("getByStatusAndGender")
    public List<Characters> getByStatusAndGender(@RequestParam Map<String, String> queryParams) {

        String status = queryParams.get("status");
        String gender = queryParams.get("gender");

        return list.filtro(status, gender);
    }


    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        try {
            delete.deleteApi(id);
        }catch(Exception e) {

        return  "El id " + id + " no se encuentra presente en la lista";

        }
        return "El personaje " + id + " ha sido eliminado exitosamente.";
    }


    @PutMapping("updateCharacter/{id}")
    public String update(@PathVariable("id") Integer id,  @RequestBody Characters character) {

        if(list.characters(id) == null){

            return "El personaje " + id + " no existe.";

        }else {


            update.update(character,id);
        }


        return "El personaje " + id + " ha sido actualizado exitosamente.";
    }
}

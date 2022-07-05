package cl.gonzalo.app.service;

import cl.gonzalo.app.model.Characters;

import java.util.List;

public interface IApiGet {

  public  Iterable<Characters> lista();

  public Characters characters(int id);

  public Iterable<Characters> filtro(String status, String gender);
}

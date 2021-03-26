package com.ustatunja.demo.repositories;

import com.ustatunja.demo.models.UsuarioModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel,Long> {

    public abstract ArrayList<UsuarioModel> findByPrioridad (Integer prioridad);

}

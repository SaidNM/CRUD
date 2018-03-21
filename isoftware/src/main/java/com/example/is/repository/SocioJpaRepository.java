package com.example.is.repository;

import com.example.is.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by saidn on 20/03/2018.
 */
public interface SocioJpaRepository extends JpaRepository<Socio,Serializable>{
    public abstract List<Socio> findByNombre(String nombre);
}

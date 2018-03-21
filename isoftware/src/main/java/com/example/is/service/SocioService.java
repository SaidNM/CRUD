package com.example.is.service;

import com.example.is.entity.Socio;

import java.util.List;

/**
 * Created by saidn on 20/03/2018.
 */
public interface SocioService {
    public abstract Socio registrar(Socio socio);
    public abstract List<Socio> consultar();
    public abstract int eliminar(int id);
    public abstract Socio actualizar(Socio socio);

}

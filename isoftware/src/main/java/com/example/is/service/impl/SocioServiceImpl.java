package com.example.is.service.impl;

import com.example.is.entity.Socio;
import com.example.is.repository.SocioJpaRepository;
import com.example.is.service.SocioService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by saidn on 20/03/2018.
 */

@Service("socioServiceImpl")
public class SocioServiceImpl implements SocioService {
    private static final Log LOG = LogFactory.getLog(SocioServiceImpl.class);

    @Autowired
    @Qualifier("socioJpaRepository")
    private SocioJpaRepository socioJpaRepository;

    @Override
    public Socio registrar(Socio socio) {
        return socioJpaRepository.save(socio);
    }

    @Override
    public List<Socio> consultar() {
        LOG.info("Call: "+"consultar()");
        return socioJpaRepository.findAll();
    }

    @Override
    public int eliminar(int id) {
        socioJpaRepository.delete(id);
        return 0;
    }

    @Override
    public Socio actualizar(Socio socio) {
        return socioJpaRepository.save(socio);
    }
}

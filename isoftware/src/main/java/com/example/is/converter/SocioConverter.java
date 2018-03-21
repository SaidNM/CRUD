package com.example.is.converter;

import com.example.is.entity.Socio;
import com.example.is.model.SocioModel;
import org.springframework.stereotype.Component;

/**
 * Created by saidn on 20/03/2018.
 */
@Component("socioConverter")
public class SocioConverter {
    //Entity -> Model
    public SocioModel entityToModel(Socio socio){
        SocioModel socioModel = new SocioModel();
        socioModel.setNombre(socio.getNombre());
        socioModel.setApellidoP(socio.getApellidoP());
        socioModel.setApellidoM(socio.getApellidoM());
        socioModel.setDescripcion(socio.getDescripcion());
        return socioModel;
    }


    //Model -> Entity
    public Socio modelToEntity(SocioModel socioModel){
        Socio socio = new Socio();
        socio.setNombre(socioModel.getNombre());
        socio.setApellidoP(socioModel.getApellidoP());
        socio.setApellidoM(socioModel.getApellidoM());
        socio.setDescripcion(socioModel.getDescripcion());
        return socio;
    }
}

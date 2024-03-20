package com.pe.tintegra.pacienteapi.service.impl;

import com.pe.tintegra.pacienteapi.controller.dto.ubigeo.Departamento;
import com.pe.tintegra.pacienteapi.controller.dto.ubigeo.Distrito;
import com.pe.tintegra.pacienteapi.controller.dto.ubigeo.Provincia;
import com.pe.tintegra.pacienteapi.model.Ubigeo;
import com.pe.tintegra.pacienteapi.repository.UbigeoRepository;
import com.pe.tintegra.pacienteapi.service.UbigeoService;
import com.pe.tintegra.pacienteapi.util.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class UbigeoServiceImpl implements UbigeoService {
    private UbigeoRepository ubigeoRepository;

    @Override
    public ResponseEntity<?> listarUbigeo() {
        List<Ubigeo> ubigeos = ubigeoRepository.listarUbigeo();

        List<Departamento> nuevodepa = new ArrayList<>();

        for (int i = 0; i < ubigeos.size(); i++) {
            Ubigeo p= ubigeos.get(i);
            int index = getIndexDepartamento(p.getCodigoDepartamento(), nuevodepa);

            Departamento pepa = new Departamento();
            Provincia pro = new Provincia();
            Distrito dist = new Distrito();

            List<Provincia> provincias = new ArrayList<>();
            List<Distrito> listaDist = new  ArrayList<>();

            dist.setId(p.getCodigoDistrito());
            dist.setNombre(p.getDescripcionDistrito());
            dist.setUbigeo(p.getCodigoUbigeo());
            pro.setId(p.getCodigoProvincia());
            pro.setNombre(p.getDescripcionProvincia());

            if (index<0) {
                pepa.setId(p.getCodigoDepartamento());
                pepa.setNombre(p.getDescripcionDepartamento());
                listaDist.add(dist);
                pro.setDistritos(listaDist);
                provincias.add(pro);
                pepa.setProvincias(provincias);
                nuevodepa.add(pepa);
            } else {
                List<Provincia> newprovincias = nuevodepa.get(index).getProvincias();
                int indexpro = getIndexProvincia(p.getCodigoProvincia(),nuevodepa.get(index).getProvincias());
                if(indexpro>=0) {
                    nuevodepa.get(index).getProvincias().get(indexpro).getDistritos().add(dist);
                }else {
                    listaDist.add(dist);
                    pro.setDistritos(listaDist);
                    newprovincias.add(pro);
                }
                nuevodepa.get(index).setProvincias(newprovincias);
            }
        }
        return ResponseUtil.handleSuccess(nuevodepa);
    }

    private int getIndexDepartamento(String idDepartamento, List<Departamento> listDepartamento) {
        for (int i = 0; i < listDepartamento.size(); i++) {
            if (listDepartamento.get(i).getId().equals(idDepartamento)) {
                return i;
            }
        }
        return -1;
    }
    private int getIndexProvincia(String idProvincia, List<Provincia> listProvincia) {
        for (int i = 0; i < listProvincia.size(); i++) {
            if (listProvincia.get(i).getId().equals(idProvincia)) return i;
        }
        return -1;
    }
}

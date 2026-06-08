package ort.da.mvp.Obligatorio.dtos;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadApuesta;

public class ModalidadDto {
     public String nombre;

public ModalidadDto(ModalidadApuesta modalidad) {
        this.nombre = modalidad.getNombre();
    }


    public static List<ModalidadDto> listaDtos(List<ModalidadApuesta> modalidades) {
        List<ModalidadDto> dtos = new ArrayList<>();
        for (ModalidadApuesta m : modalidades) {
            dtos.add(new ModalidadDto(m));
        }
        return dtos;
    }

}

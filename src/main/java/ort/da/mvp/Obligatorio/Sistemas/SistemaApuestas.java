package ort.da.mvp.Obligatorio.Sistemas;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.modelo.Apuesta;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadApuesta;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadSimple;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadSuper;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadTriple;


public class SistemaApuestas {
    private List<Apuesta> apuestas;
    private double comision = 10.0; //revisar lo de la comision, donde la coloco?
    private List<ModalidadApuesta> modalidades;
    
    public SistemaApuestas() {
        this.apuestas = new ArrayList<>();
        this.modalidades = new ArrayList<>();
       modalidades.add(new ModalidadSimple());
        modalidades.add(new ModalidadTriple());
        modalidades.add(new ModalidadSuper());
    }

    public double getComision() { return comision; }



    public List<ModalidadApuesta> getModalidades() { return modalidades; }

    public ModalidadApuesta buscarModalidad(String nombre) {
        for (ModalidadApuesta m : modalidades) {
            if (m.getNombre().equals(nombre)) {
                return m;
            }
        }
        return null;
    }


   
public void registrarApuesta(Apuesta apuesta) {
        apuestas.add(apuesta);
        apuesta.getParticipacion().getCarrera().registrarApuesta(apuesta, comision);
    }

}


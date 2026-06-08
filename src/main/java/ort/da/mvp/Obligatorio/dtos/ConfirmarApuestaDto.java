package ort.da.mvp.Obligatorio.dtos;

import ort.da.mvp.Obligatorio.modelo.Carrera;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadApuesta;
import ort.da.mvp.Obligatorio.modelo.Participacion;

public class ConfirmarApuestaDto {
    public int numeroCarrera;
    public String nombreCarrera;
    public int numeroCaballo;
    public String nombreCaballo;
    public double dividendoActual;
    public boolean dividendoValido;
    public double montoApostado;
    public String tipoApuesta;
    public double montoCosto;
    public double montoCobraria;

    public ConfirmarApuestaDto(Carrera carrera, Participacion participacion, 
                                ModalidadApuesta modalidad, double montoApostado) {
        this.numeroCarrera = carrera.getNumero();
        this.nombreCarrera = carrera.getNombre();
        this.numeroCaballo = participacion.getNumero();
        this.nombreCaballo = participacion.getCaballo().getNombre();
        this.dividendoActual = participacion.getDividendo().getValor();
        this.dividendoValido = participacion.getDividendo().EsValido();
        this.montoApostado = montoApostado;
        this.tipoApuesta = modalidad.getNombre();
        this.montoCosto = modalidad.calcularCosto(montoApostado);
        this.montoCobraria = modalidad.calcularPremio(
            montoApostado,
            participacion.getDividendo().getValor(),
            participacion.getTotalApostado()
        );
    }
}

package ort.da.mvp.Obligatorio.dtos;

import java.time.LocalDate;
import java.util.List;
import ort.da.mvp.Obligatorio.dtos.CarreraDto;
import ort.da.mvp.Obligatorio.modelo.Jornada;

public class JornadaDto {
     public LocalDate fecha;
    public double totalApostado;
    public double totalPagado;
    public double totalComisiones;
    public double balance;
    public int cantidadCarreras;
    public int cantidadFinalizadas;
    public int cantidadPorCorrer;
   public List<CarreraDto> carrerasFinalizadas;
    public List<CarreraDto> proximasCarreras;


public JornadaDto(Jornada jornada){
 this.fecha = jornada.getFecha();
 this.totalApostado = jornada.getTotalApostado();
        this.totalPagado = jornada.getTotalPagado();
        this.totalComisiones = jornada.getTotalComisiones();
        this.balance = jornada.getBalance();
        this.cantidadCarreras = jornada.getCarreras().size();
        this.cantidadFinalizadas = jornada.getCantidadFinalizadas();
        this.cantidadPorCorrer = jornada.getCantidadPorCorrer();
         this.carrerasFinalizadas = CarreraDto.listaDtos(jornada.getCarrerasFinalizadas()); 
    this.proximasCarreras = CarreraDto.listaDtos(jornada.getProximasCarreras());
}


}

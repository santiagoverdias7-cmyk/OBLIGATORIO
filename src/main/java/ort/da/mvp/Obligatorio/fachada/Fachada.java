package ort.da.mvp.Obligatorio.fachada;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import ort.da.mvp.Obligatorio.Sistemas.SistemaApuestas;
import ort.da.mvp.Obligatorio.Sistemas.SistemaJornadas;
import ort.da.mvp.Obligatorio.Sistemas.SistemaUsuarios;
import ort.da.mvp.Obligatorio.dtos.CarreraDisponibleDto;
import ort.da.mvp.Obligatorio.modelo.Apuesta;
import ort.da.mvp.Obligatorio.modelo.Carrera;
import ort.da.mvp.Obligatorio.modelo.Jornada;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadApuesta;
import ort.da.mvp.Obligatorio.modelo.Usuario;
import ort.da.mvp.Obligatorio.observador.Observable;



@Component
public class Fachada extends Observable  {

   public enum Eventos {
        cambioCarreras,
        cambioApuestas
    }


   

    private SistemaUsuarios sistemaUsuarios;
    private SistemaJornadas sistemaJornadas;
    private SistemaApuestas sistemaApuestas;

    private Fachada() {
        this.sistemaUsuarios = new SistemaUsuarios();
        this.sistemaJornadas = new SistemaJornadas();
        this.sistemaApuestas = new SistemaApuestas();
    }

    

 public void agregarUsuario(Usuario usuario) {
        sistemaUsuarios.agregarUsuario(usuario);
    }
    

public Usuario loginAdmin(String nombreUsuario, String contrasenia) {
    return sistemaUsuarios.loginAdmin(nombreUsuario, contrasenia);
}

public Usuario loginJugador(String nombreUsuario, String contrasenia) {
    return sistemaUsuarios.loginJugador(nombreUsuario, contrasenia);
}

public void agregarJornada(Jornada jornada) {
    sistemaJornadas.agregarJornada(jornada);


}

public Jornada getJornadaActual() {
    return sistemaJornadas.getJornadaActual();
}

public Jornada getJornadaAnterior(Jornada jornada) {
    return sistemaJornadas.getJornadaAnterior(jornada);
}

public Jornada getJornadaSiguiente(Jornada jornada) {
    return sistemaJornadas.getJornadaSiguiente(jornada);
}

public Carrera buscarCarreraEnJornada(int numero, LocalDate fecha) {
    return sistemaJornadas.buscarCarreraEnJornada(numero, fecha);
}

//es correcto que sistema jornadas modifique los estados de la carrera?
public void abrirCarrera(Carrera carrera) {
   sistemaJornadas.abrirCarrera(carrera);
   avisar(Eventos.cambioCarreras);
}

public void cerrarCarrera(Carrera carrera) {
    sistemaJornadas.cerrarCarrera(carrera);
    avisar(Eventos.cambioCarreras);
}

public void finalizarCarrera(Carrera carrera, int numeroGanador) {
    sistemaJornadas.finalizarCarrera(carrera, numeroGanador);
    avisar(Eventos.cambioCarreras);
}

public void registrarApuesta(Apuesta apuesta) {
    sistemaApuestas.registrarApuesta(apuesta);
     avisar(Eventos.cambioApuestas);
}

public ModalidadApuesta buscarModalidad(String nombre) {
    return sistemaApuestas.buscarModalidad(nombre);
}

//PARA CU DE JUGADOR.
public List<CarreraDisponibleDto> getCarrerasDisponibles() {
    return sistemaJornadas.getCarrerasDisponibles();
}

public List<ModalidadApuesta> getModalidades() {
    return sistemaApuestas.getModalidades();
}



}
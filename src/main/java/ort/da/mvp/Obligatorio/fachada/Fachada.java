package ort.da.mvp.Obligatorio.fachada;

import ort.da.mvp.Obligatorio.Sistemas.SistemaApuestas;
import ort.da.mvp.Obligatorio.Sistemas.SistemaJornadas;
import ort.da.mvp.Obligatorio.Sistemas.SistemaUsuarios;
import ort.da.mvp.Obligatorio.modelo.Jornada;
import ort.da.mvp.Obligatorio.modelo.Usuario;
import ort.da.mvp.Obligatorio.modelo.Carrera;




public class Fachada {

    private static Fachada instancia;

   private SistemaUsuarios sistemaUsuarios;
    private SistemaJornadas sistemaJornadas;
    private SistemaApuestas sistemaApuestas;

    private Fachada() {
        this.sistemaUsuarios = new SistemaUsuarios();
        this.sistemaJornadas = new SistemaJornadas();
        this.sistemaApuestas = new SistemaApuestas();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
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

public Carrera buscarCarreraEnJornada(int numero) {
    return sistemaJornadas.buscarCarreraEnJornadaActual(numero);
}


public void abrirCarrera(Carrera carrera) {
   sistemaJornadas.abrirCarrera(carrera);
}

public void cerrarCarrera(Carrera carrera) {
    sistemaJornadas.cerrarCarrera(carrera);
}

public void finalizarCarrera(Carrera carrera, int numeroGanador) {
    sistemaJornadas.finalizarCarrera(carrera, numeroGanador);
}


}
package ort.da.mvp.Obligatorio.datosPrueba;

import java.time.LocalDate;

import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Administrador;
import ort.da.mvp.Obligatorio.modelo.Caballo;
import ort.da.mvp.Obligatorio.modelo.Carrera;
import ort.da.mvp.Obligatorio.modelo.Cerrada;
import ort.da.mvp.Obligatorio.modelo.Jornada;
import ort.da.mvp.Obligatorio.modelo.Jugador;
import ort.da.mvp.Obligatorio.modelo.Participacion;

public class DatosPrueba {

    public static void cargarDatosDePrueba() {
        Fachada fachada = Fachada.getInstancia();

        // usuarios precargados
        fachada.agregarUsuario(new Administrador("a1", "a1", "Usuario Administrador"));
        fachada.agregarUsuario(new Administrador("a2", "a2", "Administrador Dos"));
        fachada.agregarUsuario(new Jugador("j1", "j1", "Usuario Jugador", 2000));
        fachada.agregarUsuario(new Jugador("j2", "j2", "Jugador Dos", 5000));
    //caballos
    Caballo c1 = new Caballo("Relámpago");
    Caballo c2 = new Caballo("Tornado");
    Caballo c3 = new Caballo("Trueno");
    Caballo c4 = new Caballo("Centella");
    
      // Jornada de hoy
    Jornada hoy = new Jornada(LocalDate.now());

Carrera carrera1 = new Carrera(1, "Gran Premio");
carrera1.agregarParticipacion(new Participacion(1, c1, carrera1));
carrera1.agregarParticipacion(new Participacion(2, c2, carrera1));
hoy.agregarCarrera(carrera1);

      Carrera carrera2 = new Carrera(2, "Copa de Oro");
    carrera2.agregarParticipacion(new Participacion(1, c2, carrera2));
    carrera2.agregarParticipacion(new Participacion(2, c3, carrera2));
    hoy.agregarCarrera(carrera2);

    Carrera carrera3 = new Carrera(3, "Trofeo MalaPata");
    carrera3.agregarParticipacion(new Participacion(1, c3, carrera3));
    carrera3.agregarParticipacion(new Participacion(2, c4, carrera3));
    hoy.agregarCarrera(carrera3);
// Jornada de hace una semana
    Jornada semanaAnterior = new Jornada(LocalDate.now().minusWeeks(1));

    Carrera carrera4 = new Carrera(1, "Carrera Clásica");
    carrera4.agregarParticipacion(new Participacion(1, c1, carrera4));
    carrera4.agregarParticipacion(new Participacion(2, c2, carrera4));
    carrera4.setEstado(new Cerrada());
    semanaAnterior.agregarCarrera(carrera4);

    Carrera carrera5 = new Carrera(2, "Carrera Especial");
    carrera5.agregarParticipacion(new Participacion(1, c3, carrera5));
    carrera5.agregarParticipacion(new Participacion(2, c4, carrera5));
    carrera5.setEstado(new Cerrada());
    semanaAnterior.agregarCarrera(carrera5);


    // Jornada de la semana próxima
    Jornada semanaSiguiente = new Jornada(LocalDate.now().plusWeeks(1));

    Carrera carrera6 = new Carrera(1, "Carrera Futura");
    carrera6.agregarParticipacion(new Participacion(1, c1, carrera6));
    carrera6.agregarParticipacion(new Participacion(2, c3, carrera6));
    semanaSiguiente.agregarCarrera(carrera6);

 // Agregar jornadas al sistema
    fachada.agregarJornada(hoy);
    fachada.agregarJornada(semanaAnterior);
    fachada.agregarJornada(semanaSiguiente);


}
}
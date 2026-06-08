package ort.da.mvp.Obligatorio.datosPrueba;

import java.time.LocalDate;


import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Administrador;
import ort.da.mvp.Obligatorio.modelo.Apuesta;
import ort.da.mvp.Obligatorio.modelo.Caballo;
import ort.da.mvp.Obligatorio.modelo.Carrera;
import ort.da.mvp.Obligatorio.modelo.Jornada;
import ort.da.mvp.Obligatorio.modelo.Jugador;
import ort.da.mvp.Obligatorio.modelo.Participacion;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadSuper;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadTriple;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadSimple;
import ort.da.mvp.Obligatorio.modelo.estadoCarrera.Cerrada;

public class DatosPrueba {

    public static void cargarDatosDePrueba(Fachada fachada) {
        
// no hacer el new de apuesta aca en datos de prueba, realizarlo en sistemaApuestas o verlo con el profe.
       // Administradores
        fachada.agregarUsuario(new Administrador("a1", "a1", "Usuario Administrador"));
        fachada.agregarUsuario(new Administrador("a2", "a2", "Administrador Dos"));

        // Jugadores
        Jugador j1 = new Jugador("j1", "j1", "Usuario Jugador", 20000);
        Jugador j2 = new Jugador("j2", "j2", "Jugador Dos", 50000);
        Jugador j3 = new Jugador("j3", "j3", "Jugador Tres", 50000);
        Jugador j4 = new Jugador("j4", "j4", "Jugador Cuatro", 50000);
        Jugador j5 = new Jugador("j5", "j5", "Jugador Cinco", 50000);
        Jugador j6 = new Jugador("j6", "j6", "Jugador Seis", 50000);
        Jugador j7 = new Jugador("j7", "j7", "Jugador Siete", 50000);
        Jugador j8 = new Jugador("j8", "j8", "Jugador Ocho", 50000);
        Jugador j9 = new Jugador("j9", "j9", "Jugador Nueve", 50000);
        Jugador j10 = new Jugador("j10", "j10", "Jugador Diez", 50000);
        fachada.agregarUsuario(j1);
        fachada.agregarUsuario(j2);
        fachada.agregarUsuario(j3);
        fachada.agregarUsuario(j4);
        fachada.agregarUsuario(j5);
        fachada.agregarUsuario(j6);
        fachada.agregarUsuario(j7);
        fachada.agregarUsuario(j8);
        fachada.agregarUsuario(j9);
        fachada.agregarUsuario(j10);

        // Caballos
        Caballo c1 = new Caballo("Relámpago");
        Caballo c2 = new Caballo("Tornado");
        Caballo c3 = new Caballo("Trueno");
        Caballo c4 = new Caballo("Centella");

        // Modalidades
        ModalidadSimple simple = new ModalidadSimple();
        ModalidadTriple triple = new ModalidadTriple();
        ModalidadSuper superM = new ModalidadSuper();

        // Jornada de hoy - 3 carreras en estado Definida
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

        fachada.agregarJornada(hoy);

        // Jornada de hace una semana - 2 carreras en estado Cerrada con apuestas
        Jornada semanaAnterior = new Jornada(LocalDate.now().minusWeeks(1));

        Carrera carrera4 = new Carrera(1, "Carrera Clásica");
        Participacion p4c1 = new Participacion(1, c1, carrera4);
        Participacion p4c2 = new Participacion(2, c2, carrera4);
        carrera4.agregarParticipacion(p4c1);
        carrera4.agregarParticipacion(p4c2);
        carrera4.abrir();

        fachada.registrarApuesta(new Apuesta(1000, j1, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j2, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j3, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j4, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j5, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j6, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j7, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j8, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j9, p4c1, simple));
        fachada.registrarApuesta(new Apuesta(1000, j10, p4c1, simple));

        fachada.registrarApuesta(new Apuesta(1000, j1, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j2, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j3, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j4, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j5, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j6, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j7, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j8, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j9, p4c2, triple));
        fachada.registrarApuesta(new Apuesta(1000, j10, p4c2, triple));

        carrera4.cerrar();
        semanaAnterior.agregarCarrera(carrera4);

        Carrera carrera5 = new Carrera(2, "Carrera Especial");
        Participacion p5c1 = new Participacion(1, c3, carrera5);
        Participacion p5c2 = new Participacion(2, c4, carrera5);
        carrera5.agregarParticipacion(p5c1);
        carrera5.agregarParticipacion(p5c2);
        carrera5.abrir();

        fachada.registrarApuesta(new Apuesta(1500, j1, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j2, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j3, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j4, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j5, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j6, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j7, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j8, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j9, p5c1, superM));
        fachada.registrarApuesta(new Apuesta(1500, j10, p5c1, superM));

        fachada.registrarApuesta(new Apuesta(1500, j1, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j2, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j3, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j4, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j5, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j6, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j7, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j8, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j9, p5c2, simple));
        fachada.registrarApuesta(new Apuesta(1500, j10, p5c2, simple));

        carrera5.cerrar();
        semanaAnterior.agregarCarrera(carrera5);

        fachada.agregarJornada(semanaAnterior);

        // Jornada de la semana proxima - 1 carrera en estado Definida
        Jornada semanaSiguiente = new Jornada(LocalDate.now().plusWeeks(1));

        Carrera carrera6 = new Carrera(1, "Carrera Futura");
        carrera6.agregarParticipacion(new Participacion(1, c1, carrera6));
        carrera6.agregarParticipacion(new Participacion(2, c3, carrera6));
        semanaSiguiente.agregarCarrera(carrera6);

        fachada.agregarJornada(semanaSiguiente);

}
}
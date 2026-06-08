package ort.da.mvp.Obligatorio.presentador.jugador;
import java.time.LocalDate;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import ort.da.mvp.Obligatorio.dtos.ConfirmarApuestaDto;
import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Apuesta;
import ort.da.mvp.Obligatorio.modelo.Carrera;
import ort.da.mvp.Obligatorio.modelo.Jugador;
import ort.da.mvp.Obligatorio.modelo.ModalidadAP.ModalidadApuesta;
import ort.da.mvp.Obligatorio.modelo.Participacion;
import ort.da.mvp.Obligatorio.presentador.Command;
import ort.da.mvp.Obligatorio.presentador.Commands;



@RestController
@Scope("session")
@RequestMapping("/confirmarApuesta")
public class PresentadorConfirmarApuesta {
     private final Fachada fachada;
    private Carrera carreraEnCurso;
    private Participacion participacionEnCurso;
    private ModalidadApuesta modalidadEnCurso;
    private double montoEnCurso;

    public PresentadorConfirmarApuesta(Fachada fachada) {
        this.fachada = fachada;
    }

  @PostMapping("/iniciar")
    public Commands iniciar(
            HttpSession sesionHttp,
            @RequestParam int numeroCarrera,
            @RequestParam String fechaCarrera,
            @RequestParam int numeroCaballo,
            @RequestParam String nombreModalidad,
            @RequestParam double montoApostado) {

        Jugador jugador = (Jugador) sesionHttp.getAttribute("usuarioLogueado");
        if (jugador == null) {
            return Commands.create(new Command("loginExitoso", "loginJugador.html"));
        }

        carreraEnCurso = fachada.buscarCarreraEnJornada(numeroCarrera, LocalDate.parse(fechaCarrera));
        participacionEnCurso = carreraEnCurso.buscarParticipacion(numeroCaballo);
        modalidadEnCurso = fachada.buscarModalidad(nombreModalidad);
        montoEnCurso = montoApostado;

        return Commands.create(confirmarApuesta());
    }

    @PostMapping("/confirmar")
    public Commands confirmar(
            HttpSession sesionHttp,
            @RequestParam String password) {

        Jugador jugador = (Jugador) sesionHttp.getAttribute("usuarioLogueado");

        if (carreraEnCurso == null) {
            return Commands.create(mensaje("No hay apuesta en curso"));
        }

        if (!jugador.coincideContrasenia(password)) {
            return Commands.create(mensaje("Contraseña incorrecta"));
        }

        fachada.registrarApuesta(new Apuesta(montoEnCurso, jugador, participacionEnCurso, modalidadEnCurso));
        limpiarApuestaEnCurso();
        return Commands.create(apuestaConfirmada());
    }

    @PostMapping("/descartar")
    public Commands descartar() {
        limpiarApuestaEnCurso();
        return Commands.create(apuestaDescartada());
    }

    private void limpiarApuestaEnCurso() {
        carreraEnCurso = null;
        participacionEnCurso = null;
        modalidadEnCurso = null;
        montoEnCurso = 0;
    }

private Command apuestaConfirmada() {
    return new Command("apuestaConfirmada", "tableroJugador.html");
}
private Command apuestaDescartada() {
    return new Command("apuestaDescartada", "tableroJugador.html");
}

    private Command confirmarApuesta() {
        return new Command("confirmarApuesta", new ConfirmarApuestaDto(
            carreraEnCurso, participacionEnCurso, modalidadEnCurso, montoEnCurso
        ));
    }

    private Command mensaje(String texto) {
        return new Command("mensaje", texto);
    }



}

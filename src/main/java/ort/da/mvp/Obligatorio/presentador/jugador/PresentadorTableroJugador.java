package ort.da.mvp.Obligatorio.presentador.jugador;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import jakarta.servlet.http.HttpSession;
import ort.da.mvp.Obligatorio.dtos.TableroJugadorDto;
import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Jugador;
import ort.da.mvp.Obligatorio.observador.Observable;
import ort.da.mvp.Obligatorio.observador.Observador;
import ort.da.mvp.Obligatorio.presentador.Command;
import ort.da.mvp.Obligatorio.presentador.Commands;
import ort.da.mvp.Obligatorio.utils.ConexionNavegador;

@RestController
@Scope("session")
@RequestMapping("/tableroJugador")
public class PresentadorTableroJugador implements Observador  {
   
    private final Fachada fachada;
    private final ConexionNavegador conexionNavegador;
    private Jugador jugadorActual;
    
public PresentadorTableroJugador(Fachada fachada, ConexionNavegador conexion) {
        this.fachada = fachada;
        this.conexionNavegador = conexion;
        this.fachada.agregarObservador(this);
    }

 @GetMapping(value = "/registrarSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter registrarSSE() {
        conexionNavegador.conectarSSE();
        return conexionNavegador.getConexionSSE();
    }
      @GetMapping("/vistaConectada")
    public Commands vistaConectada(HttpSession sesionHttp) {
        jugadorActual = (Jugador) sesionHttp.getAttribute("usuarioLogueado");
 System.out.println("Apuestas de j1: " + jugadorActual.getApuestas().size());   
       
        if (jugadorActual == null) {
            return Commands.create(new Command("loginExitoso", "loginJugador.html"));
        }
        return Commands.create(tablero());  
    }
   @PostMapping("/cerrarSesion")
    public Commands cerrarSesion(HttpSession sesionHttp) {
        sesionHttp.invalidate();
        jugadorActual = null;
        return Commands.create(new Command("loginExitoso", "loginJugador.html"));
    }

  @Override
    public void actualizar(Object evento, Observable origen) {
        if (Fachada.Eventos.cambioCarreras.equals(evento) ||
            Fachada.Eventos.cambioApuestas.equals(evento)) {
            if (jugadorActual != null) {
                conexionNavegador.enviarJSON(Commands.create(tablero()));
            }
        }
    }

  

private Command tablero() {
    return new Command("tablero", new TableroJugadorDto(
        jugadorActual,
        fachada.getCarrerasDisponibles(),
        fachada.getModalidades()
    ));
}



    private Command mensaje(String texto) {
        return new Command("mensaje", texto);
    }



}

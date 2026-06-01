package ort.da.mvp.Obligatorio.presentador.admin;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import ort.da.mvp.Obligatorio.dtos.JornadaDto;
import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Jornada;
import ort.da.mvp.Obligatorio.observador.Observable;
import ort.da.mvp.Obligatorio.observador.Observador;
import ort.da.mvp.Obligatorio.presentador.Command;
import ort.da.mvp.Obligatorio.presentador.Commands;
import ort.da.mvp.Obligatorio.utils.ConexionNavegador;


@RestController
@Scope("session")
@RequestMapping("/tableroAdmin")
public class PresentadorTableroAdmin implements  Observador {
    
 private Jornada jornadaActual;
 private final ConexionNavegador conexionNavegador;
 private final Fachada fachada;


public PresentadorTableroAdmin(Fachada fachada, ConexionNavegador conexion) {
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
public Commands vistaConectada() {
    jornadaActual = fachada.getJornadaActual();
     if (jornadaActual == null) {
        return Commands.create(mensaje("No hay jornadas definidas en el sistema"));    
    }
    return Commands.create(tablero());
};

@PostMapping("/jornadaAnterior")
public Commands jornadaAnterior() {
    Jornada anterior = fachada.getJornadaAnterior(jornadaActual);
    if (anterior != null) {
        jornadaActual = anterior;
        
    }
         return Commands.create(tablero());
}

@PostMapping("/jornadaSiguiente")
public Commands jornadaSiguiente() {
     Jornada siguiente = fachada.getJornadaSiguiente(jornadaActual);
    if (siguiente != null) {
        jornadaActual = siguiente;
        
    }
        return Commands.create(tablero());
}

// PresentadorTableroAdmin
@Override
public void actualizar(Object evento, Observable origen) {
    System.out.println("TableroAdmin - Evento: " + evento + " - jornadaActual: " + jornadaActual);
    System.out.println("TableroAdmin - Conexiones SSE: " + conexionNavegador.getConexionSSE());
    if (Fachada.Eventos.cambioCarreras.equals(evento) ||
        Fachada.Eventos.cambioApuestas.equals(evento)) {
        if (jornadaActual != null) {
            System.out.println("TableroAdmin - Enviando tablero...");
            conexionNavegador.enviarJSON(Commands.create(tablero()));
        } else {
            System.out.println("TableroAdmin - jornadaActual es null");
        }
    }
}



private Command mensaje(String texto) {
    return new Command("mensaje", texto);

}

private Command tablero() {
    return new Command("tablero", new JornadaDto(jornadaActual));
}


}
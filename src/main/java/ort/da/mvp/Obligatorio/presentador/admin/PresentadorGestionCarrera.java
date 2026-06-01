package ort.da.mvp.Obligatorio.presentador.admin;

import java.time.LocalDate;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import ort.da.mvp.Obligatorio.dtos.CarreraDto;
import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Carrera;
import ort.da.mvp.Obligatorio.observador.Observable;
import ort.da.mvp.Obligatorio.observador.Observador;
import ort.da.mvp.Obligatorio.presentador.Command;
import ort.da.mvp.Obligatorio.presentador.Commands;
import ort.da.mvp.Obligatorio.utils.ConexionNavegador;


@RestController
@RequestMapping("/gestionCarrera")
@Scope("session")
public class PresentadorGestionCarrera implements Observador{
private Carrera carreraSeleccionada;
private final Fachada fachada;
private final ConexionNavegador conexionNavegador;



   public PresentadorGestionCarrera(Fachada fachada, ConexionNavegador conexion) {
        this.fachada = fachada;
        this.conexionNavegador = conexion;
        this.fachada.agregarObservador(this);
    }


    @GetMapping(value = "/registrarSSE", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter registrarSSE() {
        conexionNavegador.conectarSSE();
        return conexionNavegador.getConexionSSE();
    }




    @PostMapping("/seleccionarCarrera")
    public Commands seleccionarCarrera(@RequestParam int numero, @RequestParam String fecha) {
        carreraSeleccionada = fachada.buscarCarreraEnJornada(numero, LocalDate.parse(fecha));
        if(carreraSeleccionada== null){
            return Commands.create(mensaje("Carrera no encontrada"));
        }
         return Commands.create(carrera());
        }
    
        @PostMapping("/abrirCarrera")
    public Commands abrirCarrera() {
        fachada.abrirCarrera(carreraSeleccionada);
        return Commands.create(carrera());
    }

    @PostMapping("/cerrarCarrera")
    public Commands cerrarCarrera() {
        fachada.cerrarCarrera(carreraSeleccionada);
        return Commands.create(carrera());
    }

    @PostMapping("/finalizarCarrera")
    public Commands finalizarCarrera(@RequestParam int numeroGanador) {
    fachada.finalizarCarrera(carreraSeleccionada, numeroGanador);
        return Commands.create(carrera());
    }
    

// PresentadorGestionCarrera
@Override
public void actualizar(Object evento, Observable origen) {
    System.out.println("GestionCarrera - Evento recibido: " + evento);
    if (Fachada.Eventos.cambioCarreras.equals(evento) && carreraSeleccionada != null) {
        System.out.println("GestionCarrera - Enviando carrera...");
        conexionNavegador.enviarJSON(Commands.create(carrera()));
    }
}


private Command carrera() {
    return new Command("carrera", new CarreraDto(carreraSeleccionada));
}


    private Command mensaje(String texto) {
    return new Command("mensaje", texto);
}




}

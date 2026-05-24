package ort.da.mvp.Obligatorio.presentador.admin;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Jornada;
import ort.da.mvp.Obligatorio.presentador.Command;
import ort.da.mvp.Obligatorio.presentador.Commands;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ort.da.mvp.Obligatorio.dtos.JornadaDto;


@RestController
@Scope("session")
@RequestMapping("/tableroAdmin")
public class PresentadorTableroAdmin {
    
 private Jornada jornadaActual;
    
@PostMapping("/vistaConectada")
public Commands vistaConectada() {
    jornadaActual = Fachada.getInstancia().getJornadaActual();
     if (jornadaActual != null) {
        return Commands.create(mensaje("No hay jornadas definidas en el sistema"));    
    }
    return Commands.create(tablero());
};

@PostMapping("/jornadaAnterior")
public Commands jornadaAnterior() {
    Jornada anterior = Fachada.getInstancia().getJornadaAnterior(jornadaActual);
    if (anterior != null) {
        jornadaActual = anterior;
        
    }
         return Commands.create(tablero());
}

@PostMapping("/jornadaSiguiente")
public Commands jornadaSiguiente() {
     Jornada siguiente = Fachada.getInstancia().getJornadaSiguiente(jornadaActual);
    if (siguiente != null) {
        jornadaActual = siguiente;
        
    }
        return Commands.create(tablero());
}

private Command mensaje(String texto) {
    return new Command("mensaje", texto);

}

private Command tablero() {
    return new Command("tablero", new JornadaDto(jornadaActual));
}


}
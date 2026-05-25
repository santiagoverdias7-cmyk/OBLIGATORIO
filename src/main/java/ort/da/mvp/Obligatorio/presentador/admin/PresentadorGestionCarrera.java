package ort.da.mvp.Obligatorio.presentador.admin;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ort.da.mvp.Obligatorio.dtos.CarreraDto;
import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Carrera;
import ort.da.mvp.Obligatorio.presentador.Command;
import ort.da.mvp.Obligatorio.presentador.Commands;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/gestionCarrera")
@Scope("session")
public class PresentadorGestionCarrera {
 private Carrera carreraSeleccionada;
    @PostMapping("/seleccionarCarrera")
    public Commands seleccionarCarrera(@RequestParam int numero) {
        carreraSeleccionada = Fachada.getInstancia().buscarCarreraEnJornada(numero);
        if(carreraSeleccionada== null){
            return Commands.create(mensaje("Carrera no encontrada"));
        }
         return Commands.create(carrera());
        }
    
        @PostMapping("/abrirCarrera")
    public Commands abrirCarrera() {
        Fachada.getInstancia().abrirCarrera(carreraSeleccionada);
        return Commands.create(carrera());
    }

    @PostMapping("/cerrarCarrera")
    public Commands cerrarCarrera() {
        Fachada.getInstancia().cerrarCarrera(carreraSeleccionada);
        return Commands.create(carrera());
    }

    @PostMapping("/finalizarCarrera")
    public Commands finalizarCarrera(@RequestParam int numeroGanador) {
        Fachada.getInstancia().finalizarCarrera(carreraSeleccionada, numeroGanador);
        return Commands.create(carrera());
    }
    
private Command carrera() {
    return new Command("carrera", new CarreraDto(carreraSeleccionada));
}


    private Command mensaje(String texto) {
    return new Command("mensaje", texto);
}




}

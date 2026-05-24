package ort.da.mvp.Obligatorio.presentador.jugador;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;
import ort.da.mvp.Obligatorio.fachada.Fachada;
import ort.da.mvp.Obligatorio.modelo.Usuario;
import ort.da.mvp.Obligatorio.presentador.Command;
import ort.da.mvp.Obligatorio.presentador.Commands;

@RestController
@Scope("session")
@RequestMapping("/loginJugador")
public class PresentadorLoginJugador {

  

   

    @PostMapping("/login")
    public Commands login(
            HttpSession sesionHttp,
            @RequestParam String nombreUsuario,
            @RequestParam String password) {

        Usuario usuario = Fachada.getInstancia().loginJugador(nombreUsuario, password);

        if (usuario != null) {
            sesionHttp.setAttribute("usuarioLogueado", usuario);
            return Commands.create(new Command("loginExitoso", "tableroJugador.html"));
        }

        return Commands.create(new Command("mensaje", "Acceso denegado"));
    }
}
package ort.da.mvp.Obligatorio.presentador.admin;

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
@RequestMapping("/loginAdmin")
@Scope("session")
public class PresentadorLoginAdmin {
    

    

   
    @PostMapping("/login")
    public Commands login(HttpSession sesionHttp,
            @RequestParam String nombreUsuario,
            @RequestParam String password) {
      Usuario usuario = Fachada.getInstancia().loginAdmin(nombreUsuario, password);
        
        if (usuario != null) {
            sesionHttp.setAttribute("usuarioLogueado", usuario);
            return Commands.create(new Command("loginExitoso", "tableroAdmin.html"));   
        } else {
            return Commands.create(new Command("loginExitoso", "tableroAdmin.html"));   
        }
    }
    



}

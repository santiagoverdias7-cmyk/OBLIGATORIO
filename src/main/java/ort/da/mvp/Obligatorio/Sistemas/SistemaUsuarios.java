package ort.da.mvp.Obligatorio.Sistemas;

import java.util.ArrayList;
import java.util.List;

import ort.da.mvp.Obligatorio.modelo.Administrador;
import ort.da.mvp.Obligatorio.modelo.Jugador;
import ort.da.mvp.Obligatorio.modelo.Usuario;

public class SistemaUsuarios {
    private List<Usuario> usuarios;
 
    public SistemaUsuarios() {
        this.usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }


public Usuario loginAdmin(String nombreUsuario, String password) {
    Usuario usuario = buscarUsuario(nombreUsuario, password);
    if (usuario instanceof Administrador) {
        return usuario;
    }
    return null;
}

public Usuario loginJugador(String nombreUsuario, String password) {
    Usuario usuario = buscarUsuario(nombreUsuario, password);
    if (usuario instanceof Jugador) {
        return usuario;
    }
    return null;
}
private Usuario buscarUsuario(String nombreUsuario, String password) {
    for (Usuario u : usuarios) {
        if (u.getNombreUsuario().equals(nombreUsuario) && u.getPassword().equals(password)) {
            return u;
        }
    }
    return null;
}

}

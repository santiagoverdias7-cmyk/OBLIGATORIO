package ort.da.mvp.Obligatorio.modelo;

public class Jugador extends Usuario {

   private Double saldo;


    public Jugador(String nombreUsuario, String password, String nombreCompleto, double saldo) {
        super(nombreUsuario, password, nombreCompleto);
        this.saldo = saldo;
    }

public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

}

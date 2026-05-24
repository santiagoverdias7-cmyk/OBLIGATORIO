package ort.da.mvp.Obligatorio.modelo;

public class Apuesta {
    
     private double montoApostado;
    private double montoCobrado;
    private Jugador jugador;
    private Participacion participacion;
    private ModalidadApuesta modalidad;
    //aun no sabemos la modalidad de apuesta
    public Apuesta(double montoApostado, Jugador jugador, Participacion participacion, ModalidadApuesta modalidad) {
        this.montoApostado = montoApostado;
        this.jugador = jugador;
        this.participacion = participacion;
        this.modalidad = modalidad;
        this.montoCobrado = 0;
    }

    public double getMontoApostado() { return montoApostado; }
    public double getMontoCobrado() { return montoCobrado; }
    public Jugador getJugador() { return jugador; }
    public Participacion getParticipacion() { return participacion; }

    public void setMontoCobrado(double montoCobrado) { this.montoCobrado = montoCobrado; }
}


package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public class Triple extends ModalidadApuesta {
    private CalculadorDescuento calculadorDescuento;
    private CalculadorPremio calculadorPremio;
    // Modalidad Triple: costo = monto * 1.5, premio varía según total apostado al caballo
    public Triple() {
        super("Triple");
        this.calculadorDescuento = new DescuentoTriple();
        this.calculadorPremio = new PremioTriple();
    }
    

    public double calcularCosto(double montoApostado) {
            return calculadorDescuento.calcular(montoApostado);
        }
        public double calcularPremio(double montoApostado, double dividendo, double totalApostadoCaballo) {
            return calculadorPremio.calcular(montoApostado, dividendo, totalApostadoCaballo);
        }
}

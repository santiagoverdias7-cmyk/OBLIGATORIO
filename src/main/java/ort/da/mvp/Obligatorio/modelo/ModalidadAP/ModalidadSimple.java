package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

// Modalidad Simple: sin recargo en el costo, premio = monto * dividendo
public class ModalidadSimple extends ModalidadApuesta {
    private CalculadorDescuento calculadorDescuento;
    private CalculadorPremio calculadorPremio;

    public ModalidadSimple() {
        super("Simple");
        this.calculadorDescuento = new DescuentoSimple();
        this.calculadorPremio = new PremioSimple();
    }

    public double calcularCosto(double montoApostado) {
        return calculadorDescuento.calcular(montoApostado);
    }

    public double calcularPremio(double montoApostado, double dividendo, double totalApostadoCaballo) {
        return calculadorPremio.calcular(montoApostado, dividendo, totalApostadoCaballo);
    }
}
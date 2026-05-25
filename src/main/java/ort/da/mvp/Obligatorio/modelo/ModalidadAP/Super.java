package ort.da.mvp.Obligatorio.modelo.ModalidadAP;

public class Super extends ModalidadApuesta {
    private CalculadorDescuento calculadorDescuento;
    private CalculadorPremio calculadorPremio;
// la modadalidad super: costo = monto * 2, premio varía según el dividendo del caballo
    public Super() {
        super("Super");
        this.calculadorDescuento = new DescuentoSuper();
        this.calculadorPremio = new PremioSuper();
    }

    public double calcularCosto(double montoApostado) {
        return calculadorDescuento.calcular(montoApostado);
    }

    public double calcularPremio(double montoApostado, double dividendo, double totalApostadoCaballo) {
        return calculadorPremio.calcular(montoApostado, dividendo, totalApostadoCaballo);
    }
    
}

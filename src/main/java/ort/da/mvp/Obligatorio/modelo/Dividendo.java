package ort.da.mvp.Obligatorio.modelo;

public class Dividendo {
    private double valor;
    private boolean valido;

    public Dividendo() {
        this.valor = 0;
        this.valido = false;
    }
    
 public double getValor() { return valor; }
 public boolean EsValido() { return valido; }


 public void actualizar(double totalApostadoCarrera, double comision, double totalApostadoCaballo) {
        if (totalApostadoCaballo > 0) {
            double nuevo = (totalApostadoCarrera * (1 - comision / 100.0)) / totalApostadoCaballo;
            if (nuevo > 1) {
                this.valor = nuevo;
                this.valido = true;
                return;
            }
        }
        this.valor = 0;
        this.valido = false;
    } /*revisar metodo*/


}

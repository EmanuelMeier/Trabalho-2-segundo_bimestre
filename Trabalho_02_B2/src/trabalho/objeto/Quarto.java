package trabalho.objeto;

public class Quarto {
    private int numero;
    private String tipo;
    private double precoDiario;
    private boolean disponivel;
    private boolean reservado;

    public Quarto(int numero, String tipo, double precoDiario, boolean disponivel) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = disponivel;
        this.reservado = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(double precoDiario) {
        this.precoDiario = precoDiario;
    }
    
    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Quarto [numero=" + numero + ", tipo=" + tipo + ", precoDiario=" + precoDiario + 
               ", disponivel=" + disponivel + ", reservado=" + reservado + "]";
    }
}

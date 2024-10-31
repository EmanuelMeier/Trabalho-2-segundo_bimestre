package trabalho.objeto;

public class Reserva {
    private String nome;
    private String dataEntrada;
    private String dataSaida;
    private int numQuartosRes;  
    private String tipoQuartoRes;

    public Reserva(String nome, String dataEntrada, String dataSaida, int numQuartosRes, String tipoQuartoRes) {
        this.nome = nome;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.numQuartosRes = numQuartosRes; 
        this.tipoQuartoRes = tipoQuartoRes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getNumQuartosRes() {
        return numQuartosRes;
    }

    public void setNumQuartosRes(int numQuartosRes) {
        this.numQuartosRes = numQuartosRes;
    }

    public String getTipoQuartoRes() {
        return tipoQuartoRes;
    }

    public void setTipoQuartoRes(String tipoQuartoRes) {
        this.tipoQuartoRes = tipoQuartoRes;
    }

    @Override
    public String toString() {
        return "Reserva [nome=" + nome + ", dataEntrada=" + dataEntrada + ", dataSaida=" + dataSaida + ", numQuartosRes=" + numQuartosRes + ", tipoQuartoRes=" + tipoQuartoRes + "]";
    }
}

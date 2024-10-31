package trabalho.objeto;

public class Hospede {
	public String nome;
	public String data;
	public int numQuartosRes;
	public String tipoQuartoRes;
	
	
	public Hospede(String nome, String data, int numQuartosRes, String tipoQuartoRes) {
		this.nome = nome;
		this.data = data;
		this.numQuartosRes = numQuartosRes;
		this.tipoQuartoRes = tipoQuartoRes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
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
		return "Hospede [nome=" + nome + ", data=" + data + ", numQuartosRes=" + numQuartosRes + ", tipoQuartoRes="
				+ tipoQuartoRes + "]";
	}
	
	
}


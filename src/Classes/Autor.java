package Classes;

public class Autor {
	private int idAutor;
	private String nomeAutor;
	private String dataDeNascimentoAutor;
	//---------------------------------------------------------------------------------
	public Autor(String nomeAutor, String dataDeNascimentoAutor,int idAutor) {
		super();
		this.idAutor = idAutor;
		this.nomeAutor = nomeAutor;
		this.dataDeNascimentoAutor = dataDeNascimentoAutor;
	}
	//---------------------------------------------------------------------------------
	public String getNomeAutor() {
		return nomeAutor;
	}
	//---------------------------------------------------------------------------------
	public String getDataDeNascimentoAutor() {
		return dataDeNascimentoAutor;
	}
	//---------------------------------------------------------------------------------
	public int getIdAutor() {
		return idAutor;
	}
}

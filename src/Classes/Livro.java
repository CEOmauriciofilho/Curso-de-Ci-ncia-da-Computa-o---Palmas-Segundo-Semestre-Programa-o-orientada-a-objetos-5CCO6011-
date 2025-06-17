package Classes;

public class Livro {
	private String senhaDaBiblioteca = "0000";
	private int id;
	private String titulo;
	private String Autor;
	private boolean disponibilidade = true;
	private String dataDeCadastros;
	private String dataDoUtimoEmprestimo;
	private String nomeDaPessoaQuePegouEmprestado;
	
	public Livro(int id, String titulo, String dataDeCadastros, String Autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.dataDeCadastros = dataDeCadastros;
		this.Autor = Autor;
	}
	//---------------------------------------------------------------------------------
	public String getDataDoUtimoEmprestimo() {
		return dataDoUtimoEmprestimo;
	}
	public void setDataDoUtimoEmprestimo(String dataDoUtimoEmprestimo) {
		this.dataDoUtimoEmprestimo = dataDoUtimoEmprestimo;
	}
	//---------------------------------------------------------------------------------
	public boolean isDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	//---------------------------------------------------------------------------------
	public String getNomeDaPessoaQuePegouEmprestado() {
		return nomeDaPessoaQuePegouEmprestado;
	}
	public void setNomeDaPessoaQuePegouEmprestado(String nomeDaPessoaQuePegouEmprestado) {
		this.nomeDaPessoaQuePegouEmprestado = nomeDaPessoaQuePegouEmprestado;
	}
	//---------------------------------------------------------------------------------
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getAutor() {
		return Autor;
	}
	public String getDataDeCadastros() {
		return dataDeCadastros;
	}
	public String getSenhaDaBiblioteca() {
		return senhaDaBiblioteca;
	}
}

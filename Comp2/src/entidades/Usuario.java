package entidades;

import java.util.ArrayList;
import java.util.HashMap;

public class Usuario {
	
	private HashMap<Filme, Integer> filmesAvaliados;
	private Sexo sexo;
	private int idade;
	private String nome, ocupacao, CEP;
	
	//Metodos de acesso
	public HashMap<Filme, Integer> getFilmesAvaliados() {
		return filmesAvaliados;
	}
	public void setFilmesAvaliados(HashMap<Filme, Integer> filmesAvaliados) {
		this.filmesAvaliados = filmesAvaliados;
	}
	public Sexo getSexo() {
		return sexo;
	}

	public int getIdade() {
		return idade;
	}
	public String getNome() {
		return nome;
	}
	
	public String getOcupacao() {
		return ocupacao;
	}
	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	//Construtores
	public Usuario(String n, int i, Sexo s, String o, String c)
	{
		this.nome = n;
		this.idade = i;
		this.sexo = s;
		this.ocupacao = o;
		this.CEP = c;
				
	}
	
	public Usuario(String nome, Sexo s)
	{
		this.nome = nome;
		this.sexo = s;
	}
	
	//Metodos gerais
	public void avaliaFilme(Filme f, int nota)
	{
		if(filmesAvaliados.containsKey(f)) //Se o usuario ja avaliou, atualiza a nota
			filmesAvaliados.replace(f, nota);
		else // Se nao, add nova nota
			filmesAvaliados.put(f, nota);
	}
	
	public ArrayList<Filme> verFilmesAssitidos()
	{
		ArrayList<Filme> filmesAssitidos = new ArrayList<Filme>();
		
		for(int i = 0; i < filmesAvaliados.size(); i++)
			filmesAssitidos.add(filmesAssitidos.get(i));
		
		return filmesAssitidos;
			
		
	}

}

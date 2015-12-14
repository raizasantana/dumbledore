package entidades;

import java.util.ArrayList;
import java.util.Collections;

public class Recomendador {
	
	public ArrayList<Filme> filmes = new ArrayList<Filme>();
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	
	
	private static Recomendador uniqueInstance;
	
	public static synchronized Recomendador getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Recomendador();
		
		

		return uniqueInstance;
	}

	public void geraUsuarios()
	{
		
		this.criarUsuario("Raiza",20, Sexo.feminino);
		this.criarUsuario("Rafa",20, Sexo.masculino);
		
		
	}

	public void geraFilmes()
	{
		filmes.add(new Filme("Matrix 1",Genero.drama));
		filmes.add(new Filme("Gone Girl",Genero.drama));
		filmes.add(new Filme("Jogos Vorazes",Genero.drama));
		filmes.add(new Filme("Star Wars",Genero.drama));
		filmes.add(new Filme("Se beber, não case",Genero.comedia));
	}
	
	public ArrayList<Filme> getMelhoresfilmes(int k)
	{
		ArrayList<Filme> kMelhores = new ArrayList<Filme>();
		
	/*	Collections.sort(filmes);
		
		for(int i = 0; i < k; i++)
			kMelhores.add(filmes.get(i));
		
		return kMelhores;*/
		return filmes;
	}
	
	public ArrayList<Filme> recomendaFilmes(Usuario u)
	{
		
		return this.getMelhoresfilmes(4);
	}
	
	public void criarUsuario(String nome, int idade, String feminino)
	{
		Usuario u = new Usuario(nome, feminino);
		u.setIdade(idade);
		
		usuarios.add(u);
	}
	
	
	
}


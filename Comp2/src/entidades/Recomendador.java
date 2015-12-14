package entidades;

import java.util.ArrayList;
import java.util.Collections;

public class Recomendador {
	
	private ArrayList<Filme> filmes = new ArrayList<Filme>();
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	public ArrayList<Filme> getMelhoresfilmes(int k)
	{
		ArrayList<Filme> kMelhores = new ArrayList<Filme>();
		
		Collections.sort(filmes);
		
		for(int i = 0; i < k; i++)
			kMelhores.add(filmes.get(i));
		
		return kMelhores;
	}
	
	public ArrayList<Filme> recomendaFilmes(Usuario u)
	{
		
		return this.getMelhoresfilmes(4);
	}
	
	public void criarUsuario(String nome, int idade, Sexo sexo)
	{
		Usuario u = new Usuario(nome, sexo);
		u.setIdade(idade);
		
		usuarios.add(u);
	}
	
	
	
}


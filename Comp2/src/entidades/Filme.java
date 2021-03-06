package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Filme implements Comparable{
	
	private String titulo, url, dataLancamento;
	private ArrayList<String> generos;
	
	private HashMap<Usuario, Integer> avaliacoes; 
	
	public String toString()
	{
		return this.titulo;
	}
	
	
	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getDataLancamento() {
		return dataLancamento;
	}


	public void setDataLancamento(String dataLancamento) {
		this.dataLancamento = dataLancamento;
	}


	public HashMap<Usuario, Integer> getAvaliacoes() {
		return avaliacoes;
	}


	public void setAvaliacoes(HashMap<Usuario, Integer> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}


	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public ArrayList<String> getGeneros() {
		return generos;
	}
	public void setGeneros(ArrayList<String> generos) {
		this.generos = generos;
	}
	
	
	public  Filme(String titulo, ArrayList<String> generos)
	{
		this.titulo = titulo;
		this.generos = generos;
		
		this.avaliacoes = new HashMap<Usuario, Integer>();
	}
	
	public int getNotaMedia() {
		int notaMedia = 0;
		
		if(avaliacoes.size() > 0)
		{
			for(int i = 0; i < avaliacoes.size(); i++)
				notaMedia =+ avaliacoes.get(i);
		
			return notaMedia/avaliacoes.size();
		}
		
		return 0;
			
		
	}
	
	@Override
	public int compareTo(Object f) {
		// TODO Auto-generated method stub
		int comparaNota=((Filme)f).getNotaMedia();
	
		/* For Descending order do like this */
        return comparaNota-this.getNotaMedia();

	}
	
	
	
	
	
	

}

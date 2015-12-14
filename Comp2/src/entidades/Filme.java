package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Filme implements Comparable{
	
	private String titulo;
	private ArrayList<String> generos;
	private Date dataLancamento;
	private HashMap<Usuario, Integer> avaliacoes = new HashMap<Usuario, Integer>();
	
	public String toString()
	{
		return this.titulo;
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
	public Date getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	
	public  Filme(String titulo, String genero)
	{
		this.titulo = titulo;
		this.generos = new ArrayList<String>();
		this.generos.add(genero);
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

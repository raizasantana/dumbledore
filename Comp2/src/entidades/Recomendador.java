package entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Recomendador {

	public ArrayList<Filme> filmes = new ArrayList<Filme>();
	public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	public HashMap<Integer, String> codigosGeneros = new HashMap<>();
	public Usuario usuarioLogado = null;

	private static Recomendador uniqueInstance;

	public static synchronized Recomendador getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new Recomendador();

		return uniqueInstance;
	}

	public void geraUsuarios() {
		this.criarUsuario("Raiza", 22, Sexo.feminino, "Dev","123345");
		this.criarUsuario("Renan", 23, Sexo.masculino,"Dev","123467");
		this.criarUsuario("Bruno", 25, Sexo.masculino, "Professor","3876480");

	}

	public void geraFilmes() {
		this.carregaFilmes();
	}

	public ArrayList<Filme> getMelhoresfilmes(int k) {
		ArrayList<Filme> kMelhores = new ArrayList<Filme>();

		if (filmes.size() == 0)
			geraFilmes();

		Collections.sort(filmes);

		for (int i = 0; i < k; i++)
			kMelhores.add(filmes.get(i));

		return kMelhores;

	}

	public ArrayList<Filme> recomendaFilmes(Usuario u) {

		return this.getMelhoresfilmes(4);
	}

	public void criarUsuario(String nome, int idade, String feminino, String ocupa, String cep) {
		Usuario u = new Usuario(nome, idade, feminino,ocupa,cep);
		usuarios.add(u);
	}

	public void logar(Usuario u)
	{
		this.usuarioLogado = u;
	}
	
	public void carregaFilmes() {
		this.filmes = new ArrayList<Filme>();

		try {
			FileReader arq = new FileReader("datasets/item.csv");
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();

			while (linha != null) {

				String vet[] = linha.split("#");

				Filme novo = new Filme(vet[1], getGeneros(linha));
				novo.setDataLancamento(vet[2]);
				novo.setUrl(vet[3]);

				this.filmes.add(novo);

				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}

	}

	public ArrayList<String> getGeneros(String linha) {
		String vet[] = linha.split("#");
		ArrayList<String> generos = new ArrayList<String>();

		populaHashGeneros();

		for (int i = 4; i < vet.length; i++) {

			if (Integer.valueOf(vet[i]) == 1)
				generos.add(codigosGeneros.get(i));

		}

		return generos;

	}

	public void populaHashGeneros() {
		codigosGeneros.put(4, Genero.acao);
		codigosGeneros.put(5, Genero.aventura);
		codigosGeneros.put(6, Genero.animacao);
		codigosGeneros.put(7, Genero.infantil);
		codigosGeneros.put(8, Genero.comedia);
		codigosGeneros.put(9, Genero.criminal);
		codigosGeneros.put(10, Genero.documentario);
		codigosGeneros.put(11, Genero.drama);
		codigosGeneros.put(12, Genero.fantasia);
		codigosGeneros.put(13, Genero.investigativo);
		codigosGeneros.put(14, Genero.suspense);
		codigosGeneros.put(15, Genero.musical);
		codigosGeneros.put(16, Genero.misterio);
		codigosGeneros.put(17, Genero.romance);
		codigosGeneros.put(18, Genero.sciFi);
		codigosGeneros.put(19, Genero.terror);
		codigosGeneros.put(20, Genero.guerra);
		codigosGeneros.put(21, Genero.ocidental);

	}

}

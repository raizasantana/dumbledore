package telas;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import entidades.Recomendador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaPrincipal {

	private JFrame frmNetflixChill;
	public Recomendador sistema = new Recomendador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmNetflixChill.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		Recomendador rec = Recomendador.getInstance();
		rec.carregaFilmes();
		initialize(rec);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Recomendador rec) {
		
		frmNetflixChill = new JFrame();
		frmNetflixChill.setForeground(Color.RED);
		frmNetflixChill.setTitle("NETFLIX & CHILL");
		frmNetflixChill.setBounds(100, 100, 600, 600);
		frmNetflixChill.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNetflixChill.getContentPane().setLayout(null);
		JLabel lblEfetueLoginPara = new JLabel("Efetue login para avaliar filmes e receber recomendações.");
		lblEfetueLoginPara.setHorizontalAlignment(SwingConstants.CENTER);
		lblEfetueLoginPara.setBounds(41, 138, 511, 66);
		frmNetflixChill.getContentPane().add(lblEfetueLoginPara);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 594, 21);
		frmNetflixChill.getContentPane().add(menuBar);
		
		JMenu menuUsuario = new JMenu("Usuário");
		menuBar.add(menuUsuario);
		
		JMenuItem criarUsuario = new JMenuItem("Criar Usuário");
		criarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicou!!");
				
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Pressed");
				CriarUsuario tlNovoUsuario = new CriarUsuario();
				tlNovoUsuario.setVisible(true);
				
			}
		});
		menuUsuario.add(criarUsuario);
		
		JMenuItem listarUsuarios = new JMenuItem("Listar Usuários");
		listarUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarUsuarios tlListarUsuarios = new ListarUsuarios();
				tlListarUsuarios.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tlListarUsuarios.setVisible(true);
				
			}
		});
		menuUsuario.add(listarUsuarios);
		
		JMenuItem listarFilmesAssistidos = new JMenuItem("Listar Filmes Assistidos");
		listarFilmesAssistidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarUsuariosFA tlListarUsuariosFA = new ListarUsuariosFA();
				tlListarUsuariosFA.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tlListarUsuariosFA.setVisible(true);
				
			}
		});
		menuUsuario.add(listarFilmesAssistidos);
		
		JMenuItem verFilmesSugeridos = new JMenuItem("Ver Filmes Sugeridos");
		verFilmesSugeridos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarMelhoresFilmes tlFilmesSugeridos = new ListarMelhoresFilmes();
				tlFilmesSugeridos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tlFilmesSugeridos.setVisible(true);
			}
		});
		menuUsuario.add(verFilmesSugeridos);
		
		JMenuItem mntmEntrar = new JMenuItem("Entrar");
		mntmEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListaUsuariosLogin tlLogin = new ListaUsuariosLogin();
				tlLogin.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tlLogin.setVisible(true);
				
			}
		});
		menuUsuario.add(mntmEntrar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				if(rec.usuarioLogado == null)
					JOptionPane.showMessageDialog(null, "Não há usuário logado.");
				else
				{
					JOptionPane.showMessageDialog(null, "Usuário "+rec.usuarioLogado.getNome() + " deslogado com sucesso.");
					rec.usuarioLogado = null;
				}
				
			}
		});
		menuUsuario.add(mntmSair);
		
		JMenu menuFilme = new JMenu("Filme");
		menuBar.add(menuFilme);
		
		JMenuItem listarFilmes = new JMenuItem("Listar Filmes");
		listarFilmes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				ListarFilmes tlListarfilmes = new ListarFilmes();
				tlListarfilmes.setVisible(true);
				
			}
		});
		menuFilme.add(listarFilmes);
		
		JMenuItem avaliarFilme = new JMenuItem("Avaliar Filme");
		avaliarFilme.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(rec.usuarioLogado == null)
					JOptionPane.showMessageDialog(null,"Efetue login para avaliar os filmes");
				else
				{
					ListarFilmesAV tlAvaliarFilme = new ListarFilmesAV(rec.usuarioLogado);
					tlAvaliarFilme.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tlAvaliarFilme.setVisible(true);
					
					lblEfetueLoginPara.setText("Usuário logado: "+ rec.usuarioLogado.getNome());
				}
			}
		});
		menuFilme.add(avaliarFilme);
		
		JMenuItem melhoresFilmes = new JMenuItem("Melhores Filmes");
		melhoresFilmes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListarMelhoresFilmes tlFilmesSugeridos = new ListarMelhoresFilmes();
				tlFilmesSugeridos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				tlFilmesSugeridos.setVisible(true);
			}
		});
		menuFilme.add(melhoresFilmes);
		
		JMenu mnNewMenu = new JMenu("Sobre");
		mnNewMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"AA COMP 2 - 2015.2\n Desenvolvido por Raíza Santana e Renan Sies");
			}
		});
		menuBar.add(mnNewMenu);
		
		JLabel lblNewLabel = new JLabel("Bem-vindo(a) ao NetFlix & Chill!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 60, 594, 66);
		frmNetflixChill.getContentPane().add(lblNewLabel);
		
		
	}

}

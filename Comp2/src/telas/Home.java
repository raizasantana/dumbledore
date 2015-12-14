package telas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.MenuBar;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	
	
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(0, 0, 650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Menu superior
		JPanel painel = new JPanel();
		painel.setBounds(0, 0, 130, 30);
		painel.setBackground(Color.yellow);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 100,30);		
		menuBar.add(new JMenu("Filme"));
		menuBar.getMenu(0).add(new JMenuItem("Avaliar Filmes"));
		menuBar.getMenu(0).add(new JMenuItem("Obter Filmes"));
		
		menuBar.add(new JMenu("Usuário"));
		menuBar.getMenu(1).add(new JMenuItem("Criar Usuário"));
		menuBar.getMenu(1).add(new JMenuItem("Editar Usuário"));
		
		painel.add(menuBar);
		frame.add(painel);
		
		//Tela
		JPanel painel2 = new JPanel();
		painel2.setBounds(0, 300, 200, 20);
		painel2.setBackground(Color.red);
		frame.add(painel2);
		
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	/*private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 650, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel janela = new Panel();
		janela.setBounds(0, 0, 20, 20);
		janela.setBackground(Color.yellow);
		
		
		//Cria menu surrperior
		JMenuBar menuBar = new JMenuBar();
		
		
		menuBar.add(new JMenu("Arquivo",false));
		menuBar.getMenu(0).setBounds(0, 0, 20,20);
		
		
		janela.add(menuBar);
		frame.add(janela);
		//frame.add(menuBar);
		
		
		
	}*/

}

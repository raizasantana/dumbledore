package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Filme;
import entidades.Recomendador;

import javax.swing.JList;

public class ListarFilmes extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			
			ListarFilmes dialog = new ListarFilmes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarFilmes() {
		setTitle("Filmes");
		setBounds(100, 100, 500, 400);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 494, 338);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		Recomendador rec = Recomendador.getInstance();
		
		rec.geraFilmes();
		
		contentPanel.setLayout(null);
		{
			JList list = new JList(rec.filmes.toArray());
			list.setBounds(63, 33, 365, 274);
			contentPanel.add(list);
		}
	}

}

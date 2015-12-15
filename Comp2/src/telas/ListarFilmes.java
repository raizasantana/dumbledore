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
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ListarFilmes extends JDialog {

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
		Recomendador rec = Recomendador.getInstance();
		
		//if(rec.filmes.size() <= 0)
		//	rec.geraFilmes();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 29, 400, 338);
		getContentPane().add(scrollPane);
		
			JList list = new JList(rec.filmes.toArray());
			list.setBounds(38, 147, 124, 144);
		
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					String mensagem = "Filme: " + rec.filmes.get(list.getSelectedIndex()).getTitulo() +"\n";
					
					mensagem += "Generos:";
					
					for(int i = 0; i < rec.filmes.get(list.getSelectedIndex()).getGeneros().size(); i++)
						mensagem += rec.filmes.get(list.getSelectedIndex()).getGeneros().get(i) + " | ";
				
					mensagem += "\n Lançamento: " +rec.filmes.get(list.getSelectedIndex()).getDataLancamento();
					mensagem += "\n Link IMDB: " +rec.filmes.get(list.getSelectedIndex()).getUrl();
					
//					for(int j = 0; j < rec.filmes.get(list.getSelectedIndex()).getAvaliacoes().size();j++)
					mensagem += "\n Usuarios que assistiram:" + rec.filmes.get(list.getSelectedIndex()).getAvaliacoes().keySet();
				
					JOptionPane.showMessageDialog(null, mensagem);
		
				}
			});
		
		
		scrollPane.setViewportView(list);
	}
}

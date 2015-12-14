package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import entidades.Recomendador;

public class ListarFilmesAV extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarFilmesAV dialog = new ListarFilmesAV();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarFilmesAV() {
		setTitle("Filmes");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		Recomendador rec = Recomendador.getInstance();
		
		if(rec.filmes.size() <= 0)
			rec.geraFilmes();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 29, 500, 338);
		getContentPane().add(scrollPane);
		
			JList list = new JList(rec.filmes.toArray());
			list.setBounds(38, 147, 124, 144);
		
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					String nota = "0";
					while(Integer.valueOf(nota) <= 0 || Integer.valueOf(nota) > 5)
					{	
						nota = JOptionPane.showInputDialog("Insira sua nota para o filme: (1 a 5)");
						
						if(Integer.valueOf(nota) <= 0 || Integer.valueOf(nota) > 5)
							JOptionPane.showMessageDialog(null,"Insira notas entre 1 a 5!");
					}
		
				}
			});
		
		
		scrollPane.setViewportView(list);
	}
}

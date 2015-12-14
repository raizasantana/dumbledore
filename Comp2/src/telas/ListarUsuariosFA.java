package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Recomendador;

import javax.swing.JList;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarUsuariosFA extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarUsuariosFA dialog = new ListarUsuariosFA();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarUsuariosFA() {
		setTitle("Selecione um usuário");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 444, 238);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		Recomendador rec = Recomendador.getInstance();
		rec.geraUsuarios();
		
		contentPanel.setLayout(null);
		{
			JList list = new JList(rec.usuarios.toArray());
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					rec.geraFilmes();
					
					rec.usuarios.get(list.getSelectedIndex()).avaliaFilme(rec.filmes.get(0), 2);
					rec.usuarios.get(list.getSelectedIndex()).avaliaFilme(rec.filmes.get(1), 2);
					
					ListarFilmesAssistidos tlListarFilmesAssistidos = new ListarFilmesAssistidos(rec.usuarios.get(list.getSelectedIndex()));
					setVisible(false);
					tlListarFilmesAssistidos.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tlListarFilmesAssistidos.setVisible(true);
				}
			});
			list.setBounds(50, 12, 328, 226);
			contentPanel.add(list);
		}
	}

}

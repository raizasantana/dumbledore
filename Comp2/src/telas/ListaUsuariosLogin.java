package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Recomendador;

import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListaUsuariosLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaUsuariosLogin dialog = new ListaUsuariosLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaUsuariosLogin() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 444, 273);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		Recomendador rec = Recomendador.getInstance();
		
		if(rec.usuarios.size() == 0)
			rec.geraUsuarios();
		
		JList list = new JList(rec.usuarios.toArray());
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				rec.usuarioLogado = rec.usuarios.get(list.getSelectedIndex());
				dispose();
				
			}
		});
		list.setBounds(101, 75, 260, 130);
		contentPanel.add(list);
		
		JLabel lblEscolhaUmUsurio = new JLabel("Escolha um usuário");
		lblEscolhaUmUsurio.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscolhaUmUsurio.setBounds(95, 12, 276, 15);
		contentPanel.add(lblEscolhaUmUsurio);
	}
}

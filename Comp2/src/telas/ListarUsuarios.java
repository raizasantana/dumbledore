package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Recomendador;
import entidades.Sexo;

import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListarUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarUsuarios dialog = new ListarUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarUsuarios() {
		Recomendador rec = Recomendador.getInstance();		
	
		rec.geraUsuarios();
		
		setTitle("Listar Usuários");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 444, 238);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JList list = new JList(rec.usuarios.toArray());
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					System.out.println("Clicou "+list.getSelectedIndex());
					setVisible(false);
					
					EditarUsuario tlEditarUsuario = new EditarUsuario(rec.usuarios.get(list.getSelectedIndex()), list.getSelectedIndex());
					tlEditarUsuario.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					tlEditarUsuario.setVisible(true);
					//tlEditaUsuario.getComponent(
					
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
			list.setBounds(37, 12, 362, 214);
			contentPanel.add(list); 
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 238, 444, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

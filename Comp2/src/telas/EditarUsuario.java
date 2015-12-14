package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.HierarchyBoundsAdapter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Recomendador;
import entidades.Sexo;
import entidades.Usuario;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdade;
	private JTextField txtCEP;
	private JTextField textField;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			EditarUsuario dialog = new EditarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public EditarUsuario(Usuario u, int i) {
		setTitle("Editar Usuário");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		getContentPane().add(contentPanel);
		{
			JLabel lblIdade = new JLabel("Idade");
			lblIdade.setBounds(98, 50, 70, 15);
			lblIdade.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
				
			});
			contentPanel.setLayout(null);
			lblIdade.setVerticalAlignment(SwingConstants.TOP);
			contentPanel.add(lblIdade);
		}
		{
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(88, 13, 64, 38);
			lblNome.setVerticalAlignment(SwingConstants.TOP);
			lblNome.setHorizontalAlignment(SwingConstants.LEFT);
			contentPanel.add(lblNome);
		}
		txtIdade = new JTextField(String.valueOf(u.getIdade()));
		txtIdade.setBounds(168, 48, 167, 19);
		contentPanel.add(txtIdade);
		txtIdade.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setBounds(69, 88, 70, 15);
		contentPanel.add(lblSexo);
		
		JComboBox cbSexo = new JComboBox();
		cbSexo.setBounds(168, 79, 167, 24);
		cbSexo.addItem(Sexo.feminino);
		cbSexo.addItem(Sexo.masculino);
		
		if(u.getSexo() == Sexo.feminino)
			cbSexo.setSelectedIndex(0);
		else
			cbSexo.setSelectedIndex(1);
		
		cbSexo.enable(false);
		
		contentPanel.add(cbSexo);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCEP.setBounds(69, 123, 70, 15);
		contentPanel.add(lblCEP);
		
		txtCEP = new JTextField(u.getCEP());
		txtCEP.setBounds(168, 122, 114, 19);
		contentPanel.add(txtCEP);
		txtCEP.setColumns(10);
		
		JLabel lblOcupao = new JLabel("Ocupação");
		lblOcupao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOcupao.setBounds(69, 157, 70, 15);
		contentPanel.add(lblOcupao);
		
		textField = new JTextField(u.getOcupacao());
		textField.setBounds(168, 153, 167, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		txtNome = new JTextField(u.getNome());
		txtNome.setBounds(168, 11, 167, 19);
		txtNome.enable(false);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		
		
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						Recomendador rec = Recomendador.getInstance();
						
						rec.usuarios.get(i).setCEP(txtCEP.getText());
						rec.usuarios.get(i).setIdade(Integer.valueOf(txtIdade.getText()));
						rec.usuarios.get(i).setOcupacao(textField.getText());
						
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

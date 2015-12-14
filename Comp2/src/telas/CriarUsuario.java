package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Recomendador;
import entidades.Sexo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CriarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdade;
	private JTextField txtCEP;
	private JTextField textField;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CriarUsuario dialog = new CriarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CriarUsuario() {
		setTitle("Novo Usuário");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 444, 238);
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
		
		txtIdade = new JTextField();
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
		contentPanel.add(cbSexo);
		
		JLabel lblCEP = new JLabel("CEP");
		lblCEP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCEP.setBounds(69, 123, 70, 15);
		contentPanel.add(lblCEP);
		
		txtCEP = new JTextField();
		txtCEP.setBounds(168, 122, 114, 19);
		contentPanel.add(txtCEP);
		txtCEP.setColumns(10);
		
		JLabel lblOcupao = new JLabel("Ocupação");
		lblOcupao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOcupao.setBounds(69, 157, 70, 15);
		contentPanel.add(lblOcupao);
		
		textField = new JTextField();
		textField.setBounds(168, 153, 167, 19);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(168, 11, 167, 19);
		contentPanel.add(txtNome);
		txtNome.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 238, 444, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						System.out.println("Add novo Usuario");
						
						Recomendador rec = Recomendador.getInstance();
						
						 if(cbSexo.getSelectedItem().toString() == Sexo.masculino)
							 rec.criarUsuario(txtNome.getText(), Integer.valueOf(txtIdade.getText()), Sexo.masculino);
						 else
							 rec.criarUsuario(txtNome.getText(), Integer.valueOf(txtIdade.getText()), Sexo.feminino);
						 
						
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						 	 setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

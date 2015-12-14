package telas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entidades.Filme;
import entidades.Recomendador;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AvaliarFilmes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtN1;
	private JTextField txtN2;
	private JTextField txtN3;
	private JTextField txtN4;
	private JTextField txtN5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AvaliarFilmes dialog = new AvaliarFilmes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AvaliarFilmes() {
		
		Recomendador rec = Recomendador.getInstance();
		
		rec.geraFilmes();
		
		setTitle("Filmes");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 444, 238);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblF1 = new JLabel(rec.filmes.get(0).getTitulo());
		lblF1.setBounds(69, 32, 70, 15);
		contentPanel.add(lblF1);
		
		JLabel lblF2 = new JLabel(rec.filmes.get(1).getTitulo());
		lblF2.setBounds(69, 66, 70, 15);
		contentPanel.add(lblF2);
		
		JLabel lblF3 = new JLabel(rec.filmes.get(2).getTitulo());
		lblF3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF3.setBounds(26, 109, 113, 15);
		contentPanel.add(lblF3);
		
		JLabel lblF4 = new JLabel(rec.filmes.get(3).getTitulo());
		lblF4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblF4.setBounds(12, 148, 127, 15);
		contentPanel.add(lblF4);
		
		JLabel lblF5 = new JLabel(rec.filmes.get(4).getTitulo());
		lblF5.setBounds(12, 173, 199, 54);
		contentPanel.add(lblF5);
		
		txtN1 = new JTextField();
		txtN1.setBounds(207, 30, 114, 19);
		contentPanel.add(txtN1);
		txtN1.setColumns(10);
		
		txtN2 = new JTextField();
		txtN2.setBounds(207, 64, 114, 19);
		contentPanel.add(txtN2);
		txtN2.setColumns(10);
		
		txtN3 = new JTextField();
		txtN3.setBounds(207, 107, 114, 19);
		contentPanel.add(txtN3);
		txtN3.setColumns(10);
		
		txtN4 = new JTextField();
		txtN4.setBounds(207, 146, 114, 19);
		contentPanel.add(txtN4);
		txtN4.setColumns(10);
		
		txtN5 = new JTextField();
		txtN5.setBounds(207, 191, 114, 19);
		contentPanel.add(txtN5);
		txtN5.setColumns(10);
		
		JLabel lblNotad = new JLabel("NOTAS DE 1 A 5");
		lblNotad.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotad.setForeground(Color.RED);
		lblNotad.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNotad.setBounds(127, 0, 162, 15);
		contentPanel.add(lblNotad);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 238, 444, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) 
					{
						Recomendador rec = Recomendador.getInstance();
						
						rec.usuarios.get(rec.usuarios.size()-1).avaliaFilme(rec.filmes.get(0), Integer.valueOf(txtN1.getText()));
						rec.usuarios.get(rec.usuarios.size()-1).avaliaFilme(rec.filmes.get(1), Integer.valueOf(txtN2.getText()));
						rec.usuarios.get(rec.usuarios.size()-1).avaliaFilme(rec.filmes.get(2), Integer.valueOf(txtN3.getText()));
						rec.usuarios.get(rec.usuarios.size()-1).avaliaFilme(rec.filmes.get(3), Integer.valueOf(txtN4.getText()));
						rec.usuarios.get(rec.usuarios.size()-1).avaliaFilme(rec.filmes.get(4), Integer.valueOf(txtN5.getText()));
						
						setVisible(false);
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
					public void mousePressed(MouseEvent e) 
					{
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

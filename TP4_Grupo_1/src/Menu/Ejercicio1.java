package Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldFechaNac;
	private JButton btnMostrar;
	private JLabel lblLosDatosIngresados;
	private JLabel lblResultado;

	/**
	 * Create the frame.
	 */
	public Ejercicio1() {
		setTitle("Ejercicio 1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 54, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(31, 90, 46, 14);
		contentPane.add(lblApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(31, 127, 46, 14);
		contentPane.add(lblTelefono);
		
		JLabel lblFechaNac = new JLabel("Fecha nac.");
		lblFechaNac.setBounds(31, 164, 65, 14);
		contentPane.add(lblFechaNac);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(160, 51, 86, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(160, 87, 86, 20);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(160, 124, 86, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldFechaNac = new JTextField();
		textFieldFechaNac.setBounds(160, 161, 86, 20);
		contentPane.add(textFieldFechaNac);
		textFieldFechaNac.setColumns(10);
		
		lblLosDatosIngresados = new JLabel("Los datos ingresados fueron:");
		lblLosDatosIngresados.setBounds(10, 217, 236, 14);
		contentPane.add(lblLosDatosIngresados);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(10, 242, 414, 14);
		contentPane.add(lblResultado);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean hayCamposVacios = false;
				if(textFieldNombre.getText().isEmpty()) {
					textFieldNombre.setBackground(Color.red);
					hayCamposVacios = true;
				}else{
					textFieldNombre.setBackground(Color.WHITE);
				}
				if(textFieldApellido.getText().isEmpty()) {
					textFieldApellido.setBackground(Color.red);
					hayCamposVacios = true;
				}else {
					textFieldApellido.setBackground(Color.WHITE);
				}
				if(textFieldTelefono.getText().isEmpty()) {
					textFieldTelefono.setBackground(Color.red);
					hayCamposVacios = true;
				}else{
					textFieldTelefono.setBackground(Color.WHITE);
				}
				if(textFieldFechaNac.getText().isEmpty()) {
					textFieldFechaNac.setBackground(Color.red);
					hayCamposVacios = true;
				}else{
					textFieldFechaNac.setBackground(Color.WHITE);
				}
				if(hayCamposVacios) {
					lblResultado.setText("Complete todos los campos");
					return;
				}
				lblResultado.setText( textFieldNombre.getText() + " " + textFieldApellido.getText() + " " + textFieldTelefono.getText() + " " + textFieldFechaNac.getText());
			}
		});
		btnMostrar.setBounds(251, 191, 89, 23);
		contentPane.add(btnMostrar);
		
		
	}
}

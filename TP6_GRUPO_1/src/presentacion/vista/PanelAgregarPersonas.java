package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class PanelAgregarPersonas extends JPanel {
	private JTextField tfNombre;
	private JTextField tfDni;
	private JTextField tfApellido;
	private JButton btnAceptar;

	/**
	 * Create the panel.
	 */
	public PanelAgregarPersonas() {
		setLayout(null);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(191, 74, 161, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(62, 77, 46, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(62, 130, 46, 14);
		add(lblApellido);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setBounds(62, 185, 46, 14);
		add(lblDni);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(62, 232, 89, 23);
		add(btnAceptar);
		
		tfDni = new JTextField();
		tfDni.setBounds(191, 182, 161, 20);
		add(tfDni);
		tfDni.setColumns(10);
		
		tfApellido = new JTextField();
		tfApellido.setBounds(191, 127, 161, 20);
		add(tfApellido);
		tfApellido.setColumns(10);

	}

	public JTextField getTfNombre() {
		return tfNombre;
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public JTextField getTfDni() {
		return tfDni;
	}

	public void setTfDni(JTextField tfDni) {
		this.tfDni = tfDni;
	}

	public JTextField getTfApellido() {
		return tfApellido;
	}

	public void setTfApellido(JTextField tfApellido) {
		this.tfApellido = tfApellido;
	}

	public JButton getBtnAceptar() {
		return btnAceptar;
	}

	public void setBtnAceptar(JButton btnAceptar) {
		this.btnAceptar = btnAceptar;
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
}

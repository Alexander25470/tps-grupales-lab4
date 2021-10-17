package presentacion.vista;

import javax.swing.JPanel;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelModificarPersonas extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;

	/**
	 * Create the panel.
	 */
	public PanelModificarPersonas() {
		setLayout(null);
		
		List list = new List();
		list.setBounds(38, 34, 380, 181);
		add(list);
		
		JLabel lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccioneLaPersona.setBounds(38, 14, 380, 14);
		add(lblSeleccioneLaPersona);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(38, 221, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(134, 221, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(230, 221, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(329, 221, 89, 23);
		add(btnModificar);

	}

}

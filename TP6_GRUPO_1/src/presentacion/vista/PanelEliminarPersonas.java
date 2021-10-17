package presentacion.vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.ScrollPane;
import java.awt.List;
import java.awt.Button;

public class PanelEliminarPersonas extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelEliminarPersonas() {
		setLayout(null);
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setBounds(168, 37, 117, 14);
		add(lblEliminarUsuarios);
		
		List list = new List();
		list.setBounds(126, 57, 176, 188);
		add(list);
		
		Button btnEliminar = new Button("Eliminar");
		btnEliminar.setBounds(126, 251, 176, 22);
		add(btnEliminar);

	}
}

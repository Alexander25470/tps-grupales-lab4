package presentacion.vista;

import javax.swing.JPanel;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.List;
import java.awt.Button;

public class PanelEliminarPersonas extends JPanel {
	private static DefaultListModel<Persona> listModel;
	private JList<Persona> list;
	Button btnEliminar;
	/**
	 * Create the panel.
	 */
	public PanelEliminarPersonas() {
		setLayout(null);
		listModel = new DefaultListModel<Persona>();
		
		JLabel lblEliminarUsuarios = new JLabel("Eliminar usuarios");
		lblEliminarUsuarios.setBounds(168, 37, 117, 14);
		add(lblEliminarUsuarios);
		
		list = new JList<Persona>();
		list.setBounds(89, 57, 263, 188);
		add(list);
		
		btnEliminar = new Button("Eliminar");
		btnEliminar.setBounds(126, 251, 176, 22);
		add(btnEliminar);

	}
	
	public void cargarLista(ArrayList<Persona> personas) {
		listModel.clear();
		for(Persona p:personas){
			listModel.addElement(p);
		}
		list.setModel(listModel);
	}
	
	
	
	public JList<Persona> getList() {
		return list;
	}

	public void setList(JList<Persona> list) {
		this.list = list;
	}

	public Button getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(Button btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}
}

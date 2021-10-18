package presentacion.vista;

import javax.swing.JPanel;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import entidad.Persona;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelModificarPersonas extends JPanel {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private static DefaultListModel<Persona> listModel;
	private JList<Persona> list;
	private JButton btnModificar;

	/**
	 * Create the panel.
	 */
	public PanelModificarPersonas() {
		setLayout(null);
		listModel = new DefaultListModel<Persona>();
		
		
		JLabel lblSeleccioneLaPersona = new JLabel("Seleccione la persona que desea modificar");
		lblSeleccioneLaPersona.setBounds(38, 14, 380, 14);
		add(lblSeleccioneLaPersona);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if( !  (Character.isLetter(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_SPACE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE )  ) {
					evt.consume();
			        javax.swing.JOptionPane.showMessageDialog(null, "Ingrese solo letras.");
				}
			}
		});
		txtNombre.setBounds(38, 221, 86, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				if( !  (Character.isLetter(evt.getKeyChar()) || evt.getKeyChar() == KeyEvent.VK_SPACE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE )  ) {
					evt.consume();
			        javax.swing.JOptionPane.showMessageDialog(null, "Ingrese solo letras.");
				}
			}
		});
		txtApellido.setBounds(134, 221, 86, 20);
		add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setEditable(false);
		txtDni.setBounds(230, 221, 86, 20);
		add(txtDni);
		txtDni.setColumns(10);
		
		list = new JList<Persona>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()){
					if(list.getSelectedValue()!=null) {						
						Persona selected = list.getSelectedValue();
						txtNombre.setText(selected.getNombre());
						txtApellido.setText(selected.getApellido());
						txtDni.setText(selected.getDni());
					}
		        }
			}
		});
		list.setBounds(38, 34, 380, 181);
		add(list);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(329, 221, 89, 23);
		add(btnModificar);

	}
	
	public void cargarLista(ArrayList<Persona> personas) {
		listModel.clear();
		for(Persona p:personas){
			listModel.addElement(p);
		}
		list.setModel(listModel);
	}
	
	public void mostrarMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JList<Persona> getList() {
		return list;
	}

	public void setList(JList<Persona> list) {
		this.list = list;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

}

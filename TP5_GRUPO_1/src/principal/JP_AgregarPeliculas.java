package principal;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JP_AgregarPeliculas extends JPanel {
	private JTextField TF_Nombre;
	private static DefaultListModel<Peliculas> listModel;
	/**
	 * Create the panel.
	 */
	public JP_AgregarPeliculas(DefaultListModel<Peliculas> LM_Peliculas) {
		listModel = LM_Peliculas;
		setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(43, 35, 46, 14);
		add(lblId);
		
		JLabel lblIdIngresar = new JLabel(""+Peliculas.cont);
		lblIdIngresar.setBounds(247, 35, 46, 14);
		add(lblIdIngresar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(43, 82, 46, 14);
		add(lblNombre);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(43, 132, 46, 14);
		add(lblGenero);
		
		TF_Nombre = new JTextField();
		TF_Nombre.setBounds(206, 79, 135, 20);
		add(TF_Nombre);
		TF_Nombre.setColumns(10);
		
		JComboBox<Genero> CB_Nombre = new JComboBox<Genero>();
		CB_Nombre.addItem(new Genero(1, "Seleccione un genero"));
		CB_Nombre.addItem(new Genero(2, "Terror"));
		CB_Nombre.addItem(new Genero(3, "Accion"));
		CB_Nombre.addItem(new Genero(4, "Suspenso"));
		CB_Nombre.addItem(new Genero(5, "Romantica"));
		CB_Nombre.setBounds(206, 129, 135, 20);
		add(CB_Nombre);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = TF_Nombre.getText();
				Genero genero = (Genero) CB_Nombre.getSelectedItem();
				if(nombre.isEmpty())
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Ingrese un nombre.");
				} else if (genero.id==1)
				{
					javax.swing.JOptionPane.showMessageDialog(null, "Seleccione un genero.");
				} else
				{					
					Peliculas pel = new Peliculas(nombre, genero);
					listModel.addElement(pel);
					lblIdIngresar.setText(""+Peliculas.cont);
				}
			}
		});
		btnAceptar.setBounds(43, 177, 89, 23);
		add(btnAceptar);

	}
}

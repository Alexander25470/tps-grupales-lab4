package principal;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JP_ListarPeliculas extends JPanel {

	/**
	 * Create the panel.
	 */
	private static DefaultListModel<Peliculas> listModel;
	
	public JP_ListarPeliculas() {
		setLayout(null);
		listModel = new DefaultListModel<Peliculas>();
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setBounds(43, 131, 58, 14);
		add(lblPeliculas);
		
		JList list = new JList();
		list.setModel(listModel);
		list.setBounds(121, 11, 319, 278);
		add(list);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Genero gen= new Genero("genero 1");
				Peliculas pel = new Peliculas("pelicula 1", gen);
				listModel.addElement(pel);
			}
		});
		btnNewButton.setBounds(12, 205, 89, 23);
		add(btnNewButton);

	}
}

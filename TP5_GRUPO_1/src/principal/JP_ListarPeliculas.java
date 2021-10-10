package principal;

import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

public class JP_ListarPeliculas extends JPanel {

	/**
	 * Create the panel.
	 */
	private static DefaultListModel<Peliculas> listModel;
	private static TreeSet<Peliculas> peliculas;
	
	public JP_ListarPeliculas(DefaultListModel<Peliculas> LM_Peliculas) {
		setLayout(null);
		listModel = LM_Peliculas;
		orderJlist();
		
		JLabel lblPeliculas = new JLabel("Peliculas");
		lblPeliculas.setBounds(43, 131, 58, 14);
		add(lblPeliculas);
		
		JList<Peliculas> list = new JList<Peliculas>();
		list.setModel(listModel);
		list.setBounds(121, 11, 319, 278);
		add(list);	
	}
	private void orderJlist(){
		ArrayList<Peliculas> list = Collections.list(listModel.elements());
		Collections.sort(list, new ComparadorPeliculas());
		listModel.clear();
		for(Peliculas o:list){
			listModel.addElement(o);
		}
	}
	
}

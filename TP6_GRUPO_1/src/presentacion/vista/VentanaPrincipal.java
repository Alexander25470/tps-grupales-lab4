package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import javax.swing.JLabel;

public class VentanaPrincipal extends JFrame {

	private JMenuBar menuBar;
	private JMenu mnPersonas;
	private JMenuItem mntmMenuEliminar;
	private JMenuItem mntmMenuAgregar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnPersonas = new JMenu("Personas");
		menuBar.add(mnPersonas);
		
		mntmMenuAgregar = new JMenuItem("Agregar");
		mnPersonas.add(mntmMenuAgregar);
		
		mntmModificar = new JMenuItem("Modificar");
		mnPersonas.add(mntmModificar);
		
		mntmMenuEliminar = new JMenuItem("Eliminar");
		mnPersonas.add(mntmMenuEliminar);
		
		mntmListar = new JMenuItem("Listar");
		mnPersonas.add(mntmListar);
	}

	public JMenuItem getMntmMenuEliminar() {
		return mntmMenuEliminar;
	}

	public void setMntmMenuEliminar(JMenuItem mntmMenuEliminar) {
		this.mntmMenuEliminar = mntmMenuEliminar;
	}

	public JMenuItem getMntmMenuAgregar() {
		return mntmMenuAgregar;
	}

	public void setMntmMenuAgregar(JMenuItem mntmMenuAgregar) {
		this.mntmMenuAgregar = mntmMenuAgregar;
	}

	public JMenuItem getMntmModificar() {
		return mntmModificar;
	}

	public void setMntmModificar(JMenuItem mntmModificar) {
		this.mntmModificar = mntmModificar;
	}

	public JMenuItem getMntmListar() {
		return mntmListar;
	}

	public void setMntmListar(JMenuItem mntmListar) {
		this.mntmListar = mntmListar;
	}

	
}

package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import presentacion.vista.VentanaPrincipal;
import presentacion.vista.PanelAgregarPersonas;
import presentacion.vista.PanelEliminarPersonas;
import presentacion.vista.PanelListarPersonas;
import presentacion.vista.PanelModificarPersonas;


public class Controlador implements ActionListener {

	private VentanaPrincipal ventanaPrincipal;
	private PersonaNegocio pNeg;
	private ArrayList<Persona> personasEnTabla;
	private PanelAgregarPersonas panelAgregarPersonas = new PanelAgregarPersonas();
	private PanelModificarPersonas panelModificarPersonas= new PanelModificarPersonas();
	private PanelListarPersonas panelListarPersonas = new PanelListarPersonas();
	private PanelEliminarPersonas panelEliminarPersonas = new PanelEliminarPersonas();
	
	
	//Constructor
	public Controlador(VentanaPrincipal vista, PersonaNegocio pNeg)
	{
		ventanaPrincipal = vista;
		
		ventanaPrincipal.getMntmMenuAgregar()
		.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.getContentPane().removeAll();
				ventanaPrincipal.getContentPane().add(panelAgregarPersonas);
				ventanaPrincipal.getContentPane().repaint();
				ventanaPrincipal.getContentPane().revalidate();
			}
		});

		ventanaPrincipal.getMntmModificar()
		.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.getContentPane().removeAll();
				ventanaPrincipal.getContentPane().add(panelModificarPersonas);
				ventanaPrincipal.getContentPane().repaint();
				ventanaPrincipal.getContentPane().revalidate();
			}
		});
		ventanaPrincipal.getMntmListar()
		.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelListarPersonas.cargarTabla(pNeg.readAll());
				ventanaPrincipal.getContentPane().removeAll();
				ventanaPrincipal.getContentPane().add(panelListarPersonas);
				ventanaPrincipal.getContentPane().repaint();
				ventanaPrincipal.getContentPane().revalidate();
			}
		});
		ventanaPrincipal.getMntmMenuEliminar()
		.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.getContentPane().removeAll();
				ventanaPrincipal.getContentPane().add(panelEliminarPersonas);
				ventanaPrincipal.getContentPane().repaint();
				ventanaPrincipal.getContentPane().revalidate();
			}
		});
		
	}
	

	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

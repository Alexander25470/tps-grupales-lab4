package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

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
		this.pNeg = pNeg;
		ventanaPrincipal = vista;
		panelEliminarPersonas = new PanelEliminarPersonas();
		
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
				panelModificarPersonas.cargarLista(pNeg.readAll());
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
				panelEliminarPersonas.cargarLista(pNeg.readAll());
				ventanaPrincipal.getContentPane().add(panelEliminarPersonas);
				ventanaPrincipal.getContentPane().repaint();
				ventanaPrincipal.getContentPane().revalidate();
			}
		});
		
		panelAgregarPersonas.getBtnAceptar()
		.addActionListener(a->EventoClickBoton_AgregarPesona_PanelAgregarPersonas(a));
		
		panelEliminarPersonas.getBtnEliminar()
		.addActionListener(a->EventoClickBoton_BorrarPesona_PanelEliminarPersonas(a));
		
		panelModificarPersonas.getBtnModificar()
		.addActionListener(a->EventoClickBoton_ModificarPesona_PanelModificarPersonas(a));
		
	}
	

	
	public void inicializar()
	{
		this.ventanaPrincipal.setVisible(true);
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void EventoClickBoton_AgregarPesona_PanelAgregarPersonas(ActionEvent a) {
		
		String nombre = panelAgregarPersonas.getTfNombre().getText();
		String apellido = panelAgregarPersonas.getTfApellido().getText();
		String dni = panelAgregarPersonas.getTfDni().getText();
		Persona nuevaPersona = new Persona(nombre, apellido, dni);
		
		boolean estado = pNeg.insert(nuevaPersona);
		String mensaje;
		if(estado==true)
		{
			mensaje="Persona agregada con exito";
			panelAgregarPersonas.getTfNombre().setText("");
			panelAgregarPersonas.getTfApellido().setText("");
			panelAgregarPersonas.getTfDni().setText("");
		}
		else
			mensaje="Persona no agregada, complete todos los campos";
		
		panelAgregarPersonas.mostrarMensaje(mensaje);
	
	}
	
	public void EventoClickBoton_BorrarPesona_PanelEliminarPersonas(ActionEvent s)
	{
		boolean estado=false; 
		List<Persona> filasSeleccionadas = panelEliminarPersonas.getList().getSelectedValuesList();
		for (Persona fila : filasSeleccionadas)
		{
			estado = pNeg.delete(fila);
			if(estado==true)
			{
				String mensaje="Persona eliminada con exito";
				this.panelEliminarPersonas.mostrarMensaje(mensaje);
			}
		}
		panelEliminarPersonas.cargarLista(pNeg.readAll());
	}
	
	public void EventoClickBoton_ModificarPesona_PanelModificarPersonas(ActionEvent s)
	{
		boolean estado=false; 
		String nombre = panelModificarPersonas.getTxtNombre().getText();
		String apellido = panelModificarPersonas.getTxtApellido().getText();
		String dni = panelModificarPersonas.getTxtDni().getText();
		Persona persona = new Persona(nombre, apellido, dni);
		estado = pNeg.update(persona);
		if(estado==true)
		{
			String mensaje="Persona modificada con exito";
			this.panelEliminarPersonas.mostrarMensaje(mensaje);
		}
		panelModificarPersonas.cargarLista(pNeg.readAll());
	}
	
}

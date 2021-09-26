package Menu;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_horasEnPc;
	private ButtonGroup grupoBotones;

	/**
	 * Create the frame.
	 */
	public Ejercicio3() {
		grupoBotones = new ButtonGroup();
		setTitle("Ejercicio 3");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(23, 11, 401, 39);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblElijaUnSistema = new JLabel("Elija un sistema operativo:");
		lblElijaUnSistema.setBounds(10, 11, 164, 14);
		panel.add(lblElijaUnSistema);
		
		JRadioButton rdbtnWindows = new JRadioButton("Windows");
		rdbtnWindows.setBounds(180, 7, 84, 23);
		panel.add(rdbtnWindows);
		grupoBotones.add(rdbtnWindows);
		
		JRadioButton rdbtnMac = new JRadioButton("Mac");
		rdbtnMac.setBounds(266, 7, 60, 23);
		grupoBotones.add(rdbtnMac);
		panel.add(rdbtnMac);
		
		JRadioButton rdbtnLinux = new JRadioButton("Linux");
		rdbtnLinux.setBounds(328, 7, 67, 23);
		grupoBotones.add(rdbtnLinux);
		panel.add(rdbtnLinux);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(23, 62, 401, 95);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblElijaUnaEspecialidad = new JLabel("Elija una especialidad:");
		lblElijaUnaEspecialidad.setBounds(10, 42, 116, 14);
		panel_1.add(lblElijaUnaEspecialidad);
		
		JCheckBox chckbxProgramacin = new JCheckBox("Programaci\u00F3n");
		chckbxProgramacin.setBounds(248, 12, 128, 23);
		panel_1.add(chckbxProgramacin);
		
		JCheckBox chckbxAdministracin = new JCheckBox("Administraci\u00F3n");
		chckbxAdministracin.setBounds(248, 38, 128, 23);
		panel_1.add(chckbxAdministracin);
		
		JCheckBox chckbxDiseoGrafico = new JCheckBox("Dise\u00F1o grafico");
		chckbxDiseoGrafico.setBounds(248, 64, 128, 23);
		panel_1.add(chckbxDiseoGrafico);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas en el computador:");
		lblCantidadDeHoras.setBounds(23, 168, 190, 14);
		contentPane.add(lblCantidadDeHoras);
		
		textField_horasEnPc = new JTextField();
		textField_horasEnPc.setBounds(259, 165, 86, 20);
		contentPane.add(textField_horasEnPc);
		textField_horasEnPc.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sistema = "";
				String especialidades = "";
				String horas = "";
				if(rdbtnWindows.isSelected()) {
					sistema="Windows - ";
				}else if(rdbtnMac.isSelected()) {
					sistema="Mac - ";
				} else if(rdbtnLinux.isSelected()) {
					sistema="Linux - ";
				} else {
					JOptionPane.showMessageDialog(null, "Seleccione un sistema" );
					return;
				}
				if(chckbxAdministracin.isSelected()) {
					especialidades+="Administración - ";
				}
				if(chckbxProgramacin.isSelected()) {
					especialidades+="Programación - ";
				}
				if(chckbxDiseoGrafico.isSelected()) {
					especialidades+="Diseño grafico - ";
				}
				if(especialidades=="") {
					JOptionPane.showMessageDialog(null, "Seleccione al menos una especialidad" );
					return;
				}
				if(textField_horasEnPc.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ingrese un numero de horas" );
					return;
				} else {					
					horas = textField_horasEnPc.getText() + " hs";
				}
				JOptionPane.showMessageDialog(null, sistema + especialidades + horas  );
			}
		});
		btnAceptar.setBounds(320, 227, 89, 23);
		contentPane.add(btnAceptar);
	}
}

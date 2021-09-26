package Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.Box;
import java.awt.Panel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_nota1;
	private JTextField textField_nota2;
	private JTextField textField_nota3;
	private JTextField textField_promedio;
	private JTextField textField_Condicion;

	/**
	 * Create the frame.
	 */
	public Ejercicio2() {
		setTitle("Ejercicio 2");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		 
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 11, 210, 140);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNota = new JLabel("Nota 1:");
		lblNota.setBounds(10, 23, 46, 14);
		panel.add(lblNota);
		
		JLabel lblNota_1 = new JLabel("Nota 2:");
		lblNota_1.setBounds(10, 48, 46, 14);
		panel.add(lblNota_1);
		
		JLabel lblNota_2 = new JLabel("Nota 3:");
		lblNota_2.setBounds(10, 73, 46, 14);
		panel.add(lblNota_2);
		
		JLabel lblTps = new JLabel("TPS");
		lblTps.setBounds(10, 98, 46, 14);
		panel.add(lblTps);
		
		textField_nota1 = new JTextField();
		textField_nota1.setBounds(102, 20, 98, 20);
		panel.add(textField_nota1);
		textField_nota1.setColumns(10);
		
		textField_nota2 = new JTextField();
		textField_nota2.setBounds(102, 45, 98, 20);
		panel.add(textField_nota2);
		textField_nota2.setColumns(10);
		
		textField_nota3 = new JTextField();
		textField_nota3.setBounds(102, 70, 98, 20);
		panel.add(textField_nota3);
		textField_nota3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(102, 95, 98, 20);
		comboBox.addItem("Aprobado");
		comboBox.addItem("Desaprobado");
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(34, 162, 210, 88);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setBounds(10, 31, 60, 14);
		panel_1.add(lblPromedio);
		
		JLabel lblCondicion = new JLabel("Condicion:");
		lblCondicion.setBounds(10, 56, 60, 14);
		panel_1.add(lblCondicion);
		
		textField_promedio = new JTextField();
		textField_promedio.setBounds(102, 28, 98, 20);
		panel_1.add(textField_promedio);
		textField_promedio.setColumns(10);
		
		textField_Condicion = new JTextField();
		textField_Condicion.setBounds(102, 53, 98, 20);
		panel_1.add(textField_Condicion);
		textField_Condicion.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float nota1,nota2,nota3;
				
				try {
					nota1 = Float.parseFloat(textField_nota1.getText());
					nota2 = Float.parseFloat(textField_nota2.getText());
					nota3 = Float.parseFloat(textField_nota3.getText());
				} catch (Exception e) {
					System.out.println("Complete los datos correctamente.");
					JOptionPane.showMessageDialog(null, "Complete los datos correctamente.");
					return;
				}
				
			
				float promedio = (nota1 + nota2 + nota3 ) /3;
				String notaTps = comboBox.getSelectedItem().toString();
				
				textField_promedio.setText(promedio+"");
				
				if(notaTps == "Desaprobado") {
					textField_Condicion.setText("Libre");
				}else if(nota1<6 || nota2<6 || nota3<6){
					textField_Condicion.setText("Libre");
				}else if (nota1>=8 && nota2>=8 && nota3>=8) {
					textField_Condicion.setText("Promocionado");
				} else {
					textField_Condicion.setText("Regular");
				}
			}
		});
		btnCalcular.setBounds(302, 56, 89, 23);
		contentPane.add(btnCalcular);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_nota1.setText("");
				textField_nota2.setText("");
				textField_nota3.setText("");
				textField_promedio.setText("");
				textField_Condicion.setText("");
				comboBox.setSelectedIndex(0);
			}
		});
		btnNuevo.setBounds(302, 90, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(302, 124, 89, 23);
		contentPane.add(btnSalir);
	}
}

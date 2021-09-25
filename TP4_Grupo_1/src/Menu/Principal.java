package Menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ejercicio 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejercicio1 ej1 = new Ejercicio1();
				ej1.setVisible(true);
			}
		});
		btnNewButton.setBounds(158, 101, 123, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ejercicio 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejercicio2 ej2 = new Ejercicio2();
				ej2.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(158, 135, 123, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Ejercicio 3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejercicio3 ej3 = new Ejercicio3();
				ej3.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(158, 169, 123, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Grupo numero: 1");
		lblNewLabel.setBounds(57, 56, 123, 14);
		contentPane.add(lblNewLabel);
	}
}

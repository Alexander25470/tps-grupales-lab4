package Menu;
import javax.swing.JFrame;
import javax.swing.JButton;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		JButton button = new JButton();
		button.setText("boton");
		button.setBounds(200,200,140,30);
		frame.getContentPane().add(button);
		frame.setVisible(true);
	}

}

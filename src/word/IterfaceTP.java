package word;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class IterfaceTP extends JFrame {
	
	/**A InterfaceTP nada mais é do que a tela principal do nosso sistema, para saber mais sobre nosso 
	 * sistema veja nosso arquivo read-me*/
	public IterfaceTP() {
		super("Aby");
		setSize(500,500);
		setLocationRelativeTo(null);
		add(new WordPanel());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
	
		new IterfaceTP();

	}

}

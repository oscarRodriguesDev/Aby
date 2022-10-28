package word;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import elementos.Comida;
import elementos.Elementor;
import elementos.Gerador;

@SuppressWarnings("serial")
public class WordPanel extends JPanel {
/**Classe responsavel por gerar todas as interações graficas do programa
 * @author oskha
 * */
	boolean comeu = false;
	Random r = new Random();
	Elementor e1;
	Graphics g;
	Image fundo;
	ImageIcon word = new ImageIcon("res/fundo word.png");
	Gerador gerador = new Gerador(250, 250);

	// todos os elementos vao estar dentro dessa lista
	List<Elementor> bios = new ArrayList<Elementor>();
	Comida comida;
	Eco eco;
	int contador = 0;

	/**Construtor será responsavel por iniciliazar o fundo da tela
	 * inicializar a lista de Elementors
	 * o construtor tambem lança uma nova Thread que inicializa o Gerador de comida
	 */
	public WordPanel() {

		// criando o primeiro bichinho a posição incia de cada um dos nosso bichinhos
		// deve ser randomica
		fundo = word.getImage();
		bios.add(new Elementor(r.nextInt(450), r.nextInt(450), 1, 1, 450));
		eco = new Eco();
		eco.start();

	}


	/**metodo responsavel por desenhar todos os elementos na tela*/
	public void paint(Graphics g) {

		this.g = g;

		// pintura do fundo
		g.drawImage(fundo, 0, -38, this);

		// verificando a densidade populacional
		g.setColor(Color.WHITE);
		int individuos = bios.size();
		String qtd = String.valueOf(individuos);
		g.setFont(new Font("Comic Sans", Font.BOLD, 14));
		g.drawString(qtd, 10, 10);

		// pintura da comida
		g.setColor(Color.GREEN);

		g.fillOval(comida.getX(), comida.getY(), comida.getTamanhox(), comida.getTamanhoy());

		// pintura do gerador
		g.drawImage(gerador.getImagem(), Gerador.X, Gerador.Y, gerador.getTamanhox(), gerador.getTamanhoy(), this);

		// animação da comida
		try {
			Thread.sleep(10);
			if (comida.getY() <= 200) {
				comida.setY(200);
				comida.mover(comida.getX(), comida.getY());
			} else {
				comida.setY(comida.getY() - 5);
			}
			if (comida.getTamanhox() == 20) {
				comida.setTamanhox(20);
				comida.setTamanhoy(20);
			} else {
				comida.setTamanhox(comida.getTamanhox() + 1);
				comida.setTamanhoy(comida.getTamanhoy() + 1);
			}
		} catch (InterruptedException e1) {

		}

		repaint();

		// pintando o Elementor na tela
		for (Elementor e : bios) {
			g.drawImage(e.getImagem(), e.getX(), e.getY(), e.getTamanhox(), e.getTamanhoy(), this);
			e.mover(e.getX(), e.getY());
			limite(e, comida);
			e.mover(e.getX(), e.getY());
			this.setDoubleBuffered(false);
			g.setFont(new Font("Arial", Font.PLAIN, 10));
			g.setColor(Color.WHITE);
			g.drawString("" + e.getTamanhox(), e.getX() + 6, e.getY() + 8);

			// chgecagem de colisão
			if (e.getBounds().intersects(comida.getBounds()) && comida.getY() <= 200) {
				contador++;
				comeu = true;
				comeu = false;
				comida.setY(420);
				comida.setX(230);
			
				e.crescer(1);

			}
			if (e.isReproduzindo()) {
			

				bios.add(new Elementor(r.nextInt(450), r.nextInt(450), 5, 5, 450));
				bios.add(new Elementor(r.nextInt(450), r.nextInt(450), 5, 5, 450));
				

				e.setReproduzindo(false);
			}
			if (e.isMorreu()) {
				bios.remove(e);
			}

			repaint();
		}

	}

	/**Metodo responsavel por definir o limite de movimentação na tela
	 * @author oskha
	 * @param e 
	 * se refere ao elementor pai, o primeiro a ser gerado no ambiente
	 * @param c
	 * refere-se a comida que esta sendo gerada pelo Gerador*/
	public void limite(Elementor e, Comida c) {
		// verificando se os elementos ultrapassam o limite da tela
		if (e.getX() > 450) {
			e.setX(0);
		}
		if (e.getY() > 450) {
			e.setY(0);
		}
		if (e.getX() < 0) {
			e.setX(450);
		}
		if (e.getY() < 0) {
			e.setY(450);
		}
		// limitação do movimento da comida

		if (c.getX() > 450) {
			c.setX(0);
		}

		if (c.getX() < 0) {
			c.setX(450);
		}

	}

	/**Classe responsavel por inicializar o Gerador e criar a primeira comida
	 * Essa classe vai rodar em uma  Thread distinta*/
	public class Eco extends Thread {

		public void run() {

			comida = gerador.produzir_comida();

		}
	}
}

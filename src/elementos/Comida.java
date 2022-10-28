package elementos;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.Random;

public class Comida {

	private int x;
	private int y;
	private int tamanhox;
	private int tamanhoy;
	Random randon = new Random();

	/* metodos get and sets */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTamanhox() {
		return tamanhox;
	}

	public void setTamanhox(int tamanhox) {
		this.tamanhox = tamanhox;
	}

	public int getTamanhoy() {
		return tamanhoy;
	}

	public void setTamanhoy(int tamanhoy) {
		this.tamanhoy = tamanhoy;
	}

	/* Rectangle para colisoes */
	public Rectangle getBounds() {
		return new Rectangle(x, y, tamanhox, tamanhoy);
	}

	/* construtor e metodos do objeto */

	/**
	 * Construtor do Elementor:
	 * 
	 * @author oskha
	 * @param x        refere-se a posição inicial x do Elementor
	 * @param y        refere-se a posição inicial y do Elementor
	 * @param tamanhox refere-se a largura do elementor
	 * @param tamanhoy refere-se a altura do Elementor
	 * @param wordSize limite do mundo onde o Elementor se encontra
	 * 
	 *                 <i>Basicamente esse objeto representa um ser vivo digital,
	 *                 capaz de se mover sozinho, comer, reproduzir podendo estamos
	 *                 aqui tratando da primeira versão desse micro ser</i>
	 */
	public Comida(int x, int y, int tamanhox, int tamanhoy, int wordSize) {
		this.x = x;
		this.y = y;
		this.tamanhox = tamanhox;
		this.tamanhoy = tamanhoy;

	}

	// movimento da comida
	public void mover(int x, int y) {
		
		int vel =  50;
		x+=vel;
		y =  vel+randon.nextInt(200);
		setX(x);
		//setY(y);
		
	
		}
		
	public Color sortColor() {
		return new Color(randon.nextInt(255),randon.nextInt(255),randon.nextInt(255));
	}
}

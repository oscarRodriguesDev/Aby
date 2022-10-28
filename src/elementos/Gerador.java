package elementos;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Gerador {
	
	public static final int X = 120;
	public static final int Y = 210
			;
	private int tamanhox;
	private int tamanhoy;
	private Image imagem;

	ImageIcon ger =  new ImageIcon("res/generator food.png");

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
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


	/*construtor e metodos do objeto*/

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
	public Gerador(int tamanhox, int tamanhoy) {
		
		this.tamanhox = tamanhox;
		this.tamanhoy = tamanhoy;
		setImagem(ger.getImage());

	}
	
	/**Metodo resposavel por gerar a comida do ambiente
	 * @return comida
	 * 
	 * */
	public Comida produzir_comida() {
		Comida comida = new Comida(230,420, 1, 1, X);
		return comida;
	}

	

}

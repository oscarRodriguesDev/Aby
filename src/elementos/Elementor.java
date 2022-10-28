package elementos;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Elementor {
	protected  ImageIcon icone = new ImageIcon("res/microbe_baby.png");
	protected Random randon = new Random();
	private int x;
	private int y;
	private int tamanhox;
	private int tamanhoy;
	private int velocidade;
	private Image imagem;
	boolean reproduzindo = false;
	boolean morreu = false;
	int contador = 0;

	public boolean isMorreu() {
		return morreu;
	}

	public void setMorreu(boolean morreu) {
		this.morreu = morreu;
	}

	public boolean isReproduzindo() {
		return reproduzindo;
	}

	public void setReproduzindo(boolean reproduzindo) {
		this.reproduzindo = reproduzindo;
	}

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

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public Image getImagem() {
		return imagem;
	}

	public void setImagem(Image imagem) {
		this.imagem = imagem;
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
	public Elementor(int x, int y, int tamanhox, int tamanhoy, int wordSize) {

		// definindo a imagem do objeto
		imagem = icone.getImage();
		// variveis do objeto
		this.x = x;
		this.y = y;
		this.tamanhox = tamanhox;
		this.tamanhoy = tamanhoy;

	}

	/**
	 * Metodo que permite o movimento do elemento pela tela
	 * 
	 * @author oskha
	 * @param x     refere-se a posição x do elemento que será alterada
	 * @param y     refere-se a posição y do elemento que será alterada
	 * @param vel_x refere-se a velocidade x que o elemento irá se mover
	 * @param vel_y refere-se a velocidade y que o elemento irá se mover
	 */
	public void mover(int x, int y) {
		int vel_x = 10;
		int vel_y = 10;
		try {
			Thread.sleep(20);

			boolean destiny = randon.nextBoolean();
			boolean destinx = randon.nextBoolean();
			boolean vontade = randon.nextBoolean();
			boolean acaso = randon.nextBoolean();

			if (acaso) {
				y += randon.nextInt(vel_y);
			} else {
				y--;
			}

			if (destinx && vontade) {
				x += randon.nextInt(vel_x);// valor randomico para velocidade no x
			} else if (destinx && !vontade) {
				vel_x = 0;
			} else {
				x -= randon.nextInt(vel_x);
			}

			if (destinx && vontade) {
				y += randon.nextInt(vel_y);// valor randomico para velocidade no x
			} else if (destiny && !vontade) {
				vel_y = 0;
			} else {
				y -= randon.nextInt(vel_y);
			}

			/* so vai se mover caso o elemento decida que quer fazer o tal movimento */
			boolean decisaox = randon.nextBoolean();
			boolean decisaoy = randon.nextBoolean();
			if (decisaox) {
				this.setX(x);
			}
			if (decisaoy) {
				this.setY(y);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**Metodo permite o crescimento do Elementor
	 * @author oskha
	 * @param fator 
	 * se refere ao valor que será incrementado ao tamanho do Elementor toda vez que ele crescer
	 *  O metodo tambem irá alterar a imagem representativa do Elementor em determinadas fases da vida dele
	 * */
	public void crescer(int fator) {
		setTamanhox(getTamanhox() + fator);
		setTamanhoy(getTamanhoy() + fator);

		// valores apenas para testes, ele deve ter uma baixa taxa de crescimento
		int t= getTamanhox();
	
		if(t>5&&t<15) {
			icone = new ImageIcon("res/microbe_midian.png");
			imagem = icone.getImage();
		}
		
		if(t>15&&t<25) {
			icone = new ImageIcon("res/microbe.png");
			imagem = icone.getImage();
		}

		if (getTamanhox() == 30 || getTamanhoy() == 30) {
			System.out.println("hora de reproduzir");
			// vamos reproduzir com 25 depois vamos dificultar a reprodução
			reproduzir();
			setTamanhox(40);
			setTamanhoy(40);
			System.out.println("microbe de " + this.getTamanhox()+ " acaba de morrer");
			morrer();

		} 
	}

	/**Metodo  permite que o Elementor se reproduza
	 * @author oskha*/
	public void reproduzir() {

		setReproduzindo(true);

	}

	/**Metodo define quando o Elementor vai morrer*/
	public void morrer() {

		if (getTamanhox() >= 30) {
			setY(-1000);
			morreu = true;
		}
	}
}

package shokoban.niveaux;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JPanel;

public class Accueil extends Panneau {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posBallX = -65;
	private int posBallY = 520;
	private int posFlecheX = 210;
	private int posFlecheY = 330;
	private String path = "src//img//";
	private String entrer = "";
	private String continuer = "";
	private String img = "stop.png";
	private String fleche = "flecheO.jpg";

	private int[][] posBloc = {{290,490}};
	
	


	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		try {
			g.drawImage(ImageIO.read(new File(path+img)), this.posBallX, this.posBallY, 60, 60, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int[] pos : posBloc) {
				try {
					g.drawImage(ImageIO.read(new File(path+"caisse.png")), pos[0], pos[1], 90, 90, this);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		try {
			g.drawImage(ImageIO.read(new File(path+fleche)), this.posFlecheX, this.posFlecheY, 25, 25, this);
		} catch (IOException e) {
		}
		try {
			g.drawImage(ImageIO.read(new File(path+"title.png")), 80, 50, 580, 209, this);
		} catch (IOException e) {
		}
		Font font = new Font("Courier",Font.BOLD, 30);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString(entrer, 250, 350);
		g.drawString(continuer, 250, 400);
	}
	
	public String getContinuer() {
		return continuer;
	}

	public void setContinuer(String continuer) {
		this.continuer = continuer;
	}		 

	public String getImg() {
		return img;
	}
	
	
	public void setImg(String img) {
		this.img = img;
	}

	public int getPosBallX() {
		return posBallX;
	}

	public void setPosBallX(int posBallX) {
		this.posBallX = posBallX;
	}


	public int getPosBallY() {
		return posBallY;
	}


	public void setPosBallY(int posBallY) {
		this.posBallY = posBallY;
	}


	public int[][] getPosBloc() {
		return posBloc;
	}


	public void setPosBloc(int[][] posBloc) {
		this.posBloc = posBloc;
	}


	public String getEntrer() {
		return entrer;
	}


	public void setEntrer(String entrer) {
		this.entrer = entrer;
	}
	public int getPosFlecheX() {
		return posFlecheX;
	}

	public void setPosFlecheX(int posFlecheX) {
		this.posFlecheX = posFlecheX;
	}

	public int getPosFlecheY() {
		return posFlecheY;
	}

	public void setPosFlecheY(int posFlecheY) {
		this.posFlecheY = posFlecheY;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFleche() {
		return fleche;
	}

	public void setFleche(String fleche) {
		this.fleche = fleche;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Accueil";
	}

}

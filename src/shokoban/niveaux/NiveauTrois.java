package shokoban.niveaux;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class NiveauTrois extends Panneau {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posBallX = 5;
	private int posBallY = 50;
	private int posEndX = 670;
	private int posEndY = 500;
	private String path = "src//img//";
	private String gagner = "";
	private String img = "stop.png";
	private int[][] posBloc = {{100,0,0}};
	
	


	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		try {
			g.drawImage(ImageIO.read(new File(path+"end.png")), this.posEndX, this.posEndY, 40, 40, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			g.drawImage(ImageIO.read(new File(path+img)), this.posBallX, this.posBallY, 40, 40, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int[] pos : posBloc) {
			if(pos[2] == 1)
				try {
					g.drawImage(ImageIO.read(new File(path+"caisse.png")), pos[0], pos[1], 60, 60, this);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				try {
					g.drawImage(ImageIO.read(new File(path+"mur.png")), pos[0], pos[1], 60, 60, this);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		Font font = new Font("Courier",Font.BOLD, 120);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString(gagner, 120, 300);
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


	public int getPosEndX() {
		return posEndX;
	}


	public void setPosEndX(int posEndX) {
		this.posEndX = posEndX;
	}


	public int getPosEndY() {
		return posEndY;
	}


	public void setPosEndY(int posEndY) {
		this.posEndY = posEndY;
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


	public String getGagner() {
		return gagner;
	}


	public void setGagner(String gagner) {
		this.gagner = gagner;
	}
}

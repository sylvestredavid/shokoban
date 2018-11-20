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
import javax.swing.JPanel;

public class NiveauUn extends Panneau {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posBallX = 60;
	private int posBallY = 5;
	private int posEndX = 190;
	private int posEndY = 130;
	private String path = "src//img//";
	private String gagner = "";
	private String img = "stop.png";
	private int[][] posBloc = {{0,0,0},{60,60,0},{120,60,0},{180,60,0},{240,60,0},{360,60,0},{420,0,0},{420,60,0},{300,0,1},{240,120,0},{240,180,0},{180,180,0},{120,180,0},{60,180,0},{60,240,0},{60,300,0},{360,120,0},{360,180,0},{360,240,0},{360,360,0},{480,300,0},{480,240,0},{420,240,0},{420,360,0},{480,360,0},{300,300,1},{240,240,1},{180,300,0},{120,300,0},{180,360,0},{120,360,0},{60,540,0},{180,540,0},{0,480,0},{60,420,1},{240,360,0},{0,120,1},{240,420,0},{180,480,1},{300,480,0},{360,480,0},{420,480,0},{480,480,0},{600,480,0},{660,480,0},{660,360,0},{600,360,0},{540,360,0},{540,420,1},{600,540,0},{420,540,0},{540,540,1},{600,600,0},{660,600,0},{660,540,0},{300,600,1},{360,540,0},{300,540,0},{120,600,0},{120,540,0},{0,540,0},{0,600,0},{60,600,0},{540,300,0},{600,300,0},{660,300,0},{660,240,0},{600,240,0},{540,240,0},{540,180,0},{480,180,0},{420,180,0},{420,120,0},{480,120,0},{540,120,0},{600,120,0},{660,120,0},{660,180,0},{600,180,0},{660,60,0},{660,0,0},{600,0,0},{540,0,0},{480,0,0},{480,60,0},{540,60,0},{600,60,0}};
	
	


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




	public String getPath() {
		return path;
	}




	public void setPath(String path) {
		this.path = path;
	}




	public String getGagner() {
		return gagner;
	}




	public void setGagner(String gagner) {
		this.gagner = gagner;
	}




	public String getImg() {
		return img;
	}




	public void setImg(String img) {
		this.img = img;
	}




	public int[][] getPosBloc() {
		return posBloc;
	}




	public void setPosBloc(int[][] posBloc) {
		this.posBloc = posBloc;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}


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

public class Panneau extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posBallX, posBallY, posEndX, posEndY = 0;
	private String path, gagner, img = "";
	private int[][] posBloc = {{0,0,0}};
	
	


	public void paintComponent(Graphics g) {
		
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

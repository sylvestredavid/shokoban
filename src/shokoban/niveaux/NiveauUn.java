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
	private int posBallX = 220;
	private int posBallY = 5;
	private int posEndX = 470;
	private int posEndY = 670;
	private String path = "src//img//";
	private String gagner = "";
	private String img = "stop.png";
	private int[][] posBloc = {{100,0,0},                        {280,0,0}, 
							   {100,60,0},                       {280,60,0}, 
							   {100,120,0},                       {280,120,0}, 
							   {100,180,0},                       {280,180,0}, 
							   {100,240,0},{160,240,1},          {280,240,0}, 
							   {100,300,0},                                 {340,300,0}, 
							   {100,360,0},                      {280,360,0}, 
							   {100,420,0},{160,420,1},          {280,420,0}, 
							   {100,480,0},                      {280,480,0},{340,480,0}, 
							   {100,540,0},          {220,540,1},{280,540,0},             {400,540,0},{460,540,0},{520,540,0},
							   {100,600,0},                                  {340,600,1},             {460,600,1},           {580,600,1},
							   {100,660,0},{160,660,0},{220,660,0},                        {400,660,0},           {520,660,0}};
	
	


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


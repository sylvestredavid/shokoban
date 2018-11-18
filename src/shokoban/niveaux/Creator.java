package shokoban.niveaux;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Creator extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posX = 0;
	private int posY = 0;
	private String path = "src//img//";
	private int[][] posBloc = new int[144][3];
	
	


	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.blue);
		g.drawRect(this.posX, this.posY, 60, 60);
//		try {
//			g.drawImage(ImageIO.read(new File(path+"end.png")), this.posEndX, this.posEndY, 40, 40, this);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			g.drawImage(ImageIO.read(new File(path+img)), this.posBallX, this.posBallY, 40, 40, this);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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
	}
	
	public void create(int[] bloc) {
		BufferedWriter out = null;
		try {
            
            // 1) Instanciation de l'objet
            out = new BufferedWriter(new FileWriter(new File("src//fenetre//creator.txt")));
          
            try {
              
                 // 2) Utilisation de l'objet
                 out.write(String.valueOf(bloc));
              
            } finally {
              
                 // 3) Libération de la ressource exploitée par l'objet
                 out.close();
              
            }
          
       } catch (IOException e) {
            e.printStackTrace();
       }
	}




	public int getPosX() {
		return posX;
	}




	public void setPosX(int posX) {
		this.posX = posX;
	}




	public int getPosY() {
		return posY;
	}




	public void setPosY(int posY) {
		this.posY = posY;
	}




	public int[][] getPosBloc() {
		return posBloc;
	}




	public void setPosBloc(int[][] posBloc) {
		this.posBloc = posBloc;
	}		 
}
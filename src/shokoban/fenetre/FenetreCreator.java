package shokoban.fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import shokoban.niveaux.Creator;

public class FenetreCreator extends JFrame implements KeyListener {
	
	Creator p = new Creator();
	int[][] posBloc = p.getPosBloc();
	int i = 1;
	
	public FenetreCreator() {
		this.setTitle("Shokoban");
		this.setSize(725, 695);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(p);
		this.setVisible(true);
		this.addKeyListener(this);
		int[] bloc = {-100,-100,0};
		posBloc[0] = bloc;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37 && p.getPosX() > 1) 
			p.setPosX(p.getPosX() - 60);

		if(e.getKeyCode() == 38 && p.getPosY() > 1) 
			p.setPosY(p.getPosY() - 60);

		if(e.getKeyCode() == 39 && p.getPosX() < 655) 
			p.setPosX(p.getPosX() + 60);

		if(e.getKeyCode() == 40 && p.getPosY() < 590) 
			p.setPosY(p.getPosY() + 60);
		
		if(e.getKeyChar() == 'm') {
			int[] bloc = {p.getPosX(), p.getPosY(), 0};
			posBloc[i] = bloc;
			p.setPosBloc(posBloc);
			p.create(bloc);
			i++;
		}
		
		if(e.getKeyChar() == 'c') {
			int[] bloc = {p.getPosX(), p.getPosY(), 1};
			posBloc[i] = bloc;
			p.setPosBloc(posBloc);
			p.create(bloc);
			i++;
		}
			
		p.repaint();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

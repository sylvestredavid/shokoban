package shokoban.fenetre;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import shokoban.niveaux.Accueil;
import shokoban.niveaux.NiveauDeux;
import shokoban.niveaux.NiveauTrois;
import shokoban.niveaux.NiveauUn;
import shokoban.niveaux.Panneau;
import shokoban.users.User;

public class Fenetre extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Panneau[] panneaux = { new NiveauUn(), new NiveauDeux(), new NiveauTrois() };
	Accueil acc = new Accueil();
	int i = 0;
	private Panneau pan = panneaux[i];
	User user = new User();
	boolean entrer = false;
	int count = 0;

	public Fenetre() {
		this.setTitle("Shokoban");
		this.setSize(720, 745);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(this);
		go();
	}

	public void accueil() {
		this.setContentPane(acc);
		while (acc.getPosBloc()[0][0] < this.getWidth()) { // tant que le block n'est pas en dehors de la droite de
															// l'ecran
			int x = acc.getPosBallX();
			x++;
			acc.setPosBallX(x);
			if (acc.getPosBallX() + 60 >= acc.getPosBloc()[0][0]) {
				// si le bonhomme entre en colision avec le block
				// (si sa coordonée X+sa largeur se retrouve a la coordonnée x du block)
				// le block se deplace alors a la même vitesse que le bonhomme
				int[][] posBloc = acc.getPosBloc();
				posBloc[0][0]++;
				acc.setPosBloc(posBloc);
			}
			// on alterne les images pour donner un effet de marche
			// avec une interrupetion de 5milliemes de secondes entre chaques
			// on repaint le panneau pour voir les changements
			acc.setImg("droite1.png");
			acc.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acc.setImg("droite2.png");
			acc.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		while (acc.getPosBallX() > 340) { // tant que le bonhomme n'est pas a la moitièe de la fenetre
			int x = acc.getPosBallX();
			x--; // il se deplace
			acc.setPosBallX(x);
			acc.setImg("gauche1.png");
			acc.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			acc.setImg("gauche2.png");
			acc.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (!entrer) {
			acc.setImg("stop.png");
			acc.setFleche("fleche.png");
			acc.setEntrer("Jouer");

			if (user.continuer() != 0) // si le fichier texte ne retourne pas 0
				acc.setContinuer("Continuer");
			acc.repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (acc.getPosFlecheY() == 330) { // si la fleche est a la coordonnee Y de 230, on commence au premier niveau
			pan = panneaux[i]; // on commence a l'index 0
		} else if (user.continuer() != 0) { // sinon, si le fichier texte ne retourne pas 0
			i = user.continuer();
			pan = panneaux[i]; // on commence a l'index retourné par le fichier texte
		}
		// on donne le nouveau panneau en contentPan,
		// on repaint pour mettre a jour les variables,
		//on revalidate pour changer de vue
		this.setContentPane(pan);
		this.repaint();
		this.revalidate();

	}

	public void go() {
		accueil();
		while (true) {
			pan.setGagner("");
			deplaceBloc();
			if (gagner()) {
				try {
					i++;
					user.writer(i);
					pan = panneaux[i];
					this.setContentPane(pan);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.repaint();
				this.revalidate();

			}
			pan.repaint();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
		}
	}

	public void deplaceBloc() {
		int[][] posBloc = pan.getPosBloc();

		// deplacement du bloc vers la droite
		for (int i = 0; i < posBloc.length; i++) {
			if (pan.getPosBallX() + 40 == posBloc[i][0]) { //si x du bonhomme + sa taille = x du block
				if (pan.getPosBallY() + 30 >= posBloc[i][1] && pan.getPosBallY() <= posBloc[i][1] + 60) { // si son Y est >= au y du block et <= au y du block + la taille du block
					if (posBloc[i][0] + 60 > pan.getWidth()) { // si le block est au bord de l'ecran
						pan.setPosBallX(pan.getPosBallX() - 5); // colision le bonhomme recule (effet de rebond)
					} else {
						boolean isBlocked = false;
						for (int j = 0; j < posBloc.length; j++) {
							if (posBloc[i][0] + 60 == posBloc[j][0]) { // si le x du block + sa taille est egale au x d'un utre block
								if (posBloc[i][1] + 60 > posBloc[j][1] && posBloc[i][1] < posBloc[j][1] + 60) { // si son Y est >= au y de l'autre et <= au y de l'autre + sa taille
									isBlocked = true; // colision
								}
							}
						}
						if (isBlocked || posBloc[i][2] == 0) { // si collision ou block imbougable
							pan.setPosBallX(pan.getPosBallX() - 5);
						} else { // sinon on change la valeur x du block
							posBloc[i][0] += 5;
							pan.setPosBloc(posBloc);
						}

					}
				}
			}

			// deplacement du bloc vers la gauche
			if (pan.getPosBallX() == posBloc[i][0] + 60) {
				if (pan.getPosBallY() + 30 >= posBloc[i][1] && pan.getPosBallY() <= posBloc[i][1] + 60) {
					if (posBloc[i][0] < 1) {
						pan.setPosBallX(pan.getPosBallX() + 5);
					} else {
						boolean isBlocked = false;
						for (int j = 0; j < posBloc.length; j++) {
							if (posBloc[i][0] == posBloc[j][0] + 60) {
								if (posBloc[i][1] + 60 > posBloc[j][1] && posBloc[i][1] < posBloc[j][1] + 60) {
									isBlocked = true;
								}
							}
						}
						if (isBlocked || posBloc[i][2] == 0) {
							pan.setPosBallX(pan.getPosBallX() + 5);
						} else {
							posBloc[i][0] -= 5;
							pan.setPosBloc(posBloc);
						}
					}
				}
			}

			// deplacement du bloc vers le bas
			if (pan.getPosBallY() + 40 == posBloc[i][1]) {
				if (pan.getPosBallX() + 40 >= posBloc[i][0] && pan.getPosBallX() <= posBloc[i][0] + 60) {
					if (posBloc[i][1] + 60 > pan.getHeight()) {
						pan.setPosBallY(pan.getPosBallY() - 5);
					} else {
						boolean isBlocked = false;
						for (int j = 0; j < posBloc.length; j++) {
							if (posBloc[i][1] + 60 == posBloc[j][1]) {
								if (posBloc[i][0] + 60 > posBloc[j][0] && posBloc[i][0] < posBloc[j][0] + 60) {
									isBlocked = true;
								}
							}

						}
						if (isBlocked || posBloc[i][2] == 0) {
							pan.setPosBallY(pan.getPosBallY() - 5);
						} else {
							posBloc[i][1] += 5;
							pan.setPosBloc(posBloc);
						}
					}
				}
			}

			// deplacement du bloc vers le haut
			if (pan.getPosBallY() == posBloc[i][1] + 60) {
				if (pan.getPosBallX() + 40 >= posBloc[i][0] && pan.getPosBallX() <= posBloc[i][0] + 60) {
					if (posBloc[i][1] < 1) {
						pan.setPosBallY(pan.getPosBallY() + 5);
					} else {
						boolean isBlocked = false;
						for (int j = 0; j < posBloc.length; j++) {
							if (posBloc[i][1] == posBloc[j][1] + 60) {
								if (posBloc[i][0] + 60 > posBloc[j][0] && posBloc[i][0] < posBloc[j][0] + 60) {
									isBlocked = true;
								}
							}
						}
						if (isBlocked || posBloc[i][2] == 0) {
							pan.setPosBallY(pan.getPosBallY() + 5);
						} else {
							posBloc[i][1] -= 5;
							pan.setPosBloc(posBloc);
						}
					}
				}
			}

		}
	}

	public boolean gagner() {
		// si les coordonnées du bonhommes se retrouvent sur les coordonnées du point de fin, c'est gagné !
		if ((pan.getPosBallX() + 40 >= pan.getPosEndX() && pan.getPosBallX() <= pan.getPosEndX() + 40)
				&& pan.getPosBallY() >= pan.getPosEndY()) {
			pan.setGagner("Gagné !");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 37 && !(pan.getPosBallX() < 1)) {// touche gauche
			pan.setPosBallX(pan.getPosBallX() - 5);
			if (count % 2 == 0 && count % 4 != 0)
				pan.setImg("gauche2.png");
			else if (count % 4 == 0)
				pan.setImg("gauche1.png");
		} else if (e.getKeyCode() == 38 && !(pan.getPosBallY() < 1)) {// touche haut
			pan.setPosBallY(pan.getPosBallY() - 5);
			if (count % 2 == 0 && count % 4 != 0)
				pan.setImg("haut2.png");
			else if (count % 4 == 0)
				pan.setImg("haut1.png");
		} else if (e.getKeyCode() == 39 && !(pan.getPosBallX() > pan.getWidth() - 40)) {// touche droite
			pan.setPosBallX(pan.getPosBallX() + 5);
			if (count % 2 == 0 && count % 4 != 0)
				pan.setImg("droite2.png");
			else if (count % 4 == 0)
				pan.setImg("droite1.png");
		} else if (e.getKeyCode() == 40 && !(pan.getPosBallY() > pan.getHeight() - 40)) {// touche bas
			pan.setPosBallY(pan.getPosBallY() + 5);
			if (count % 2 == 0 && count % 4 != 0)
				pan.setImg("bas2.png");
			else if (count % 4 == 0)
				pan.setImg("bas1.png");
		} else if (e.getKeyCode() == 10) {
			entrer = true;
		}

		if (e.getKeyCode() == 40 && user.continuer() != 0)
			acc.setPosFlecheY(380);

		if (e.getKeyCode() == 38)
			acc.setPosFlecheY(330);

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 37 && !(pan.getPosBallX() < 1)) {
			pan.setImg("gauche1.png");
		} else if (e.getKeyCode() == 38 && !(pan.getPosBallY() < 1)) {
			pan.setImg("haut1.png");
		} else if (e.getKeyCode() == 39 && !(pan.getPosBallX() > pan.getWidth() - 40)) {
			pan.setImg("droite1.png");
		} else if (e.getKeyCode() == 40 && !(pan.getPosBallY() > pan.getHeight() - 40)) {
			pan.setImg("stop.png");
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}

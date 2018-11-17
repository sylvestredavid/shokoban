package shokoban.users;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class User {

	public int continuer() {
		try {
			Scanner scan = new Scanner(new File("src//fichiers//niveaux.txt"));
			return scan.nextInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public void writer(int i) {
		FileWriter fichier;
		try {
			fichier = new FileWriter("src//fichiers//niveaux.txt");
			fichier.write(String.valueOf(i));
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

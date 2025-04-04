// importation des modules java 
import javax.swing.*;
import java.awt.*;

public class Grille extends JPanel { // class de la grille 
    
    // la grille est constituées de bloc
    private Bloc[][] grille;
    
    public Grille() { // constructeur par default, sans le fichier, la configuration est aléatoire
        this.setLayout(new GridLayout(10, 15));
        String[] images = {"./images/rouge.png", "./images/bleu.png", "./images/vert.png"};
        this.grille = new Bloc[10][15];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                int random = (int) (Math.random() * 3);
                this.grille[i][j] = new Bloc(i, j, images[random]);
                this.add(this.grille[i][j]); 
            }
        }
    }

    public Grille(String[][] grille) { // constructeur pour les fichier, la configuration est faites par le fichier .txt de l'utilisateur
        this.setLayout(new GridLayout(10, 15)); 
        this.grille = new Bloc[10][15]; 
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 15; j++) {
                // repartitions des couleur dans la grille
                if (grille[i][j].equals("R")) {
                    this.grille[i][j] = new Bloc(i, j, "./images/rouge.png");
                } else if (grille[i][j].equals("B")) {
                    this.grille[i][j] = new Bloc(i, j, "./images/bleu.png");
                } else if (grille[i][j].equals("G")) {
                    this.grille[i][j] = new Bloc(i, j, "./images/vert.png");    
                }
                this.add(this.grille[i][j]); 
            }
        }
    }
    // getteur
    public Bloc[][] getGrille() {
        return this.grille;
    }
    
}
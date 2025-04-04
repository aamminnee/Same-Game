//importation des module java
import javax.swing.*;
import java.awt.*;

public class Bloc extends JComponent { // class bloc (elements de la grille)

    // initialisation des attribut de la classe Bloc
    private boolean selectionner;
    private boolean supprimer;
    private int ligne;
    private int colonne;
    private Image image;

    public Bloc(int ligne, int colonne, String image) {
        this.supprimer = false;
        this.selectionner = false;
        this.ligne = ligne;
        this.colonne = colonne;
        this.image = Toolkit.getDefaultToolkit().getImage(image);

        this.setPreferredSize(new Dimension(50, 50));
        this.setOpaque(true);
    }

    // ensemble de setteurs et getteurs
    public Image getCouleur() {
        return this.image;
    }

    public void setCouleur(Image image) {
        this.image = image;
    }

    public int getLigne() {
        return this.ligne;
    }

    public int getColonne() {
        return this.colonne;
    }  

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setSelectionner(boolean selectionner) {
        this.selectionner = selectionner;
    }

    public boolean estSelectionner() {
        return this.selectionner;
    }

    public Boolean getSupprimer() {
        return this.supprimer;
    }
 
    public void setSupprimer(boolean supprimer) {
        this.supprimer = supprimer;
    }

    // la dessin du bouton / son apparence
    @Override
    protected void paintComponent(Graphics g) {
        Graphics g2 = (Graphics) g.create();
        if (this.isOpaque()) {
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        if (this.selectionner && !this.supprimer) {
            g2.setColor(Color.YELLOW);
            g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        if (!this.supprimer) {
            int x = (this.getWidth() - image.getWidth(this)) / 2;
            int y = (this.getHeight() - image.getHeight(this)) / 2;
            g2.drawImage(this.image, x, y, this);
        }
    
        g2.dispose();

    }
}

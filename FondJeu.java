// importation des modules
import javax.swing.*;
import java.awt.*;
public class FondJeu extends JPanel {

    // initialastion des attributs
    private Image backgroundImage;

    public FondJeu(String chemin) {
        try {
            backgroundImage = new ImageIcon(chemin).getImage();
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement de l'image : " + e.getMessage());
        }
    }

    // redssiner la fenetre a l'afigie du fond d'écran 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
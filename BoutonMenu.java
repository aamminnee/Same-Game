import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class BoutonMenu extends JButton { // class pour modifier l'apparence d'un bouton sur java

    //initialisation de l'attribut nom du bouton
    private String nom;

    public BoutonMenu(String nom) {
        super(nom);
        this.nom = nom;
        setContentAreaFilled(false); 
        setFocusPainted(false); 
        setBorderPainted(false); 
        Border roundedBorder = BorderFactory.createLineBorder(Color.BLACK, 1, true);
        setBorder(roundedBorder);
    }
    
    // getteur
    public String getNom() {
        return nom;
    }

    // setteur
    public void setNom(String nom) {
        this.nom = nom;
    }

    // méthode pour redessiner les bouton des menu 
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); 
        super.paintComponent(g2);
        g2.dispose();
    }
}
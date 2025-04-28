import javax.swing.*;
import java.awt.*;

public class Acceuil2 extends JFrame {

    private String titre;

    public Acceuil2(String titre) {
        this.setSize(1080, 720);
        this.setTitle("Same Game");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        FondJeu fond = new FondJeu("images/fond_colors_crush.png"); // affichage du fond
        fond.setLayout(new BorderLayout());
        this.setContentPane(fond);
        
        // initialisation des boutons dans l'acceuil 2
        BoutonMenu jouer = new BoutonMenu("Jouer");
        BoutonMenu charger = new BoutonMenu("Charger");
        BoutonMenu retour = new BoutonMenu("Retour");
        
        // dimensuions des boutons
        Dimension dimension = new Dimension(110, 50);

        // personalisation des boutons
        jouer.setFont(new Font("Arial", Font.PLAIN, 24));
        jouer.setPreferredSize(dimension);
        jouer.setBackground(new Color(231, 9, 9));
        jouer.setForeground(Color.WHITE);
        jouer.addMouseListener(new BoutonJouerAleatoire(this));

        charger.setFont(new Font("Arial", Font.PLAIN, 24));
        charger.setPreferredSize(dimension);
        charger.setBackground(new Color(13, 195, 250));
        charger.setForeground(Color.WHITE);
        charger.addMouseListener(new BoutonJeuFile(this));

        retour.setPreferredSize(dimension);
        retour.setFont(new Font("Arial", Font.PLAIN, 24));
        retour.setBackground(new Color(21, 171, 25));
        retour.setForeground(Color.WHITE);
        retour.addMouseListener(new BoutonRetour(this));

        JPanel panneauBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 155, 450));
        panneauBoutons.setOpaque(false);
        panneauBoutons.add(jouer);
        panneauBoutons.add(charger);
        panneauBoutons.add(retour);

        fond.add(panneauBoutons, BorderLayout.CENTER);
    } 

    public String getTitre() {
        return this.titre;
    }
}

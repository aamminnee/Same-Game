import javax.swing.*;
import java.awt.*;


public class FinJeu extends JFrame{

    private String titre;

    public FinJeu(String titre, int score) {
        this.titre = titre;
        this.setSize(1080, 720);
        this.setTitle(this.titre);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        Dimension dimension = new Dimension(110, 50);

        FondJeu fond = new FondJeu("images/fond_vide.png");
        fond.setLayout(new BorderLayout());
        this.setContentPane(fond);
        
        //texte a afficher pour la fin de partie
        JLabel finMessage = new JLabel("<html>Partie terminée !<br>Score final : " + score + "</html>", SwingConstants.CENTER);
        finMessage.setFont(new Font("Arial", Font.BOLD, 30));
        finMessage.setForeground(Color.WHITE);
        fond.add(finMessage, BorderLayout.CENTER);
        
        JPanel panneauBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 100));
        panneauBoutons.setOpaque(false); 
        
        // initialisation et personnalisation des boutons du menu de fin de partie
        BoutonMenu rejouer = new BoutonMenu("Rejouer");
        rejouer.addMouseListener(new BoutonRejouer(this));
        rejouer.setPreferredSize(dimension);
        rejouer.setFont(new Font("Arial", Font.PLAIN, 24));
        rejouer.setBackground(new Color(194, 13, 195));
        rejouer.setForeground(Color.WHITE);
        BoutonMenu quitter = new BoutonMenu("Quitter");
        quitter.addMouseListener(new BoutonQuitter());
        quitter.setPreferredSize(dimension);
        quitter.setFont(new Font("Arial", Font.PLAIN, 24));
        quitter.setBackground(new Color(194, 13, 195));
        quitter.setForeground(Color.WHITE);

        panneauBoutons.add(rejouer);
        panneauBoutons.add(quitter);
    
        fond.add(panneauBoutons, BorderLayout.SOUTH); 
    }

    public String getTitre() {
        return titre;
    }
}



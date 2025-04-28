import javax.swing.*;
import java.awt.*;

public class Acceuil1 extends JFrame {

    private String titre;
    
    public Acceuil1(String titre) { 
        this.titre = titre; 
        this.setSize(1080, 720);
        this.setTitle(this.titre);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        FondJeu fond = new FondJeu("images/fond_colors_crush.png"); // fon d'écran
            fond.setLayout(new BorderLayout());
            this.setContentPane(fond);
            
            // les différren
            BoutonMenu jeux = new BoutonMenu("Jeux");
            BoutonMenu regles = new BoutonMenu("Règles");
            BoutonMenu quitter = new BoutonMenu("Quitter");
            
            // dimension des boutons
            Dimension dimension = new Dimension(110, 50);

            //modification des boutons
            jeux.setFont(new Font("Arial", Font.PLAIN, 24));
            jeux.setPreferredSize(dimension);
            jeux.setBackground(new Color(231, 9, 9));
            jeux.setForeground(Color.WHITE);
            jeux.addMouseListener(new BoutonAcceuil2(this));
    
            regles.setFont(new Font("Arial", Font.PLAIN, 24));
            regles.setPreferredSize(dimension);
            regles.setBackground(new Color(13, 195, 250));
            regles.setForeground(Color.WHITE);
            regles.addMouseListener(new BoutonRegles(this));
    
            quitter.setPreferredSize(dimension);
            quitter.setFont(new Font("Arial", Font.PLAIN, 24));
            quitter.setBackground(new Color(21, 171, 25));
            quitter.setForeground(Color.WHITE);
            quitter.addMouseListener(new BoutonQuitter());
    
            JPanel panneauBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 155, 450));
            panneauBoutons.setOpaque(false);
            panneauBoutons.add(jeux);
            panneauBoutons.add(regles);
            panneauBoutons.add(quitter);
    
            fond.add(panneauBoutons, BorderLayout.CENTER);
    } 

    public String getTitre() {
        return this.titre;
    }
}

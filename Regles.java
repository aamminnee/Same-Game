import java.awt.*;
import javax.swing.*;

public class Regles extends JFrame {

    private String titreFrame;

    public String getTitreFrame() {
        return this.titreFrame;
    }
    
    public Regles(String titreFrame) {
        this.setSize(1080, 720);
        this.setTitle(this.titreFrame);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        FondJeu fond = new FondJeu("images/fond_vide.png");
            fond.setLayout(new BorderLayout());
            this.setContentPane(fond);

            // titre du lenu regles
            JLabel titre = new JLabel("Color Crush", SwingConstants.CENTER);
            titre.setFont(new Font("Arial", Font.BOLD, 45));
            titre.setForeground(Color.WHITE);
            titre.setOpaque(false);
    
            JTextArea reglesText = new JTextArea(
                    " \n\n Règles du Jeu : Colors Crush\n\n" +
                    "  Colors Crush est un jeu simple et amusant !\n\n" +
                    "  Objectif :\n" +
                    "  Vider la grille en supprimant des groupes de blocs de même couleur.\n\n" +
                    "  Comment Jouer ?\n" +
                    "  Clique sur un groupe d'au moins deux blocs de même couleur pour les éliminer.\n" +
                    "  Les blocs restants tombent vers le bas pour combler les vides.\n" +
                    "  Si une colonne devient vide, les colonnes à droite se décalent vers la gauche.\n\n" +
                    "  Points :\n" +
                    "  Plus tu élimines de blocs à la fois, plus tu gagnes de points :\n" +
                    "      2 blocs : 0 point\n" +
                    "      3 blocs : 1 point\n" +
                    "      4 blocs : 4 points\n" +
                    "      5 blocs : 9 points\n" +
                    "      etc. (Points = (nombre de blocs - 2)²)\n\n" +
                    "  Fin de la Partie :\n" +
                    "  Le jeu se termine quand il n'y a plus de groupes possibles. Ton score final s'affiche à ce moment-là.\n\n" +
                    "                                  Amuse-toi bien !"
            );
            //modification du chamos d'affichage du texte
            reglesText.setFont(new Font("Arial", Font.PLAIN, 21));
            reglesText.setForeground(Color.WHITE);
            reglesText.setOpaque(false);
            reglesText.setEditable(false);
            reglesText.setLineWrap(true);
            reglesText.setWrapStyleWord(true);
            
            // initialisation du scrolleur
            JScrollPane scrollPane = new JScrollPane(reglesText);
            scrollPane.setBorder(null);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            
            // initilation et personalisation du bouton retour des règles
            BoutonMenu retour = new BoutonMenu("Retour");
            retour.setPreferredSize(new Dimension(200, 50));
            retour.setFont(new Font("Arial", Font.PLAIN, 24));
            retour.setBackground(new Color(194, 13, 195));
            retour.setForeground(Color.WHITE);
            retour.addMouseListener(new BoutonRetour(this));
            
            // configuration de l'affichage 
            JPanel panneauPrincipal = new JPanel(new BorderLayout());
            panneauPrincipal.setOpaque(false);
            panneauPrincipal.add(titre, BorderLayout.NORTH);
            panneauPrincipal.add(scrollPane, BorderLayout.CENTER);
            panneauPrincipal.add(retour, BorderLayout.SOUTH);
    
            fond.add(panneauPrincipal, BorderLayout.CENTER);
    }
    
}

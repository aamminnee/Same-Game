// importation des modules nécéssaires 
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fenetre extends JFrame {

    // initialisation des variables d'état
    private boolean estAcceuil;
    private boolean estAcceuil2;
    private boolean estRegle;
    private boolean estJeu;
    private boolean estJeu2;
    private boolean estFin;
    private String titre;
    private int score;
    

    public Fenetre(String titre) {
        this.score = 0;
        this.titre = titre;
        this.setSize(1080, 720);
        this.setTitle(this.titre);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.estAcceuil = true;
        this.estAcceuil2 = false;
        this.estRegle = false;
        this.estJeu = false;
        this.estJeu2 = false;
        this.estFin = false;
        
        this.updateView();
    }

    // enssembles des setteur et getteur pour el bon fonctionnement de l'état du jeu

    public boolean isEstAcceuil() {
        return this.estAcceuil;
    }

    public void setEstAcceuil(boolean estAcceuil) {
        this.estAcceuil = estAcceuil;
    }

    public boolean isEstAcceuil2() {
        return this.estAcceuil2;
    }

    public void setEstAcceuil2(boolean estAcceuil2) {
        this.estAcceuil2 = estAcceuil2;
    }

    public boolean isEstRegle() {
        return this.estRegle;
    }

    public void setEstRegle(boolean estRegle) {
        this.estRegle = estRegle;
    }

    public boolean isEstJeu() {
        return this.estJeu;
    }

    public void setEstJeu(boolean estJeu) {
        this.estJeu = estJeu;
    }

    public boolean isEstJeu2() {
        return this.estJeu2;
    }

    public void setEstJeu2(boolean estJeu2) {
        this.estJeu2 = estJeu2;
    } 

    public boolean getEstFin() {
        return this.estFin;
    }

    public void setEstFin(boolean estFin) {
        this.estFin = estFin;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setScore(int score) {
        this.score = score;
    } 

    public int getScore() {
        return this.score;
    } 

    // montre l'affichage en tant réel selon les différentes variables d'état
    public void updateView() {
        // suprime tout les éléments affiché en cas de changement d'éat
        getContentPane().removeAll();
        
        if (estAcceuil && !estAcceuil2) { // le premier menu
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
            jeux.addMouseListener(new ControlleurBoutonMenu(this));
    
            regles.setFont(new Font("Arial", Font.PLAIN, 24));
            regles.setPreferredSize(dimension);
            regles.setBackground(new Color(13, 195, 250));
            regles.setForeground(Color.WHITE);
            regles.addMouseListener(new ControlleurBoutonMenu(this));
    
            quitter.setPreferredSize(dimension);
            quitter.setFont(new Font("Arial", Font.PLAIN, 24));
            quitter.setBackground(new Color(21, 171, 25));
            quitter.setForeground(Color.WHITE);
            quitter.addMouseListener(new ControlleurBoutonMenu(this));
    
            JPanel panneauBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 155, 450));
            panneauBoutons.setOpaque(false);
            panneauBoutons.add(jeux);
            panneauBoutons.add(regles);
            panneauBoutons.add(quitter);
    
            fond.add(panneauBoutons, BorderLayout.CENTER);
            
        } else if (estAcceuil2) { // le deuxième menu
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
            jouer.addMouseListener(new ControlleurBoutonMenu(this));
    
            charger.setFont(new Font("Arial", Font.PLAIN, 24));
            charger.setPreferredSize(dimension);
            charger.setBackground(new Color(13, 195, 250));
            charger.setForeground(Color.WHITE);
            charger.addMouseListener(new ControlleurBoutonMenu(this));
    
            retour.setPreferredSize(dimension);
            retour.setFont(new Font("Arial", Font.PLAIN, 24));
            retour.setBackground(new Color(21, 171, 25));
            retour.setForeground(Color.WHITE);
            retour.addMouseListener(new ControlleurBoutonMenu(this));
    
            JPanel panneauBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 155, 450));
            panneauBoutons.setOpaque(false);
            panneauBoutons.add(jouer);
            panneauBoutons.add(charger);
            panneauBoutons.add(retour);
    
            fond.add(panneauBoutons, BorderLayout.CENTER);
            
        } else if (estRegle) { // les règles
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
            retour.addMouseListener(new ControlleurBoutonMenu(this));
            
            // configuration de l'affichage 
            JPanel panneauPrincipal = new JPanel(new BorderLayout());
            panneauPrincipal.setOpaque(false);
            panneauPrincipal.add(titre, BorderLayout.NORTH);
            panneauPrincipal.add(scrollPane, BorderLayout.CENTER);
            panneauPrincipal.add(retour, BorderLayout.SOUTH);
    
            fond.add(panneauPrincipal, BorderLayout.CENTER);
            
        } else if (this.estJeu) { // démarrage du jeu sans fichier donc un configuration de la grille aléatoire
            // initialisation de la grille
            Grille grille = new Grille();
            for (Bloc[] ligne : grille.getGrille()) {
                for (Bloc bloc : ligne) {
                    ControlleurGrille controlleur = new ControlleurGrille(grille, bloc, this);
                    bloc.addMouseListener(controlleur);
                }
            }
            this.add(grille, BorderLayout.CENTER);
        } else if (this.estJeu2) { // démarrage du jeu avec fichier donc la configuration se fait par l'utulisateur
            Grille grille = chargerGrilleDepuisFichier();
    
            if (grille != null) {
                // initialisation de la grille
                for (Bloc[] ligne : grille.getGrille()) {
                    for (Bloc bloc : ligne) {
                        ControlleurGrille controleur = new ControlleurGrille(grille, bloc, this);
                        bloc.addMouseListener(controleur);
                    }
                }
                this.add(grille, BorderLayout.CENTER);
            } else { // gestion des erreurs d'ouverture de fichier
                JOptionPane.showMessageDialog(this, "Erreur lors du chargement de la grille", "Erreur", JOptionPane.ERROR_MESSAGE);
                this.setEstJeu2(false);
                this.setEstAcceuil2(true);
                this.updateView();
            }
        }  else if (this.estFin) { // menu de fin de partie
            Dimension dimension = new Dimension(110, 50);

            FondJeu fond = new FondJeu("images/fond_vide.png");
            fond.setLayout(new BorderLayout());
            this.setContentPane(fond);
            
            //texte a afficher pour la fin de partie
            JLabel finMessage = new JLabel("<html>Partie terminée !<br>Score final : " + this.score + "</html>", SwingConstants.CENTER);
            finMessage.setFont(new Font("Arial", Font.BOLD, 30));
            finMessage.setForeground(Color.WHITE);
            fond.add(finMessage, BorderLayout.CENTER);
            
            JPanel panneauBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 100));
            panneauBoutons.setOpaque(false); 
            
            // initialisation et personnalisation des boutons du menu de fin de partie
            BoutonMenu rejouer = new BoutonMenu("Rejouer");
            rejouer.addMouseListener(new ControlleurBoutonMenu(this));
            rejouer.setPreferredSize(dimension);
            rejouer.setFont(new Font("Arial", Font.PLAIN, 24));
            rejouer.setBackground(new Color(194, 13, 195));
            rejouer.setForeground(Color.WHITE);
            BoutonMenu quitter = new BoutonMenu("Quitter");
            quitter.addMouseListener(new ControlleurBoutonMenu(this));
            quitter.setPreferredSize(dimension);
            quitter.setFont(new Font("Arial", Font.PLAIN, 24));
            quitter.setBackground(new Color(194, 13, 195));
            quitter.setForeground(Color.WHITE);

            panneauBoutons.add(rejouer);
            panneauBoutons.add(quitter);
        
            fond.add(panneauBoutons, BorderLayout.SOUTH); 
        }
            // actualisation de l'affichage
            this.revalidate();
            this.repaint();
    
    }

    private Grille chargerGrilleDepuisFichier() {
         // ouverture de fichier , chargement de fichier, gestion d'erreurs sur les fichier et filtre de recherche
        JFileChooser choixFichier = new JFileChooser();
        choixFichier.setDialogTitle("Charger une grille");
        FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichiers texte (.txt)", "txt");
        choixFichier.setFileFilter(filtre);
        int choixUtilisateur = choixFichier.showOpenDialog(this);
        if (choixUtilisateur == JFileChooser.APPROVE_OPTION) {
            File fichier = choixFichier.getSelectedFile();
            if (!fichier.getName().toLowerCase().endsWith(".txt")) {
                JOptionPane.showMessageDialog(this, 
                    "Le fichier doit avoir l'extension .txt", 
                    "Format incorrect", JOptionPane.WARNING_MESSAGE);
                return null;
            } 
            try (BufferedReader lecteur = new BufferedReader(new FileReader(fichier))) {
                String[][] grilleSymboles = new String[10][15];
                int ligneActuelle = 0;
                String ligneLue;
                while ((ligneLue = lecteur.readLine()) != null) {
                    ligneLue = ligneLue.trim().toUpperCase();
                
                    if (ligneActuelle >= 10) {
                        JOptionPane.showMessageDialog(this,
                            "Le fichier contient plus de 10 lignes",
                            "Erreur de format", JOptionPane.ERROR_MESSAGE);
                        return null;
                    }
                    
                    if (ligneLue.length() != 15) {
                        JOptionPane.showMessageDialog(this,
                            "Ligne " + (ligneActuelle + 1) + ": doit contenir exactement 15 caractères (R, G ou B)\n" +
                            "Longueur trouvée: " + ligneLue.length() + " caractères",
                            "Erreur de format", JOptionPane.ERROR_MESSAGE);
                        return null;
                    }
                    
                    for (int colonne = 0; colonne < 15; colonne++) {
                        char symbole = ligneLue.charAt(colonne);
                        if (symbole != 'R' && symbole != 'G' && symbole != 'B') {
                            JOptionPane.showMessageDialog(this,
                                "Caractère invalide à la ligne " + (ligneActuelle + 1) + ", colonne " + (colonne + 1) + "\n" +
                                "Caractère trouvé: '" + symbole + "' (doit être R, G ou B)",
                                "Erreur de format", JOptionPane.ERROR_MESSAGE);
                            return null;
                        }
                        grilleSymboles[ligneActuelle][colonne] = String.valueOf(symbole);
                    }
                    ligneActuelle++;
                }
                
                if (ligneActuelle < 10) {
                    JOptionPane.showMessageDialog(this,
                        "Le fichier contient seulement " + ligneActuelle + " lignes\n" +
                        "Il doit en contenir exactement 10",
                        "Erreur de format", JOptionPane.ERROR_MESSAGE);
                    return null;
                }
                
                return new Grille(grilleSymboles);
                
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this,
                    "Erreur de lecture du fichier:\n" + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return null;
    }
}

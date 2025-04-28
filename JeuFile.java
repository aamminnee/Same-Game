// importation des modules nécéssaires 
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JeuFile extends Jeu {

    private JFrame frame;
    
    public JeuFile(String titre, JFrame frame) {
        super(titre);
        this.frame = frame;
    
        try {
            Grille grille = chargerGrilleDepuisFichier();
            if (grille == null) {
                throw new Exception("Chargement de grille échoué");
            }
    
            // Initialisation réussie
            this.frame.dispose();
            
            for (Bloc[] ligne : grille.getGrille()) {
                for (Bloc bloc : ligne) {
                    ControlleurGrille controleur = new ControlleurGrille(grille, bloc, this);
                    bloc.addMouseListener(controleur);
                }
            }
            this.add(grille, BorderLayout.CENTER);
            
        } catch (Exception ex) {
            if (this.isVisible()) {
                this.dispose();
            }
            throw new RuntimeException(ex);
        }
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

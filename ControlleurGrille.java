// importation des modules
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Queue;

public class ControlleurGrille implements MouseListener {
    
    //initialisation des attributs
    private Bloc[][] grille;
    private Grille vue;
    private Bloc bloc;
    private int ordreGraphe;
    private Fenetre frame;
    private int ordreGrapheSelect;

    public ControlleurGrille(Grille vue, Bloc bloc, Fenetre fenetre) {
        this.vue = vue;
        this.grille = vue.getGrille();
        this.bloc = bloc;
        this.ordreGraphe = 0;
        this.ordreGrapheSelect = 0;
        this.frame = fenetre;
    }

    @Override
    public void mouseClicked(MouseEvent e) { // si le joueur clique sur un bloc de la grille
        if (this.ordreGrapheSelect > 1) { // le jeu s'assure qu'il supprime un ensemble de blocs et non un suel bloc 

            // deselectionne l'ensemble de bloc selectionner de la grille
            for (Bloc[] ligne : grille) {
                for (Bloc b : ligne) {
                    b.setSelectionner(false);
                }
            }

            // supprimmer l'ensemble de blocs
            this.trouveEnsemble(bloc, 3);
            this.gravite_y();
            this.gravite_x();
            
            // calculs du score
            int points = (int) Math.pow(this.ordreGraphe - 2, 2);
            this.frame.setScore(this.frame.getScore() + points);
            this.frame.setTitle("Score : " + this.frame.getScore() + " | " + this.frame.getTitre());
        }
        this.conditionFinPartie();
            
        // actualise la fenetre
        vue.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.trouveEnsemble(bloc, 1);
    }

    @Override
    public void mouseExited(MouseEvent e) { // quand le joueur quitte une zone d'un ensemble de blocs
        this.trouveEnsemble(bloc, 2);
    }

    private int[] trouverIndices(Bloc bloc) {
        for (int x = 0; x < this.grille.length; x++) {
            for (int y = 0; y < this.grille[x].length; y++) {
                if (this.grille[x][y] == bloc) {
                    return new int[]{x, y};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private void trouveEnsemble(Bloc bloc, int mode) {
        // cette méthode sert a reperer, selectionner, deselectionner, compter l'ordre ou encore supprimer un ensemble par parcours en largeur 
        if (mode == 3) {
            this.ordreGraphe = 0;
        } 
        if (mode == 1 || mode == 4) {
            this.ordreGrapheSelect = 0;
        }
        this.ordreGraphe = 0;
        this.ordreGrapheSelect = 0;
        if (bloc == null) return;
        Image couleur = bloc.getCouleur();
        Queue<Bloc> queue = new LinkedList<>();
        boolean[][] blocVisiter = new boolean[grille.length][grille[0].length];
        int[] indices = trouverIndices(bloc);
        int i = indices[0];
        int j = indices[1];
        if (i == -1 || j == -1) return;
        queue.add(grille[i][j]);
        blocVisiter[i][j] = true;
        while (!queue.isEmpty()) {
            Bloc blocTemp = queue.poll();
            // selon le mode il sert a supprimer, selectionner, deselectionner l'ensemble a travers chaque blocs
            if (mode == 1) { 
                if (!blocTemp.getSupprimer()) {
                    blocTemp.setSelectionner(true);
                    this.ordreGrapheSelect++;
                }
            } else if (mode == 2) { 
                blocTemp.setSelectionner(false);
            } else if (mode == 3) { 
                this.ordreGraphe++;
                blocTemp.setSupprimer(true);
                blocTemp.setSelectionner(false);
            } else if (mode == 4) {
                this.ordreGrapheSelect++;
            }
            indices = trouverIndices(blocTemp);
            i = indices[0];
            j = indices[1];

            // recherche des voisins en respectent les regles du jeu
            if (i > 0 && !blocVisiter[i - 1][j] && grille[i - 1][j].getCouleur().equals(couleur) && !grille[i - 1][j].getSupprimer()) {
                queue.add(grille[i - 1][j]);
                blocVisiter[i - 1][j] = true;
            }
            if (i < grille.length - 1 && !blocVisiter[i + 1][j] && grille[i + 1][j].getCouleur().equals(couleur) && !grille[i + 1][j].getSupprimer()) {
                queue.add(grille[i + 1][j]);
                blocVisiter[i + 1][j] = true;
            }
            if (j > 0 && !blocVisiter[i][j - 1] && grille[i][j - 1].getCouleur().equals(couleur) && !grille[i][j - 1].getSupprimer()) {
                queue.add(grille[i][j - 1]);
                blocVisiter[i][j - 1] = true;
            }
            if (j < grille[0].length - 1 && !blocVisiter[i][j + 1] && grille[i][j + 1].getCouleur().equals(couleur) && !grille[i][j + 1].getSupprimer()) {
                queue.add(grille[i][j + 1]);
                blocVisiter[i][j + 1] = true;
            }
        }
        
        // actualise la fenetre
        vue.repaint();
    }

    private void gravite_y() { // gère la gravité selon la colonne
        for (int j = 0; j < grille[0].length; j++) { 
            int positionVide = grille.length - 1; 
            for (int i = grille.length - 1; i >= 0; i--) {
                if (!grille[i][j].getSupprimer()) { 
                    grille[positionVide][j].setCouleur(grille[i][j].getCouleur());
                    grille[positionVide][j].setSupprimer(false);
                    grille[positionVide][j].setSelectionner(false);
                    positionVide--;
                }
            }
            for (int i = positionVide; i >= 0; i--) {
                grille[i][j].setSupprimer(true);
                grille[i][j].setSelectionner(false);
            }
        }
        vue.repaint();
    }

    public  boolean[]  colonneVide() { // repère les colonne vide dde la grille
        boolean[] colonnesVides = new boolean[grille[0].length];
        for (int j = 0; j < grille[0].length; j++) { 
            boolean estVide = true; 

            for (int i = 0; i < grille.length; i++) { 
                if (!grille[i][j].getSupprimer()) {
                    estVide = false;
                    break;
                }
            }
            colonnesVides[j] = estVide; 
        }
        return colonnesVides; 
    }

    private void gravite_x() { // gère la gravité en lignes, mofifié selon les règles du jeu
        boolean[] colonnesVides = colonneVide(); 
        int nbColonnes = grille[0].length; 
        int positionVide = 0; 
        for (int j = 0; j < nbColonnes; j++) {
            if (!colonnesVides[j]) { 
                
                if (j != positionVide) { 
                    for (int i = 0; i < grille.length; i++) {
                        // change les propriété des blocs
                        grille[i][positionVide].setCouleur(grille[i][j].getCouleur());
                        grille[i][positionVide].setSupprimer(grille[i][j].getSupprimer());
                        grille[i][positionVide].setSelectionner(grille[i][j].estSelectionner());
                    }
                }
                positionVide++; 
            }
        }

        for (int j = positionVide; j < nbColonnes; j++) {
            for (int i = 0; i < grille.length; i++) {
                grille[i][j].setSupprimer(true); 
                grille[i][j].setSelectionner(false); 
            }
        }

        // actualise la fenetre
        vue.repaint(); 
    }

    public void conditionFinPartie() {
        boolean toutesCasesSupprimees = true;
        boolean allBlocSeul = true;
    
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                if (!grille[i][j].getSupprimer()) {
                    toutesCasesSupprimees = false;
                    this.trouveEnsemble(grille[i][j], 4);
    
                    // Si on trouve un ensemble de taille >1, on peut quitter cette condition
                    if (this.ordreGrapheSelect > 1) {
                        allBlocSeul = false;
                    }
                }
            }
        }
    
        // Vérifier si la grille est vide ou si tous les blocs restants sont seuls
        if (toutesCasesSupprimees || allBlocSeul) {
            this.frame.setEstFin(true);
            this.frame.setEstJeu(false);
            this.frame.setEstJeu2(false);
            this.frame.updateView();
        }
    }
    
}
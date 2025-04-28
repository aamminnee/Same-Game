import java.awt.BorderLayout;


public class JeuAleatoire extends Jeu {


    public JeuAleatoire(String titre) {
        super(titre);
        // initialisation de la grille
        Grille grille = new Grille();
        for (Bloc[] ligne : grille.getGrille()) {
            for (Bloc bloc : ligne) {
                ControlleurGrille controlleur = new ControlleurGrille(grille, bloc, this);
                bloc.addMouseListener(controlleur);
            }
        }
        this.add(grille, BorderLayout.CENTER);
    }
    
}

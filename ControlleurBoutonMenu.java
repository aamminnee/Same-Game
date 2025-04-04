// importation des module java
import java.awt.event.*;

public class ControlleurBoutonMenu implements MouseListener { // sert a controller les differents bouton des diffferents menu

    // PREND LA FENETRE DU JEU EN ARGUEMNT
    private Fenetre frame;

    public ControlleurBoutonMenu(Fenetre fenetre) {
        this.frame = fenetre;   
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        BoutonMenu source = (BoutonMenu)e.getSource();
        String text = source.getText();
        // condition pour identifier les differents boutons du jeu et mettre les ifferents attribits de la class Fenetre  via ses setteurs
        switch(text) {
            case "Rejouer":
                frame.setEstAcceuil(false);
                frame.setEstAcceuil2(true);
                frame.setEstRegle(false);
                frame.setEstJeu(false);
                frame.setEstJeu2(false);
                frame.setEstFin(false);
                frame.setScore(0);
                break;
            case "Charger":
                frame.setEstAcceuil(false);
                frame.setEstAcceuil2(false);
                frame.setEstRegle(false);
                frame.setEstJeu(false);
                frame.setEstJeu2(true);
                frame.setEstFin(false);
                break;
            case "Jeux":
                frame.setEstAcceuil(true);
                frame.setEstAcceuil2(true);
                frame.setEstRegle(false);
                frame.setEstJeu(false);
                frame.setEstFin(false);
                break;
            case "Règles":
                frame.setEstAcceuil(false);
                frame.setEstAcceuil2(false);
                frame.setEstRegle(true);
                frame.setEstJeu(false);
                frame.setEstFin(false);
                break;
            case "Quitter":
                frame.setEstAcceuil(false);
                frame.setEstAcceuil2(false);
                frame.setEstRegle(false);
                frame.setEstJeu(false);
                frame.setEstFin(true);
                System.exit(0);
                break;
            case "Jouer":
                frame.setEstAcceuil(false);
                frame.setEstAcceuil2(false);
                frame.setEstRegle(false);
                frame.setEstJeu(true);
                frame.setEstFin(false);
                break;
            case "Retour":
                frame.setEstAcceuil(true);
                frame.setEstAcceuil2(false);
                frame.setEstRegle(false);
                frame.setEstJeu(false);
                frame.setEstFin(false);
                break;
        }
        
        this.frame.updateView();
    }


    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}

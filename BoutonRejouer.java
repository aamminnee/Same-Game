import java.awt.event.*;


public class BoutonRejouer implements MouseListener {

    private FinJeu frame;

    public BoutonRejouer(FinJeu frame) {
        this.frame = frame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Acceuil2 nouveauJeu = new Acceuil2(this.frame.getTitre());
        nouveauJeu.setVisible(true);
        this.frame.dispose();
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

import java.awt.event.*;
import javax.swing.*;

public class BoutonRetour implements MouseListener {

    private JFrame frame;

    public BoutonRetour(JFrame fenetre) {
        this.frame = fenetre;   
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Acceuil1 acceuil1 = new Acceuil1("Accueil");
        acceuil1.setVisible(true);
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

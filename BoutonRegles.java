import java.awt.event.*;
import javax.swing.*;

public class BoutonRegles implements MouseListener {

    private JFrame frame;

    public BoutonRegles(JFrame fenetre) {
        this.frame = fenetre;   
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Regles regles = new Regles(this.frame.getTitle());
        regles.setVisible(true);
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

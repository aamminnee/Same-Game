import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

public class BoutonJouerAleatoire implements MouseListener {

    private JFrame frame;

    public BoutonJouerAleatoire(JFrame fenetre) {
        this.frame = fenetre;   
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        JeuAleatoire jeuAleatoire = new JeuAleatoire(this.frame.getTitle());
        jeuAleatoire.setVisible(true);
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

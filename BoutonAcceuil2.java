import java.awt.event.*;

public class BoutonAcceuil2 implements MouseListener {

    private Acceuil1 frame;

    public BoutonAcceuil2(Acceuil1 fenetre) {
        this.frame = fenetre;   
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Acceuil2 acceuil2 = new Acceuil2(this.frame.getTitre());
        acceuil2.setVisible(true);
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

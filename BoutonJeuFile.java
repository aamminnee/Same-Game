import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

public class BoutonJeuFile implements MouseListener {
    
    private Acceuil2 acceuil;
    
    public BoutonJeuFile(Acceuil2 acceuil) {
        this.acceuil = acceuil;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        try {
            JeuFile jeuFile = new JeuFile(this.acceuil.getTitre(), this.acceuil);
            jeuFile.setVisible(true);
            this.acceuil.dispose(); // Fermer Acceuil2 après création réussie
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                this.acceuil,
                "Erreur lors de l'ouverture du fichier : " + ex.getMessage(),
                "Erreur",
                JOptionPane.ERROR_MESSAGE
            );
            // Ne pas créer de nouvelle Acceuil2 ici
        }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {}
    
}

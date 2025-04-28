import javax.swing.*;

public class Jeu extends JFrame {

    private String titre;
    private int score;
    
    public Jeu(String titre) {
        this.titre = titre;
        this.score = 0;
        this.setSize(1080, 720);
        this.setTitle("Same Game");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public String getTitre() {
        return titre;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class Applet1 extends Applet {
    public Applet1() {
        this.setBackground(Color.BLACK);
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(50, 50, 50, 50);
    }
}
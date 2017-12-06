import java.applet.Applet;
import java.awt.*;

public class Trifle extends Applet {
    private String lighthouse = "";

    public void init() {
        setBackground(Color.black);
        setForeground(Color.green);
        lighthouse += "--init--";
    }

    public void start() {
        lighthouse += " --start-- ";
    }

    public void stop() {
        lighthouse += " --stop-- ";
    }

    public void destroy() {
        lighthouse += " --destroy-- ";
    }

    public void paint(Graphics graphics) {
        lighthouse += "--paint--";
        graphics.drawString(lighthouse, 100, 50);
    }
}

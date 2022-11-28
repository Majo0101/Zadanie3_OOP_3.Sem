import javax.swing.*;
import java.awt.*;

public class Application extends JPanel  {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 400;


    Application() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
    }
}

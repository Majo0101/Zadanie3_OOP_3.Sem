import javax.swing.*;
import java.awt.*;

public class Application extends JPanel  {
    static final int SCREEN_WIDTH = 400;
    static final int SCREEN_HEIGHT = 700;
    AppText text;
    AppImages img;
    JButton submit;
    JTextField search;

    Application(){
        text = new AppText();
        img = new AppImages();
        submit = new JButton();
        search = new JTextField(10);

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.add(submit);
        this.add(search);
    }

    public void kk(){

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);

        img.drawBackground(g, true);
        text.drawTitle(g, "Bratislava");
        text.drawTime(g);
        text.drawTemp(g, "2");
        text.drawTempMinus(g);
        text.drawHum(g, "65%");
        text.drawSun(g, "Low");
        text.drawStatus(g, "SNOW");
        img.drawHum(g);
        img.drawSun(g);
        img.drawIcon(g, 2);
    }


}

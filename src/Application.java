import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

// TODO JPanel
public class Application extends JPanel{
    static final int SCREEN_WIDTH = 400;    // App width
    static final int SCREEN_HEIGHT = 700;   // App height
    AppText text;       // Texts
    AppImages img;      // Graphic
    Connection connect;     // API call
    JButton submit;     // Button
    JTextField search;      // TextField

    Application(){
        text = new AppText();
        img = new AppImages();
        submit = new JButton();
        search = new JTextField(10);
        connect = new Connection();

        // TODO JPanel settings
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));  // Set Height and Width
        this.setBackground(Color.black);    // Set Background
        this.setFocusable(true);
        this.setLayout(null);   // Remove Layout
        this.add(submit);   // Add button to JPanel
        this.add(search);   // Add TextField to JPanel

        // TODO Button settings
        submit.setBounds(310, 320, 40, 40);
        submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submit.setOpaque(false);
        submit.setContentAreaFilled(false);
        submit.setBorderPainted(false);
        try{
            submit.setIcon(new ImageIcon(img.searchB()));
        }catch (IOException e){
            e.printStackTrace();
        }

        // TODO TextField settings
        search.setBounds(50, 320, 260, 40);
        search.setOpaque(false);
        search.setBorder(null);
        search.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 26));
        search.setForeground(Color.WHITE);
        search.setCaretColor(Color.WHITE);
        search.putClientProperty("caretWidth", 3);

        // TODO Submit button action listener
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                connect.connect(search.getText());      // Send Location to api
                search.setText("");     // Reset TextField
                repaint();      // Repaint
            }
        });
    }

    // TODO Paint Graphics
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // TODO AntiAliasing ON
        Graphics2D g2 = (Graphics2D)g;
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHints(rh);

        // TODO Paint
        img.drawBackground(g, connect.getNight());  // Background

        text.drawTitle(g, connect.getLocation());   // Location
        text.drawTime(g);   // Local date
        text.drawTemp(g, connect.getTemperature());     // Temperature
        if (connect.getLowTemp()){      // Show Minus if temperature < 0
            text.drawTempMinus(g);
        }
        text.drawHum(g, connect.getHumidity() + "%");   // Humidity
        text.drawSun(g, connect.getSunIntensity());     // Sun intensity
        text.drawStatus(g, connect.getWeatherText());   // Weather text

        img.drawHum(g);     // Humidity icon
        img.drawSun(g);     // Sun icon
        img.drawIcon(g, connect.getWeatherNum());   // Weather icon
        img.drawLine(g);    // Draw line
    }

    @Override
    public String toString() {
        return "Application{}";
    }
}

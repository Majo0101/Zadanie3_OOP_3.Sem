import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Application extends JPanel{
    static final int SCREEN_WIDTH = 400;
    static final int SCREEN_HEIGHT = 700;
    AppText text;
    AppImages img;
    Connection connect;
    JButton submit;
    JTextField search;

    Application(){
        text = new AppText();
        img = new AppImages();
        submit = new JButton();
        search = new JTextField(10);
        connect = new Connection();

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setLayout(null);
        this.add(submit);
        this.add(search);

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

        search.setBounds(50, 320, 260, 40);
        search.setOpaque(false);
        search.setBorder(null);
        search.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 26));
        search.setForeground(Color.WHITE);
        search.setCaretColor(Color.WHITE);
        search.putClientProperty("caretWidth", 3);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("mnaaau");
                try {
                    connect.connect();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println(search.getText());
                search.setText("");
                repaint();
            }
        } );
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
        text.drawTemp(g, "25");
        text.drawTempMinus(g);
        text.drawHum(g, "65%");
        text.drawSun(g, "Low");
        text.drawStatus(g, "SNOW");

        img.drawHum(g);
        img.drawSun(g);
        img.drawIcon(g, 2);
        img.drawLine(g);
    }

    @Override
    public String toString() {
        return "Application{}";
    }
}

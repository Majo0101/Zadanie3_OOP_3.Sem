import javax.swing.*;

public class WeatherFrame extends JFrame{

    Application app = new Application();
    ImageIcon icon = new ImageIcon("cloud-rain.png");

    public WeatherFrame(){
        this.add(app);
        this.setTitle("Weather 1.0");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setIconImage(icon.getImage());
    }
}


import javax.swing.*;

// TODO Main frame object
public class WeatherFrame extends JFrame{

    Application app = new Application();    // JPanel create
    ImageIcon icon = new ImageIcon("cloud-rain.png");   // Load Icon from source directory

    public WeatherFrame(){
        this.add(app);  // Add app
        this.setTitle("Weather 1.0");   // Set name
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Set close operation
        this.setResizable(false);   // Resizable window false
        this.pack();
        this.setVisible(true);  // Set visible true
        this.setLocationRelativeTo(null);   // Location false
        this.setIconImage(icon.getImage());     // Set image Icon
    }

    @Override
    public String toString() {
        return "WeatherFrame{}";
    }
}

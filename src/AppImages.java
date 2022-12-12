import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// TODO Graphic
public class AppImages {

    public AppImages() {
    }

    // Image
    private BufferedImage backgroundDay() throws IOException {
        return ImageIO.read(new File("Day.png"));
    }

    // Image
    private BufferedImage backgroundNight() throws IOException {
        return ImageIO.read(new File("Night.png"));
    }

    // Image
    private BufferedImage hum() throws IOException {
        return ImageIO.read(new File("hum.png"));
    }

    // Image
    private BufferedImage sun() throws IOException {
        return ImageIO.read(new File("sun.png"));
    }

    // Image Weather icon
    private BufferedImage snowW() throws IOException {
        return ImageIO.read(new File("snow.png"));
    }

    // Image Weather icon
    private BufferedImage sunW() throws IOException {
        return ImageIO.read(new File("sunB.png"));
    }

    // Image Weather icon
    private BufferedImage stormW() throws IOException {
        return ImageIO.read(new File("storm.png"));
    }

    // Image Weather icon
    private BufferedImage fogW() throws IOException {
        return ImageIO.read(new File("fog.png"));
    }

    // Image Weather icon
    private BufferedImage cloudW() throws IOException {
        return ImageIO.read(new File("cloud.png"));
    }

    // Image Weather icon
    private BufferedImage rainW() throws IOException {
        return ImageIO.read(new File("rain.png"));
    }

    // Image Weather icon
    private BufferedImage moonW() throws IOException {
        return ImageIO.read(new File("moon.png"));
    }

    // Image Search icon
    BufferedImage searchB() throws IOException {
        return ImageIO.read(new File("search.png"));
    }

    // Graphics rectangle
    public void drawLine(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(30,365,340,2);
    }

    // TODO Swap background function
    public void drawBackground(Graphics g, Boolean dayOff){
        if (dayOff){
            try {
                g.drawImage(backgroundNight().getScaledInstance(400, -1, Image.SCALE_SMOOTH), 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            try {
                g.drawImage(backgroundDay().getScaledInstance(400, -1, Image.SCALE_SMOOTH), 0, 0, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO Draw Hum icon
    public void drawHum(Graphics g) {
        try{
            g.drawImage(hum(), 220, 647, null);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // TODO Draw Sun icon
    public void drawSun(Graphics g){
        try{
            g.drawImage(sun(), 310, 647, null);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // TODO Swap weather icon
    public void drawIcon(Graphics g, int num){
        switch (num){
            case 1:
                try{
                    g.drawImage(snowW(), 250, 510, null);
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 2:
                try{
                    g.drawImage(sunW(), 250, 510, null);
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 3:
                try{
                    g.drawImage(stormW(), 250, 510, null);
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 4:
                try{
                    g.drawImage(fogW(), 250, 510, null);
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 5:
                try{
                    g.drawImage(cloudW(), 250, 510, null);
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 6:
                try{
                    g.drawImage(rainW(), 250, 510, null);
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
            case 7:
                try{
                    g.drawImage(moonW(), 250, 510, null);
                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "AppImages{}";
    }
}

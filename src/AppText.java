import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppText {

    public AppText() {
    }

    public void drawTitle(Graphics g, String text){
        g.setColor(Color.white);
        g.setFont(new Font("DejaVu Sans", Font.BOLD, 36));
        int textWidth = g.getFontMetrics().stringWidth(text);
        g.drawString(text, 200 - textWidth/2, 100);
    }

    public void drawTime(Graphics g){
        Date date = new Date();
        SimpleDateFormat dayText = new SimpleDateFormat("EEEE, ");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        SimpleDateFormat monthText = new SimpleDateFormat("MMM ");

        String str = dayText.format(date).substring(0,1).toUpperCase() +
                dayText.format(date).substring(1) +
                monthText.format(date).substring(0,1).toUpperCase() +
                monthText.format(date).substring(1) +
                month.format(date);

        g.setColor(Color.white);
        g.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
        int textWidth = g.getFontMetrics().stringWidth(str);
        g.drawString(str, 200 - textWidth/2, 130);
    }

    public void drawTemp(Graphics g, String temp){
        g.setColor(Color.white);

        g.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 90));
        int textWidth = g.getFontMetrics().stringWidth(temp);
        g.drawString(temp, 50 , 660);

        g.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
        g.drawString("°C", 50 + textWidth,600);
    }

    public void drawTempMinus(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 90));
        g.drawString("-", 25,650);
    }

    public void drawHum(Graphics g, String hum){
        g.setColor(Color.white);
        g.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 16));
        g.drawString(hum, 240,660);
    }

    public void drawSun(Graphics g, String text){
        g.setColor(Color.white);
        g.setFont(new Font("DejaVu Sans Light", Font.PLAIN, 16));
        g.drawString(text, 330,660);
    }

    public void drawStatus(Graphics g, String text){
        g.setColor(Color.white);
        g.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
        int textWidth = g.getFontMetrics().stringWidth(text);
        g.drawString(text, 290 - textWidth/2,630);
    }

}

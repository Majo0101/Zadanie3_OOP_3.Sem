import com.google.gson.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

// TODO Get data from API
public class Connection {

    // TODO Weather enumeration
    private enum Weather{
        SNOW (1),
        SUN (2),
        STORM(3),
        FOG(4),
        CLOUD(5),
        RAIN(6),
        MOON(7);

        private final int number;

        Weather(int number){
            this.number = number;
        }

        public int getResponse() {
            return number;
        }
    }

    private Boolean Night;
    private String location;
    private String temperature;
    private Boolean lowTemp;
    private String humidity;
    private String sunIntensity;
    private String weatherText;
    private int weatherNum;

    public Connection() {
        Night = false;
        this.location = "Enter location";
        this.temperature = "00";
        this.lowTemp = false;
        this.humidity = "00";
        this.sunIntensity = "Low";
        this.weatherText = "Nothing";
        this.weatherNum = Weather.FOG.getResponse();
    }

    // TODO Parse JSON API
    void connect(String Location){
        URLConnection request = null;
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
            request = url.openConnection();
            request.connect();
        } catch (Exception e) {
            System.out.println("Chyba");
        }

        try{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            assert request != null;
            JsonElement root =jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject obj = gson.fromJson(root, JsonObject.class);

            System.out.println(obj.get("id").toString());
            location = obj.get("id").toString();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    // TODO Getters and Setters
    public Boolean getNight() {
        return Night;
    }

    public void setNight(Boolean night) {
        Night = night;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Boolean getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(Boolean lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getSunIntensity() {
        return sunIntensity;
    }

    public void setSunIntensity(String sunIntensity) {
        this.sunIntensity = sunIntensity;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    public int getWeatherNum() {
        return weatherNum;
    }

    public void setWeatherNum(int weatherNum) {
        this.weatherNum = weatherNum;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "Night=" + Night +
                ", location='" + location + '\'' +
                ", temperature='" + temperature + '\'' +
                ", lowTemp=" + lowTemp +
                ", humidity='" + humidity + '\'' +
                ", sunIntensity='" + sunIntensity + '\'' +
                ", weatherText='" + weatherText + '\'' +
                ", weatherNum=" + weatherNum +
                '}';
    }
}

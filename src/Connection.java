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

    private final static String API_KEY = ;
    private Boolean Night;
    private String location;
    private String temperature;
    private Boolean lowTemp;
    private String humidity;
    private String sunIntensity;
    private String weatherText;
    private int weatherNum;

    public Connection() {
        this.Night = false;
        this.location = "Enter location";
        this.temperature = "00";
        this.lowTemp = false;
        this.humidity = "00";
        this.sunIntensity = "Low";
        this.weatherText = "Nothing";
        this.weatherNum = Weather.FOG.getResponse();
    }

    // TODO Parse JSON API
    void connect(String location){

        URLConnection request = null;
        Gson gson;
        JsonParser jsonParser;

        // TODO Try download JSON via REST API
        try {
            URL url = new URL("http://api.weatherapi.com/v1/current.json?key=" + API_KEY + "&q=" + location + "&aqi=no");
            request = url.openConnection();
            request.connect();
        } catch (Exception e) {
            this.Night = false;
            this.location = "Fog in the data";
            this.temperature = "00";
            this.lowTemp = false;
            this.humidity = "00";
            this.sunIntensity = "Low";
            this.weatherText = "FOG";
            this.weatherNum = Weather.FOG.getResponse();
        }

        // TODO Try parse JSON not for daily or commercial use
        try{
            gson = new GsonBuilder().setPrettyPrinting().create();
            jsonParser = new JsonParser();
            assert request != null;

            JsonElement data =jsonParser.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject obj = gson.fromJson(data, JsonObject.class);

            JsonObject locationJson = gson.fromJson(obj.get("location"), JsonObject.class);
            JsonObject currentJson = gson.fromJson(obj.get("current"), JsonObject.class);
            JsonObject conditionJson = gson.fromJson(currentJson.get("condition"), JsonObject.class);

//            this.Night = currentJson.get("is_day").getAsInt() == 0;
            this.location = locationJson.get("name").getAsString();
            int temp = currentJson.get("temp_c").getAsInt();

            if (temp < 0){
                this.lowTemp = true;
                String tmp = Integer.toString(temp);
                this.temperature = tmp.substring(1);
            }else{
                this.lowTemp = false;
                this.temperature = Integer.toString(temp);
            }

            this.humidity = currentJson.get("humidity").getAsString();
            this.sunIntensity = "Low";
            this.weatherText = conditionJson.get("text").getAsString();

            this.weatherNum = Weather.FOG.getResponse();

            // TODO Worst part of code
            switch (conditionJson.get("code").getAsInt()){
                case 1000:
                case 1003:
//                    if (currentJson.get("is_day").getAsInt() == 0){
//                        this.weatherNum = Weather.MOON.getResponse();
//                    }else{
//                        this.weatherNum = Weather.SUN.getResponse();
//                    }
                    break;
                case 1063:
                case 1276:
                case 1273:
                case 1246:
                case 1243:
                case 1240:
                case 1201:
                case 1195:
                case 1192:
                case 1198:
                case 1189:
                case 1286:
                case 1283:
                case 1280:
                case 1171:
                case 1168:
                    this.weatherNum = Weather.RAIN.getResponse();
                    break;
                case 1237:
                case 1279:
                case 1264:
                case 1261:
                case 1258:
                case 1255:
                case 1252:
                case 1249:
                case 1225:
                case 1222:
                case 1219:
                case 1216:
                case 1210:
                case 1213:
                case 1114:
                case 1066:
                    this.weatherNum = Weather.SNOW.getResponse();
                    break;
                case 1135:
                case 1147:
                    this.weatherNum = Weather.FOG.getResponse();
                    break;
                case 1087:
                    this.weatherNum = Weather.STORM.getResponse();
                    break;
                default:
                    this.weatherNum = Weather.CLOUD.getResponse();
                    break;
            }

            System.out.println(gson.toJson(obj));
        }catch (IOException e){
            this.Night = false;
            this.location = "Fog in the data";
            this.temperature = "00";
            this.lowTemp = false;
            this.humidity = "00";
            this.sunIntensity = "Low";
            this.weatherText = "FOG";
            this.weatherNum = Weather.FOG.getResponse();
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

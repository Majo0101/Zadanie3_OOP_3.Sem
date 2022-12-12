import com.google.gson.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Connection {

    void connect() throws IOException {
        URLConnection request = null;
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
            request = url.openConnection();
            request.connect();
        } catch (Exception e) {
            System.out.println("Chyba");
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        assert request != null;
        JsonElement root =jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject obj = gson.fromJson(root, JsonObject.class);

        System.out.println(obj.get("id").toString());




    }
}

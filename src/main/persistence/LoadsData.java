package persistence;

import model.Driver;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class LoadsData {
    // requires: the 'filePath' should refer to a JSON file with driver data
    // effects: returns a list of Driver

    private final String filePath;

    public LoadsData(String filePath) {
        this.filePath = filePath;
    }

    public List<Driver> loadsDriverData() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONArray array = new JSONArray(data);

        List<Driver> drivers = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            Driver driver = new Driver(
                    object.getString("name"),
                    object.getString("team"),
                    object.getString("country"),
                    object.getInt("points"),
                    object.getInt("racewins"),
                    object.getInt("topthrees"),
                    object.getInt("polepositions"),
                    object.getInt("fastestlaps")
            );
            drivers.add(driver);
        }
        return drivers;

    }
}

package persistence;

import model.Driver;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class SavesData {

    private final String filePath;

    public SavesData(String filePath) {
        this.filePath = filePath;
    }
    // requires: the list of Driver cannot be null
    // modifies: this
    // effects: saves the data of the drivers from the list to the JSON file

    public void savesDriverData(List<Driver> drivers) throws IOException {
        JSONArray array = new JSONArray();
        for (Driver driver : drivers) {
            JSONObject object = new JSONObject();
            object.put("name", driver.getName());
            object.put("team", driver.getTeam());
            object.put("country", driver.getCountry());
            object.put("points", driver.getPoints());
            object.put("racewins", driver.getRacewins());
            object.put("topthrees", driver.getTopthrees());
            object.put("polepositions", driver.getPolepositions());
            object.put("fastestlaps", driver.getFastestlaps());
            array.put(object);
        }
        String data = array.toString();
        Files.write(Paths.get(filePath), data.getBytes());
    }
}

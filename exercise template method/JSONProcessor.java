import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class JSONProcessor extends DataProcessor {

    private List<Map<String, String>> records;

    @Override
    protected void load() {
        System.out.println("Loading JSON data...");
        records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.json"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("{") && (line.endsWith("},") || line.endsWith("}"))) {
                    // remove curly braces and comma
                    line = line.substring(1, line.length() - (line.endsWith("},") ? 2 : 1)).trim();
                    Map<String, String> record = new HashMap<>();
                    String[] pairs = line.split(",");
                    for (String pair : pairs) {
                        String[] kv = pair.split(":");
                        String key = kv[0].trim().replaceAll("\"", "");
                        String value = kv[1].trim().replaceAll("\"", "");
                        record.put(key, value);
                    }
                    records.add(record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void transform() {
        System.out.println("Transforming JSON data (adding timestamp)...");
        String timestamp = LocalDateTime.now().toString();
        for (Map<String, String> record : records) {
            record.put("timestamp", timestamp);
        }
    }

    @Override
    protected void save() {
        System.out.println("Saving JSON data...");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.json"))) {
            bw.write("[\n");
            for (int i = 0; i < records.size(); i++) {
                Map<String, String> record = records.get(i);
                bw.write("  {");
                int j = 0;
                for (Map.Entry<String, String> entry : record.entrySet()) {
                    bw.write("\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"");
                    if (j < record.size() - 1) bw.write(",");
                    j++;
                }
                bw.write("}");
                if (i < records.size() - 1) bw.write(",");
                bw.write("\n");
            }
            bw.write("]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean validateData() {
        System.out.println("Validating JSON data...");
        return records != null && !records.isEmpty(); // simple validation
    }
}

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessor extends DataProcessor {

    // Store CSV data in a field
    private List<String[]> rows;

    @Override
    protected void load() {
        System.out.println("Loading CSV data...");
        rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("input.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                rows.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void transform() {
        System.out.println("Transforming CSV data (to uppercase)...");
        for (String[] row : rows) {
            for (int i = 0; i < row.length; i++) {
                row[i] = row[i].toUpperCase();
            }
        }
    }

    @Override
    protected void save() {
        System.out.println("Saving CSV data...");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"))) {
            for (String[] row : rows) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean validateData() {
        System.out.println("Validating CSV data...");
        return rows != null && !rows.isEmpty(); // simple validation
    }
}

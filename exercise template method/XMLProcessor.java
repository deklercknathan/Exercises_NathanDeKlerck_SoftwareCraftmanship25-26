import java.io.*;

public class XMLProcessor extends DataProcessor {

    private String data;

    @Override
    protected void load() {
        System.out.println("Loading XML data...");
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("input.xml"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        data = sb.toString();
    }

    @Override
    protected void transform() {
        System.out.println("Transforming XML data (making content uppercase)...");
        // Very simple transformation: uppercase all letters
        data = data.toUpperCase();
    }

    @Override
    protected void save() {
        System.out.println("Saving XML data...");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.xml"))) {
            bw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean validateData() {
        System.out.println("Validating XML data...");
        // Simple validation: check if file contains "<" and ">"
        return data.contains("<") && data.contains(">");
    }
}

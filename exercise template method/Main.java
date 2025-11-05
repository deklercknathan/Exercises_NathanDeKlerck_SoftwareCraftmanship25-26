public class Main {
    public static void main(String[] args) {
        // CSV processing
        DataProcessor csvProcessor = new CSVProcessor();
        csvProcessor.process();

        // JSON processing
        DataProcessor jsonProcessor = new JSONProcessor();
        jsonProcessor.process();

        // XML processing
        DataProcessor xmlProcessor = new XMLProcessor();
        xmlProcessor.process();
    }
}

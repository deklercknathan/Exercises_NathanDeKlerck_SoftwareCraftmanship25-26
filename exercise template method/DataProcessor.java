public abstract class DataProcessor {

    public final void process() {
        load();
        if (validateData()) { 
            transform();
            save();
        } else {
            System.out.println("Data validation failed. Aborting process.");
        }
    }

    protected abstract void load();
    protected abstract void transform();
    protected abstract void save();

    protected boolean validateData() {
        return true; 
    }
}

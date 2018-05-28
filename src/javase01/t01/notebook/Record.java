package javase01.t01.notebook;

/**
 * The {@code Record} represents record in {@link Notebook}
 */
public class Record {

    private String value;

    public Record(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
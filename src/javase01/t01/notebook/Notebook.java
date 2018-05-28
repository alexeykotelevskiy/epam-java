package javase01.t01.notebook;

import java.util.Arrays;
import oracle.jrockit.jfr.Recording;

/**
 * The {@code Notebook} represents a dynamically expandable notebook, which contains {@link Record}.
 */
public class Notebook {
    /**
     * default size for an array of {@link Record}
     */
    private final static int DEFAULT_SIZE = 4;
    /**
     * Current size for an array of {@link Record}
     */
    private int size;

    /**
     * Inner array, which contains records
     */
    private Record[] values;

    public Notebook() {
        values = new Record[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * Expands the {@link Notebook#values} by 25%
     */
    private void grow() {
        int newSize = (int) (values.length * 1.25);
        values = Arrays.copyOf(values, newSize);
    }

    /**
     * Shrinks the {@link Notebook#values} by 25%
     */
    private void shrink() {
        if (values.length <= DEFAULT_SIZE) {
            return;
        }
        int newSize = (int) (values.length * 0.75);
        values = Arrays.copyOf(values, newSize);
    }

    /**
     * Adds a new string to the end of notebook.
     * Invoke {@link Notebook#grow} if the new element does not fit into the notepad.
     *
     * @param s the string to be added
     */
    public void append(String s) {
        if (size == values.length) {
            grow();
        }
        values[size++] = new Record(s);
    }


    /**
     * Removes element from a notepad.
     * Invoked {@link Notebook#shrink}, if half or more than half of the array is free
     *
     * @param key index of element
     * @return deleted item
     * @throws IndexOutOfBoundsException
     */
    public Record remove(int key) throws IndexOutOfBoundsException {
        if (key >= size) {
            throw new IndexOutOfBoundsException();
        }
        Record ret = values[key];
        for (int i = key; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        if (size <= values.length / 2) {
            shrink();
        }
        return ret;
    }


    /**
     * Edit the notepad item by index.
     *
     * @param key item's index
     * @param s   new string
     * @return updated item
     * @throws IndexOutOfBoundsException
     */
    public Record edit(int key, String s) throws IndexOutOfBoundsException {
        if (key >= size) {
            throw new IndexOutOfBoundsException();
        }
        values[key].setValue(s);
        return values[key];
    }

    /**
     * Displays indexes and notepad records.
     */
    public void showAllRecords() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + values[i]);
        }
    }
}
package javase01.t01.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import javase01.t01.notebook.*;

public class Task6 {
    public static void main(String[] args) throws IOException {
        Notebook nb = new Notebook();
        final String pkg = nb.getClass().getPackage().toString();
        System.out.println(
                "Welcome to " + pkg + "!"
                        + "\nSupported commands:"
                        + "\n\tappend\n<key>"
                        + "\n\tedit \n<key>\n<value>"
                        + "\n\tremove\n<key>"
                        + "\n\tshow"
                        + "\n\tquit");
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String cmd;
            int key;
            String val;
            while (!"quit".equals(cmd = reader.readLine().trim())) {
                if (cmd.isEmpty()) {
                    continue;
                }

                switch (cmd) {
                case "append":
                    val = reader.readLine();
                    nb.append(val);
                    break;

                case "remove":
                    key = Integer.parseInt(reader.readLine());
                    try {
                        nb.remove(key);
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    break;
                case "show":
                    nb.showAllRecords();
                    break;
                case "edit":
                    key = Integer.parseInt(reader.readLine());
                    val = reader.readLine();
                    try {
                        nb.edit(key, val);
                    } catch (IndexOutOfBoundsException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.err.println("Unsupported command: " + cmd);
                }
                System.out.println();
            }

        }
    }
}
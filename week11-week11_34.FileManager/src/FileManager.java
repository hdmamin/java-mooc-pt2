
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {

    public List<String> read(String name) throws FileNotFoundException {
        File file = new File(name);
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> lines = new ArrayList<String>();
        
        while (reader.hasNextLine()) {
            lines.add(reader.nextLine());
        }
        
        return lines;
    }

    public void save(String name, String text) throws IOException {
        FileWriter writer = new FileWriter(name);
        writer.write(text);
        writer.close();
    }

    public void save(String name, List<String> text) throws IOException {
        FileWriter writer = new FileWriter(name, true);
        for (String line:text) {
            writer.write(line + "\n");
        }
        writer.close();
    }
}

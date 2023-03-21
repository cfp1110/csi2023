import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        String inputFilename = "input.txt";
        String outputFilename = "output.txt";
        
        // Create a map to store the word counts
        Map<String, Integer> wordCounts = new HashMap<>();
        
        // Read the input file and count the words
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.toLowerCase();
                int count = wordCounts.getOrDefault(word, 0);
                wordCounts.put(word, count + 1);
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            System.exit(1);
        }
        
        // Write the word counts to the output file
        try (FileWriter writer = new FileWriter(outputFilename)) {
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                String word = entry.getKey();
                int count = entry.getValue();
                writer.write(word + " " + count + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
            System.exit(1);
        }
    }
}

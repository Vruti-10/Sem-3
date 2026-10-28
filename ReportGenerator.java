
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportGenerator {

    public static void generate(Path logsFolder) throws IOException {

        int totalFiles = 0;
        int totalTransactions = 0;

        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(logsFolder)) {

            for (Path file : stream) {

                if (!Files.isRegularFile(file)) {
                    continue;
                }

                totalFiles++;

                try (BufferedReader reader = Files.newBufferedReader(
                        file, StandardCharsets.UTF_8)) {

                    String line;

                    while ((line = reader.readLine()) != null) {
                        if (!line.trim().isEmpty()) {
                            totalTransactions++;
                            System.out.println(
                                file.getFileName() + ": " + line
                            );
                        }
                    }
                }
            }
        }

        System.out.println("\n===== END OF DAY REPORT =====");
        System.out.println("Log files processed: " + totalFiles);
        System.out.println("Total transactions: " + totalTransactions);
    }
}

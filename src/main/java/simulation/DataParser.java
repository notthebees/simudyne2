package simulation;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import static simulation.Breed.C;
import static simulation.Breed.NC;

public class DataParser {
    public List<Agent> parse(File file) throws IOException {
        List<CSVRecord> records = parseCSV(file);
        removeHeaderLine(records);

        return records.stream()
                .map(record -> {
                    if (record.get(0).equals("Breed_C")) {
                        return new Agent(C);
                    } else {
                        return new Agent(NC);
                    }
                })
                .collect(Collectors.toList());
    }

    private void removeHeaderLine(List<CSVRecord> records) {
        records.remove(0);
    }

    private List<CSVRecord> parseCSV(File file) throws IOException {
        Reader in = new FileReader(file);
        CSVParser csvParser = new CSVParser(in, CSVFormat.DEFAULT);
        return csvParser.getRecords();
    }
}

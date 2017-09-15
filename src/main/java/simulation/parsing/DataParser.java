package simulation.parsing;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import simulation.agent.Agent;
import simulation.agent.Breed;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static simulation.agent.Breed.C;
import static simulation.agent.Breed.NC;

public class DataParser {
    public List<Agent> parse(File file) throws IOException {
        List<CSVRecord> records = parseCSV(file);
        removeHeaderLine(records);

        return records.stream()
                .map(record -> {
                    Breed breed = record.get(0).equals("Breed_C") ? C : NC;
                    int socialGrade = parseInt(record.get(3));
                    int paymentAtPurchase = parseInt(record.get(4));
                    double attributeBrand = parseDouble(record.get(5));
                    double attributePrice = parseDouble(record.get(6));
                    double attributePromotions = parseDouble(record.get(7));
                    boolean autoRenew = record.get(8).equals("1");
                    int inertiaForSwitch = parseInt(record.get(9));

                    return new Agent(breed, socialGrade, paymentAtPurchase, attributeBrand, attributePrice,
                            attributePromotions, autoRenew, inertiaForSwitch);
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

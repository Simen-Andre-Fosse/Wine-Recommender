package sample;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class creates a list of the countries which the drinks comes from.
 *
 */
public class countryList {

        private static final String myCSV = "viner.csv";
        private ArrayList<String> countries = new ArrayList<>();

        public void main() throws IOException {
            List<String> list = new ArrayList<>();

            try (
                    Reader reader = Files.newBufferedReader(Paths.get(myCSV));
                    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
            ) {
                for (CSVRecord csvRecord : csvParser) {
                    String country = csvRecord.get(12);
                    list.add(country);

                }

            }

            List<String> newlist = list.stream()
                    .distinct()
                    .collect(Collectors.toList());
            newlist.remove(0);
            //System.out.println(newlist);
            countries.addAll(newlist);
        }

    public ArrayList<String> getCountryList() throws IOException {
            main();
            return countries;
    }
}


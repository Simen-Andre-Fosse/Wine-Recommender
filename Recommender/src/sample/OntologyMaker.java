package sample;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.ontology.*;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDF;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 * Class for making the ontology model.
 * Our Queries are also inn here.
 *
 */

public class OntologyMaker {

    //Feltene
    private  final String CSV_FILE_PATH = "viner.csv";
    private  ArrayList<String> countries = new ArrayList<>();
    private  OntModel owlModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF);
    private  String base;
    private  String prefixes;


    //
    public void createOwlModel () throws IOException {

        updateCountries();

        base = "http://www.w3.org/2000/01/rdf-schema#";
        prefixes = ""
                + "PREFIX ex: <" + base + "> "
                + "PREFIX owl: <" + OWL.getURI() + "> ";
        ModelFactory
                .createDefaultModel();
        List list = new ArrayList<>();

        // lager properties
        DatatypeProperty hasVareNummer = owlModel.createDatatypeProperty(base + "hasVareNummer"); //data
        DatatypeProperty hasVolum = owlModel.createDatatypeProperty(base + "hasVolum");            //data
        DatatypeProperty hasPrice = owlModel.createDatatypeProperty(base + "hasPrice"); //data
        DatatypeProperty hasLiterPris = owlModel.createDatatypeProperty(base + "hasLiterPris"); //data
        ObjectProperty hasType = owlModel.createObjectProperty(base + "hasType");
        ObjectProperty hasFarge = owlModel.createObjectProperty(base + "hasFarge");
        DatatypeProperty hasLukt = owlModel.createDatatypeProperty(base + "hasLukt"); //data
        DatatypeProperty hasSmak = owlModel.createDatatypeProperty(base + "hasSmak");  //data
        ObjectProperty hasCountry = owlModel.createObjectProperty(base + "hasCountry");
        DatatypeProperty hasAlkohol = owlModel.createDatatypeProperty(base + "hasAlkohol"); //data
        ObjectProperty hasProducer = owlModel.createObjectProperty(base + "hasProdusent");
        ObjectProperty hasEmbalasjeType = owlModel.createObjectProperty(base + "hasEmbalasjetype");
        DatatypeProperty hasKorkType = owlModel.createDatatypeProperty(base + "hasKorktype"); //data
        DatatypeProperty hasURL = owlModel.createDatatypeProperty(base + "hasURL"); //data
        DatatypeProperty matSomPasserTil = owlModel.createDatatypeProperty(base + "matSomPasserTil");
        DatatypeProperty matSomPasserTil2 = owlModel.createDatatypeProperty(base + "matSomPasserTil2");
        DatatypeProperty matSomPasserTil3 = owlModel.createDatatypeProperty(base + "matSomPasserTil3");


        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String vareNummer = csvRecord.get(0);
                String vareNavn = csvRecord.get(1).replace(' ', '+'); // bytter ut mellomrom med ' + '
                String volum = csvRecord.get(2);
                String pris = csvRecord.get(3);
                String literPris = csvRecord.get(4);
                String vareType = csvRecord.get(5);
                String farge = csvRecord.get(6);
                String lukt = csvRecord.get(7);
                String smak = csvRecord.get(8);
                String passerTil = csvRecord.get(9);
                String passerTilTo = csvRecord.get(10);
                String passerTilTre = csvRecord.get(11);
                String land = csvRecord.get(12);
                String alkohol = csvRecord.get(13);
                String produsent = csvRecord.get(14);
                String embalasjeType = csvRecord.get(16);
                String vareUrl = csvRecord.get(17);
                String ecoFriendly = csvRecord.get(17);


                //lager individer
                Individual Wine = owlModel.createIndividual(base + vareNavn, OWL.Thing);
                Individual Country = owlModel.createIndividual(base + countries.toString(), OWL.Thing);

                // må lage properties utenfor loop
                hasVareNummer.addProperty(RDF.type, OWL.TransitiveProperty);
                hasVolum.addProperty(RDF.type, OWL.TransitiveProperty);
                hasPrice.addProperty(RDF.type, OWL.TransitiveProperty);
                hasLiterPris.addProperty(RDF.type, OWL.TransitiveProperty);
                hasType.addProperty(RDF.type, OWL.TransitiveProperty);
                hasFarge.addProperty(RDF.type, OWL.TransitiveProperty);
                hasLukt.addProperty(RDF.type, OWL.TransitiveProperty);
                hasSmak.addProperty(RDF.type, OWL.TransitiveProperty);
                hasCountry.addProperty(RDF.type, OWL.TransitiveProperty);
                hasAlkohol.addProperty(RDF.type, OWL.TransitiveProperty);
                hasProducer.addProperty(RDF.type, OWL.TransitiveProperty);
                hasEmbalasjeType.addProperty(RDF.type, OWL.TransitiveProperty);
                hasKorkType.addProperty(RDF.type, OWL.TransitiveProperty);
                hasURL.addProperty(RDF.type, OWL.TransitiveProperty);
                matSomPasserTil.addProperty(RDF.type, OWL.TransitiveProperty);
                matSomPasserTil2.addProperty(RDF.type, OWL.TransitiveProperty);
                matSomPasserTil3.addProperty(RDF.type, OWL.TransitiveProperty);





                Wine.addProperty(hasVareNummer,vareNummer,XSDDatatype.XSDinteger);
                Wine.addProperty(hasVolum,volum,XSDDatatype.XSDinteger);
                Wine.addProperty(hasPrice, pris,XSDDatatype.XSDinteger);
                Wine.addProperty(hasCountry, land);
                Wine.addProperty(hasLiterPris,literPris,XSDDatatype.XSDinteger);
                Wine.addProperty(hasType,vareType);
                Wine.addProperty(hasFarge, farge);
                Wine.addProperty(hasLukt, lukt);
                Wine.addProperty(hasSmak,smak);
                Wine.addProperty(hasAlkohol,alkohol,XSDDatatype.XSDinteger);
                Wine.addProperty(hasProducer, produsent);
                Wine.addProperty(hasEmbalasjeType, embalasjeType);
                Wine.addProperty(hasURL, vareUrl);
                Wine.addProperty(matSomPasserTil, passerTil);
                Wine.addProperty(matSomPasserTil2, passerTilTo);
                Wine.addProperty(matSomPasserTil3,passerTilTre);


            }

            //owlModel.write(System.out, "TURTLE");
        }
    }

    public ArrayList<QuerySolution> getAll() throws IOException {
        ArrayList<QuerySolution> qResults = new ArrayList<>();
        createOwlModel();
        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris  WHERE {"
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();


            while(resultSet.hasNext()) {
                QuerySolution qs = resultSet.next();
                qResults.add(qs);
            }

            return qResults;
    }

    public ArrayList<QuerySolution> getAllRed() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ex:hasType \"rødvin\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();

        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }

    public ArrayList<QuerySolution>  ost() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Ost\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();

        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }

    public ArrayList<QuerySolution>  fisk() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Fisk\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();



        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }

    public ArrayList<QuerySolution>  skallDyr() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Skalldyr\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();


        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }

    public ArrayList<QuerySolution> gronnsaker() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"grønnsaker\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();


        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }



    public ArrayList<QuerySolution>  lam() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Lam og sau\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();

        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }

    public ArrayList<QuerySolution>  storfe() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Storfe\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();

        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }


    public ArrayList<QuerySolution>  dessert() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Dessert. kake. frukt\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();

        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }

    public ArrayList<QuerySolution>  storvilt() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Storvilt\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();

        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }




    public ArrayList<QuerySolution>  aperitiff() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Aperitiff/avec\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();


        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }



    public ArrayList<QuerySolution>  svinekjott() throws IOException {
        ArrayList<QuerySolution> qsResult = new ArrayList<>();
        createOwlModel();



        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + prefixes
                        + "SELECT ?navn ?farge ?type ?pris WHERE {"
                        + " ?navn ?p \"Svinekjøtt\" ."
                        + " ?navn ex:hasFarge ?farge ."
                        + " ?navn ex:hasType ?type ."
                        + " ?navn ex:hasPrice ?pris "
                        + "}", owlModel)
                .execSelect();

        while(resultSet.hasNext()) {
            QuerySolution qs = resultSet.next();
            qsResult.add(qs);
        }

        return qsResult;

    }



    private void updateCountries() throws IOException {
        countryList def = new countryList();
        countries = def.getCountryList();

    }


}
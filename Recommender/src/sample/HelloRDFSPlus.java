package sample;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.vocabulary.OWL;


public class HelloRDFSPlus {
    HelloRDFSPlus() {

        String base = "http://ex.org/info216#";
        String prefixes = ""
                + "PREFIX ex: <" + base + "> "
                + "PREFIX owl: <" + OWL.getURI() + "> ";

        OntModel owlModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF);

        UpdateAction.parseExecute(prefixes
                + "INSERT DATA {"
                + "    ex:INFO310 ex:buildsOn ex:INFO216 . "
                + "    ex:INFO216 ex:buildsOn ex:INFO116 . "
                + "    ex:INFO116 ex:buildsOn ex:INFO100 . "
                + "    ex:buildsOn a owl:TransitiveProperty . "
                + "}", owlModel);

        owlModel.getWriter("TURTLE").write(owlModel, System.out, "base");
        System.out.print("hello");
    }
}
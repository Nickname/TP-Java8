package java8.ex03;

import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.List;

/**
 * Exercice 03 - ForEach
 */
public class Lambda_03_Test {

    // tag::PersonProcessor[]
    interface PersonProcessor<I> {
        void process(I p);
    }
    // end::PersonProcessor[]

    // tag::forEach[]
    private <I> void forEach(List<I> source, PersonProcessor<I> processor) {
    		for (I i : source) {
        		processor.process(i);
    		}
    }
    // end::forEach[]


    // tag::test_verify_person[]
    @Test
    public void test_verify_person() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO vérifier qu'une personne à un prénom qui commence par first
        // TODO vérifier qu'une personne à un nom qui commence par last
        // TODO vérifier qu'une personne à un age > 0
        // TODO la vérification se fait via une assertion (mot clé assert)
        PersonProcessor<Person> verifyPerson = p -> {
        		assert p.getFirstname().startsWith("first");
        		assert p.getLastname().startsWith("last");
        		assert p.getAge() > 0;
        };

        assert verifyPerson != null;
        
        forEach(personList, verifyPerson);
    }
    // end::test_verify_person[]

}

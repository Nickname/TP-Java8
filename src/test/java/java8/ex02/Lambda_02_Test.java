package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

    // tag::PersonToAccountMapper[]
    interface PersonToAccountMapper<I, O> {
        O map(I t);
    }
    // end::PersonToAccountMapper[]

    // tag::map[]
    private <I, O> List<O> map(List<I> personList, PersonToAccountMapper<I, O> mapper) {
        // TODO implémenter la méthode pour transformer une liste de personnes en liste de comptes
    		List<O> map = new ArrayList<O>();
    		
    		for (I p : personList) {
    			map.add(mapper.map(p));
    		}
    		
        return map;
    }
    // end::map[]


    // tag::test_map_person_to_account[]
    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de comptes
        // TODO tous les objets comptes ont un solde à 100 par défaut
        List<Account> result = map(personList, person -> {
        		Account acc = new Account();
        		acc.setBalance(100);
        		acc.setOwner(person);
        	
        		return acc;
        });

        assert result.size() == personList.size();
        for (Account account : result) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de prénoms
        List<String> result = map(personList, person -> {
        		return person.getFirstname();
        });

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
    // end::test_map_person_to_firstname[]
}

package com.halfacode.ecommerce.countryTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.halfacode.ecommerce.country.Country;
import com.halfacode.ecommerce.country.CountryRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback
public class CountryRepositoryTest {

	@Autowired
	private CountryRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewCountry() {
		
		Country saveCountry= repo.save(new Country("sudan"));
		assertNotNull(saveCountry);
		assertTrue(saveCountry.getId() > 0);
	}
	
	@Test
	public void testList() {
		entityManager.persist(new Country("sudan"));
		entityManager.persist(new Country("UEA"));
		entityManager.persist(new Country("Suadia"));
		
		List<Country> listCountry= (List<Country>) repo.findAll();
		for(Country country : listCountry) {
			System.out.println(country.getName());
		}
		
		
	}
}

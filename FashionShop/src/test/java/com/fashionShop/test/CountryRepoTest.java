package com.fashionShop.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(locations = "classpath:test.properties")
public class CountryRepoTest {
	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewCountry() {
		Country saveCountry = countryRepo.save(new Country("Vietnam"));
		
		assertNotNull(saveCountry);
		assertTrue(saveCountry.getId() > 0);
	}
	
	@Test
	public void testList() {
		entityManager.persist(new Country("Vietnam"));
		entityManager.persist(new Country("United States"));
		entityManager.persist(new Country("Japan"));
		
		List<Country> listCountries = (List<Country>) countryRepo.findAll();
		
		for (Country country : listCountries) {
			System.out.println(country.getName());
		}
		
		assertThat(listCountries).isNotEmpty();
	}
}

package pet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.Matchers.containsInAnyOrder;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet pet1;
	VirtualPet pet2;
	
	@Before
	public void setUp(){
		underTest = new VirtualPetShelter();
		pet1 = new VirtualPet("Fido", "Sort of peculiar looking", 50, 60, 70);
		pet2 = new VirtualPet("Rex", "A bit mangy", 40, 20, 60);
	}
	
	@Test
	public void shouldBeAbleToAddPet() {
		underTest.addPet(pet1);
		VirtualPet retrievedPet = underTest.findPet(pet1.getName());
		assertThat(retrievedPet, is(pet1));
	}
	
	@Test
	public void shouldBeAbleToAddTwoPets() {
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(pet2, pet1));
		assertEquals(2, allPets.size(), 0);
	}
	
	@Test
	public void shouldBeAbleToRemovePet() {
		underTest.addPet(pet1);
		underTest.adoptPet(pet1);
		VirtualPet retrievedPet = underTest.findPet(pet1.getName());
		assertThat(retrievedPet, is(nullValue()));
	}
	
	@Test
	public void shouldBeAbleToFeedAllPets() {
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		int pet1HungerBefore = pet1.getHunger();
		int pet2HungerBefore = pet2.getHunger();
		int feedAmount = 20;
		underTest.feedAllPets(feedAmount);
		int pet1HungerAfter = pet1.getHunger();
		int pet2HungerAfter = pet2.getHunger();
		assertEquals(pet1HungerAfter, pet1HungerBefore - feedAmount, 0);
		assertEquals(pet2HungerAfter, pet2HungerBefore - feedAmount, 0);		
	}
	
	@Test
	public void shouldBeAbleToWaterAllPets() {
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		int pet1ThirstBefore = pet1.getThirst();
		int pet2ThirstBefore = pet2.getThirst();
		int waterAmount = 10;
		underTest.waterAllPets(waterAmount);
		int pet1HungerAfter = pet1.getThirst();
		int pet2HungerAfter = pet2.getThirst();
		assertEquals(pet1HungerAfter, pet1ThirstBefore - waterAmount, 0);
		assertEquals(pet2HungerAfter, pet2ThirstBefore - waterAmount, 0);		
	}
	
	@Test
	public void shouldBeAbleToPlayWithOnePet() {
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		int playAmount = 20;
		int pet2BoredomBefore = pet2.getBoredom();
		underTest.playWithOnePet(pet2.getName(), playAmount);
		int pet2BoredomAfter = pet2.getBoredom();
		assertEquals(pet2BoredomAfter, pet2BoredomBefore - playAmount, 0);
	}
	
	@Test
	public void hungerShouldIncreaseWhenTickAllPets() {
		underTest.addPet(pet1);
		underTest.addPet(pet2);
		int pet2HungerBefore = pet2.getHunger();
		underTest.tickAllPets();
		int pet2HungerAfter = pet2.getHunger();
		assertTrue(pet2HungerAfter > pet2HungerBefore);
	}
	
}

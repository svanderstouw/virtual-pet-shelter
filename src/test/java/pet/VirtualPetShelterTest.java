package pet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
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
		pet2 = new VirtualPet("Rex", "A bit mangy", 40, 20, 10);
	}
	
	@Test
	public void shouldBeAbleToAddPet() {
		underTest.add(pet1);
		VirtualPet retrievedPet = underTest.findPet(pet1.getName());
		assertThat(retrievedPet, is(pet1));
	}
	
	@Test
	public void shouldBeAbleToAddTwoPets() {
		underTest.add(pet1);
		underTest.add(pet2);
		Collection<VirtualPet> allPets = underTest.getAllPets();
		assertThat(allPets, containsInAnyOrder(pet2, pet1));
		assertEquals(2, allPets.size(), 0);
	}
	
	@Test
	public void shouldBeAbleToRemovePet() {
		underTest.add(pet1);
		underTest.remove(pet1);
		VirtualPet retrievedPet = underTest.findPet(pet1.getName());
		assertThat(retrievedPet, is(nullValue()));
	}
	
}

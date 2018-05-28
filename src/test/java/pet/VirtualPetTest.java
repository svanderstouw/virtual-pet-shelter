package pet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetTest {
	
	VirtualPet underTest;
	
	@Before
	
	public void setUp() {
		underTest = new VirtualPet("Fido", "Sort of peculiar looking", 50, 60, 70);
	}
	
	
	@Test
	public void getPetName() {
		String name = underTest.getName();
		assertEquals("", "Fido", name);
	}
	
	@Test
	public void getPetDescription() {
		String description = underTest.getDescription();
		assertEquals("", "Sort of peculiar looking", description);
	}
	
	@Test
	public void feedPet() {
		int beforeFeeding = underTest.getHunger();
		int feedAmount = 25;
		underTest.feed(feedAmount);
		int afterFeeding = underTest.getHunger();
		assertEquals(afterFeeding, beforeFeeding - feedAmount, 0);
	}
	
	@Test
	public void waterPet() {
		int beforeWatering = underTest.getThirst();
		int waterAmount = 25;
		underTest.water(waterAmount);
		int afterWatering = underTest.getThirst();
		assertEquals(afterWatering, beforeWatering - waterAmount, 0);
	}
	
	@Test
	public void playWithPet() {
		int beforePlaying = underTest.getBoredom();
		int playAmount = 25;
		underTest.play(playAmount);
		int afterPlaying = underTest.getBoredom();
		assertEquals(afterPlaying, beforePlaying - playAmount, 0);
	}
	
	@Test
	public void hungerIncreasesWithTick() {
		int hungerBeforeTick = underTest.getHunger();
		underTest.tick();
		int hungerAfterTick = underTest.getHunger();
		assertTrue(hungerAfterTick > hungerBeforeTick);
	}
	
	
	
	
	
	
	
	
}

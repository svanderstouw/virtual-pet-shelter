package pet;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

	Map<String, VirtualPet> pets = new HashMap<String, VirtualPet>();

	public void addPet(VirtualPet pet) {
		pets.put(pet.getName(), pet);
	}

	public VirtualPet findPet(String petName) {
		return pets.get(petName);
	}
	
	public String formatPetName(String originalName) {
		String lowerCasePetName = originalName.toLowerCase();
		String firstLetter = lowerCasePetName.substring(0, 1);
		firstLetter = firstLetter.toUpperCase();
		String restOfName = lowerCasePetName.substring(1);
		return firstLetter + restOfName;
	}

	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public void adoptPet(VirtualPet pet) {
		pets.remove(pet.getName(), pet);
	}

	public void feedAllPets(int feedAmount) {
		Collection<VirtualPet> allPets = pets.values();
		for (VirtualPet pet : allPets) {
			pet.feed(feedAmount);
		}
	}

	public void waterAllPets(int waterAmount) {
		Collection<VirtualPet> allPets = pets.values();
		for (VirtualPet pet : allPets) {
			pet.water(waterAmount);
		}
	}

	public void playWithOnePet(String petName, int playAmount) {
		VirtualPet retrievedPet = pets.get(petName);
		retrievedPet.play(playAmount);
	}

	public void tickAllPets() {
		Collection<VirtualPet> allPets = pets.values();
		for (VirtualPet pet : allPets) {
			pet.tick();
		}
	}

	public void showPetStats() {
		Collection<VirtualPet> allPets = pets.values();
		System.out.println("This is the status of your dogs:");
		System.out.println();
		System.out.println("Name \t\t |Hunger \t |Thirst \t |Boredom");
		System.out.println("-----------------|---------------|---------------|---------------");
		for (VirtualPet pet : allPets) {
			System.out.println(pet.toString());
		}
	}

	public void showPetDescriptions() {
		Collection<VirtualPet> allPets = pets.values();
		System.out.println();
		for (VirtualPet pet : allPets) {
			System.out.println(pet.descriptionsToString());
		}
	}
}

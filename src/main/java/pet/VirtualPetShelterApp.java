package pet;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class VirtualPetShelterApp {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String menuChoice = "0";
		VirtualPetShelter myShelter = new VirtualPetShelter();
		VirtualPet pet1 = new VirtualPet("Snoopy", " likes to sleep on top of his doghouse.", 75, 43, 10);
		VirtualPet pet2 = new VirtualPet("Odie", " has a large tongue and slobbers alot.", 25, 82, 38);
		VirtualPet pet3 = new VirtualPet("Pluto", " likes to play with rodents.", 51, 14, 65);
		VirtualPet pet4 = new VirtualPet("Astro", " really seems to understand English.", 49, 34, 27);
		myShelter.addPet(pet1);
		myShelter.addPet(pet2);
		myShelter.addPet(pet3);
		myShelter.addPet(pet4);

		System.out.println("Thank you for volunteering at the Animated Dog Shelter!");

		while (!menuChoice.equals("6")) {
			System.out.println();
			myShelter.showPetStats();
			System.out.println();
			System.out.println("What would you like to do next?");
			System.out.println();
			System.out.println("1. Feed the dogs");
			System.out.println("2. Water the dogs");
			System.out.println("3. Play with a dog");
			System.out.println("4. Adopt a dog");
			System.out.println("5. Admit a new dog");
			System.out.println("6. Quit");
			System.out.print("> ");

			menuChoice = input.nextLine();
			switch (menuChoice) {
			case "1":
				System.out.println();
				System.out.println("Would you like to feed them a 1) Small Meal or 2) Big Meal?");
				System.out.print("> ");
				String mealChoice = input.nextLine();
				myShelter.tickAllPets();
				if (mealChoice.equals("2")) {
					myShelter.feedAllPets(50);
					System.out.println("You fed them a Big Meal.");
				} else {
					myShelter.feedAllPets(25);
					System.out.println("You fed them a Small Meal.");
				}			
				break;
			case "2":
				System.out.println();
				myShelter.tickAllPets();
				myShelter.waterAllPets(60);
				System.out.println("You watered the dogs.");			
				break;
			case "3":
				System.out.println();
				System.out.println("You'd like to play with a dog.");
				myShelter.showPetDescriptions();
				System.out.println();
				System.out.println("Which dog would you like to play with?");
				System.out.print("> ");
				String petName = input.nextLine();
				String formattedPetName = myShelter.formatPetName(petName);
				myShelter.tickAllPets();
				myShelter.playWithOnePet(formattedPetName, 100);
				System.out.println("You played with " + formattedPetName);				
				break;
			case "4":
				System.out.println();
				System.out.println("You'd like to adopt a dog.");
				myShelter.showPetDescriptions();
				System.out.println();
				System.out.println("Which dog would you like to adopt?");
				System.out.print("> ");
				petName = input.nextLine();
				formattedPetName = myShelter.formatPetName(petName);
				VirtualPet retrievedPet = myShelter.findPet(formattedPetName);
				myShelter.adoptPet(retrievedPet);
				System.out.println("You adopted " + formattedPetName + ".");
				myShelter.tickAllPets();
				break;
			case "5":
				System.out.println();
				System.out.println("You'd like to admit a new dog.  Please input the following information:");
				System.out.print("Dog's name: ");
				String newDogName = input.nextLine();
				String newDogNameFormatted = myShelter.formatPetName(newDogName);
				System.out.print("Fun fact about the dog: " + newDogNameFormatted + "... ");
				String newDogDescription = input.nextLine();
				newDogDescription = " " + newDogDescription;
				int newDogHunger = ThreadLocalRandom.current().nextInt(0, 91);
				int newDogThirst = ThreadLocalRandom.current().nextInt(0, 91);
				int newDogBoredom = ThreadLocalRandom.current().nextInt(0, 91);
				VirtualPet petNew = new VirtualPet(newDogNameFormatted, newDogDescription, newDogHunger, newDogThirst, newDogBoredom);
				myShelter.addPet(petNew);
				System.out.println(petNew.getName() + " is a new dog in the shelter.");
				myShelter.tickAllPets();
				break;
			}
		}
		System.out.println();
		System.out.println("Thank you for volunteering at the shelter!");
		input.close();
	}
}

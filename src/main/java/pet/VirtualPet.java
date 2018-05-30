package pet;

import java.util.concurrent.ThreadLocalRandom;

public class VirtualPet {
	
	private String name;
	private String description;
	private int hunger;
	private int hungerIncrease = 5;
	private int hungerMultiplier = ThreadLocalRandom.current().nextInt(1, 5);
	private int thirst;
	private int thirstIncrease = 4;
	private int thirstMultiplier = ThreadLocalRandom.current().nextInt(1, 5);
	private int boredom;
	private int boredomIncrease = 3;
	private int boredomMultiplier = ThreadLocalRandom.current().nextInt(1, 5);

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getHunger() {
		return hunger;
	}
	
	public int getThirst() {
		return thirst;
	}
	
	public int getBoredom() {
		return boredom;
	}
	
	public VirtualPet(String name, String description, int hunger, int thirst, int boredom) {
		this.name = name;
		this.description = description;
		this.hunger = hunger;
		this.thirst = thirst;
		this.boredom = boredom;
	}

	public void feed(int feedAmount) {
		hunger -= feedAmount;
		if (hunger < 0) {
			hunger = 0;
		}
	}

	public void water(int waterAmount) {
		thirst -= waterAmount;
		if (thirst < 0) {
			thirst = 0;
		}
	}

	public void play(int playAmount) {
		boredom -= playAmount;
		if (boredom < 0) {
			boredom = 0;
		}
	}

	public void tick() {
		hunger += hungerIncrease * hungerMultiplier;
		thirst += thirstIncrease * thirstMultiplier;
		boredom += boredomIncrease * boredomMultiplier;
	}

	public String toString() {
		return name + "\t\t |" + hunger + "\t\t |" + thirst + "\t\t |" + boredom;
	}
	
	public String descriptionsToString() {
		return name + description;
	}
}

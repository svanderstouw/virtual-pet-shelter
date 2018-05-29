# Virtual Pet Shelter Project

The application simulates taking care of pets in a shelter.

**VirtualPet Class**

Each VirtualPet has a name, brief description, and starting values for hunger, thrist and boredom.  The VirtualPet Class also generates a random multiplier for each value so that they increase by a different amount for each pet using their tick method.  It also has an overridden toString method that returns a string with the stats for that pet.

**VirtualPetShelter Class**

This class gathers the pets together in a HashMap.  It has methods that allow it to add a pet, find a pet, gather a collection of all of the pets, remove a pet, feed all of the pets, water all of the pets, play with an individual pet, advance the tick methods of all of the pets and show the stats for all of the pets.

**VirtualPetShelterApp Class**

This class interacts with the user on the console and provides feedback.  It sends the user instructions to the VirtualPetShelter Class.

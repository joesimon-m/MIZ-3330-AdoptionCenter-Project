package pets.model;

import java.util.HashSet;
import java.util.Set;

public class Shelter <T extends Pet>{
	private Set<T> pets;
	
	/** Constructor for the shelter
	 * 
	 */
	public Shelter() {
		this.pets = new HashSet<>();
	}
	
	/** Constructor for the shelter given a Set of pets
	 * 
	 * @param pets		Set of pets
	 */
	public Shelter(Set<T> pets) {
		this.pets = new HashSet<>(pets);
	}
	
	/** Adds a pet to the shelter
	 * 
	 * @param pet	pet to be added
	 * @return		true is returned if the pet was added, and false otherwise
	 */
	public boolean add(T pet) {
		return pets.add(pet);
	}
	
	/** Adds a set of pets to the shelter
	 * 
	 * @param pets	Set of pets to be added
	 */
	public void addSetOfPets(Set<T> pets) {
		this.pets.addAll(pets);
	}
	
	/** Removes a pet from the shelter
	 * 
	 * @param pet	pet to be removed
	 * @return		true is returned if the pet was successfully removed, and false otherwise
	 */
	public boolean remove(T pet) {
		return pets.remove(pet);
	}
	
	/** Gets the total set of pets 
	 * 
	 * @return	Set of pets in the shelter
	 */
	public Set<T> getAllPets() {
		return pets;
	}
	
}

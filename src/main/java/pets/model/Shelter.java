package pets.model;

import java.util.HashSet;
import java.util.Set;

public class Shelter <T extends Pet>{
	private Set<T> pets;
	
	public Shelter() {
		this.pets = new HashSet<>();
	}
	
	public Shelter(Set<T> pets) {
		this.pets = new HashSet<>(pets);
	}
	
	public boolean add(T pet) {
		return pets.add(pet);
	}
	
	public void addSetOfPets(Set<T> pets) {
		this.pets.addAll(pets);
	}
	
	public boolean remove(T pet) {
		return pets.remove(pet);
	}
	
	public Set<T> getAllPets() {
		return pets;
	}
	
}

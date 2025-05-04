package pets.model;

import java.util.Comparator;

public class PetAgeComparator implements Comparator<Pet> {

	/**
	 * 
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
	
}

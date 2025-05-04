package pets.model;

import java.util.Comparator;

public class PetAgeComparator implements Comparator<Pet> {

	/** Compares two pets by their age
	 * 
	 * @param o1 	First Pet to be compared
	 * @param o2	Second Pet to be compared
	 * @return		A negative value is returned if the age of o1 is less than o2, zero if they're the same, and a positive value if o1's age is greater than o2
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		return Integer.compare(o1.getAge(), o2.getAge());
	}
	
}

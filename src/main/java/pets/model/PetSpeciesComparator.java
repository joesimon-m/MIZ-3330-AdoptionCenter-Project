package pets.model;

import java.util.Comparator;

public class PetSpeciesComparator implements Comparator<Pet>{

	/** Compares two pets by their species
	 * 
	 * @param o1 	First Pet to be compared
	 * @param o2	Second Pet to be compared
	 * @return		A negative value is returned if the species of o1 is less than o2, zero if they're the same, and a positive value if o1's species is greater than o2
	 */
	@Override
	public int compare(Pet o1, Pet o2) {
		return o1.getSpecies().compareTo(o2.getSpecies());
	}
	
}

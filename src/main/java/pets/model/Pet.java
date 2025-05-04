package pets.model;

public abstract class Pet implements Comparable<Pet> {
	private String name;
	private int age;
	private String species;
	private boolean adopted;
	
	/** Constructor for the Pet class
	 * 
	 * @param name		String name of the pet
	 * @param species	String species for this pet
	 * @param age		int age of this pet
	 */
	public Pet(String name, String species, int age) {
		this.name = name;
		this.species = species;
		this.age = age;
		adopted = false;
	}

	/** Returns the name of this pet
	 * 
	 * @return			String name of this pet
	 */
	public String getName() {
		return name;
	}

	/** Sets the name of this pet
	 * 
	 * @param name		String name to be set to this pet's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Returns the age of this pet
	 * 
	 * @return			int age of this pet
	 */
	public int getAge() {
		return age;
	}

	/** Sets the age of this pet
	 * 
	 * @param age		int age to be set to this pet's age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/** Returns the species of this pet
	 * 
	 * @return			String species to be set to this pet's species variable
	 */
	public String getSpecies() {
		return species;
	}

	/** Sets the species of this pet
	 * 
	 * @param species	New string species of this pet
	 */
	public void setSpecies(String species) {
		this.species = species;
	}

	/** Returns the adopted status of this pet
	 * 
	 * @return 			boolean value indicated whether this pet is adopted or not 
	 */
	public boolean isAdopted() {
		return adopted;
	}

	
	/** Sets the adopted status of this pet
	 * 
	 * @param adopted	Sets the boolean value for this pet, indicating whether it has been adopted or not
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	/** Compares the names of the given pet class with this pet class (defaults to name)
	 * 
	 * @param o		Pet object to be compared with this object
	 * @return		negative integer, zero, or a positive integer depending on if this pet's name is less than, equal, or greater than the other pet's name
	 */
	@Override
	public int compareTo(Pet o) {
		return this.name.compareTo(o.name);
	}
	
	/** Compares each variable to see if each object is truly equal to each other
	 * 
	 * @param		Object to be compared
	 * @return		true if the given object is a Pet, and if it's equal to this Pet class (and false otherwise)
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pet) {
			return (this.name.equals(((Pet)obj).name)) && (this.species.equals(((Pet)obj).species)) && (this.age == ((Pet)obj).age) && (this.adopted == ((Pet)obj).adopted);
		} else {
			return false;
		}
	}
	
	/** Formats this pet if ever called
	 * 
	 * @return		String representation of this pet
	 */
	@Override
	public String toString() {
		return String.format("%s has the following qualities:\n\tAge: %d\n\tSpecies: %s\n\tAdopted: %s", name, age, species, adopted);
	}
}

package pets.model;

public class ExoticAnimal {

	private String uniqueId;
	private String animalName;
	private String subSpecies;
	private String category;
	private int yearsold;
	private boolean adopted;

	/** Constructor for the Exotic Animal
	 * 
	 * @param id		String id of the animal
	 * @param name		String name of the animal
	 * @param species	String species of the animal
	 * @param category	String category of the animal
	 * @param age		int age of the animal
	 */
	public ExoticAnimal(String id, String name, String species, String category, int age) {
		this.uniqueId = id;
		this.animalName = name;
		this.category = category;
		this.subSpecies = species;
		this.yearsold = age;
		adopted = false;
	}

	/** Returns the String ID of the animal to the user
	 * 
	 * @return	String value of this animal's ID
	 */
	public String getId() {
		return uniqueId;
	}

	/** Gives this animal a new String ID
	 * 
	 * @param id	New ID to be assigned to this animal
	 */
	public void setId(String id) {
		this.uniqueId = id;
	}

	/** Returns the name of this animal
	 * 
	 * @return	String name of this animal
	 */
	public String getName() {
		return animalName;
	}

	/** Sets the name of this animal to the given parameter
	 * 
	 * @param name	New String name to be given
	 */
	public void setName(String name) {
		this.animalName = name;
	}

	/** Returns the species of this animal
	 * 
	 * @return	String species of this animal
	 */
	public String getSpecies() {
		return subSpecies;
	}

	/** Sets the species for this animal
	 * 
	 * @param species	New String species to be assigned
	 */
	public void setSpecies(String species) {
		this.subSpecies = species;
	}

	/** Returns the age of this animal
	 * 
	 * @return	int age of this animal
	 */
	public int getAge() {
		return yearsold;
	}

	/** Sets the age of this animal
	 * 
	 * @param age	New age to be assigned
	 */
	public void setAge(int age) {
		this.yearsold = age;
	}

	/** Status returning whether this animal was adopted or not
	 * 
	 * @return	true if the animal has been adopted, and false otherwise
	 */
	public boolean isAdopted() {
		return adopted;
	}

	/** Sets the adopted status of this animal
	 * 
	 * @param adopted	True if this animal has been adopted, and false otherwise
	 */
	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	/** Returns the category of this animal (e.g. Reptile, Bird, etc.)
	 * 
	 * @return 	String category of this animal
	 */
	public String getCategory() {
		return category;
	}

	/** Sets the category for this animal
	 * 
	 * @param category	New String category for this animal
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
     * Returns a string representation of the exotic animal.
     * 
     * @return New formatted string for the exotic animal
     */
	@Override
	public String toString() {
		return String.format("%s has the following qualities:\n\tID: %s\n\tAge: %d\n\tCategory: %s\n\tSpecies: %s\n\tAdopted: %s", animalName, uniqueId, yearsold, category, subSpecies, adopted);
	}
}

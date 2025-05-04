package pets.model;

public class DogModel extends Pet {

	/** Creates a Dog, which is a type of Pet
	 * 
	 * @param id		int ID of the dog
	 * @param name		String name of the dog
	 * @param species	String species of the dog
	 * @param age		int age of the dog
	 */
	public DogModel(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

	/**
     * Returns a string representation of the dog.
     * 
     * @return 			String representation of the dog
     */
	@Override
	public String toString() {
		return String.format("Dog: %s"
				+ "n", super.toString());
	}
}

package pets.model;

public class CatModel extends Pet {

	/** Creates a cat as a type of pet
	 * 
	 * @param id		int ID of the cat
	 * @param name		String name of the cat
	 * @param species	String species of the cat
	 * @param age		int age of the cat
	 */
	public CatModel(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

	/**
     * Returns a string representation of the cat.
     * 
     * @return 			String representation, returning Cat, then the Pet's toString
     */
	@Override
	public String toString() {
		return String.format("Cat: %s\n", super.toString());
	}
}

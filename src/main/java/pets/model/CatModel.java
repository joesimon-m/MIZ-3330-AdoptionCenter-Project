package pets.model;

public class CatModel extends Pet {

	/**
	 * 
	 * @param id
	 * @param name
	 * @param species
	 * @param age
	 */
	public CatModel(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

	@Override
	public String toString() {
		return String.format("Cat: %s\n", super.toString());
	}
}

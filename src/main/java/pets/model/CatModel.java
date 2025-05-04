package pets.model;

public class CatModel extends Pet {

	public CatModel(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

	@Override
	public String toString() {
		return String.format("Cat: %s\n", super.toString());
	}
}

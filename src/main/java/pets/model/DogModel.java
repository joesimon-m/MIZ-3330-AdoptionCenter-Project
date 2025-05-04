package pets.model;

public class DogModel extends Pet {

	public DogModel(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

	@Override
	public String toString() {
		return String.format("Dog: %s"
				+ "n", super.toString());
	}
}

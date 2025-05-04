package pets.model;

public class RabbitModel extends Pet {

	public RabbitModel(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

	@Override
	public String toString() {
		return String.format("Rabbit: %s\n", super.toString());
	}
}

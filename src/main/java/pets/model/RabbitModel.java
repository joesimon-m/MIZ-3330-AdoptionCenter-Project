package pets.model;

public class RabbitModel extends Pet {

	/** Creates a rabbit as a type of pet
	 * 
	 * @param id		int ID of the rabbit
	 * @param name		String name of the rabbit
	 * @param species	String species of the rabbit
	 * @param age		int age of the rabbit
	 */
	public RabbitModel(int id, String name, String species, int age) {
		super(id, name, species, age);
	}

	/**
     * Returns a string representation of the rabbit.
     * 
     * @return 			String representation of the rabbit 
     */
	@Override
	public String toString() {
		return String.format("Rabbit: %s\n", super.toString());
	}
}

package pets.model;

public class ExoticAnimal {

	private int id;
	private String name;
	private String species;
	private String category;
	private int age;
	private boolean adopted;
	
	public ExoticAnimal(int id, String name, String species, int age, boolean adopted) {
		this.id = id;
		this.name = name;
		this.species = species;
		this.age = age;
		this.adopted = adopted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}

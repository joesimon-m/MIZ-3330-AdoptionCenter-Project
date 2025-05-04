package pets.model;

public class ExoticAnimal {

	private String uniqueId;
	private String animalName;
	private String subSpecies;
	private String category;
	private int yearsold;
	private boolean adopted;

	
	public ExoticAnimal(String id, String name, String species, String category, int age) {
		this.uniqueId = id;
		this.animalName = name;
		this.category = category;
		this.subSpecies = species;
		this.yearsold = age;
		adopted = false;
	}

	public String getId() {
		return uniqueId;
	}

	public void setId(String id) {
		this.uniqueId = id;
	}

	public String getName() {
		return animalName;
	}

	public void setName(String name) {
		this.animalName = name;
	}

	public String getSpecies() {
		return subSpecies;
	}

	public void setSpecies(String species) {
		this.subSpecies = species;
	}

	public int getAge() {
		return yearsold;
	}

	public void setAge(int age) {
		this.yearsold = age;
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

	@Override
	public String toString() {
		return String.format("%s has the following qualities:\n\tID: %s\n\tAge: %d\n\tCategory: %s\n\tSpecies: %s\n\tAdopted: %s", animalName, uniqueId, yearsold, category, subSpecies, adopted);
	}
}

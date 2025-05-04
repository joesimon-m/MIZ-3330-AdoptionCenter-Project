package pets.model;

public abstract class Pet implements Comparable<Pet> {
	private String name;
	private int age;
	private String species;
	private boolean adopted;
	
	public Pet(String name, String species, int age) {
		this.name = name;
		this.species = species;
		this.age = age;
		adopted = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public boolean isAdopted() {
		return adopted;
	}

	public void setAdopted(boolean adopted) {
		this.adopted = adopted;
	}
	
	@Override
	public int compareTo(Pet o) {
		return this.name.compareTo(o.name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pet) {
			return (this.name.equals(((Pet)obj).name)) && (this.species.equals(((Pet)obj).species)) && (this.age == ((Pet)obj).age) && (this.adopted == ((Pet)obj).adopted);
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s has the following qualities:\n\tAge: %d\n\tSpecies: %s\n\tAdopted: %s", name, age, species, adopted);
	}
	
}

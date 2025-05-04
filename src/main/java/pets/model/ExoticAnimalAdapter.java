package pets.model;

public class ExoticAnimalAdapter extends Pet{

	private ExoticAnimal exoticAnimal;
	
	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
		super(exoticAnimal.getId(), exoticAnimal.getName(), exoticAnimal.getSpecies(), exoticAnimal.getAge());
		this.exoticAnimal = exoticAnimal;
	}

}

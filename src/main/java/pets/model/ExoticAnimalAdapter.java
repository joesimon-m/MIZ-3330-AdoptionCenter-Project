package pets.model;

public class ExoticAnimalAdapter extends Pet{

	private ExoticAnimal exoticAnimal;
	
	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
		super(exoticAnimal.getId(), exoticAnimal.getName(), exoticAnimal.getSpecies(), exoticAnimal.getAge());
		this.exoticAnimal = exoticAnimal;
		setAdopted(exoticAnimal.isAdopted());
	}
	
	public ExoticAnimal getExoticAnimal() {
		return exoticAnimal;
	}
	
	public String getCategory() {
		return exoticAnimal.getCategory();
	}
	
	@Override
	public void setAdopted(boolean adopted) {
		super.setAdopted(adopted);
		exoticAnimal.setAdopted(adopted);
	}
	
	@Override
	public boolean isAdopted() {
		return super.isAdopted();
	}
	
	

}

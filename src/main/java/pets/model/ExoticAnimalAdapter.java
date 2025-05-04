package pets.model;

public class ExoticAnimalAdapter extends Pet{

	private ExoticAnimal exoticAnimal;
	
	/** Constructor for the ExoticAnimalAdaptor class
	 * 
	 * @param exoticAnimal	The ExoticAnimal to be adapted
	 */
	public ExoticAnimalAdapter(ExoticAnimal exoticAnimal) {
		super(Integer.parseInt(exoticAnimal.getId().substring(exoticAnimal.getId().length() - 3)), // Inside exotic_animals.json this is a string, so we have to get the 3 rightmost characters and parse them as an int 
				exoticAnimal.getName(), 
				exoticAnimal.getSpecies(), 
				exoticAnimal.getAge());
		this.exoticAnimal = exoticAnimal;
		setAdopted(exoticAnimal.isAdopted());
	}
	
	/** Returns the wrapped ExoticAnimal
	 * 
	 * @return	Wrapped ExoticAnimal
	 */
	public ExoticAnimal getExoticAnimal() {
		return exoticAnimal;
	}
	
	/** Gives the category of this animal
	 * 
	 * @return	String category of this animal
	 */
	public String getCategory() {
		return exoticAnimal.getCategory();
	}
	
	/** Gets an adoption status and sets that status within both the Pet class and the exoticAnimal class
	 * 
	 * @param adopted	boolean value indicating whether this animal is adopted or not
	 */
	@Override
	public void setAdopted(boolean adopted) {
		super.setAdopted(adopted);
		exoticAnimal.setAdopted(adopted);
	}
	
	/** Gives the adoption status of this animal
	 * 
	 * @return	boolean adoption status of this animal
	 */
	@Override
	public boolean isAdopted() {
		return super.isAdopted();
	}
}

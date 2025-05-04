package pets.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonImportAndExport {
	private static final Gson gson = new Gson();

	
	/** Goes through each animal in the exotic_animals.json file, stores them in a set, then returns that set to the user
	 * 
	 * @return				Set of Pets representing each exotic Animal
	 * @throws IOException	IOException if an error occurs within the reading process
	 */
	public static Set<Pet> loadExoticAnimals() throws IOException {
		InputStream input = JsonImportAndExport.class.getResourceAsStream("/exotic_animals.json");
		if (input == null) {
		    throw new FileNotFoundException("exotic_animals.json wasn't found");
		}
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
		    ExoticAnimal[] exoticAnimals = gson.fromJson(reader, ExoticAnimal[].class);
		    Set<Pet> exoticAnimalsToPets = new HashSet<>();
		    for (ExoticAnimal ea : exoticAnimals) {
		        exoticAnimalsToPets.add(new ExoticAnimalAdapter(ea));
		    }
		    return exoticAnimalsToPets;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw e;
		} 
	}
	
	/** Goes through each pet within the pets.json file and returns the total set of pets to the user
	 * 
	 * @return				Set of Pets containing each pet
	 * @throws IOException	IOException in the case where an error occurs within the reading process
	 */
	public static Set<Pet> loadPets() throws IOException {
	    Set<Pet> petSet = new HashSet<>();

	    try (BufferedReader reader = new BufferedReader(new InputStreamReader(
	            Objects.requireNonNull(JsonImportAndExport.class.getResourceAsStream("/pets.json"))))) {
	        JsonElement ele = JsonParser.parseReader(reader);
	        JsonArray arr = ele.getAsJsonArray();

	        // Go through each element within the json file to find all the characteristics of each pet, then call each pet's respective class
	        for (JsonElement element : arr) {
	            JsonObject obj = element.getAsJsonObject();
	            String type = obj.get("type").getAsString();

	            Pet pet = null;
	            int id = obj.get("id").getAsInt();
	            String name = obj.get("name").getAsString();
	            String species = obj.get("species").getAsString();
	            int age = obj.get("age").getAsInt();
	            boolean adopted = obj.get("adopted").getAsBoolean();

	            // goes through each type of category inside the pets.json file and calls the associated Pet Model to be assigned to this pet variable
	            switch (type.toLowerCase()) {
	                case "dog":
	                    pet = new DogModel(id, name, species, age);
	                    break;
	                case "cat":
	                    pet = new CatModel(id, name, species, age);
	                    break;
	                case "rabbit":
	                    pet = new RabbitModel(id, name, species, age);
	                    break;
	                default:
	                    System.err.println("Unknown pet type: " + type);
	                    continue;
	            }

	            pet.setAdopted(adopted);
	            petSet.add(pet);
	        }

	    } catch (IOException e) {
	        System.err.println(e.getMessage());
	        throw e;
	    }

	    return petSet;
	}
	
	/** Saves a json file located in src/main/resources containing the new set of pets
	 * 
	 * @param pets			Set of pets to be saved
	 * @throws IOException	IOException in the case that something goes wrong when trying to write the pets to the json file
	 */
	public static String savePets(Set<Pet> pets) throws IOException {
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String time = date.format(new Date());
		String saveFile = "/PetAdoptionCenter/src/main/resources/" + time + "_pets.json";
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(saveFile))) {
			gson.toJson(pets, writer);
			return saveFile;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw e;
		}
				
	}
}

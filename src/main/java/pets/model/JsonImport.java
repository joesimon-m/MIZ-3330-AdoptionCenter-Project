package pets.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class JsonImport {
	private static final Gson gson = new Gson();
	private static final String EXOTIC_ANIMALS_PATH = "/PetAdoptionCenter/src/main/resources/exotic_animals.json";
	private static final String PETS_PATH = "/PetAdoptionCenter/src/main/resources/pets.json";
	
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Set<Pet> loadExoticAnimals() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(EXOTIC_ANIMALS_PATH))) {
			ExoticAnimal[] exoticAnimals = gson.fromJson(reader, ExoticAnimal[].class);
			
			Set<Pet> exoticAnimalsToPets = new HashSet<>();
			for(ExoticAnimal ea : exoticAnimals) {
				exoticAnimalsToPets.add(new ExoticAnimalAdapter(ea));
			}
			
			reader.close();
			return exoticAnimalsToPets;
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw e;
		} 
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static Set<Pet> loadPets() throws IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(PETS_PATH))) {
			Pet[] pets = gson.fromJson(reader, Pet[].class);
			reader.close();
			return new HashSet<>(Arrays.asList(pets));
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw e;
		}
	}
	
	/**
	 * 
	 * @param pets
	 * @param filePath
	 * @throws IOException
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

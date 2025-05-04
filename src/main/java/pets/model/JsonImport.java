package pets.model;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.Set;

import com.google.gson.Gson;

public class JsonImport {
	private static final Gson gson = new Gson();
	
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static Set<Pet> loadExoticAnimals(String filePath) throws IOException {
		
		
		return null;
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	public static Set<Pet> loadPets(String filePath) throws IOException {
		
		
		return null;
	}
	
	/**
	 * 
	 * @param pets
	 * @param filePath
	 * @throws IOException
	 */
	public static void savePets(Set<Pet> pets, String filePath) throws IOException {
		BufferedWriter writer = new BufferedWriter((Writer) Paths.get(filePath));
		gson.toJson(pets, writer);
		writer.close();
	}
}

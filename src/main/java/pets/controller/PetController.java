package pets.controller;

import pets.model.*;
import pets.view.PetInputView;
import javax.swing.*;
import java.io.IOException;
import java.util.Set;

/**
 * The  class acts as the main controller for the pet shelter application.
 * It handles user interactions, manages the shelter data, and updates the view.
 */
public class PetController {
    private Shelter<Pet> shelter;
    private PetInputView view;
    private int petIdCounter = 1;

    /**
     * Constructs a new  PetController with the specified view.
     * Initializes the shelter and loads pets from files.
     *
     * @param view the PetInputView used for user interaction
     */
    public PetController(PetInputView view) {
        this.shelter = new Shelter<>();
        this.view = view;
        loadPetsFromFile();
    }

    /**
     * Loads pets including exotic animals from JSON files and adds them to the shelter.
     * Updates the view with the loaded data.
     */
    private void loadPetsFromFile() {
        try {
            Set<Pet> loadedPets = JsonImportAndExport.loadPets();
            Set<Pet> exoticPets = JsonImportAndExport.loadExoticAnimals();

            loadedPets.addAll(exoticPets);

            for (Pet pet : loadedPets) {
                shelter.add(pet);
                if (pet.getId() >= petIdCounter) {
                    petIdCounter = pet.getId() + 1;
                }
            }
            view.updatePetTable(shelter.getAllPets());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Error loading pets from file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Starts the application logic. 
     */
    public void start() {
    }

    /**
     * Prompts the user to add a new pet via the view. If a pet is added,
     * it is assigned a unique ID and added to the shelter and view.
     */
    public void addNewPet() {
        Pet newPet = view.showAddPetDialog();
        if (newPet != null) {
            newPet.setId(petIdCounter++);
            shelter.add(newPet);
            view.updatePetTable(shelter.getAllPets());
        }
    }

    /**
     * Displays details of the selected pet from the pet table.
     * Shows an error message if no pet is selected.
     */
    public void viewPetDetails() {
        int selectedRow = view.getPetTableModel();
        if (selectedRow >= 0) {
            Pet pet = shelter.getAllPets().stream().skip(selectedRow).findFirst().orElse(null);
            if (pet != null) {
                view.showPetDetailsDialog(pet);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please select a pet to view details.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Marks the selected pet as adopted if it is not already adopted.
     * Updates the view.
     */
    public void adoptPet() {
        int selectedRow = view.getPetTableModel();
        if (selectedRow >= 0) {
            Pet pet = shelter.getAllPets().stream().skip(selectedRow).findFirst().orElse(null);
            if (pet != null && !pet.isAdopted()) {
                pet.setAdopted(true);
                view.updatePetTable(shelter.getAllPets());
                JOptionPane.showMessageDialog(view, pet.getName() + " has been adopted!", "Adopt Pet", JOptionPane.INFORMATION_MESSAGE);
            } else if (pet != null) {
                JOptionPane.showMessageDialog(view, pet.getName() + " is already adopted.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please select a pet to adopt.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Removes the selected pet from the shelter and updates the view.
     * Shows an error if no pet is selected.
     */
    public void removePet() {
        int selectedRow = view.getPetTableModel();
        if (selectedRow >= 0) {
            Pet pet = shelter.getAllPets().stream().skip(selectedRow).findFirst().orElse(null);
            if (pet != null) {
                shelter.remove(pet);
                view.updatePetTable(shelter.getAllPets());
                JOptionPane.showMessageDialog(view, pet.getName() + " has been removed from the shelter.", "Remove Pet", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(view, "Please select a pet to remove.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Saves all current pets in the shelter to a JSON file and displays the file path.
     * Displays an error message if the save operation fails.
     */
    public void savePets() {
        try {
            String saveFilePath = JsonImportAndExport.savePets(shelter.getAllPets());
            JOptionPane.showMessageDialog(view, "Pets have been saved to " + saveFilePath, "Save Pets", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Error saving pets: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

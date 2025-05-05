package pets.controller;

import pets.model.*;
import pets.view.PetInputView;
import javax.swing.*;
import java.io.IOException;
import java.util.Set;

public class PetController {
    private Shelter<Pet> shelter;
    private PetInputView view;
    private int petIdCounter = 1;

    public PetController(PetInputView view) {
        this.shelter = new Shelter<>();
        this.view = view;
        loadPetsFromFile();
    }

    private void loadPetsFromFile() {
        try {
            Set<Pet> loadedPets = JsonImportAndExport.loadPets();
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

    public void start() {
    }

    public void addNewPet() {
        Pet newPet = view.showAddPetDialog();
        if (newPet != null) {
            newPet.setId(petIdCounter++);
            shelter.add(newPet);
            view.updatePetTable(shelter.getAllPets());
        }
    }

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

    public void savePets() {
        try {
            String saveFilePath = JsonImportAndExport.savePets(shelter.getAllPets());
            JOptionPane.showMessageDialog(view, "Pets have been saved to " + saveFilePath, "Save Pets", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(view, "Error saving pets: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package pets;

import pets.controller.PetController;
import pets.view.PetInputView;


public class Main {

    /**
     * The main method initializes the PetInputView and PetController,
     * links them together, and starts the application.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create the view component
        PetInputView petInputView = new PetInputView(null); 
        
        // Create the controller and associate it with the view
        PetController petController = new PetController(petInputView);
        
        // Link the view back to the controller
        petInputView.setController(petController);
        
        // Start the application
        petController.start();
    }
}

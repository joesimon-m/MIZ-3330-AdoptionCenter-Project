package pets;

import pets.controller.PetController;
import pets.view.PetInputView;

public class Main {

    public static void main(String[] args) {
        
        PetInputView petInputView = new PetInputView(null); 
        
     
        PetController petController = new PetController(petInputView);
        
        
        petInputView.setController(petController);
        
        
        petController.start();
    }
}

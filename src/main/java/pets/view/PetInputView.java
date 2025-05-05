package pets.view;

import javax.swing.*;
import java.awt.*;
import pets.model.*;
import pets.controller.PetController;
import java.util.ArrayList;
import java.util.Set;

public class PetInputView extends JFrame {
    private PetController controller;

    public void setController(PetController controller) {
        this.controller = controller;
    }

    private JTable petTable;
    private JButton addButton, adoptButton, removeButton, viewButton, saveButton;
    private JComboBox<String> sortComboBox;
    private PetTableModel petTableModel;

    public PetInputView(PetController controller) {
        this.controller = controller;
        initialize();
    }

    private void initialize() {
        setTitle("Pet Shelter Management");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        petTableModel = new PetTableModel(new ArrayList<Pet>());
        petTable = new JTable(petTableModel);
        JScrollPane scrollPane = new JScrollPane(petTable);
        add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.SOUTH);

        addButton = new JButton("Add Pet");
        addButton.addActionListener(e -> controller.addNewPet());
        panel.add(addButton);

        adoptButton = new JButton("Adopt Pet");
        adoptButton.addActionListener(e -> controller.adoptPet());
        panel.add(adoptButton);

        removeButton = new JButton("Remove Pet");
        removeButton.addActionListener(e -> controller.removePet());
        panel.add(removeButton);

        viewButton = new JButton("View Pet Details");
        viewButton.addActionListener(e -> controller.viewPetDetails());
        panel.add(viewButton);

        saveButton = new JButton("Save Pets");
        saveButton.addActionListener(e -> controller.savePets());
        panel.add(saveButton);

        sortComboBox = new JComboBox<>(new String[] { "Sort by Age", "Sort by Species" });
        panel.add(sortComboBox);

        setVisible(true);
    }

    public void updatePetTable(Set<Pet> set) {
        petTableModel.setPets(set);
    }

    public int getPetTableModel() {
        return petTable.getSelectedRow();
    }

    public JFrame getFrame() {
        return this;
    }

    public Pet showAddPetDialog() {
        JTextField nameField = new JTextField(10);
        JTextField speciesField = new JTextField(10);
        JTextField ageField = new JTextField(10);

        JComboBox<String> petTypeComboBox = new JComboBox<>(new String[] { "Cat", "Dog" });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("Pet Type:"));
        panel.add(petTypeComboBox);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Species:"));
        panel.add(speciesField);
        panel.add(new JLabel("Age:"));
        panel.add(ageField);

        int option = JOptionPane.showConfirmDialog(this, panel, "Add New Pet", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String species = speciesField.getText();
            int age = Integer.parseInt(ageField.getText());
            String petType = (String) petTypeComboBox.getSelectedItem();

            Pet newPet = null;
            if ("Cat".equals(petType)) {
                newPet = new CatModel(0, name, species, age);
            } else if ("Dog".equals(petType)) {
                newPet = new DogModel(0, name, species, age);
            }

            return newPet;
        }
        return null;
    }

    public void showPetDetailsDialog(Pet pet) {
        if (pet != null) {
            JTextArea detailsArea = new JTextArea(pet.toString());
            detailsArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(detailsArea);
            JOptionPane.showMessageDialog(this, scrollPane, "Pet Details", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No pet selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

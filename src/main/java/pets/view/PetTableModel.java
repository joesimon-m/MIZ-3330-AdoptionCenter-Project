package pets.view;

import pets.model.Pet;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Table model for displaying pet information in a JTable.
 * Converts a Set of Pet objects to a List and maps their fields to table columns.
 */
public class PetTableModel extends AbstractTableModel {
    private List<Pet> pets;
    private final String[] columnNames = {"ID", "Name", "Species", "Age"};

    /**
     * Constructs the table model with an initial list of pets.
     *
     * @param pets the initial list of pets to display
     */
    public PetTableModel(List<Pet> pets) {
        this.pets = pets;
    }

    /**
     * Sets a new list of pets by converting from a Set, and updates the table.
     *
     * @param set the set of pets to be displayed in the table
     */
    public void setPets(Set<Pet> set) {
        this.pets = new ArrayList<>(set); // Convert Set to List
        fireTableDataChanged(); // Notify the JTable to refresh its data
    }

    /**
     * Returns the number of rows (pets) in the table.
     *
     * @return the number of rows
     */
    @Override
    public int getRowCount() {
        return pets.size();
    }

    /**
     * Returns the number of columns in the table.
     *
     * @return the number of columns
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Returns the name of a specified column.
     *
     * @param column the index of the column
     * @return the column name
     */
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Returns the value at the specified cell.
     *
     * @param rowIndex the row index
     * @param columnIndex the column index
     * @return the cell value
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pet pet = pets.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pet.getId();
            case 1:
                return pet.getName();
            case 2:
                return pet.getSpecies();
            case 3:
                return pet.getAge();
            default:
                return null;
        }
    }

    /**
     * Indicates whether a cell is editable. This implementation disables editing.
     *
     * @param rowIndex the row index
     * @param columnIndex the column index
     * @return false, since editing is disabled
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}

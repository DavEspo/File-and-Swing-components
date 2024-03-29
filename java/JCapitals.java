import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCapitals extends JFrame implements ActionListener {
    // JFrame, JComboBox, JLabel, and JTextField
    private static JFrame capital;
    private static JComboBox<String> countryChoice;
    private static JLabel selection;
    private static JTextField capitalOfCountry;
    
    // Array of capitals
    private static String[] capitals = new String[7];
    
    public static void main(String[] args) {
        // Initialize the JFrame
        capital = new JFrame("Capitals");
        
        // Set properties of the JFrame
        capital.setSize(400, 150);
        capital.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        capital.setLayout(new FlowLayout());
        
        // Create an instance of JCapitals
        JCapitals s = new JCapitals();
        
        // Array of countries
        String[] countries = {"Austria", "Canada", "England", "France", "Italy", "Mexico", "Spain"};
        
        // Initialize the array of capitals
        capitals[0] = "Vienna";
        capitals[1] = "Toronto";
        capitals[2] = "London";
        capitals[3] = "Paris";
        capitals[4] = "Rome";
        capitals[5] = "Mexico City";
        capitals[6] = "Madrid";
        
        // Initialize the JComboBox
        countryChoice = new JComboBox<>(countries);
        countryChoice.addActionListener(s);
        
        // Initialize the JLabel and the JTextField
        selection = new JLabel("Select a country");
        capitalOfCountry = new JTextField("The capital of Austria is Vienna");
        
        // Add components to the JFrame
        capital.add(selection);
        capital.add(countryChoice);
        capital.add(capitalOfCountry);

        // Set JFrame Visible
        capital.setVisible(true);
    }
    
    // ActionListener implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == countryChoice) {
            capitalOfCountry.setText("The capital of " + countryChoice.getSelectedItem() + " is " + capitals[countryChoice.getSelectedIndex()]);
        }
    }
}
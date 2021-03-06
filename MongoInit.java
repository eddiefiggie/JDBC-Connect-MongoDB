/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 5/11/18
 *
 * Description: Database Connector for MongoDB
 *****************************************************************/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout; // Aligns components
import javax.swing.JFrame; // Provides basic window features
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;



public class MongoInit extends JFrame {

    private JTextField location;
    private JTextField port;
    private JTextField databaseName;
    private JTextField collection;
    private JTextField userName;
    private JPasswordField password;
    private JButton cancel;
    private JButton apply;
    private String locationString;
    private String portConvert;
    private int portInt;
    private String databaseNameString;
    private String collectionString;
    private String userNameString;

    // DatabaseInit constructor adds JTextFields to JFrame
    public MongoInit() {
        super("Database Initiaization");
        GridLayout grid = new GridLayout(7,2);
        setLayout(grid); // set frame layout

        // Construct location field
        JLabel locationLabel = new JLabel("Database IP or Machine Name: ");
        location = new JTextField("localhost", 20); // Setting column width
        add(locationLabel);
        add(location);  // add location to JFrame

        // Construct port with default of 27017 (MongoDB Default)
        JLabel portLabel = new JLabel("Custom Port: ");
        port = new JTextField("27017", 20);
        add(portLabel);
        add(port); // add port to JFrame

        // Construct databaseName to JFrame
        JLabel databaseNameLabel = new JLabel("Database Name: ");
        databaseName = new JTextField("GenericDB", 20); // Setting column width
        add(databaseNameLabel);
        add(databaseName);  // add to JFrame

        // Construct collection field
        JLabel collectionLabel = new JLabel("Collection Name: ");
        collection = new JTextField("GenericList", 20); // Setting column width
        add(collectionLabel);
        add(collection);  // add collection to JFrame

        // Construct userName to JFrame
        JLabel userNameLabel = new JLabel("User Name: ");
        userName = new JTextField(20); // Setting column width
        add(userNameLabel);
        add(userName);  // add to JFrame

        // Construct password to JFrame
        JLabel passwordLabel = new JLabel("Password: ");
        password = new JPasswordField("password", 20); // Setting column width
        add(passwordLabel);
        add(password);  // add to JFrame

        // Cancel button
        cancel = new JButton("Cancel");
        add(cancel);

        // Accept button
        apply = new JButton("Apply");
        add(apply);

        // Register event handlers
        TextFieldHandler handler = new TextFieldHandler();
        cancel.addActionListener(handler);
        apply.addActionListener(handler);
    }

    public String getLo() {
        return locationString;
    }

    public int getPort() {
        return portInt;
    }

    public String getDatabaseName() {
        return databaseNameString;
    }

    public String getUserName() {
        return userNameString;
    }

    private class TextFieldHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent event) {

            String string = ""; // declare String to display

            // cancel button action
            if(event.getSource() == cancel)
                System.exit(0);

            // apply button action
            else if(event.getSource() == apply)
                locationString = location.getText();
                portConvert = port.getText();
                portInt = Integer.parseInt(portConvert);
                databaseNameString = databaseName.getText();
                userNameString = userName.getText();
                collectionString = collection.getText();

                string = "Connection to " + location.getText() + " succesfull.";

                try {

                    // Creating a Mongo client
                    MongoClient mongo = new MongoClient(locationString, portInt);

                    // Creating Credentials
                    MongoCredential credential;

                    credential = MongoCredential.createCredential(userNameString,
                        databaseNameString, password.getPassword()/*.toCharArray()*/);

                    JOptionPane.showMessageDialog(null, string);

                    // Accessing the database
                    MongoDatabase database = mongo.getDatabase(databaseNameString);

                    //Creating a collection
                    database.createCollection(collectionString);

                }
                catch (MongoException e) {
                    System.err.println(e);
                    System.exit(1);
                }
                System.exit(0);
        }
    }
}

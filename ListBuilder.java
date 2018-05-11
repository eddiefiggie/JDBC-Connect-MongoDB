/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 5/11/18
 *
 * Description: Build list with mongoDB documents
 *****************************************************************/

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import org.bson.Document;


public class MongoInit extends JPanel{

    private JTextField desc;
    private JTextField qty;
    private JTextField store;
    private JTextField assign;
    private String descString;
    private String qtyConvert;
    private int qtyInt;
    private String storeString;
    private String assignString;
    private JButton cancel;
    private JButton add;
    // DATABASE CARIABLES MUST BE PRESENTED
    private String locationString = "localhost";
    private String portConvert = "27017";
    private int portInt;
    private String databaseNameString = "GenericDatabase";
    private String collectionString = "GenericList";
    private String userNameString = "GenericUser";

    public MongoInit() {
        super("List Builder");
        GridLayout grid = new GridLayout(5,2);
        setLayout(grid); // set frame layout

        // *****************************************************
        JLabel descLabel = new JLabel("Item Description: ");
        desc = new JTextField(20);
        add(descLabel);
        add(desc);

        // *****************************************************
        JLabel qtyLabel = new JLabel("Quantity Needed: ");
        qty = new JTextField("1", 20);
        add(qtyLabel);
        add(qty);

        // *****************************************************
        JLabel storeLabel = new JLabel("Where to Purchase: ");
        store = new JTextField(20);
        add(storeLabel);
        add(store);

        // *****************************************************
        JLabel assignLabel = new JLabel("Assigned To: ");
        assign = new JTextField(20);
        add(assignLabel);
        add(assign);

        // *****************************************************
        cancel = new JButton("Cancel");
        add(cancel);

        // *****************************************************
        add = new JButton("Add Item");
        add(add);

        // Register event handlers
        TextFieldHandler handler = new TextFieldHandler();
        cancel.addActionListener(handler);
        add.addActionListener(handler);
    }


    private class TextFieldHandler implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent event) {

            String string = "";

            // cancel button action
            if(event.getSource() == cancel)
                System.exit(0);

            // apply button action
            else if(event.getSource() == apply)
                descString = desc.getText();
                qtyConvert = qty.getText();
                qtyInt = Integer.parseInt(qtyConvert);
                storeString = store.getText();
                assignString = assign.getText();
                collectionString = collection.getText();

                string = qtyInt + " " + descString + "(s) added.";

                try {

                    // Creating a Mongo client
                    MongoClient mongo = new MongoClient(locationString, portInt);

                    // Creating Credentials
                    MongoCredential credential;

                    credential = MongoCredential.createCredential(userNameString,
                        databaseNameString, "password".toCharArray());

                    JOptionPane.showMessageDialog(null, string);

                    // Accessing the database
                    MongoDatabase database = mongo.getDatabase(databaseNameString);

                    //Creating a collection
                    database.createCollection(collectionString);

                    // Retrieving a collection
                    MongoCollection<Document> collection = database.getCollection(collectionString);

                    Document document = new Document("title", "Items")
                    .append("desc", descString):
                    .append("qty", qtyInt):
                    .append("store", storeString):
                    .append("assign", assignString):
                    collection.insertOne(document);

                    JOptionPane.showMessageDialog(null, string);

                }
                catch (MongoException e) {
                    System.err.println(e);
                    System.exit(1);
                }
                System.exit(0);
        }
    }
}

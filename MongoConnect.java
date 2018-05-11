/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 5/1/18
 *
 * Description: Test DB Connection with MongoDB
 *****************************************************************/


import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import javax.swing.JFrame;

public class MongoConnect {

    public static void main(String args[]) {

        MongoInit dbConn = new MongoInit();
        dbConn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dbConn.setSize(450,108); // Frame setSize
        dbConn.setVisible(true);
    }
}

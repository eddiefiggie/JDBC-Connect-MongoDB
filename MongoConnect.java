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

public class MongoConnect { 
   
    public static void main( String args[] ) {  
        try {  
            // Creating a Mongo client 
            MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
   
            // Creating Credentials 
            MongoCredential credential; 
            credential = MongoCredential.createCredential("ExampleUser", "Database_01", 
                 "PlaceHolder".toCharArray()); 
            System.out.println();
            System.out.println("Connected to the database successfully."); 
            System.out.println(); 
      
            // Accessing the database 
            MongoDatabase database = mongo.getDatabase("myDb"); 
            System.out.println("Credentials:  " + credential);
            System.out.println();
        } 
        catch (MongoException e) {
            System.err.println(e);
            System.exit(1);
        }
    } 
}

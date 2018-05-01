/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 5/1/18
 *
 * Description: Test DB Connection with MongoDB
 *****************************************************************/

import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class MongoConnect { 
   
    public static void main( String args[] ) {  
      
       // Creating a Mongo client 
       MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
   
       // Creating Credentials 
       MongoCredential credential; 
       credential = MongoCredential.createCredential("sampleUser", "myDb", 
          "password".toCharArray()); 
       System.out.println("Connected to the database successfully");  
      
       // Accessing the database 
       MongoDatabase database = mongo.getDatabase("myDb"); 
       System.out.println("Credentials ::"+ credential);     
    } 
}

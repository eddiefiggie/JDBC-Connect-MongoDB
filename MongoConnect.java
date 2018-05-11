/*****************************************************************
 * Name: Edwin Figueroa
 * Date: 5/11/18
 *
 * Description: Test DB Connection with MongoDB
 *****************************************************************/

import javax.swing.JFrame;

public class MongoConnect {

    public static void main(String args[]) {

        MongoInit dbConn = new MongoInit();
        dbConn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dbConn.setSize(450,108);
        dbConn.setLocationRelativeTo(null);
        dbConn.setVisible(true);
    }
}

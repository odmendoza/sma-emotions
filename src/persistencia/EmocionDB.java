package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmocionDB {
    
    ConexionDB conecction = new ConexionDB();
     
    public ResultSet getEmotion(String emotion) throws ClassNotFoundException, SQLException{
        
        Statement statement = conecction.openConnection().createStatement();
        String query = String.format("SELECT * FROM Emotion "
                + "WHERE nameEmotion = '%s'", emotion);
 
        return statement.executeQuery(query);
    }
}
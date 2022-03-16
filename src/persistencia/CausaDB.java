package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CausaDB {
    
    ConexionDB conecction = new ConexionDB();
    
    public ResultSet getCauses(String idEmotion) throws ClassNotFoundException, SQLException{
        
        Statement statement = conecction.openConnection().createStatement();
        String query = String.format("SELECT idCause, descriptionCause FROM Cause \n" +
                "WHERE idEmotion = '%s'", idEmotion);
        
        return statement.executeQuery(query);
    }
}

package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RecomendacionDB {
   
    ConexionDB conecction = new ConexionDB();
    
    public ResultSet getRecommendations(String idEmotion) throws ClassNotFoundException, SQLException{
        
        Statement statement = conecction.openConnection().createStatement();
        String query = String.format("SELECT idRecommendation, descriptionRecommendation FROM "
                + "Recommendation WHERE idEmotion = '%s'", idEmotion);
        
        return statement.executeQuery(query);
    }
}
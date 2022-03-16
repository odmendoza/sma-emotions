package modelos;

import java.util.ArrayList;

public class Emocion implements java.io.Serializable{
    
    private String idEmotion;
    private String nameEmotion;
    private ArrayList<Causa> causes;
    private ArrayList<Recomendacion> recommendations;

    public Emocion() {
    }

    public Emocion(String idEmotion, String nameEmotion) {
        this.idEmotion = idEmotion;
        this.nameEmotion = nameEmotion;
    }

    public Emocion(String idEmotion, String nameEmotion, ArrayList<Causa> causes, 
            ArrayList<Recomendacion> recommendations) {
        this.idEmotion = idEmotion;
        this.nameEmotion = nameEmotion;
        this.causes = causes;
        this.recommendations = recommendations;
    }

    public String getIdEmotion() {
        return idEmotion;
    }

    public void setIdEmotion(String idEmotion) {
        this.idEmotion = idEmotion;
    }

    public String getNameEmotion() {
        return nameEmotion;
    }

    public void setNameEmotion(String nameEmotion) {
        this.nameEmotion = nameEmotion;
    }

    public ArrayList<Causa> getCauses() {
        return causes;
    }

    public void setCauses(ArrayList<Causa> causes) {
        this.causes = causes;
    }

    public ArrayList<Recomendacion> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(ArrayList<Recomendacion> recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public String toString() {
                
        return String.format("idEmotion: %s, nameEmotion: %s, causes: %s, "
                + "recommendations: %s", idEmotion, nameEmotion, causes, recommendations);
    }     
}

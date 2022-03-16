package modelos;

public class Recomendacion implements java.io.Serializable{
    
    private String idRecommendation;
    private String descriptionRecommendation;

    public Recomendacion() {
    }

    public Recomendacion(String idRecommendation, String descriptionRecommendation) {
        
        this.idRecommendation = idRecommendation;
        this.descriptionRecommendation = descriptionRecommendation;
    }

    public String getIdRecommendation() {
        return idRecommendation;
    }

    public void setIdRecommendation(String idRecommendation) {
        this.idRecommendation = idRecommendation;
    }

    public String getDescriptionRecommendation() {
        return descriptionRecommendation;
    }

    public void setDescriptionRecommendation(String descriptionRecommendation) {
        this.descriptionRecommendation = descriptionRecommendation;
    }

    @Override
    public String toString(){
        return String.format("idRecommendation: %s, descriptionRecommendation: %s", 
                idRecommendation, descriptionRecommendation);
    }
}
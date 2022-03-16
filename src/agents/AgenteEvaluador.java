package agents;

import modelos.Causa;
import modelos.Emocion;
import modelos.Recomendacion;
import persistencia.CausaDB;
import persistencia.EmocionDB;
import persistencia.RecomendacionDB;
import vistas.AgenteEvaluadorGUI;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteEvaluador extends Agent {

    /**
     * Buscar y asociar los datos que recibe del Agente Detector
     * Enviar resultados al Agente Presentador
     */
    class SearchAgentBehaivour extends CyclicBehaviour {

        @Override
        public void action() {

            // Recibir el mensaje del agente detector (DetectingAgent)
            ACLMessage detecting_message = blockingReceive();
            
            if (detecting_message != null) {

                try {

                    Emocion emotion = searchEmotion(detecting_message.getContent());
                    
                    updateInterface(emotion.getNameEmotion());
                    
                    if (emotion != null) {                        
                        
                        AID presenter__agent_id = new AID(); // Identificador del agente con el que se va a comunicar (Agente Presentador)
                        AID evaluator__agent_id = new AID();

                        presenter__agent_id.setLocalName("Presentador"); // Nombre del agente con el que se va a comunicar (Agente Presentador)
                        evaluator__agent_id.setLocalName("Evaluador");

                        ACLMessage search_message = new ACLMessage(ACLMessage.REQUEST);
                        search_message.setSender(evaluator__agent_id);
                        search_message.setLanguage("Español");
                        search_message.addReceiver(presenter__agent_id); // Agregar receptor (Agente Presentador)

                        search_message.setContentObject(emotion);

                        send(search_message); // Enviar mensaje al agente 'Presentador' (Agente Presentador)'
                    }
                    
                } catch (ClassNotFoundException | SQLException | IOException | InterruptedException ex) {
                    Logger.getLogger(AgenteEvaluador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            block();
        }
    }

    @Override
    protected void setup() {
        addBehaviour(new SearchAgentBehaivour()); // Agregar comportamiento
    }

    protected Emocion searchEmotion(String emotionDetected)
            throws ClassNotFoundException, SQLException {

        EmocionDB emotionDB = new EmocionDB();
        Emocion emotion = new Emocion();
        ResultSet resultset = emotionDB.getEmotion(emotionDetected);
        while (resultset.next()) {
            String idEmotion = resultset.getString(1);
            String nameEmotion = resultset.getString(2);
            ArrayList<Causa> causes = searchCauses(idEmotion);
            ArrayList<Recomendacion> recommendations = searchRecommendations(idEmotion);

            emotion = new Emocion(idEmotion, nameEmotion, causes, recommendations);
        }

        return emotion;
    }

    protected ArrayList<Causa> searchCauses(String idEmotion) throws ClassNotFoundException, SQLException {

        ArrayList<Causa> causes = new ArrayList<>();
        CausaDB causeDB = new CausaDB();
        ResultSet resultset = causeDB.getCauses(idEmotion);

        while (resultset.next()) {
            String idCause = resultset.getString(1);
            String descriptionCause = resultset.getString(2);
            Causa cause = new Causa(idCause, descriptionCause);
            causes.add(cause);
        }

        return causes;
    }

    protected ArrayList<Recomendacion> searchRecommendations(String idEmotion)
            throws ClassNotFoundException, SQLException {

        ArrayList<Recomendacion> recommendations = new ArrayList<>();
        RecomendacionDB recommendationDB = new RecomendacionDB();
        ResultSet resultset = recommendationDB.getRecommendations(idEmotion);

        while (resultset.next()) {
            String idRecommendation = resultset.getString(1);
            String descriptionRecommendation = resultset.getString(2);
            Recomendacion recommendation = new Recomendacion(idRecommendation, descriptionRecommendation);
            recommendations.add(recommendation);
        }

        return recommendations;
    }

    protected void updateInterface(String emotionDetected) throws InterruptedException {
        AgenteEvaluadorGUI searchInterface = new AgenteEvaluadorGUI();
        searchInterface.setVisible(true);
        searchInterface.lblEmotionSearch.setText("Buscando relaciones "
                + "asociados con " + emotionDetected.toUpperCase());
        for (int j = 0; j < 100; j++) {
            searchInterface.jProgressBarEvaluador.setValue(j);
            Thread.sleep(50);
        } 
        searchInterface.setVisible(false);
        searchInterface.lblEmotionSearch.setText("");
    }
}

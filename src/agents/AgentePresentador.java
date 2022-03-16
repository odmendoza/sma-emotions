package agents;

import modelos.Causa;
import modelos.Emocion;
import modelos.Recomendacion;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import vistas.AgentePresentadorGUI;
import jade.lang.acl.UnreadableException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgentePresentador extends Agent {

    /**
     * Presentar resultados de evaluación 
     * Emitir criterio u sugerencia
     */

    class EvaluatingAgentBehaivour extends CyclicBehaviour {

        @Override
        public void action() {

            // Recibir el mensaje del Agente Evaluador
            ACLMessage search_message = blockingReceive();

            if (search_message != null) {
                try {
                    
                    Emocion emotion = (Emocion) search_message.getContentObject();                    
                    updateInterface(emotion);
                    
                } catch (UnreadableException | InterruptedException ex) {
                    Logger.getLogger(AgentePresentador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    protected void setup() {
        addBehaviour(new EvaluatingAgentBehaivour()); // Agregar comportamiento
    }

    protected void updateInterface(Emocion emotion) throws InterruptedException {
        
        AgentePresentadorGUI evaluatingInterface = new AgentePresentadorGUI();
        Random random = new Random();
        
        evaluatingInterface.setVisible(true);

        evaluatingInterface.txtEmotionName.setText(
                emotion.getNameEmotion().toUpperCase());
        
        evaluatingInterface.txtRecomendation.setLineWrap(true);
        
        ArrayList<Causa> causes = emotion.getCauses();
        
        String descriptionCauses = "";
        for (Causa cause : causes) {
            descriptionCauses = String.format("%s - %s\n", descriptionCauses,
                    cause.getDescriptionCause());
        }
        
        evaluatingInterface.txtCauses.setLineWrap(true);
        evaluatingInterface.txtCauses.setText(descriptionCauses);
        ArrayList<Recomendacion> recommendations = emotion.getRecommendations();
        
        if (!recommendations.isEmpty()) {
            Recomendacion recommendation = recommendations.get(
                    random.nextInt(recommendations.size()));
            evaluatingInterface.txtRecomendation.setText(
                    recommendation.getDescriptionRecommendation());
        } else {
            evaluatingInterface.txtRecomendation.setText(""
                    + "Continuar aplicando metodologías de enseñanza innovadoras aplicando TICS para mantener la participación de los estudiantes.");
        }
        
        Thread.sleep(30000);
        evaluatingInterface.setVisible(false);
    }
}

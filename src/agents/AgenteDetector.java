package agents;

import vistas.AgenteDetectorGUI;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.event.*;

public class AgenteDetector extends Agent {

    int flag;

    /**
     * Simulación de la detección de la emoción a través de a enstrada de usuario
     */
    class DetectingAgentBehaviour extends Behaviour {

        @Override
        public void action() {
            flag = 0;
            try {
                String emotionDetected = detectingEmotion();
                
                AID evaluator_agent_id = new AID();
                AID detect_agent_id = new AID();
                
                detect_agent_id.setLocalName("Detector"); // Nombre del agente  (Agente Detector)
                evaluator_agent_id.setLocalName("Evaluador"); // Nombre del agente con el que se va a comunicar (Agente Evaluador)
                

                ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
                message.setSender(detect_agent_id);
                message.setLanguage("Español");
                message.addReceiver(evaluator_agent_id); // Agregar receptor (Agente Evaluador)

                // Contenido del mensaje
                message.setContent(emotionDetected);

                send(message); // Enviar mensaje al agente 'Buscador' (Agente Evaluador)'
            } catch (Exception ex) {
                Logger.getLogger(AgenteDetector.class.getName()).log(Level.SEVERE, null, ex);
            }
            block(36000);
//            block();
        }

        // Comprueba si el comportamiento se ha cumplido
        @Override
        public boolean done() {
            return false;
        }
    }

    @Override
    protected void setup() {
        DetectingAgentBehaviour detectingBehaviour = new DetectingAgentBehaviour();
        addBehaviour(detectingBehaviour); // Agregar comportamiento
    }

    protected String detectingEmotion() {

        AgenteDetectorGUI detectingInterface = new AgenteDetectorGUI();
        detectingInterface.setVisible(true);

        while (flag == 0) {
            detectingInterface.buttonSend.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    detectingInterface.setVisible(false);
                    flag = 1;
                }
            });

        }

        String emotionDectected = detectingInterface.comboBoxEmotions.getSelectedItem().toString();

        return emotionDectected;
    }
    
}

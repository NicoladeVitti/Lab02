package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtRisultato;
    
    private AlienDictionary model;

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String riga = txtParola.getText();
    	
    	if(riga.equals("")) {
    		txtRisultato.setText("ERRORE: non hai inserito nulla");
			txtParola.setText("");
			
			return ;

    	}
    	
    	if(riga.contains(" ")) {
    		
    		String campi[] = riga.split(" ");
   
    		if(campi.length > 2) {
    			txtRisultato.setText("ERRORE: hai inserito troppe parole");
    			txtParola.setText("");
    		}
    		
    		else if(campi.length < 2) {
    			txtRisultato.setText("ERRORE: devi togliere lo spazio dopo la parola inserita");
    			txtParola.setText("");

    		}
    		
    		else if(campi.length == 2) {
    		
    			String primaParola = campi[0];
    			String secondaParola = campi[1];
    			
    			if(primaParola.equals("")) {
    				txtRisultato.setText("ERRORE: devi togliere lo spazio prima della parola inserita");
        			txtParola.setText("");
        			
        			return;
    			}
    			
    			
    			else if(primaParola.matches("[a-zA-Z]*") && secondaParola.matches("[a-zA-Z]*")) {
    				
    				String primaParolaMin = primaParola.toLowerCase();
    				String secondaParolaMin = secondaParola.toLowerCase();
    				
    				model.addWord(primaParolaMin, secondaParolaMin);
    				
        			txtRisultato.setText("la parola " + primaParola + " con traduzione " + secondaParola + " è stata inserita correttamente nel dizionario");
        			txtParola.setText("");

    				
    				return ;
    			}
    			
    			else {
        			txtRisultato.setText("ERRORE: formato della parole non corretto");
        			txtParola.setText("");

    			}
    		
    		}
    	}
    	
    	else if(!riga.contains(" ")) {
    		
    		if(riga.matches("[a-zA-Z]*")) {
    			
    			String parola = riga.toLowerCase();
    			String risultato = model.translateWord(parola);
    			
    			if(risultato == null) {
        			txtRisultato.setText("ERRORE: la parola non ha traduzione");
        			txtParola.setText("");

    			}
    			else {
    				txtRisultato.setText("la traduzione della parola inserita è " +risultato);
        			txtParola.setText("");

    			}
    			
    		}
    		
    		else {
    			txtRisultato.setText("ERRORE: formato della parola non corretto");
    			txtParola.setText("");

    		}
    		
    	}
    }
    
    public void setModel(AlienDictionary model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}

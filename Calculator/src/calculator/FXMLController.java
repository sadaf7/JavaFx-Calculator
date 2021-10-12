
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class FXMLController implements Initializable {

    @FXML
   // @Override
    private Label txtDisplay;
    private long num1=0;
    long num2;
    private String op = "";
    private boolean start = true;
    private Modal modal = new Modal();
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
     @FXML
     
     
     
    public void processNumbers(ActionEvent event){
        if(start){
            txtDisplay.setText("");
            start=false;
        }
        String value = ((Button)event.getSource()).getText();
        txtDisplay.setText(txtDisplay .getText()+value);
       
    }
    
     @FXML
     
    public void processOperator(ActionEvent event){
        String value = ((Button)event.getSource()).getText();
        if(!value.equals("=")){
            if(!op.isEmpty()){
                return;
            
            }
                op=value;
            num1 = Long.parseLong(txtDisplay.getText());
            txtDisplay.setText("");
            
        }  
        else{
            if(op.isEmpty())
                return;
              
            long num2 = Long.parseLong(txtDisplay.getText());
            float output=modal.calculate(num1, num2, op);
            txtDisplay.setText(String.valueOf(output));
            op="";
            start = true;
        }
        
    }
    
}

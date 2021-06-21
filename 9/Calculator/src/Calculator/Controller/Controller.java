package Calculator.Controller;

import Calculator.Model.Container;
import Calculator.Model.ContainerNumber;
import Calculator.Model.ContainerOperator;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.ArrayList;

/**
 * Controller class
 * @author HamidrezaAbooei
 */
public class Controller {
    // Fields
    ArrayList<Container> containers;

    @FXML
    private JFXButton oneButten;

    @FXML
    private JFXButton twoButten;

    @FXML
    private JFXButton fourButten;

    @FXML
    private JFXButton fiveButten;

    @FXML
    private JFXButton threeButten;

    @FXML
    private JFXButton sixButten;

    @FXML
    private JFXButton sevenButten;

    @FXML
    private JFXButton eightButten;

    @FXML
    private JFXButton nineButten;

    @FXML
    private JFXButton addButten;

    @FXML
    private JFXButton subtractButten;

    @FXML
    private JFXButton multipleButten;

    @FXML
    private JFXButton resButten;

    @FXML
    private JFXButton devideButten;

    @FXML
    private JFXButton zeroButten;

    @FXML
    private Label resultTextField;

    @FXML
    private JFXButton dotButten;

    @FXML
    private JFXButton ClearButten;

    @FXML
    private JFXButton CleanButten;

    @FXML
    private JFXButton sinButten;

    @FXML
    private JFXButton cosButten;

    @FXML
    private JFXButton tanButten;

    /**
     * Constructor
     */
    public Controller() {
        containers = new ArrayList<>();

    }

    /**
     * add new number
     * @param event that applied
     */
    @FXML
    void addNumber(ActionEvent event) {
        int number = -1;
        if(event.getSource().equals(oneButten)){
            number = 1;
        }else if(event.getSource().equals(twoButten)){
            number = 2;
        }else if(event.getSource().equals(threeButten)){
            number = 3;
        }else if(event.getSource().equals(fourButten)){
            number = 4;
        }else if(event.getSource().equals(fiveButten)){
            number = 5;
        }else if(event.getSource().equals(sixButten)){
            number = 6;
        }else if(event.getSource().equals(sevenButten)){
            number = 7;
        }else if(event.getSource().equals(eightButten)){
            number = 8;
        }else if(event.getSource().equals(nineButten)){
            number = 9;
        }else if(event.getSource().equals(zeroButten)){
            number = 0;
        }else if(event.getSource().equals(dotButten)){
            number = 11;
        }
        addNewNumber(number);
    }

    /**
     * update label with foreach on containers
     */
    private void updateLabel(){
        String displayText = "";
        for (Container container:containers) {
            displayText += container.toString();
        }
        resultTextField.setText(displayText);
    }

    /**
     * add new number to containers
     * @param number to add to containers
     */
    private void addNewNumber(int number){
        containers.add(new ContainerNumber(number));
        updateLabel();
    }

    /**
     * add operation event listener
     * @param event event that passed
     */
    @FXML
    void addOperator(ActionEvent event) {
        int operatorID = -1;

        if(event.getSource().equals(addButten)){
            operatorID = 0;
        }else if(event.getSource().equals(subtractButten)){
            operatorID = 1;
        }else if(event.getSource().equals(multipleButten)){
            operatorID = 2;
        }else if(event.getSource().equals(devideButten)){
            operatorID = 3;
        }else if(event.getSource().equals(sinButten)){
            operatorID = 4;
        }else if(event.getSource().equals(cosButten)){
            operatorID = 5;
        }else if(event.getSource().equals(tanButten)){
            operatorID = 6;
        }
        addNewOperator(operatorID);
    }

    /**
     * add new operation to containers
     * @param operatorID id of that operator
     */
    private void addNewOperator(int operatorID){
        containers.add(new ContainerOperator(operatorID));
        updateLabel();
    }

    /**
     * clear and clean function
     * @param event actionEvent
     */
    @FXML
    void clear(ActionEvent event){
        if(event.getSource().equals(CleanButten))
            containers.clear();
        else if (containers.size()>0)
            containers.remove(containers.size()-1);
        updateLabel();

    }

    /**
     * result of expression
     * @param event actionEvent
     */
    @FXML
    void resaultButten(ActionEvent event){
        float result = 0;
        float readNumber = 0;
        String readNewNumber = "";
        int operator = -1;
        boolean first = true;
        for (Container container: containers) {
            // create full number from entries
            if (container instanceof ContainerNumber){
                readNewNumber += container.toString();
                readNumber = Float.parseFloat(readNewNumber);
            }else {
                if(first){
                    result += readNumber;
                    first = false;
                }
                // if an operation applied
                if (operator!=-1){
                    if(operator == 0){
                        result+=readNumber;
                    }else if(operator == 1){
                        result -= readNumber;
                    }else if(operator == 2){
                        result *= readNumber;
                    }else if(operator == 3){
                        result /= readNumber;
                    }else if(operator == 4){
                        result += Math.sin(readNumber);
                    }else if(operator == 5){
                        result += Math.cos(readNumber);
                    }else if(operator == 6){
                        result += Math.tan(readNumber);
                    }
                }
                readNewNumber = "";
                operator = ((ContainerOperator) container).getOperatorId();
            }

        }
        // apply last operation
        if (operator!=-1){
            if(operator == 0){
                result+=readNumber;
            }else if(operator == 1){
                result -= readNumber;
            }else if(operator == 2){
                result *= readNumber;
            }else if(operator == 3){
                result /= readNumber;
            }else if(operator == 4){
                result += Math.sin(readNumber);
            }else if(operator == 5){
                result += Math.cos(readNumber);
            }else if(operator == 6){
                result += Math.tan(readNumber);
            }
        }
        containers.clear();

        resultTextField.setText(result+"");
    }

}

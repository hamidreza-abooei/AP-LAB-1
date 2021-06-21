package Calculator.Model;
/**
 * this class contains Operators
 * @author HamidrezaAbooei
 */
public class ContainerOperator extends Container{
    // id of that container
    private int id ;

    /**
     * Constructor
     * @param id of that Operator
     */
    public ContainerOperator(int id){
        this.id = id;
    }

    /**
     * get Operator id
     * @return id of this operator
     */
    public int getOperatorId() {
        return id;
    }

    /**
     * override toString
     * @return string that related to that operator to show in display
     */
    @Override
    public String toString(){
        String res = "";
        if(id == 0){
            res = " + ";
        }else if(id == 1){
            res = " - ";
        }else if(id == 2){
            res = " x ";
        }else if(id == 3){
            res = " / ";
        }else if(id == 4){
            res = " Sin ";
        }else if(id == 5){
            res = " Cos ";
        }else if(id == 6){
            res = " Tan ";
        }
        return res;
    }

}

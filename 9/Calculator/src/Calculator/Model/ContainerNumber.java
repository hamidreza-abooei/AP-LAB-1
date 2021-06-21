package Calculator.Model;
/**
 * this class is for Numbers and dot(.)
 * @author HamidrezaAbooei
 */
public class ContainerNumber extends Container{
    private int number ;

    /**
     * ContainerNumber constructor
     * @param number number that is specify
     */
    public ContainerNumber(int number){
        this.number = number;
    }

    /**
     * override toString
     * @return that number or dot (code 11 is dot)
     */
    @Override
    public String toString(){
        String returnNumber = "";
        if (number >= 0 && number<=9){
            returnNumber = number+"";
        }else if (number == 11){
            returnNumber = ".";
        }
        return returnNumber;
    }
}

import java.util.*;
public class Functions {
    protected  SortedMap<String, Double> map = new TreeMap<String, Double>();
    //checks for operands
    public boolean operand(char check){
        if((check >= 'a' && check <= 'z')||(check >= 'A' && check <= 'Z')||(check >= '0' && check <= '9')||(check == '.')){
            return true;
        }
        else{
            return false;
        }
    }
    //returns empty string
    public String deleteString(){
        String empty = "";
        return empty;
    }
    //checks for precedence
    public int precedence(char input)
    {
        if(input == '^')
            return 3;
        else if(input == '*' || input == '/')
            return 2;
        else if(input == '+' || input == '-')
            return 1;
        else
            return -1;
    }
    //checks if string is an operand
    boolean operator(Character input){
        //detects operands
        if(input == '^'||input == '-'||input == '+'||input == '/'||input == '*'|| input =='('|| input ==')'){
            return true;
        }
        else
            return false;
    }
    //displays data in converted postfix form
    String view(Stack<Character> flip){
        String output = "";
        while(!flip.empty())
        {
            if(flip.peek() =='|'){
                flip.pop();
            }
            else{
                char s =  flip.pop();
                output += s;
            }
        }
        System.out.println(output);
        return output;
    }
    //displays data in seperate raw form
    String viewStandard(Stack<Character> flip){
        String output="";
        while(!flip.empty()){
            char s = flip.pop();
            output += s;
        }
        System.out.println(output);
        return output;
    }
    //Calculation function with PostFixReturn input
    Double postfixCalc(PostFixReturn returnValue){
        //data initialization
        Stack<Character> input = returnValue.postFix;

        char event;
        Stack<Double> Values = new Stack<>();
        String numStr="";
        double number1,number2,number;
        double result = 0.0000;
        Long temp;
        //main loop
        while (!input.empty()){
            //detects numerics and converts it into doubles and place it within stack
            if(input.peek()=='|'){
                input.pop();
                while(input.peek()!='|'){
                    Character c = input.pop();
                    numStr += c;
                }
                input.pop();
                //detects strings as keys
                if(map.containsKey(numStr)){
                    number = map.get(numStr);
                }
                else {
                    number = Double.valueOf(numStr);
                }
//                number = Double.valueOf(numStr);
                Values.push(number);
                numStr = deleteString();
            }
            // checks operand and uses the last 2 numerics as input
            else if(operator(input.peek())){
                //checks events and does calculations
                event = input.pop();
                number1= Values.pop();
                System.out.println("Operand1: " + number1);
                number2 = Values.pop();
                System.out.println("Operand2: " + number2);
                System.out.println("Operator: " + event);
                if (event == '+'){
                    result = number2 + number1;
                }
                else if (event == '-'){
                    result = number2 - number1;
                }
                else if (event == '*'){
                    result = number2 * number1;
                }
                else if (event == '/'){
                    result = number2 / number1;
                }
                else if (event == '^') {
                    result = Math.pow(number2, number1);
                }
                System.out.println("result: "+result);
                Values.push(result);
            }

            else{
                input.pop();
            }
        }
        result = Values.pop();
        //places into hashmap
        if (returnValue.status){
            map.put(returnValue.key,result);
        }

        return result;
    }



}

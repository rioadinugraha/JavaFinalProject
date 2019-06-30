
import java.util.*;


public class PostfixFuncs implements PostfixFuncsInterface {

    protected Stack<Character> afinal = new Stack<Character>();
    protected int length;
    protected Stack<Character> flip = new Stack<Character>();
    protected boolean flag;
    protected PostFixReturn returnValues = new PostFixReturn();


    public void setLength(int length) {
        this.length = length;
    }

    public void setFlip(Stack<Character> flip) {
        this.flip = flip;
    }

    public PostFixReturn PostfixStack(String inp){
        setLength(inp.length());
        Stack<Character> stk = new Stack<>();
        Stack<Character> flip = new Stack<>();
        Functions func = new Functions();
        this.flag = false;
        String key = "";
        int count = 0;
        char[] input = inp.toCharArray();
        returnValues.status = false;
        //clause for key and values
        if (inp.contains("=")){
            while (input[count]!= '=') {
                key += input[count];
                count = count + 1;
            }
            count = count+1;
            returnValues.key = key;
            returnValues.status = true;
        }
        //main loop
        for(int i = count; i< length;i++){
            if(i>0){
                //adding the clause of negative numbers
                if(input[i]=='-' && func.operator(input[i-1]) &&input[i-1]!=')'){
                    this.afinal.push('|');
                    this.afinal.push('-');
                    // continues loop until operand is found
                    for(int j = i+1; j< length;j++){
                        if (j == length-1)
                        {
                            this.afinal.push(input[j]);
                            i = j;
                            this.flag = true;
                            break;
                        }
                        else if(!func.operator(input[j])){
                            this.afinal.push(input[j]);
                        }
                        else{
                            this.afinal.push('|');
                            i = j;
                            break;
                        }
                    }
                }
            }
            else if(i == 0 &&input[i]=='-'){
                this.afinal.push('|');
                this.afinal.push('-');
                for(int j = i+1; j< length;j++){
                    if(func.operand(input[j])){
                        System.out.println(input[j]);
                        this.afinal.push(input[j]);
                    }
                    else{
                        this.afinal.push('|');
                        i = j;
                        break;
                    }
                }
            }
            if (this.flag){break;
            }
            if(func.operand(input[i])){
                this.afinal.push('|');
                for(int j = i; j< length;j++){
                    if (j == length-1) {
                        if(input[j]!= ')'){
                            this.afinal.push(input[j]);
                        }
                        i = j;
                        this.flag = true;
                        break;
                    }
                    else if(func.operand(input[j])){
                        this.afinal.push(input[j]);
                    }
                    else{
                        this.afinal.push('|');
                        i = j;
                        break;
                    }
                }
            }
            if (this.flag){break;
            }
            //detects '(' characters to seperated and processes them into stk stack for temporary storage
            else if(input[i]== '('){
                stk.push(input[i]);
            }
            else if(input[i]==')'){
                while(stk.peek()!='('&& !stk.empty()){
                    Character c = stk.pop();
//                    System.out.println(c);
                    this.afinal.push(c);
                }
                if(stk.peek()=='('){
                    stk.pop();
                }
            }
            else{
                //detects and sorts precedence
                while(!stk.empty() && func.precedence(input[i]) <= func.precedence(stk.peek()))
                {
                    Character c = stk.pop();
                    this.afinal.push(c);
                }
//                System.out.println(input[i]);
                stk.push(input[i]);
            }
            if (this.flag){break;
            }
        }
        this.afinal.push('|');
        //empties stk stack into final stack
        while(!stk.empty())
        {
            if(stk.peek()!= '('){
                this.afinal.push(stk.peek());
                stk.pop();
            }
            else{
                stk.pop();
            }

        }
        //flips stack for final usage
        while(!this.afinal.empty())
        {
            if(this.afinal.peek()!= ')'){
                flip.push(this.afinal.peek());
                this.afinal.pop();
            }
            else{
                this.afinal.pop();
            }
        }
        returnValues.postFix = flip;
        while(!afinal.empty()){
            afinal.pop();
        }

        return returnValues;
    }

}

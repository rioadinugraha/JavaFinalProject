import javax.swing.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException,IllegalAccessException,InstantiationException
    {
        //test bug fixing code
//        Functions tesuto = new Functions();
//        PostFixReturn returnValue;
////
//        String tests = "100+(500134*(55+2)+(22-2)";
//        String test = "25*A/(1+-2)";
//        PostfixFuncs trie = new PostfixFuncs();
//        returnValue = trie.PostfixStack(test);
//        tesuto.viewStandard(returnValue.postFix);
//        tesuto.view(returnValue.postFix);
//        System.out.println(returnValue.key);
//        System.out.println(returnValue.status);
//        System.out.println(tesuto.postfixCalc(returnValue));
//        returnValue = trie.PostfixStack(tests);
//        tesuto.viewStandard(returnValue.postFix);
//        System.out.println(tesuto.postfixCalc(returnValue));
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        CalculatorGui dialog = new CalculatorGui();

      //  System.exit(0);
    }
}

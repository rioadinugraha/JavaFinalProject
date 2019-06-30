import javax.swing.*;
import java.awt.event.*;

public class CalculatorGui extends JFrame{
    private JPanel MainPanel;
    private JButton a7Button;
    private JTextField displayTextField;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton xButton;
    private JButton PlusButton;
    private JButton DivButton;
    private JButton MinusButton;
    private JButton EqualsButton;
    private JButton ansButton;
    private JButton EXITButton;
    private JPanel DIsplayPanel;
    private JButton a2Button;
    private JButton a1Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton a0Button;
    private JButton powerButton;
    private JButton dotButton;
    private JButton openBracketButton;
    private JButton closeBracketButton;
    private JButton delButton;
    private JButton stackButton;
    private JButton aButton;
    private JButton bButton1;
    private JButton exitButton;
    private JButton postFixButton;
    private JButton CEButton;
    private JButton cButton;
    private String displaytext;
    private String answertext;
    private boolean equals=false;
    private PostFixReturn returnValue = new PostFixReturn();
    private Functions func = new Functions();
    private PostfixFuncs postfix = new PostfixFuncs();
    private Double answer;

    public CalculatorGui() {
        setContentPane(MainPanel);
        setTitle("Calculator");
        setSize(400,500);
        displaytext="";
        displayTextField.setText(displaytext);
        pack();
        setVisible(true);
//        getRootPane().setDefaultButton(EXITButton);

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
//
//        a7Button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                displaytext+="e";
//            }
//        });
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="1";
                displayTextField.setText(displaytext);
            }
        });
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="2";
                displayTextField.setText(displaytext);
            }
        });
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="3";
                displayTextField.setText(displaytext);
            }
        });
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="4";
                displayTextField.setText(displaytext);
            }
        });
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="5";
                displayTextField.setText(displaytext);
            }
        });
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="6";
                displayTextField.setText(displaytext);
            }
        });
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="7";
                displayTextField.setText(displaytext);
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="8";
                displayTextField.setText(displaytext);
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="9";
                displayTextField.setText(displaytext);
            }
        });

        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="0";
                displayTextField.setText(displaytext);
            }
        });
        dotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+=".";
                displayTextField.setText(displaytext);
            }
        });


        EqualsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!equals) {
                    displaytext += "=";
                    displayTextField.setText(displaytext);
                }
            }
        });

        DivButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="/";
                displayTextField.setText(displaytext);
            }
        });

        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="*";
                displayTextField.setText(displaytext);
            }
        });

        powerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="^";
                displayTextField.setText(displaytext);
            }
        });

        ansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                returnValue = postfix.PostfixStack(displaytext);
                System.out.println(displaytext);
                System.out.println(returnValue.postFix);
                equals = false;

                displaytext = "";
                answertext = "";

                answer = func.postfixCalc(returnValue);
                if (returnValue.status){

                    answertext = returnValue.key;
                    answertext += " = ";
                    answertext += answer;
                }
                else{

                    answertext = "Ans";
                    answertext += " = ";
                    answertext += answer;
                }
                displayTextField.setText(answertext);



            }
        });
        MinusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="-";
                displayTextField.setText(displaytext);
            }
        });
        PlusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="+";
                displayTextField.setText(displaytext);
            }
        });


        openBracketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="(";
                displayTextField.setText(displaytext);
            }
        });
        closeBracketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+=")";
                displayTextField.setText(displaytext);
            }
        });
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displaytext.endsWith("=")){
                    equals = false;
                }

                displaytext = displaytext.substring(0,displaytext.length()-1);
                displayTextField.setText(displaytext);
            }
        });

        CEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext ="";
                equals = false;
                displayTextField.setText(displaytext);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        postFixButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnValue = postfix.PostfixStack(displaytext);
                displaytext = "";
                answertext = "";
                equals = false;
                answertext = func.view(returnValue.postFix);
                displayTextField.setText(answertext);

            }
        });
        stackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnValue = postfix.PostfixStack(displaytext);
                displaytext = "";
                answertext = "";
                answertext = func.viewStandard(returnValue.postFix);
                displayTextField.setText(answertext);
            }
        });
        aButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="A";
                displayTextField.setText(displaytext);
            }
        });
        bButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="B";
                displayTextField.setText(displaytext);
            }
        });
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaytext+="C";
                displayTextField.setText(displaytext);
            }
        });
    }
    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}

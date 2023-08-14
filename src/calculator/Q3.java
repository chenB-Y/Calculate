package calculator;

import java.util.*;

public class Q3 {

    private static Queue<String> queue = new LinkedList<>();
    private static Stack<String> stack = new Stack<>();
    private static Stack<Expression> finalS = new Stack<>();


    public static double calc(String expression)throws Exception{
        Scanner scanner = new Scanner(expression);
        scanner.useDelimiter("(?<=[-+*/()])|(?=[-+*/()])");
        while(scanner.hasNext()){
            String str = scanner.next();
            if(isDouble(str))
                queue.add(str);
            else{
                switch (str) {
                    case "(" :
                    case "*" :
                    case "/" :
                        stack.push(str);
                        break;
                    case ")" :
                        while(!stack.peek().equals("("))
                            queue.add(stack.pop());
                        stack.pop();
                        break;
                    case "+" :
                    case "-" :
                        while(!stack.empty() && (!stack.peek().equals("(")))
                            queue.add(stack.pop());
                        stack.push(str);
                        break;
                }
            }
        }
        while(!stack.empty())
            queue.add(stack.pop());

        while(!queue.isEmpty()){
            String exp = queue.poll();
                if (isDouble(exp))
                    finalS.push(new Number(Double.parseDouble(exp)));
                else {
                    Expression right = finalS.pop();
                    Expression left = finalS.pop();
                    switch(exp){
                        case "+" :
                            finalS.add(new Plus(left,right));
                            break;
                        case "-" :
                            finalS.add(new Minus(left,right));
                            break;
                        case "/" :
                            finalS.add(new Div(left,right));
                            break;
                        case "*" :
                            finalS.add(new Mul(left,right));

                }
            }
        }
        return finalS.pop().calculate();
    }



    private static boolean isDouble(String str) throws Exception{
        try {
            double num = Double.parseDouble(str);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}

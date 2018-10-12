package br.com.java8.new_features.lambda_expressions;

public class LambdaExpressions {

    public void run() {

        try {
            int test[] = new int[15];
            test[14] = 38/15;
            System.out.println(test[14]);
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

    }

}

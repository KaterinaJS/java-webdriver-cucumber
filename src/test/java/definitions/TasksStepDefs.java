package definitions;

import cucumber.api.java.en.Given;

public class TasksStepDefs {
    @Given("I solve task with Alternate case")
    public void iSolveTask() {
        String string = "Hello World";
        alternateCase(string);
    }

    static String alternateCase(final String string) {
        String result = "";
        String[] arr = string.split("");
        for (int i = 0; i < string.length(); i++) {
            if (string == "") {
                //System.out.println("");
                return "";
            } else if (arr[i] == arr[i].toUpperCase()) {
                result += arr[i].toLowerCase();
            } else {
                result += arr[i].toUpperCase();
            }
        }
        System.out.println(result);
        return result;
    }

    @Given("I fix string case")
    public void iFixStringCase() {
        /* you will be given a string that may have mixed uppercase and lowercase letters
        and your task is to convert that string to either lowercase only or uppercase only based on:
        - make as few changes as possible.
        - if the string contains equal number of uppercase and lowercase letters,
        convert the string to lowercase.

        1. solve("coDe") = "code";
        2. solve("CODe") = "CODE";
        3. solve("coDE") = "code" */

        System.out.println(cases("coDe"));
        System.out.println(cases("CODe"));
        System.out.println(cases("coDE"));
    }

    public static String cases(final String str) {
        int countLower = 0;
        int countUpper = 0;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == Character.toLowerCase(str.charAt(i))) {
                countLower += 1;
            } else {
                countUpper += 1;
            }
            if (countLower > countUpper) {
                result = str.toLowerCase();
            } else if (countLower < countUpper) {
                result = str.toUpperCase();
            } else {
                result = str.toLowerCase();
            }
        }
        return result;
    }

    @Given("I reverse a part of a string")
    public void iReverseAPartOfAString() {
        /* you will be given a string and two indexes (a and b).
        Your task is to reverse the portion of that string between those two indices inclusive.
        Input will be lowercase and uppercase letters only.
        The first index a will always be lower that than the string length;
        the second index b can be greater than the string length.

        1. solve("codewars",1,5) = "cawedors" -- elements at index 1 to 5 inclusive are "odewa".
        So we reverse them.
        2. solve("cODEWArs", 1,5) = "cAWEDOrs" -- to help visualize. */

        System.out.println(partialReverse("codewars", 1, 5));
        System.out.println(partialReverse("cODEWArs", 1, 5));
        System.out.println(partialReverse("Kate", 1, 5));
    }


    public static String partialReverse (String s, int a, int b) {
        if (b > s.length() - 1) {
            String part = s.substring(a);
            StringBuilder sb = new StringBuilder(part);
            String reversePart = sb.reverse().toString();
            return s.substring(0, a) + reversePart;
        } else {
            String part = s.substring(a, b + 1);
            StringBuilder sb = new StringBuilder(part);
            String reversePart = sb.reverse().toString();
            return s.substring(0, a) + reversePart + s.substring(b + 1);
        }
    }


    @Given("I calculate doubles")
    public void iCalculateDoubles() {
        /* Write a function called calculate that takes 3 values. The first and third values are numbers.
        The second value is a character. If the character is "+" , "-", "*", or "/",
        the function will return the result of the corresponding mathematical function on the two numbers.
        If the string is not one of the specified characters, the function should return null.
        Keep in mind, you cannot divide by zero. If an attempt to divide by zero is made, return null */

        System.out.println(calculate(3, "+", 1.5));
        System.out.println(calculate(3, "*", 1.5));
        System.out.println(calculate(3, "/", 0));
        System.out.println(calculate(3, "r", 1.5));
    }

        public static Double calculate (final double numberOne, final String operation, final double numberTwo) {
            double result = 0.0;
            if((operation != "+") && (operation != "-") && (operation != "*") && (operation != "/")){
                return null;
            }

            else if(operation == "/" && numberTwo == 0){
                return null;
            } else {

                switch (operation){
                    case "+":
                        result += numberOne + numberTwo;
                        break;
                    case "-":
                        result += numberOne - numberTwo;
                        break;
                    case "*":
                        result += numberOne * numberTwo;
                        break;
                    case "/":
                        result += numberOne / numberTwo;
                        break;
                }
            }
            return result;
        }

    @Given("I calculate doubles second version")
    public void iCalculateDoublesSecondVersion() {
        /* Write a function called calculate that takes 3 values. The first and third values are numbers.
        The second value is a character. If the character is "+" , "-", "*", or "/",
        the function will return the result of the corresponding mathematical function on the two numbers.
        If the string is not one of the specified characters, the function should return null.
        Keep in mind, you cannot divide by zero. If an attempt to divide by zero is made, return null */

        System.out.println(calculateNew(3, "+", 1.5));
        System.out.println(calculateNew(3, "*", 1.5));
        System.out.println(calculateNew(3, "/", 0));
        System.out.println(calculateNew(3, "r", 1.5));
    }

    public static Double calculateNew(final double x, final String op, final double y) {
        switch (op) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y + 0.0;
            case "/": return y == 0 ? null : x / y;
        }
        return null;
    }
}






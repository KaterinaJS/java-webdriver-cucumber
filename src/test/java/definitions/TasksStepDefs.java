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
        /*you will be given a string that may have mixed uppercase and lowercase letters
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
}






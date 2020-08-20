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
                for(int i = 0; i < string.length(); i++){
                    if(string == ""){
                        //System.out.println("");
                        return "";
                    } else if(arr[i] == arr[i].toUpperCase()){
                        result += arr[i].toLowerCase();
                    } else {
                        result += arr[i].toUpperCase();
                    }
                }
                System.out.println(result);
                return result;
            }
    }



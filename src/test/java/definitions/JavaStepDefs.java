package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.util.ArrayList;
import java.util.List;

public class JavaStepDefs {
    @Given("I say hello world")
    public void iSayHelloWorld() {
        System.out.println("Hello world");
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @And("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);
        System.out.println("str1: " + str1.toUpperCase());
        System.out.println("str2: " + str2.toUpperCase());
        System.out.println("str1 length: " + str1.length());
        System.out.println("str2 length: " + str2.length());
        System.out.println("exact comparison: " + str1.equals(str2));
        System.out.println("exact comparison ignoring cases: " + str1.equalsIgnoreCase(str2));
        System.out.println("partial comparison: " + str1.contains(str2));
    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        int[] nums = {5, 2, 5, 7, 10, 11, 1};
        nums[0] = 7;
        nums[6] = 17;
        System.out.println(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }

        System.out.println("First out of nums: " + nums[0]);

        System.out.println();
        String[] fruits = {"kiwi", "apple", "orange"};
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }

        System.out.println("First out of fruits: " + fruits[0]);

        String str1 = new String("value");
        Integer int1 = new Integer(5);

        List<Integer> listOfNums = new ArrayList<>();
        listOfNums.add(5);
        listOfNums.add(2);
        listOfNums.add(3);
        for (int i : listOfNums) {
            System.out.println(i);
        }

        List<String> listOfFruits = new ArrayList<>();
        listOfFruits.add("kiwi");
        listOfFruits.add("apple");
        listOfFruits.add("orange");
        for (String fruit : listOfFruits) {
            System.out.print(fruit + " ");
        }
    }

    @And("I calculate numbers")
    public void iCalculateNumbers() {
        System.out.println(10 / 3);
        System.out.println(21 % 3);

        int i = 5;
        Integer index = 5;

        double d = 5.0;
        Double doubleValue = 5.0;

        System.out.println(index == d);
        // below 2 are the same
        System.out.println(index != d);
        System.out.println(!(index == d));

        if (i > d) {
            System.out.println("i more than d!");
        } else if (i == d) {
            System.out.println("i equals d!");
        } else {
            System.out.println("i less than d!");
        }
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num == 0){
            System.out.println("Number " + num + " is not negative and not positive");
        } else if (num > 0) {
            System.out.println("Number " + num + " is positive");
        } else {
            System.out.println("Number " + num + " is negative");
        }
    }


    @And("I print {int} th day of week")
    public void iPrintThDayOfWeek(int day) {
        switch (day) {
            case 1:
                System.out.println(day + " th day of week is Monday");
                break;
            case 2:
                System.out.println(day + " th day of week is Tuesday");
                break;
            case 3:
                System.out.println(day + " th day of week is Wednesday");
                break;
            case 4:
                System.out.println(day + " th day of week is Thursday");
                break;
            case 5:
                System.out.println(day + " th day of week is Friday");
                break;
            case 6:
                System.out.println(day + " th day of week is Saturday");
                break;
            case 7:
                System.out.println(day + " th day of week is Sunday");
                break;
            default:
                System.out.println("Incorrect number of day: " + day);
        }
    }
}

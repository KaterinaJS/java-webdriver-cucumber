package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.*;

import java.util.*;

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

        int num1 = 7;
        int num2 = 3;
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Quotient: " + quotient);
        System.out.println("Product: " + product);
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num == 0) {
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

    @And("I work with maps")
    public void iWorkWithMaps() {
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");

        String first = info.get("firstName");
        String middle = info.get("middleName");

        info.put("firstName", middle);
        info.put("middleName", first);

        System.out.println(info);


        Map<String, String> user = new HashMap<>();
        user.put("username", "jdoe");
        user.put("email", "john@doe.example.com");
        user.put("password", "jdoe");
        for (String key : user.keySet()) {
            System.out.println(key + ": " + user.get(key));
        }

        Map<String, String> admin = new HashMap<>();
        admin.put("username", "admin");
        admin.put("email", "admin@admin.example.com");
        admin.put("password", "adminPass");


        for (String key : admin.keySet()) {
            System.out.println(key + ": " + admin.get(key));
        }

    }

    @And("I print {int} th day of week \\(Slava's version)")
    public void iPrintThDayOfWeekSlavaSVersion(int day) {
        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        System.out.println(daysOfWeek[day - 1]);
    }

    @And("I print every {int} day of week")
    public void iPrintEveryDayOfWeek(int every) {
        final String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int i = 1;
        for (String day : daysOfWeek) {
            if (i % every == 0) {
                System.out.println(day);
            }
            i++;
        }

        System.out.println("----------");

        for (int j = 1; j <= daysOfWeek.length; j++) {
            if (j % every == 0) {
                System.out.println(daysOfWeek[j - 1]);
            }
        }

        System.out.println("----------");

        for (int k = every; k <= daysOfWeek.length; k += every) {
            System.out.println(daysOfWeek[k - 1]);
        }

        System.out.println("----------");

        for (int m = 0; m < daysOfWeek.length; m++) {
            System.out.println(daysOfWeek[m]);
        }
    }

    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
        System.out.println("Coding challenges: >>>>>>>");
        // swap
        swap(10, 15);
        // swap map keys
        Map<String, String> info = new LinkedHashMap<>();
        info.put("firstName", "John");
        info.put("middleName", "George");
        swapMap(info);
    }

    void swap(int a, int b) {
        System.out.println("swap method >>>");
        System.out.println("a: " + a);
        System.out.println("b: " + b);

        int temp = a;
        a = b;
        b = temp;

        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    void swapMap(Map<String, String> info) {
        System.out.println("swapMap method >>>");
        System.out.println("info: " + info);

        String temp = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", temp);

        System.out.println("info: " + info);
    }

    @Given("I solve task with swapping two array elements {int} th and {int} th")
    public void iSolveTaskWithSwappingTwoArrayElements(int ind1, int ind2) {
        int[] num = {5, 2, 9, 7, 3};

        if (ind1 >= num.length + 1 || ind2 >= num.length + 1) {
            System.out.println("Not found element");
        } else {
            int temp = num[ind2 - 1];
            num[ind2 - 1] = num[ind1 - 1];
            num[ind1 - 1] = temp;

            for (int n : num) {
                System.out.print(n + " ");
            }
        }
    }


    @Given("I check if a number {int} divisible by {int} and {int}")
    public void iCheckIfANumberDivisibleByAnd(int num, int divByNum1, int divByNum2) {
        if (num % divByNum1 == 0 && num % divByNum2 == 0) {
            System.out.println("Number " + num + " is divisible by " + divByNum1 + " and " + divByNum2);
        } else if (num % divByNum1 == 0) {
            System.out.println("Number " + num + " is divisible by " + divByNum1);
        } else if (num % divByNum2 == 0) {
            System.out.println("Number " + num + " is divisible by " + divByNum2);
        } else {
            System.out.println("Number " + num + " is not divisible by " + divByNum1 + " or " + divByNum2);
        }
    }


    @Given("I print all numbers from zero up to n")
    public void iPrintAllNumbersFromZeroUpToN() {
        allNumbers(5);
    }

    public void allNumbers(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(i + " ");
        }
    }

    @Given("I print all numbers from zero up to n and support also negative numbers")
    public void iPrintAllNumbersFromZeroUpToNAndSupportAlsoNegativeNumbers() {
        printNumbers(-7);
    }

    public void printNumbers(int n) {
        if (n > 0) {
            for (int i = 0; i <= n; i++) {
                System.out.print(i + " ");
            }
        } else if (n < 0) {
            for (int i = n; i <= 0; i++) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(0);
        }
    }

    @Given("I print all integer array")
    public void iPrintAllIntegerArray() {
        int[] arr = {2, 5, 7, 9, 12};
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    @Given("I print all even numbers from integer array")
    public void iPrintAllEvenNumbersFromIntegerArray() {
        int[] arr = {2, 5, 7, 8, 45, -24};
        for (int num : arr) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            } else {
                System.out.print("");
            }
        }
    }

    @Given("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        int[] arr = {2, 5, 7, 8, 45, -24};

        if (arr.length == 0) {
            System.out.println("This array is empty");
        } else {
            System.out.println("This array is NOT empty");
        }
    }

    @Given("I solve Fizz Buzz task")
    public void iSolveFizzBuzzTask() {
        fizzBuzz(20);
    }

    public void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    @Given("I check if array contains another element")
    public void iCheckIfArrayContainsAnotherElement() {
        int[] numbers = {5, 7, 34, 789, 15};
        int n = -7;
        containsElement(numbers, n);
    }

    public void containsElement(int[] numbers, int n) {
        int count = 0;
        for (int num : numbers) {
            if (num == n) count += 1;
        }
        if (count > 0) {
            System.out.println("This array contains number " + n);
        } else {
            System.out.println("This array DOES NOT contain number " + n);
        }
    }

    @Given("I check if a String array contains another element \\(with return)")
    public void iCheckIfAStringArrayContainsAnotherElementWithReturn() {
        String[] colors = {"green", "Orange", "RED", "blue"};
        String color = "red";
        System.out.println(containsColor(colors, color));
    }

    public Boolean containsColor(String[] colors, String color) {
        int count = 0;
        for (String col : colors) {
            if (col.equalsIgnoreCase(color))
                count += 1;
        }
        return count > 0;
    }

    @And("I write lambda")
    public void iWriteLambda() {
        List<String> intList = Arrays.asList("abcabc", "abcabcabc", "abc");
        System.out.println(intList);

        intList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

//        intList.sort((o1, o2) -> o2.length() - o1.length());
        System.out.println(intList);
    }

    @Given("I check if array is empty \\(Slava)")
    public void iCheckIfArrayIsEmptySlava() {
        int[] intArr = {5, 6, 8, 9};
        int[] emptyArr = {};
        int[] nullArr = null;
        System.out.println(isArrayEmpty(intArr));
        System.out.println(isArrayEmpty(emptyArr));
        System.out.println(isArrayEmpty(nullArr));
    }

    // O(1)
    boolean isArrayEmpty(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }


    @Given("I print reversed string")
    public void iPrintReversedString() {
        String str = "WebDriver";
        printReversed(str);
    }

    void printReversed(String str) {
        System.out.println("Reverse " + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    @Given("I return reversed string")
    public void iReturnReversedString() {
        String str = "WebDriver";
        System.out.println(getReversed(str));
    }

    // O(n)
    String getReversed(String str) {
        System.out.println("Return reversed " + str);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    @Given("I reverse every third character of a reversed string")
    public void iReverseEveryThirdCharacterOfAReversedString() {
//        Example: "WebDriver" => "vDW"
        System.out.println(reverse3thChar("WebDriver"));
    }

    public String reverse3thChar(String str) {
        String reversedStr = "";
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }
        for (int j = 1; j <= reversedStr.length(); j++) {
            if (j % 3 == 0) {
                result += reversedStr.charAt(j - 1);
            } else {
                result += "";
            }
        }
        return result;
    }

    @Given("I reverse words in a sentence")
    public void iReverseWordsInASentence() {
//        Example: "I am Automation Engineer" => "Engineer Automation am I"
        System.out.print(reverseWords("I am Automation Engineer"));
    }

    public String reverseWords(String sentence) {
        String result = "";
        String[] sentenceArr = sentence.split(" ");
        for (int i = sentenceArr.length - 1; i >= 0; i--) {
            result += sentenceArr[i] + " ";
        }
        return result;
    }

    @Given("I check if array contains another element \\(Slava version)")
    public void iCheckIfArrayContainsAnotherElementSlavaVersion() {
        String[] strArr = {"apple", "kiwi", "orange"};
        String strOtherEl = "kiwi";
        Integer[] intArr = {5, 4, 3, 8, 5};
        Integer otherEl = 8;
        System.out.println(isContaining(strArr, strOtherEl));
        System.out.println(isContaining(intArr, otherEl));
    }

    // O(n)
    boolean isContaining(Object[] arr, Object otherElement) {
        System.out.println("isContaining() method");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(otherElement)) {
                return true;
            }
        }
        return false;
    }

    @Given("I find max element in the array")
    public void iFindMaxElementInTheArray() {
        int[] arr = {-5, -4, -3, -8, -4};
        System.out.println(maxNum(arr));
    }

    // O(n)
    int maxNum(int[] arr) {
        System.out.println("Max num");
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    @Given("I reverse a string without extra variable")
    public void iReverseAStringWithoutExtraVariable() {
        String str = "WebDriver";
        System.out.println(getReversedNoVar(str));
    }

    String getReversedNoVar(String str) {
        System.out.println("Return reversed no extra var " + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            str += str.charAt(i);
        }
        return str.substring(str.length() / 2);
    }

    @Given("I sort an array")
    public void iSortAnArray() {
        int[] unsortedArr = {5, 8, 7, 5, 1};
        System.out.println(Arrays.toString(sort(unsortedArr)));
    }

    int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    @Given("I find two max numbers in an array")
    public void iFindTwoMaxNumbersInAnArray() {
        int[] array = {5, 8, 7, 5, 1};
        twoMaxElements(array);
    }

    public void twoMaxElements(int[] arr) {
        int max1 = 0;
        int max2 = 0;
        for (int num : arr) {
            if (max1 < num) {
                max2 = max1;
                max1 = num;
            } else if (max2 < num) {
                max2 = num;
            }
        }
        System.out.println("First max number: " + max1);
        System.out.println("Second max number: " + max2);
    }

    @Given("I check if array contains duplicates")
    public void iCheckIfArrayContainsDuplicates() {
        String[] strArr = {"orange", "apple", "kiwi"};
        Integer[] intArr = {5, 4, 3, 8, 5};
        System.out.println(ifContainsDuplicates(strArr));
        System.out.println(ifContainsDuplicates(intArr));

    }

    boolean ifContainsDuplicates(Object[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] != null && arr[i].equals(arr[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Given("I check if word is palindrome")
    public void iCheckIfWordIsPalindrome() {
        System.out.println(isPalindrome("Anna"));
        System.out.println(isPalindrome("Refer"));
        System.out.println(isPalindrome("noon"));
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome("day"));
    }

    boolean isPalindrome(String word){
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
            if(word.equalsIgnoreCase(reversedWord)){
                return true;
            }
        }
        return false;
    }


    @Given("I check if word is palindrome \\(Slava)")
    public void iCheckIfWordIsPalindromeSlava() {
        System.out.println(isItPalindrome("anna"));
        System.out.println(isItPalindrome("refer"));
        System.out.println(isItPalindrome("noon"));
        System.out.println(isItPalindrome("hello"));
        System.out.println(isItPalindrome("day"));
    }

    boolean isItPalindrome(String word){
        int j = 0;
        for(int i = word.length() - 1; i >= 0; i--){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            j++;
        } return true;
    }

    @Given("I work with classes")
    public void iWorkWithClasses() {
        Animal cat = new Cat("Tom");
        System.out.println(cat.getName());
        cat.walk();
        cat.sleep();
        cat.speak();
        cat.eat("fish");
        cat.swim();

        Animal dog = new Dog("Max");
        System.out.println(dog.getName());
        dog.walk();
        dog.sleep();
        dog.speak();
        dog.eat("bone");
        dog.swim();

        Animal parrot = new Parrot("Jack");
        System.out.println(parrot.getName());
        parrot.walk();
        parrot.sleep();
        parrot.speak();
        parrot.eat("seeds");
        parrot.fly();

        Animal fish = new Fish();
        System.out.println(fish.getName());
        fish.sleep();
        fish.eat("worms");
        fish.swim();


        List<Animal> list = new ArrayList<>();
        list.add(cat);
        list.add(dog);
        list.add(parrot);
        list.add(fish);
        printAnimalNames(list);

    }

    public void printAnimalNames(List<Animal> animals) {
        System.out.println("print names method");
        for (Animal animal : animals) {
            animal.speak();
            System.out.println(animal.getName());
        }
    }

    @Given("I check if word is palindrome \\(S2V)")
    public void iCheckIfWordIsPalindromeS() {
        System.out.println(isPalindromeOtherWay("anna"));
        System.out.println(isPalindromeOtherWay("refer"));
        System.out.println(isPalindromeOtherWay("noon"));
        System.out.println(isPalindromeOtherWay("hello"));
        System.out.println(isPalindromeOtherWay("day"));
    }

    // O(n)
    boolean isPalindromeOtherWay(String word) {
        System.out.println("isPalindrome check for " + word);
        int j = 0;
        for (int i = word.length() - 1; i > word.length() / 2; i--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            j++;
        }
        return true;
    }

    @Given("I solve factorial task")
    public void iSolveFactorialTask() {
        System.out.println(factorial(0));
        System.out.println(factorial(5));
    }

    long factorial(long num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    @Given("I find if sum of two elements in an array is a number")
    public void iFindIfSumOfTwoElementsInAnArrayIsANumber() {
        int[] arr = {5, 8, 7, 5, 1};
        System.out.println(findSum(arr, 6));
        System.out.println(findSum(arr, 8));
        System.out.println(findSum(arr, 5));
    }

    boolean findSum(int[] arr, int sum) {
        System.out.println("findSum for " + sum);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    @Given("I find two max numbers in an array SV")
    public void iFindTwoMaxNumbersInAnArraySV() {
        int[] arr1 = {6, 2, 3, 5, 9};
        int[] arr2 = {6, 2, 9, 5, 7};
        find2MaxNumbers(arr2);
    }

    void find2MaxNumbers(int[] arr) {
        System.out.println("Two max num");
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max1 < arr[i]) {
                max2 = max1;
                max1 = arr[i];
            } else if (max2 < arr[i]) {
                max2 = arr[i];
            }
        }
        System.out.println("First max: " + max1 + " Second max: " + max2);
    }

    @Given("I do fibonacci sequence")
    public void iDoFibonacciSequence() {
        for (int i = 1; i <= 11; i++) {
            System.out.print(fibFor(i) + " ");
        }
    }

    long fibFor(int seq) {
        long prevFib = 0;
        long nextFib = 1;
        for (int i = 1; i < seq; i++) {
            long temp = nextFib;
            nextFib = prevFib + nextFib;
            prevFib = temp;
        }
        return nextFib;
    }

    @Given("I do fibonacci sequence with recursion")
    public void iDoFibonacciSequenceWithRecursion() {
        for (int i = 1; i <= 11; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    long fib(long num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fib(num - 1) + fib(num - 2);
    }

    @Given("I check if a number is prime")
    public void iCheckIfANumberIsPrime() {
        System.out.println(isPrime(2));
        System.out.println(isPrime(1));
        System.out.println(isPrime(0));
        System.out.println(isPrime(-4341));
        System.out.println(isPrime(8));
        System.out.println(isPrime(9));
        System.out.println(isPrime(97));
        System.out.println(isPrime(Integer.MAX_VALUE));

        for (int i = 1; i < 500; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    boolean isPrime(int num) {
        System.out.println("Checking if " + num + " is prime...");
        if (num < 2) {
            return false;
        }

        if (num % 2 == 0 && num != 2) {
            return false;
        }

        double sqrt = Math.sqrt(num);
        for (int i = 3; i <= sqrt; i+=2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
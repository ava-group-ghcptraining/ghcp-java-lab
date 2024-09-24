package api.utils;

//Optimize the given code snippet

public class CodeOptimize {

    public static String concatenateStrings(String str1, String str2) {
    String result = "";
    for (int i = 0; i < str1.length(); i++) {
        result += str1.charAt(i);
    }
    for (int i = 0; i < str2.length(); i++) {
        result += str2.charAt(i);
    }
    return result;
}

}
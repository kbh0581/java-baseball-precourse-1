package baseball.util;

public class ArrayUtil {

    /*
    * String Array를 Integer Array로 반환
    *
    **/
    public static Integer[] convertStringToInteger(String[] stringArray) {
        Integer[] integers = new Integer[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            integers[i] = Integer.parseInt(stringArray[i]);
        }
        return integers;
    }
}

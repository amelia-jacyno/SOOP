package start;

import java.util.ArrayList;

public class Lab5 {

    static void printArr(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("}\n");
    }

    static int[] arrayListToPrimitive(ArrayList<Integer> arr) {
        int[] resultArr = new int[arr.size()];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = arr.get(i);
        }
        return resultArr;
    }

    static void reverseSign(int[] arr) {
        if (arr.length > 0) arr[0] *= -1;
    }

    static boolean isNegative(int[] arr) {
        return arr.length > 0 && arr[0] < 0;
    }

    static boolean isLarger(int[] arr1, int[] arr2) {
        if (arr1.length > 0 && arr2.length > 0) {
            if (!isNegative(arr1) && !isNegative(arr2)) {
                if (arr1.length > arr2.length) return true;
                if (arr1.length < arr2.length) return false;
                else {
                    for (int i = 0; i < arr1.length; i++) {
                        if (arr1[i] > arr2[i]) return true;
                    }
                    return false;
                }
            }
            if (!isNegative(arr1) && isNegative(arr2)) return true;
            if (isNegative(arr1) && !isNegative(arr2)) return false;
            if (isNegative(arr1) && isNegative(arr2)) {
                if (arr1.length > arr2.length) return false;
                if (arr1.length < arr2.length) return true;
                else {
                    for (int i = 0; i < arr1.length; i++) {
                        if (arr1[i] > arr2[i]) return false;
                    }
                    return true;
                }
            }
        } else return arr2.length == 0;
        return false;
    }

    static int[] toNumberArray(int value) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (value > 0) {
            while (value > 0) {
                arr.add(0, value % 10);
                value = (value - value % 10) / 10;
            }
        } else if (value < 0) {
            value *= -1;
            while (value > 0) {
                arr.add(0, value % 10);
                value = (value - value % 10) / 10;
            }
            arr.set(0, arr.get(0) * -1);
        } else {
            arr.add(0);
        }
        return arrayListToPrimitive(arr);
    }

    static int[] toNumberArray(String value) {
        int intValue;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.err.println(value + " is not correctly formatted");
            return new int[]{};
        }
        return toNumberArray(intValue);
    }

    static int[] subtractNumberArrays(int[] arr1, int[] arr2) {
        ArrayList<Integer> resultArr = new ArrayList<>();
        int remainder = 0;
        for (int i = 0; i < arr1.length || i < arr2.length || remainder < 0; i++) {
            int tempSum = remainder;
            if (i < arr1.length) tempSum += arr1[arr1.length - 1 - i];
            if (i < arr2.length) tempSum -= arr2[arr2.length - 1 - i];
            if (tempSum < 0) {
                remainder = -1;
                tempSum += 10;
            } else {
                remainder = 0;
            }
            resultArr.add(0, tempSum);
        }
        for (int i = 0; i < resultArr.size() && resultArr.size() > 1; i++) {
            if (resultArr.get(i) == 0) {
                resultArr.remove(i);
                i--;
            }
            else break;
        }
        return arrayListToPrimitive(resultArr);
    }

    static int[] addNumberArrays(int[] arr1, int[] arr2) {
        ArrayList<Integer> resultArr = new ArrayList<>();
        if (isNegative(arr1) == isNegative(arr2)) {
            int remainder = 0;
            for (int i = 0; i < arr1.length || i < arr2.length || remainder > 0; i++) {
                int tempSum = remainder;
                if (i == arr1.length - 1) {
                    if (isNegative(arr1)) tempSum -= arr1[0];
                    else tempSum += arr1[0];
                } else if (i < arr1.length) tempSum += arr1[arr1.length - 1 - i];
                if (i == arr2.length - 1) {
                    if (isNegative(arr2)) tempSum -= arr2[0];
                    else tempSum += arr2[0];
                } else if (i < arr2.length) tempSum += arr2[arr2.length - 1 - i];
                if (tempSum >= 10) {
                    remainder = 1;
                    tempSum -= 10;
                } else {
                    remainder = 0;
                }
                resultArr.add(0, tempSum);
            }
        } else {
            int[] tempArr;
            boolean arr1Reversed = false;
            boolean arr2Reversed = false;
            if (isNegative(arr1)) {
                reverseSign(arr1);
                arr1Reversed = true;
            }
            if (isNegative(arr2)) {
                reverseSign(arr2);
                arr2Reversed = true;
            }
            if (isLarger(arr1, arr2)) {
                tempArr = subtractNumberArrays(arr1, arr2);
                if (arr1Reversed) reverseSign(tempArr);
            } else {
                tempArr = subtractNumberArrays(arr2, arr1);
                if (arr2Reversed) reverseSign(tempArr);
            }
            if (arr1Reversed) reverseSign(arr1);
            if (arr2Reversed) reverseSign(arr2);
            return tempArr;
        }
        for (int i = 0; i < resultArr.size() && resultArr.size() > 1; i++) {
            if (resultArr.get(i) == 0) {
                resultArr.remove(i);
                i--;
            }
            else break;
        }
        if (isNegative(arr1) == isNegative(arr2) && isNegative(arr1) && resultArr.size() > 0)
            resultArr.set(0, resultArr.get(0) * -1);
        return arrayListToPrimitive(resultArr);
    }

    /*
    static int[] multiplyNumberArrays(int[] arr1, int[] arr2) {

    } */

    public static void main(String[] args) {
        System.out.println("Int toNumberArray test:");
        printArr(toNumberArray(-31415));
        printArr(toNumberArray(27182));
        printArr(toNumberArray(0));
        System.out.println();

        System.out.println("String toNumberArray test:");
        printArr(toNumberArray("xd"));
        printArr(toNumberArray("-12ey3"));
        printArr(toNumberArray("-0"));
        printArr(toNumberArray("-31415"));
        printArr(toNumberArray("123"));
        printArr(toNumberArray("0"));
        printArr(toNumberArray(""));
        System.out.println();

        System.out.println("Positive numbers addNumberArrays test:");
        printArr(addNumberArrays(toNumberArray(0), toNumberArray(123)));
        printArr(addNumberArrays(toNumberArray(0), toNumberArray(0)));
        printArr(addNumberArrays(toNumberArray(123), toNumberArray(123)));
        printArr(addNumberArrays(toNumberArray(31415), toNumberArray(271)));
        System.out.println();

        System.out.println("Negative numbers addNumberArrays test:");
        printArr(addNumberArrays(toNumberArray(-31514), toNumberArray(1000)));
        printArr(addNumberArrays(toNumberArray(100), toNumberArray(-123)));
        printArr(addNumberArrays(toNumberArray(123), toNumberArray(-123)));
        printArr(addNumberArrays(toNumberArray(-123), toNumberArray(123)));
        printArr(addNumberArrays(toNumberArray(-123), toNumberArray(0)));
        printArr(addNumberArrays(toNumberArray(-123), toNumberArray(-123)));
        printArr(addNumberArrays(toNumberArray(-31415), toNumberArray(-271)));
    }
}

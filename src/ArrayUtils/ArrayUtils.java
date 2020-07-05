package ArrayUtils;

import java.util.*;

public final class ArrayUtils {

  private ArrayUtils() {}

  /**
   * Creates a new array of type double, where each element of the new array is the corresponding
   * element of {@code arr} but cast to a double
   *
   * @param arr - the array to cast
   * @return - a new array containing the values of the given array, but in the type Double
   */
  public static double[] intToDouble(int[] arr) {
    return Arrays.stream(arr).mapToDouble(x -> (double) x).toArray();
  }

  /**
   * Creates a new array of type long, where each element of the new array is the corresponding
   * element of {@code arr} but cast to a long
   *
   * @param arr - the array to cast
   * @return - a new array containing the values of the given array, but in the type long
   */
  public static long[] intToLong(int[] arr) {
    return Arrays.stream(arr).mapToLong(x -> (long) x).toArray();
  }

  /**
   * Creates a new array of type int, where each element of the new array is the corresponding
   * element of {@code arr} but cast to a int
   *
   * @param arr - the array to cast
   * @return - a new array containing the values of the given array, but in the type int
   */
  public static int[] doubleToInt(double[] arr) {
    return Arrays.stream(arr).mapToInt(x -> (int) Math.floor(x)).toArray();
  }

  /**
   * Creates a new array of type long, where each element of the new array is the corresponding
   * element of {@code arr} but cast to a long
   *
   * @param arr - the array to cast
   * @return - a new array containing the values of the given array, but in the type long
   */
  public static long[] doubleToLong(double[] arr) {
    return Arrays.stream(arr).mapToLong(x -> (long) Math.floor(x)).toArray();
  }

  /**
   * Creates a new array of type double, where each element of the new array is the corresponding
   * element of {@code arr} but cast to a double
   *
   * @param arr - the array to cast
   * @return - a new array containing the values of the given array, but in the type double
   */
  public static double[] longToDouble(long[] arr) {
    return Arrays.stream(arr).mapToDouble(x -> (double) x).toArray();
  }

  /**
   * Creates a new array of type int, where each element of the new array is the corresponding
   * element of {@code arr} but cast to a int
   *
   * @param arr - the array to cast
   * @return - a new array containing the values of the given array, but in the type int
   */
  public static int[] longToInt(long[] arr) {
    return Arrays.stream(arr).mapToInt(x -> (int) x).toArray();
  }

  /**
   * Returns a new array representing the addition of the two arrays If the arrays are not the same
   * length, the returned array is the size of the shorter array
   *
   * @param arr1 - the first array to be part of the addition
   * @param arr2 - the second array to be part of the addition
   * @return - a new integer array, with element[i] = arr1[i] + arr2[i]
   */
  public static int[] add(int[] arr1, int[] arr2) {
    int[] result = new int[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] + arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the addition of the two arrays If the arrays are not the same
   * length, the returned array is the size of the shorter array
   *
   * @param arr1 - the first array to be part of the addition
   * @param arr2 - the second array to be part of the addition
   * @return - a new float array, with element[i] = arr1[i] + arr2[i]
   */
  public static float[] add(float[] arr1, float[] arr2) {
    float[] result = new float[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] + arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the addition of the two arrays If the arrays are not the same
   * length, the returned array is the size of the shorter array
   *
   * @param arr1 - the first array to be part of the addition
   * @param arr2 - the second array to be part of the addition
   * @return - a new double array, with element[i] = arr1[i] + arr2[i]
   */
  public static double[] add(double[] arr1, double[] arr2) {
    double[] result = new double[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] + arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the addition of the two arrays If the arrays are not the same
   * length, the returned array is the size of the shorter array
   *
   * @param arr1 - the first array to be part of the addition
   * @param arr2 - the second array to be part of the addition
   * @return - a new short array, with element[i] = arr1[i] + arr2[i]
   */
  public static short[] add(short[] arr1, short[] arr2) {
    short[] result = new short[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] + arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the addition of the two arrays If the arrays are not the same
   * length, the returned array is the size of the shorter array
   *
   * @param arr1 - the first array to be part of the addition
   * @param arr2 - the second array to be part of the addition
   * @return - a new byte array, with element[i] = arr1[i] + arr2[i]
   */
  public static byte[] add(byte[] arr1, byte[] arr2) {
    byte[] result = new byte[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] + arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the addition of the two arrays If the arrays are not the same
   * length, the returned array is the size of the shorter array
   *
   * @param arr1 - the first array to be part of the addition
   * @param arr2 - the second array to be part of the addition
   * @return - a new long array, with element[i] = arr1[i] + arr2[i]
   */
  public static long[] add(long[] arr1, long[] arr2) {
    long[] result = new long[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] + arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the addition of the two arrays If the arrays are not the same
   * length, the returned array is the size of the shorter array
   *
   * @param arr1 - the first array to be part of the addition
   * @param arr2 - the second array to be part of the addition
   * @return - a new char array, with element[i] = arr1[i] + arr2[i]
   */
  public static char[] add(char[] arr1, char[] arr2) {
    char[] result = new char[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] + arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the addition of the two arrays If the arrays are not the same
   * length, the returned array is the size of the shorter array
   *
   * @param arr1 - the array to subtract from
   * @param arr2 - the array to subtract
   * @return - a new integer array, with element[i] = arr1[i] - arr2[i]
   */
  public static int[] subtract(int[] arr1, int[] arr2) {
    int[] result = new int[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] - arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the subtraction of the two arrays If the arrays are not the
   * same length, the returned array is the size of the shorter array
   *
   * @param arr1 - the array to subtract from
   * @param arr2 - the array to subtract
   * @return - a new float array, with element[i] = arr1[i] - arr2[i]
   */
  public static float[] subtract(float[] arr1, float[] arr2) {
    float[] result = new float[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] - arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the subtraction of the two arrays If the arrays are not the
   * same length, the returned array is the size of the shorter array
   *
   * @param arr1 - the array to subtract from
   * @param arr2 - the array to subtract
   * @return - a new double array, with element[i] = arr1[i] - arr2[i]
   */
  public static double[] subtract(double[] arr1, double[] arr2) {
    double[] result = new double[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] - arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the subtraction of the two arrays If the arrays are not the
   * same length, the returned array is the size of the shorter array
   *
   * @param arr1 - the array to subtract from
   * @param arr2 - the array to subtract
   * @return - a new long array, with element[i] = arr1[i] - arr2[i]
   */
  public static long[] subtract(long[] arr1, long[] arr2) {
    long[] result = new long[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] - arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the subtraction of the two arrays If the arrays are not the
   * same length, the returned array is the size of the shorter array
   *
   * @param arr1 - the array to subtract from
   * @param arr2 - the array to subtract
   * @return - a new byte array, with element[i] = arr1[i] - arr2[i]
   */
  public static byte[] subtract(byte[] arr1, byte[] arr2) {
    byte[] result = new byte[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] - arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the subtraction of the two arrays If the arrays are not the
   * same length, the returned array is the size of the shorter array
   *
   * @param arr1 - the array to subtract from
   * @param arr2 - the array to subtract
   * @return - a new short array, with element[i] = arr1[i] - arr2[i]
   */
  public static short[] subtract(short[] arr1, short[] arr2) {
    short[] result = new short[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] - arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array representing the subtraction of the two arrays If the arrays are not the
   * same length, the returned array is the size of the shorter array
   *
   * @param arr1 - the array to subtract from
   * @param arr2 - the array to subtract
   * @return - a new char array, with element[i] = arr1[i] - arr2[i]
   */
  public static char[] subtract(char[] arr1, char[] arr2) {
    char[] result = new char[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] += arr1[i] - arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array where each element is the corresponding element in the given array
   * multiplied by the given scalar
   *
   * @param arr - the array to apply scalar multiplication to
   * @param scalar - the scalar by which to multiply the array
   * @return - a new integer array with element[i] = scalar * arr[i]
   */
  public static int[] scalarMultiplication(int[] arr, int scalar) {
    int[] result = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] * scalar;
    }

    return result;
  }

  /**
   * Returns a new array where each element is the corresponding element in the given array
   * multiplied by the given scalar
   *
   * @param arr - the array to apply scalar multiplication to
   * @param scalar - the scalar by which to multiply the array
   * @return - a new float array with element[i] = scalar * arr[i]
   */
  public static float[] scalarMultiplication(float[] arr, float scalar) {
    float[] result = new float[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] * scalar;
    }

    return result;
  }

  /**
   * Returns a new array where each element is the corresponding element in the given array
   * multiplied by the given scalar
   *
   * @param arr - the array to apply scalar multiplication to
   * @param scalar - the scalar by which to multiply the array
   * @return - a new double array with element[i] = scalar * arr[i]
   */
  public static double[] scalarMultiplication(double[] arr, double scalar) {
    double[] result = new double[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] * scalar;
    }

    return result;
  }

  /**
   * Returns a new array where each element is the corresponding element in the given array
   * multiplied by the given scalar
   *
   * @param arr - the array to apply scalar multiplication to
   * @param scalar - the scalar by which to multiply the array
   * @return - a new long array with element[i] = scalar * arr[i]
   */
  public static long[] scalarMultiplication(long[] arr, long scalar) {
    long[] result = new long[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] * scalar;
    }

    return result;
  }

  /**
   * Returns a new array where each element is the corresponding element in the given array, divided
   * by the given scalar using integer division
   *
   * @param arr - the array to be divided
   * @param scalar - the scalar to divide the array by
   * @return - a new array with element[i] = arr[i] / scalar
   */
  public static int[] scalarDivision(int[] arr, int scalar) {
    int[] result = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] / scalar;
    }

    return result;
  }

  /**
   * Returns a new array where each element is the corresponding element in the given array, divided
   * by the given scalar using floating point division
   *
   * @param arr - the array to be divided
   * @param scalar - the scalar to divide the array by
   * @return - a new array with element[i] = arr[i] / scalar
   */
  public static float[] scalarDivision(float[] arr, float scalar) {
    float[] result = new float[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] / scalar;
    }

    return result;
  }

  /**
   * Returns a new array where each element is the corresponding element in the given array, divided
   * by the given scalar using floating point division
   *
   * @param arr - the array to be divided
   * @param scalar - the scalar to divide the array by
   * @return - a new array with element[i] = arr[i] / scalar
   */
  public static double[] scalarDivision(double[] arr, double scalar) {
    double[] result = new double[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] / scalar;
    }

    return result;
  }

  /**
   * Returns a new array where each element is the corresponding element in the given array, divided
   * by the given scalar using long division
   *
   * @param arr - the array to be divided
   * @param scalar - the scalar to divide the array by
   * @return - a new array with element[i] = arr[i] / scalar
   */
  public static long[] scalarDivision(long[] arr, long scalar) {
    long[] result = new long[arr.length];

    for (int i = 0; i < arr.length; i++) {
      result[i] = arr[i] / scalar;
    }

    return result;
  }

  /**
   * Returns a new array where each element is the multiplication of the corresponding elements in
   * the given arrays. If the arrays are not the same length, the result is the same size as the
   * shorter one.
   *
   * @param arr1 - the first array to be part of the multiplication
   * @param arr2 - the second array to be part of the multiplication
   * @return - a new integer array with element[i] = arr1[i] * arr2[i]
   */
  public static int[] multiply(int[] arr1, int[] arr2) {
    int[] result = new int[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] * arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array where each element is the multiplication of the corresponding elements in
   * the given arrays. If the arrays are not the same length, the result is the same size as the
   * shorter one.
   *
   * @param arr1 - the first array to be part of the multiplication
   * @param arr2 - the second array to be part of the multiplication
   * @return - a new float array with element[i] = arr1[i] * arr2[i]
   */
  public static float[] multiply(float[] arr1, float[] arr2) {
    float[] result = new float[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] * arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array where each element is the multiplication of the corresponding elements in
   * the given arrays. If the arrays are not the same length, the result is the same size as the
   * shorter one.
   *
   * @param arr1 - the first array to be part of the multiplication
   * @param arr2 - the second array to be part of the multiplication
   * @return - a new double array with element[i] = arr1[i] * arr2[i]
   */
  public static double[] multiply(double[] arr1, double[] arr2) {
    double[] result = new double[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] * arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array where each element is the multiplication of the corresponding elements in
   * the given arrays. If the arrays are not the same length, the result is the same size as the
   * shorter one.
   *
   * @param arr1 - the first array to be part of the multiplication
   * @param arr2 - the second array to be part of the multiplication
   * @return - a new long array with element[i] = arr1[i] * arr2[i]
   */
  public static long[] multiply(long[] arr1, long[] arr2) {
    long[] result = new long[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] * arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array where each element is the division of the corresponding element in the
   * first array by that in the second. If the arrays are different lengths, the result is the same
   * length as the shorter of the two arrays.
   *
   * @param arr1 - the array to divide
   * @param arr2 - the array to divide by
   * @return - an integer array with element[i] = arr1[i] / arr2[i]
   */
  public static int[] divide(int[] arr1, int[] arr2) {
    int[] result = new int[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] / arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array where each element is the division of the corresponding element in the
   * first array by that in the second. If the arrays are different lengths, the result is the same
   * length as the shorter of the two arrays.
   *
   * @param arr1 - the array to divide
   * @param arr2 - the array to divide by
   * @return - a float array with element[i] = arr1[i] / arr2[i]
   */
  public static float[] divide(float[] arr1, float[] arr2) {
    float[] result = new float[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] / arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array where each element is the division of the corresponding element in the
   * first array by that in the second. If the arrays are different lengths, the result is the same
   * length as the shorter of the two arrays.
   *
   * @param arr1 - the array to divide
   * @param arr2 - the array to divide by
   * @return - a double array with element[i] = arr1[i] / arr2[i]
   */
  public static double[] divide(double[] arr1, double[] arr2) {
    double[] result = new double[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] / arr2[i];
    }

    return result;
  }

  /**
   * Returns a new array where each element is the division of the corresponding element in the
   * first array by that in the second. If the arrays are different lengths, the result is the same
   * length as the shorter of the two arrays.
   *
   * @param arr1 - the array to divide
   * @param arr2 - the array to divide by
   * @return - an integer array with element[i] = arr1[i] / arr2[i]
   */
  public static long[] divide(long[] arr1, long[] arr2) {
    long[] result = new long[Math.min(arr1.length, arr2.length)];

    for (int i = 0; i < Math.min(arr1.length, arr2.length); i++) {
      result[i] = arr1[i] / arr2[i];
    }

    return result;
  }

  /**
   * Returns the square root of the sum of all elements in the array squared.
   *
   * @param arr - the array to calculate the vector length of
   * @return - the vector length of the array
   */
  public static double vectorLength(int[] arr) {
    double sum = 0.0;

    for (int x : arr) {
      sum += Math.pow(x, 2);
    }

    return Math.sqrt(sum);
  }

  /**
   * Returns the square root of the sum of all elements in the array squared.
   *
   * @param arr - the array to calculate the vector length of
   * @return - the vector length of the array
   */
  public static double vectorLength(double[] arr) {
    double sum = 0.0;

    for (double x : arr) {
      sum += Math.pow(x, 2);
    }

    return Math.sqrt(sum);
  }

  /**
   * Returns the square root of the sum of all elements in the array squared.
   *
   * @param arr - the array to calculate the vector length of
   * @return - the vector length of the array
   */
  public static double vectorLength(float[] arr) {
    double sum = 0.0;

    for (float x : arr) {
      sum += Math.pow(x, 2);
    }

    return Math.sqrt(sum);
  }

  /**
   * Returns the square root of the sum of all elements in the array squared.
   *
   * @param arr - the array to calculate the vector length of
   * @return - the vector length of the array
   */
  public static double vectorLength(long[] arr) {
    double sum = 0.0;

    for (long x : arr) {
      sum += Math.pow(x, 2);
    }

    return Math.sqrt(sum);
  }

  /**
   * Returns the square root of the sum of all elements in the array squared.
   *
   * @param arr - the array to calculate the vector length of
   * @return - the vector length of the array
   */
  public static double vectorLength(short[] arr) {
    double sum = 0.0;

    for (short x : arr) {
      sum += Math.pow(x, 2);
    }

    return Math.sqrt(sum);
  }

  /**
   * Returns the square root of the sum of all elements in the array squared.
   *
   * @param arr - the array to calculate the vector length of
   * @return - the vector length of the array
   */
  public static double vectorLength(byte[] arr) {
    double sum = 0.0;

    for (byte x : arr) {
      sum += Math.pow(x, 2);
    }

    return Math.sqrt(sum);
  }

  /**
   * Returns the mean average of the values in the array
   *
   * @param arr - the array to calculate the mean over
   * @return - the mean average of the values in the array
   */
  public static double mean(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    return (double) Arrays.stream(arr).sum() / (double) arr.length;
  }

  /**
   * Returns the mean average of the values in the array
   *
   * @param arr - the array to calculate the mean over
   * @return - the mean average of the values in the array
   */
  public static double mean(float[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    double sum = 0;

    for (float value : arr) {
      sum += value;
    }

    return sum / arr.length;
  }

  /**
   * Returns the mean average of the values in the array
   *
   * @param arr - the array to calculate the mean over
   * @return - the mean average of the values in the array
   */
  public static double mean(double[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    return Arrays.stream(arr).sum() / arr.length;
  }

  /**
   * Returns the mean average of the values in the array
   *
   * @param arr - the array to calculate the mean over
   * @return - the mean average of the values in the array
   */
  public static double mean(long[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    return (double) Arrays.stream(arr).sum() / (double) arr.length;
  }

  /**
   * Returns the mean average of the values in the array
   *
   * @param arr - the array to calculate the mean over
   * @return - the mean average of the values in the array
   */
  public static double mean(short[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    double sum = 0;

    for (short value : arr) {
      sum += value;
    }

    return sum / arr.length;
  }

  /**
   * Returns the mean average of the values in the array
   *
   * @param arr - the array to calculate the mean over
   * @return - the mean average of the values in the array
   */
  public static double mean(byte[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    double sum = 0;

    for (byte value : arr) {
      sum += value;
    }

    return sum / arr.length;
  }

  /**
   * Returns the last most frequently occurring value in the array (the mode)
   *
   * @param arr - the array to find the mode value for
   * @return - the mode of the array
   */
  public static int mode(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int value : arr) {
      if (map.containsKey(value)) {
        map.put(value, map.get(value) + 1);
      } else {
        map.put(value, 1);
      }
    }

    return map.entrySet().stream()
        .reduce((x, y) -> x.getValue() > y.getValue() ? x : y)
        .get()
        .getKey();
  }

  /**
   * Returns the last most frequently occurring value in the array (the mode)
   *
   * @param arr - the array to find the mode value for
   * @return - the mode of the array
   */
  public static double mode(double[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    HashMap<Double, Integer> map = new HashMap<>();

    for (double value : arr) {
      if (map.containsKey(value)) {
        map.put(value, map.get(value) + 1);
      } else {
        map.put(value, 1);
      }
    }

    return map.entrySet().stream()
        .reduce((x, y) -> x.getValue() > y.getValue() ? x : y)
        .get()
        .getKey();
  }

  /**
   * Returns the last most frequently occurring value in the array (the mode)
   *
   * @param arr - the array to find the mode value for
   * @return - the mode of the array
   */
  public static long mode(long[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    HashMap<Long, Integer> map = new HashMap<>();

    for (long value : arr) {
      if (map.containsKey(value)) {
        map.put(value, map.get(value) + 1);
      } else {
        map.put(value, 1);
      }
    }

    return map.entrySet().stream()
        .reduce((x, y) -> x.getValue() > y.getValue() ? x : y)
        .get()
        .getKey();
  }

  /**
   * Returns the last most frequently occurring value in the array (the mode)
   *
   * @param arr - the array to find the mode value for
   * @return - the mode of the array
   */
  public static float mode(float[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    HashMap<Float, Integer> map = new HashMap<>();

    for (float value : arr) {
      if (map.containsKey(value)) {
        map.put(value, map.get(value) + 1);
      } else {
        map.put(value, 1);
      }
    }

    return map.entrySet().stream()
        .reduce((x, y) -> x.getValue() > y.getValue() ? x : y)
        .get()
        .getKey();
  }

  /**
   * Returns the last most frequently occurring value in the array (the mode)
   *
   * @param arr - the array to find the mode value for
   * @return - the mode of the array
   */
  public static short mode(short[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    HashMap<Short, Integer> map = new HashMap<>();

    for (short value : arr) {
      if (map.containsKey(value)) {
        map.put(value, map.get(value) + 1);
      } else {
        map.put(value, 1);
      }
    }

    return map.entrySet().stream()
        .reduce((x, y) -> x.getValue() > y.getValue() ? x : y)
        .get()
        .getKey();
  }

  /**
   * Returns the last most frequently occurring value in the array (the mode)
   *
   * @param arr - the array to find the mode value for
   * @return - the mode of the array
   */
  public static byte mode(byte[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    HashMap<Byte, Integer> map = new HashMap<>();

    for (byte value : arr) {
      if (map.containsKey(value)) {
        map.put(value, map.get(value) + 1);
      } else {
        map.put(value, 1);
      }
    }

    return map.entrySet().stream()
        .reduce((x, y) -> x.getValue() > y.getValue() ? x : y)
        .get()
        .getKey();
  }

  /**
   * Returns the median average of the array Calculated by sorting the array and taking the midpoint
   * if of odd length, or the mean of the midpoints if of even length.
   *
   * @param arr - the array to find the median average of
   * @return - the median average of the array
   */
  public static int median(int[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    int[] copy = arr.clone();
    Arrays.sort(copy);

    return arr.length % 2 == 1
        ? copy[arr.length / 2]
        : (copy[arr.length / 2 - 1] + copy[arr.length / 2]) / 2;
  }

  /**
   * Returns the median average of the array Calculated by sorting the array and taking the midpoint
   * if of odd length, or the mean of the midpoints if of even length.
   *
   * @param arr - the array to find the median average of
   * @return - the median average of the array
   */
  public static double median(double[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    double[] copy = arr.clone();
    Arrays.sort(copy);

    return arr.length % 2 == 1
        ? copy[arr.length / 2]
        : (copy[arr.length / 2 - 1] + copy[arr.length / 2]) / 2;
  }

  /**
   * Returns the median average of the array Calculated by sorting the array and taking the midpoint
   * if of odd length, or the mean of the midpoints if of even length.
   *
   * @param arr - the array to find the median average of
   * @return - the median average of the array
   */
  public static float median(float[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    float[] copy = arr.clone();
    Arrays.sort(copy);

    return arr.length % 2 == 1
        ? copy[arr.length / 2]
        : (copy[arr.length / 2 - 1] + copy[arr.length / 2]) / 2;
  }

  /**
   * Returns the median average of the array Calculated by sorting the array and taking the midpoint
   * if of odd length, or the mean of the midpoints if of even length.
   *
   * @param arr - the array to find the median average of
   * @return - the median average of the array
   */
  public static long median(long[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    long[] copy = arr.clone();
    Arrays.sort(copy);

    return arr.length % 2 == 1
        ? copy[arr.length / 2]
        : (copy[arr.length / 2 - 1] + copy[arr.length / 2]) / 2;
  }

  /**
   * Returns the median average of the array Calculated by sorting the array and taking the midpoint
   * if of odd length, or the mean of the midpoints if of even length.
   *
   * @param arr - the array to find the median average of
   * @return - the median average of the array
   */
  public static short median(short[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    short[] copy = arr.clone();
    Arrays.sort(copy);

    return arr.length % 2 == 1
        ? copy[arr.length / 2]
        : (short) ((copy[arr.length / 2 - 1] + copy[arr.length / 2]) / (short) 2);
  }

  /**
   * Returns the median average of the array Calculated by sorting the array and taking the midpoint
   * if of odd length, or the mean of the midpoints if of even length.
   *
   * @param arr - the array to find the median average of
   * @return - the median average of the array
   */
  public static byte median(byte[] arr) {
    if (arr.length == 0) {
      return 0;
    }

    byte[] copy = arr.clone();
    Arrays.sort(copy);

    return arr.length % 2 == 1
        ? copy[arr.length / 2]
        : (byte) ((copy[arr.length / 2 - 1] + copy[arr.length / 2]) / (byte) 2);
  }

  /**
   * Returns the minimum value stored in the array, or null if the array is empty
   *
   * @param arr - the array to find the minimum value for
   * @param <T> - the type for the array can be any class which is a subclass of
   *           Comparable
   * @return - the minimum value in the array
   */
  public static <T extends Comparable<T>> T minimum(T[] arr) {
    T minValue = null;
    for (T value : arr) {
      if (minValue == null || value.compareTo(minValue) < 0) {
        minValue = value;
      }
    }

    return minValue;
  }

  /**
   * Returns the maximum value stored in the array, or null if the array is empty
   *
   * @param arr - the array to find the maximum value for
   * @param <T> - the type for the array can be any class which is a subclass of
   *           Comparable.
   * @return - the minimum value in the array
   */
  public static <T extends Comparable<T>> T maximum(T[] arr) {
    T maxValue = null;
    for(T value : arr) {
      if(maxValue == null || value.compareTo(maxValue) > 0) {
        maxValue = value;
      }
    }

    return maxValue;
  }

  /**
   * Returns the index of the array's minimum value, or -1 if the array is empty
   *
   * @param arr - the array to find the minimum location for
   * @param <T> - the array can be any type which extends Comparable
   * @return - the index of the minimum value stored in the array
   */
  public static <T extends Comparable<T>> int minimumLocation(T[] arr) {
    T minValue = null;
    int minLocation = -1;

    for(int i = 0; i < arr.length; i++) {
      if(minValue == null || arr[i].compareTo(minValue) < 0) {
        minValue = arr[i];
        minLocation = i;
      }
    }

    return minLocation;
  }

  /**
   * Returns the index of the array's minimum value, or -1 if the array is empty
   *
   * @param arr - the array to find the minimum location for
   * @param <T> - the array can be any type which extends Comparable
   * @return - the index of the minimum value stored in the array
   */
  public static <T extends Comparable<T>> int maximumLocation(T[] arr) {
    T maxValue = null;
    int maxLocation = -1;

    for(int i = 0; i < arr.length; i++) {
      if(maxValue == null || arr[i].compareTo(maxValue) > 0) {
        maxValue = arr[i];
        maxLocation = i;
      }
    }

    return maxLocation;
  }
}

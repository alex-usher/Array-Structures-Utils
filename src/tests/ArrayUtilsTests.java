package tests;

import org.junit.Assert;
import org.junit.Test;
import ArrayUtils.ArrayUtils;

import static org.junit.Assert.*;

public class ArrayUtilsTests {

  @Test
  public void testAdd() {
    double[] double1 = {1.0, 2.0, 3.0, 4.0};
    double[] double2 = {4.0, 3.0, 2.0, 1.0};
    double[] exp1 = {5.0, 5.0, 5.0, 5.0};

    assertArrayEquals("Double add tests", exp1, ArrayUtils.add(double1, double2), 0.0001);

    int[] int1 = {1, 0, 2, -1};
    int[] int2 = {0, 1, -1, 2};
    int[] exp2 = {1, 1, 1, 1};

    assertArrayEquals("Integer add test", exp2, ArrayUtils.add(int1, int2));

    float[] float1 = {1, 2, 3, 4};
    float[] float2 = {4, 3, 2, 1};
    float[] exp3 = {5, 5, 5, 5};

    assertArrayEquals("Float add test", exp3, ArrayUtils.add(float1, float2), 0);

    short[] short1 = {1, 0, 2, -1};
    short[] short2 = {0, 1, -1, 2};
    short[] exp4 = {1, 1, 1, 1};

    assertArrayEquals("Short add test", exp4, ArrayUtils.add(short1, short2));

    byte[] byte1 = {1, 2, 3, 4};
    byte[] byte2 = {4, 3, 2, 1};
    byte[] exp5 = {5, 5, 5, 5};

    assertArrayEquals("Byte add test", exp5, ArrayUtils.add(byte1, byte2));
  }

  @Test
  public void testSubtract() {
    int[] arr1 = {0, 2, 1, -1};
    int[] arr2 = {-1, 1, 0, -2};
    int[] exp1 = {1, 1, 1, 1};

    assertArrayEquals("Integer subtract test", exp1, ArrayUtils.subtract(arr1, arr2));

    double[] double1 = {9.0, 8.0, 7.0, 6.0};
    double[] double2 = {4.0, 3.0, 2.0, 1.0};
    double[] exp2 = {5.0, 5.0, 5.0, 5.0};

    assertArrayEquals("Double subtract test", exp2, ArrayUtils.subtract(double1, double2), 0.0001);

    float[] float1 = {0, 2, 1, -1};
    float[] float2 = {-1, 1, 0, -2};
    float[] exp3 = {1, 1, 1, 1};

    assertArrayEquals("Float subtract test", exp3, ArrayUtils.subtract(float1, float2), 0);

    long[] long1 = {9, 8, 7, 6};
    long[] long2 = {4, 3, 2, 1};
    long[] exp4 = {5, 5, 5, 5};

    assertArrayEquals("Long subtract test", exp4, ArrayUtils.subtract(long1, long2));

    short[] short1 = {0, 2, 1, -1};
    short[] short2 = {-1, 1, 0, -2};
    short[] exp5 = {1, 1, 1, 1};

    assertArrayEquals("Short subtract test", exp5, ArrayUtils.subtract(short1, short2));

    byte[] byte1 = {9, 8, 7, 6};
    byte[] byte2 = {4, 3, 2, 1};
    byte[] exp6 = {5, 5, 5, 5};

    assertArrayEquals("Byte subtract test", exp6, ArrayUtils.subtract(byte1, byte2));
  }

  @Test
  public void testDivide() {
    int[] int1 = {10, 10, 10, 10};
    int[] int2 = {5, 5, 5, 5};
    int[] exp1 = {1, 1, 1, 1};
    int[] exp2 = {2, 2, 2, 2};

    assertArrayEquals("Int divide test on itself", exp1, ArrayUtils.divide(int1, int1));
    assertArrayEquals("Int divide test", exp2, ArrayUtils.divide(int1, int2));
    assertArrayEquals(
        "Int divide test, testing floor division", exp2, ArrayUtils.divide(int2, exp2));

    double[] double1 = {10.0, 10.0, 10.0, 10.0};
    double[] double2 = {5.0, 5.0, 5.0, 5.0};
    double[] exp3 = {1.0, 1.0, 1.0, 1.0};
    double[] exp4 = {2.0, 2.0, 2.0, 2.0};
    double[] exp5 = {2.5, 2.5, 2.5, 2.5};

    assertArrayEquals(
        "Double divide test on itself", exp3, ArrayUtils.divide(double1, double1), 0.0001);
    assertArrayEquals("Double divide test", exp4, ArrayUtils.divide(double1, double2), 0.0001);
    assertArrayEquals("Double divide test 2", exp5, ArrayUtils.divide(double2, exp4), 0.0001);

    float[] float1 = {10, 10, 10, 10};
    float[] float2 = {5, 5, 5, 5};
    float[] exp6 = {1, 1, 1, 1};
    float[] exp7 = {2, 2, 2, 2};

    assertArrayEquals("Float divide test on itself", exp6, ArrayUtils.divide(float1, float1), 0);
    assertArrayEquals("Float divide test", exp7, ArrayUtils.divide(float1, float2), 0);
    assertArrayEquals(
        "Float divide test, testing float division", float2, ArrayUtils.divide(float1, exp7), 0);

    long[] long1 = {10, 10, 10, 10};
    long[] long2 = {5, 5, 5, 5};
    long[] exp8 = {1, 1, 1, 1};
    long[] exp9 = {2, 2, 2, 2};

    assertArrayEquals("long divide test on itself", exp8, ArrayUtils.divide(long1, long1));
    assertArrayEquals("long divide test", exp9, ArrayUtils.divide(long1, long2));
    assertArrayEquals(
        "long divide test, testing floor division", exp9, ArrayUtils.divide(long2, exp9));
  }

  @Test
  public void testMultiply() {
    int[] int1 = {2, 2, 2, 2};
    int[] int2 = {5, 5, 5, 5};
    int[] exp1 = {10, 10, 10, 10};

    assertArrayEquals("Int multiply test", exp1, ArrayUtils.multiply(int1, int2));

    double[] double1 = {2.0, 2.0, 2.0, 2.0};
    double[] double2 = {5.0, 5.0, 5.0, 5.0};
    double[] double3 = {0.5, 0.5, 0.5, 0.5};
    double[] exp2 = {10.0, 10.0, 10.0, 10.0};
    double[] exp3 = {1.0, 1.0, 1.0, 1.0};
    double[] exp4 = {2.5, 2.5, 2.5, 2.5};

    assertArrayEquals(
        "Double multiply test 1", exp2, ArrayUtils.multiply(double1, double2), 0.0001);
    assertArrayEquals(
        "Double multiply test 2", exp3, ArrayUtils.multiply(double1, double3), 0.0001);
    assertArrayEquals(
        "Double multiply test 3", exp4, ArrayUtils.multiply(double2, double3), 0.0001);

    float[] float1 = {2, 2, 2, 2};
    float[] float2 = {5, 5, 5, 5};
    float[] exp5 = {10, 10, 10, 10};

    assertArrayEquals("Float multiply test", exp5, ArrayUtils.multiply(float1, float2), 0);

    long[] long1 = {2, 2, 2, 2};
    long[] long2 = {5, 5, 5, 5};
    long[] exp6 = {10, 10, 10, 10};

    assertArrayEquals("Long multiply test", exp6, ArrayUtils.multiply(long1, long2));
  }

  @Test
  public void testScalarMultiplication() {
    int[] int1 = {5, 2, -1, 0};
    int[] exp1 = {10, 4, -2, 0};

    assertArrayEquals(
        "Int scalar multiplication test", exp1, ArrayUtils.scalarMultiplication(int1, 2));

    double[] double1 = {5.0, 2.0, -1.0, 0.0};
    double[] exp2 = {10.0, 4.0, -2.0, 0.0};
    double[] exp3 = {2.5, 1.0, -0.5, 0.0};

    assertArrayEquals(
        "Double scalar multiplication test 1",
        exp2,
        ArrayUtils.scalarMultiplication(double1, 2),
        0.0001);
    assertArrayEquals(
        "Double scalar multiplication test 2",
        exp3,
        ArrayUtils.scalarMultiplication(double1, 0.5),
        0.0001);

    float[] float1 = {5, 2, -1, 0};
    float[] exp4 = {10, 4, -2, 0};

    assertArrayEquals(
        "Float scalar multiplication test", exp4, ArrayUtils.scalarMultiplication(float1, 2), 0);

    long[] long1 = {5, 2, -1, 0};
    long[] exp5 = {10, 4, -2, 0};

    assertArrayEquals(
        "Long scalar multiplication test", exp5, ArrayUtils.scalarMultiplication(long1, 2));
  }

  @Test
  public void testScalarDivision() {
    int[] int1 = {10, 4, -2, 0};
    int[] exp1 = {5, 2, -1, 0};
    int[] exp2 = {2, 1, 0, 0};

    assertArrayEquals("Integer scalar division test", exp1, ArrayUtils.scalarDivision(int1, 2));
    assertArrayEquals(
        "Integer scalar floor division test", exp2, ArrayUtils.scalarDivision(int1, 4));

    double[] double1 = {10, 4, -2, 0};
    double[] exp3 = {5, 2, -1, 0};
    double[] exp4 = {2.5, 1, -0.5, 0};

    assertArrayEquals(
        "Double scalar division test 1", exp3, ArrayUtils.scalarDivision(double1, 2), 0.0001);
    assertArrayEquals(
        "Double scalar division test 2", exp4, ArrayUtils.scalarDivision(double1, 4), 0.0001);

    float[] float1 = {10, 4, -2, 0};
    float[] exp5 = {5, 2, -1, 0};
    float[] exp6 = {2, 1, 0, 0};

    assertArrayEquals("Float scalar division test", exp5, ArrayUtils.scalarDivision(float1, 2), 0);
    assertArrayEquals(
        "Float floating division test", exp6, ArrayUtils.scalarDivision(float1, 4), 1);

    long[] long1 = {10, 4, -2, 0};
    long[] exp7 = {5, 2, -1, 0};
    long[] exp8 = {2, 1, 0, 0};

    assertArrayEquals("Long scalar division test", exp7, ArrayUtils.scalarDivision(long1, 2));
    assertArrayEquals("Long scalar floor division test", exp8, ArrayUtils.scalarDivision(long1, 4));
  }

  @Test
  public void testMean() {
    int[] int1 = {2, 2, 2, 2};
    int[] int2 = {1, 2, 3, 4};

    assertEquals("Integer mean test for the same value", 2, ArrayUtils.mean(int1), 0.0001);
    assertEquals("Integer mean test for normal values", 2.5, ArrayUtils.mean(int2), 0.0001);

    double[] double1 = {2, 2, 2, 2};
    double[] double2 = {1.5, 2.5, 3.5, 4.5};

    assertEquals("Double mean for the same value", 2, ArrayUtils.mean(double1), 0.0001);
    assertEquals("Double mean for normal values", 3, ArrayUtils.mean(double2), 0.0001);

    float[] float1 = {2, 2, 2, 2};
    float[] float2 = {1, 2, 3, 4};

    assertEquals("Float mean test for the same value", 2, ArrayUtils.mean(float1), 0.0001);
    assertEquals("Float mean test for normal values", 2.5, ArrayUtils.mean(float2), 0.0001);

    long[] long1 = {2, 2, 2, 2};
    long[] long2 = {1, 2, 3, 4};

    assertEquals("Long mean test for the same value", 2, ArrayUtils.mean(long1), 0.0001);
    assertEquals("Long mean test for normal values", 2.5, ArrayUtils.mean(long2), 0.0001);

    short[] short1 = {2, 2, 2, 2};
    short[] short2 = {1, 2, 3, 4};

    assertEquals("Short mean test for the same value", 2, ArrayUtils.mean(short1), 0.0001);
    assertEquals("Short mean test for normal values", 2.5, ArrayUtils.mean(short2), 0.0001);

    byte[] byte1 = {2, 2, 2, 2};
    byte[] byte2 = {1, 2, 3, 4};

    assertEquals("Byte mean test for the same value", 2, ArrayUtils.mean(byte1), 0.0001);
    assertEquals("Byte mean test for normal values", 2.5, ArrayUtils.mean(byte2), 0.0001);
  }

  @Test
  public void testMode() {
    int[] int1 = {};
    int[] int2 = {1, 1, 1, 1};
    int[] int4 = {1, 4, 4, 3, 2};

    assertEquals("Integer mode test for empty array", 0, ArrayUtils.mode(int1));
    assertEquals("Integer mode test for the same value", 1, ArrayUtils.mode(int2));
    assertEquals("Integer mode test for normal values", 4, ArrayUtils.mode(int4));

    double[] double1 = {};
    double[] double2 = {1, 1, 1, 1};
    double[] double4 = {1, 4, 4, 3, 2};

    assertEquals("Double mode test for empty array", 0, ArrayUtils.mode(double1), 0.0001);
    assertEquals("Double mode test for the same value", 1, ArrayUtils.mode(double2), 0.0001);
    assertEquals("Double mode test for normal values", 4, ArrayUtils.mode(double4), 0.0001);

    long[] long1 = {};
    long[] long2 = {1, 1, 1, 1};
    long[] long4 = {1, 4, 4, 3, 2};

    assertEquals("Long mode test for empty array", 0, ArrayUtils.mode(long1));
    assertEquals("Long mode test for the same value", 1, ArrayUtils.mode(long2));
    assertEquals("Long mode test for normal values", 4, ArrayUtils.mode(long4));

    float[] float1 = {};
    float[] float2 = {1, 1, 1, 1};
    float[] float4 = {1, 4, 4, 3, 2};

    assertEquals("Float mode test for empty array", 0, ArrayUtils.mode(float1), 0);
    assertEquals("Float mode test for the same value", 1, ArrayUtils.mode(float2), 0);
    assertEquals("Float mode test for normal values", 4, ArrayUtils.mode(float4), 0);

    short[] short1 = {};
    short[] short2 = {1, 1, 1, 1};
    short[] short4 = {1, 4, 4, 3, 2};

    assertEquals("Short mode test for empty array", 0, ArrayUtils.mode(short1));
    assertEquals("Short mode test for the same value", 1, ArrayUtils.mode(short2));
    assertEquals("Short mode test for normal values", 4, ArrayUtils.mode(short4));

    byte[] byte1 = {};
    byte[] byte2 = {1, 1, 1, 1};
    byte[] byte4 = {1, 4, 4, 3, 2};

    assertEquals("Byte mode test for empty array", 0, ArrayUtils.mode(byte1));
    assertEquals("Byte mode test for the same value", 1, ArrayUtils.mode(byte2));
    assertEquals("Byte mode test for normal values", 4, ArrayUtils.mode(byte4));
  }

  @Test
  public void testMedian() {
    int[] int1 = {};
    int[] int2 = {1, 1, 1, 1};
    int[] int3 = {0, 1, 2, 3, 4, 5, 6};
    int[] int4 = {0, 1, 2, 3, 4, 5, 6, 7};

    assertEquals("Integer median test for empty array", 0, ArrayUtils.median(int1));
    assertEquals("Integer median test for the same values", 1, ArrayUtils.median(int2));
    assertEquals("Integer median test for normal values, odd length", 3, ArrayUtils.median(int3));
    assertEquals("Integer median test for normal values, even length", 3, ArrayUtils.median(int4));

    double[] double1 = {};
    double[] double2 = {1, 1, 1, 1};
    double[] double3 = {0, 1, 2, 3, 4, 5, 6};
    double[] double4 = {0, 1, 2, 3, 4, 5, 6, 7};

    assertEquals("Double median test for empty array", 0, ArrayUtils.median(double1), 0.0001);
    assertEquals("Double median test for the same values", 1, ArrayUtils.median(double2), 0.0001);
    assertEquals(
        "Double median test for normal values, odd length", 3, ArrayUtils.median(double3), 0.0001);
    assertEquals(
        "Double median test for normal values, even length",
        3.5,
        ArrayUtils.median(double4),
        0.0001);

    long[] long1 = {};
    long[] long2 = {1, 1, 1, 1};
    long[] long3 = {0, 1, 2, 3, 4, 5, 6};
    long[] long4 = {0, 1, 2, 3, 4, 5, 6, 7};

    assertEquals("Long median test for empty array", 0, ArrayUtils.median(long1));
    assertEquals("Long median test for the same values", 1, ArrayUtils.median(long2));
    assertEquals("Long median test for normal values, odd length", 3, ArrayUtils.median(long3));
    assertEquals("Long median test for normal values, even length", 3, ArrayUtils.median(long4));

    float[] float1 = {};
    float[] float2 = {1, 1, 1, 1};
    float[] float3 = {0, 1, 2, 3, 4, 5, 6};
    float[] float4 = {0, 1, 2, 3, 4, 5, 6, 7};

    assertEquals("Float median test for empty array", 0, ArrayUtils.median(float1), 0);
    assertEquals("Float median test for the same values", 1, ArrayUtils.median(float2), 0);
    assertEquals(
        "Float median test for normal values, odd length", 3, ArrayUtils.median(float3), 0);
    assertEquals(
        "Float median test for normal values, even length", 3.5, ArrayUtils.median(float4), 0);

    short[] short1 = {};
    short[] short2 = {1, 1, 1, 1};
    short[] short3 = {0, 1, 2, 3, 4, 5, 6};
    short[] short4 = {0, 1, 2, 3, 4, 5, 6, 7};

    assertEquals("Short median test for empty array", 0, ArrayUtils.median(short1));
    assertEquals("Short median test for the same values", 1, ArrayUtils.median(short2));
    assertEquals("Short median test for normal values, odd length", 3, ArrayUtils.median(short3));
    assertEquals("Short median test for normal values, even length", 3, ArrayUtils.median(short4));

    byte[] byte1 = {};
    byte[] byte2 = {1, 1, 1, 1};
    byte[] byte3 = {0, 1, 2, 3, 4, 5, 6};
    byte[] byte4 = {0, 1, 2, 3, 4, 5, 6, 7};

    assertEquals("Byte median test for empty array", 0, ArrayUtils.median(byte1));
    assertEquals("Byte median test for the same values", 1, ArrayUtils.median(byte2));
    assertEquals("Byte median test for normal values, odd length", 3, ArrayUtils.median(byte3));
    assertEquals("Byte median test for normal values, even length", 3, ArrayUtils.median(byte4));
  }

  @Test
  public void testVectorLength() {
    int[] int1 = {};
    int[] int2 = {1, 1, 1, 1};
    int[] int3 = {1, 2, 3, -1};
    int[] int4 = {0};

    assertEquals(
        "Integer vector length test for empty array", 0, ArrayUtils.vectorLength(int1), 0.0001);
    assertEquals(
        "Integer vector length test for the same value", 2, ArrayUtils.vectorLength(int2), 0.0001);
    assertEquals(
        "Integer vector length test for normal values",
        Math.sqrt(15),
        ArrayUtils.vectorLength(int3),
        0.0001);
    assertEquals(
        "Integer vector length test for normal values", 0, ArrayUtils.vectorLength(int4), 0.0001);

    double[] double1 = {};
    double[] double2 = {1, 1, 1, 1};
    double[] double3 = {1, 2, 3, -1};
    double[] double4 = {0};
    double[] double5 = {1 / Math.sqrt(2), 1 / Math.sqrt(2)};

    assertEquals(
        "Double vector length test for empty array", 0, ArrayUtils.vectorLength(double1), 0.0001);
    assertEquals(
        "Double vector length test for the same value",
        2,
        ArrayUtils.vectorLength(double2),
        0.0001);
    assertEquals(
        "Double vector length test for normal values",
        Math.sqrt(15),
        ArrayUtils.vectorLength(double3),
        0.0001);
    assertEquals(
        "Double vector length test for normal values", 0, ArrayUtils.vectorLength(double4), 0.0001);
    assertEquals(
        "Double vector length test for unit vector", 1, ArrayUtils.vectorLength(double5), 0.0001);

    float[] float1 = {};
    float[] float2 = {1, 1, 1, 1};
    float[] float3 = {1, 2, 3, -1};
    float[] float4 = {0};

    assertEquals(
        "Float vector length test for empty array", 0, ArrayUtils.vectorLength(float1), 0.0001);
    assertEquals(
        "Float vector length test for the same value", 2, ArrayUtils.vectorLength(float2), 0.0001);
    assertEquals(
        "Float vector length test for normal values",
        Math.sqrt(15),
        ArrayUtils.vectorLength(float3),
        0.0001);
    assertEquals(
        "Float vector length test for normal values", 0, ArrayUtils.vectorLength(float4), 0.0001);

    long[] long1 = {};
    long[] long2 = {1, 1, 1, 1};
    long[] long3 = {1, 2, 3, -1};
    long[] long4 = {0};

    assertEquals(
        "Long vector length test for empty array", 0, ArrayUtils.vectorLength(long1), 0.0001);
    assertEquals(
        "Long vector length test for the same value", 2, ArrayUtils.vectorLength(long2), 0.0001);
    assertEquals(
        "Long vector length test for normal values",
        Math.sqrt(15),
        ArrayUtils.vectorLength(long3),
        0.0001);
    assertEquals(
        "Long vector length test for normal values", 0, ArrayUtils.vectorLength(long4), 0.0001);

    short[] short1 = {};
    short[] short2 = {1, 1, 1, 1};
    short[] short3 = {1, 2, 3, -1};
    short[] short4 = {0};

    assertEquals(
        "Short vector length test for empty array", 0, ArrayUtils.vectorLength(short1), 0.0001);
    assertEquals(
        "Short vector length test for the same value", 2, ArrayUtils.vectorLength(short2), 0.0001);
    assertEquals(
        "Short vector length test for normal values",
        Math.sqrt(15),
        ArrayUtils.vectorLength(short3),
        0.0001);
    assertEquals(
        "Short vector length test for normal values", 0, ArrayUtils.vectorLength(short4), 0.0001);

    byte[] byte1 = {};
    byte[] byte2 = {1, 1, 1, 1};
    byte[] byte3 = {1, 2, 3, -1};
    byte[] byte4 = {0};

    assertEquals(
        "Byte vector length test for empty array", 0, ArrayUtils.vectorLength(byte1), 0.0001);
    assertEquals(
        "Byte vector length test for the same value", 2, ArrayUtils.vectorLength(byte2), 0.0001);
    assertEquals(
        "Byte vector length test for normal values",
        Math.sqrt(15),
        ArrayUtils.vectorLength(byte3),
        0.0001);
    assertEquals(
        "Byte vector length test for normal values", 0, ArrayUtils.vectorLength(byte4), 0.0001);
  }

  @Test
  public void testMinimumAndMinimumLocation() {
    String[] arr1 = {"", "12", "1234", "1245"};

    assertEquals("String minimum test", "", ArrayUtils.minimum(arr1));
    assertEquals("String minimum location test", 0, ArrayUtils.minimumLocation(arr1));

    String[] arr2 = {"1234", "12345"};
    assertEquals(
        "String minimum test for edge case, strings identical but one is shorter",
        "1234",
        ArrayUtils.minimum(arr2));
    assertEquals(
        "String minimum location test for edge case, strings identical but one is shorter",
        0,
        ArrayUtils.minimumLocation(arr2));

    Integer[] arr3 = {0, 0, 0, -1};
    assertEquals(
        "Integer minimum test, testing negative values", new Integer(-1), ArrayUtils.minimum(arr3));
    assertEquals(
        "Integer minimum location test, testing negative values",
        3,
        ArrayUtils.minimumLocation(arr3));

    int[] arr4 = {0, 0, 0, -1};
    assertEquals("int minimum test, testing negative values", -1, ArrayUtils.minimum(arr4));
    assertEquals(
        "int minimum location test, testing negative values", 3, ArrayUtils.minimumLocation(arr4));

    double[] arr5 = {0.4, 0.401, 0.45, 0.41, 0.49};
    assertEquals(
        "double minimum test, testing small margins between values",
        0.4,
        ArrayUtils.minimum(arr5),
        0.0001);
    assertEquals(
        "double minimum location test, testing small margins between values",
        0,
        ArrayUtils.minimumLocation(arr5));
  }

  @Test
  public void testMaximumAndMaximumLocation() {
    String[] arr1 = {"", "12", "1234", "1245"};

    assertEquals("String maximum test", "1245", ArrayUtils.maximum(arr1));
    assertEquals("String maximum location test", 3, ArrayUtils.maximumLocation(arr1));

    String[] arr2 = {"1234", "12345"};
    assertEquals(
            "String maximum test for edge case, strings identical but one is shorter",
            "12345",
            ArrayUtils.maximum(arr2));
    assertEquals(
            "String maximum location test for edge case, strings identical but one is shorter",
            1,
            ArrayUtils.maximumLocation(arr2));

    Integer[] arr3 = {0, 0, 0, -1};
    assertEquals(
            "Integer maximum test, testing negative values", new Integer(0), ArrayUtils.maximum(arr3));
    assertEquals(
            "Integer maximum location test, testing negative values",
            0,
            ArrayUtils.maximumLocation(arr3));

    int[] arr4 = {0, 0, 0, -1};
    assertEquals("int maximum test, testing negative values", 0, ArrayUtils.maximum(arr4));
    assertEquals(
            "int maximum location test, testing negative values", 0, ArrayUtils.maximumLocation(arr4));

    double[] arr5 = {0.4, 0.401, 0.45, 0.41, 0.49};
    assertEquals(
            "double maximum test, testing small margins between values",
            0.49,
            ArrayUtils.maximum(arr5),
            0.0001);
    assertEquals(
            "double maximum location test, testing small margins between values",
            4,
            ArrayUtils.maximumLocation(arr5));
  }

  @Test
  public void testPower() {
    int[] arr = {1, 2, 3, 4};
    int[] exp = {1, 1, 1, 1};

    assertArrayEquals("Integer power test", exp, ArrayUtils.power(arr, 0));

    double[] arr1 = {1, 4, 9, 16};
    double[] exp1 = {1, 2, 3, 4};

    assertArrayEquals("Double power test", exp1, ArrayUtils.power(arr1, 0.5), 0.0001);
  }

  @Test
  public void testConcat() {
    String[] arr1 = {"Hello"};
    String[] arr2 = {"World"};
    String[] exp1 = {"Hello", "World"};

    assertArrayEquals("String concat() Normal Test", exp1, ArrayUtils.concat(arr1, arr2));
    assertArrayEquals("String concat() Test for first array being empty", exp1, ArrayUtils.concat(new String[0], exp1));
    assertArrayEquals("String concat() Test for second array being empty", exp1, ArrayUtils.concat(exp1, new String[0]));

    int[] arr3 = {1, 2, 3};
    int[] arr4 = {4, 5, 6};
    int[] exp2 = {1, 2, 3, 4, 5, 6};

    assertArrayEquals("Normal int concat() test", exp2, ArrayUtils.concat(arr3, arr4));
    assertArrayEquals("int concat() test for first array being empty", exp2, ArrayUtils.concat(new int[0], exp2));
    assertArrayEquals("int concat() test for second array being empty", exp2, ArrayUtils.concat(exp2, new int[0]));

    double[] arr5 = {1, 2, 3};
    double[] arr6 = {4, 5, 6};
    double[] exp3 = {1, 2, 3, 4, 5, 6};

    assertArrayEquals("Normal double concat() test", exp3, ArrayUtils.concat(arr5, arr6), 0.0001);
    assertArrayEquals("double concat() test for first array being empty", exp3, ArrayUtils.concat(new double[0], exp3), 0.0001);
    assertArrayEquals("double concat() test for second array being empty", exp3, ArrayUtils.concat(exp3, new double[0]), 0.0001);

    long[] arr7 = {1, 2, 3};
    long[] arr8 = {4, 5, 6};
    long[] exp4 = {1, 2, 3, 4, 5, 6};

    assertArrayEquals("Normal long concat() test", exp4, ArrayUtils.concat(arr7, arr8));
    assertArrayEquals("long concat() test for first array being empty", exp4, ArrayUtils.concat(new long[0], exp4));
    assertArrayEquals("long concat() test for second array being empty", exp4, ArrayUtils.concat(exp4, new long[0]));
  }
}

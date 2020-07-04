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

    assertArrayEquals(
        "Float subtract test", exp3, ArrayUtils.subtract(float1, float2), 0);

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

    assertArrayEquals(
        "Float divide test on itself", exp6, ArrayUtils.divide(float1, float1), 0);
    assertArrayEquals("Float divide test", exp7, ArrayUtils.divide(float1, float2), 0);
    assertArrayEquals(
        "Float divide test, testing float division",
        float2,
        ArrayUtils.divide(float1, exp7),
        0);

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

    assertArrayEquals("Double multiply test 1", exp2, ArrayUtils.multiply(double1, double2), 0.0001);
    assertArrayEquals("Double multiply test 2", exp3, ArrayUtils.multiply(double1, double3), 0.0001);
    assertArrayEquals("Double multiply test 3", exp4, ArrayUtils.multiply(double2, double3), 0.0001);

    float[] float1 = {2, 2, 2, 2};
    float[] float2 = {5, 5, 5, 5};
    float[] exp5 = {10, 10, 10, 10};

    assertArrayEquals("Float multiply test", exp5, ArrayUtils.multiply(float1, float2), 0);

    long[] long1 = {2, 2, 2, 2};
    long[] long2 = {5, 5, 5, 5};
    long[] exp6 = {10, 10, 10, 10};

    assertArrayEquals("Long multiply test", exp6, ArrayUtils.multiply(long1, long2));
  }
}

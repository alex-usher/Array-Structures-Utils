package tests;

import Exceptions.NullVectorException;
import Exceptions.VectorException;
import Exceptions.VectorPositionException;
import Vector.DoubleVector;
import org.junit.Test;

import static org.junit.Assert.*;

public class VectorTests {

  @Test
  public void testDimension() {
    Double[] arr = {1.0, 2.0, 3.0};
    assertEquals(
        "Dimension from vector initialised with array", 3, new DoubleVector(arr).getDimension());

    assertEquals(
        "Dimension vector initialised with dimension", 2, new DoubleVector(2).getDimension());
  }

  @Test
  public void testGetLength() {
    assertEquals("Initialised vector has length 0", 0.0, new DoubleVector(5).getLength(), 0.001);

    Double[] arr = {1.0, 1.0, 1.0};
    assertEquals("Vector length test 1", Math.sqrt(3), new DoubleVector(arr).getLength(), 0.001);
  }

  @Test
  public void testSameSize() {
    assertTrue("Same Size Vector Test", new DoubleVector(4).sameSize(new DoubleVector(4)));
    assertFalse("Different Size Vector Test", new DoubleVector(4).sameSize(new DoubleVector(5)));
  }

  @Test(expected = NullVectorException.class)
  public void testSameSizeException() {
    new DoubleVector(5).sameSize(null);
  }

  @Test
  public void testSameLength() {
    Double[] arr = {1.0, 1.0, 1.0};
    assertTrue(
        "Vectors with same values have the same length",
        new DoubleVector(arr).sameLength(new DoubleVector(arr)));

    Double[] arr1 = {Math.sqrt(3), 0.0, 0.0};
    assertTrue(
        "Vectors with different values but the same length",
        new DoubleVector(arr).sameLength(new DoubleVector(arr1)));

    Double[] arr2 = {2.0, 1.0, 0.0};
    assertFalse(
        "Vectors with different lengths", new DoubleVector(arr).sameLength(new DoubleVector(arr2)));

    Double[] arr3 = {Math.sqrt(3)};
    assertTrue(
        "Different dimension vector but same length",
        new DoubleVector(arr).sameLength(new DoubleVector(arr3)));
  }

  @Test(expected = NullVectorException.class)
  public void testSameLengthException() {
    new DoubleVector(5).sameLength(null);
  }

  @Test
  public void testPosition() {
    Double[] arr = {1.0, 2.0, 3.0, 4.0};
    DoubleVector vector = new DoubleVector(arr);

    for (int i = 0; i < arr.length; i++) {
      assertEquals("position() test", arr[i], vector.position(i));
    }
  }

  @Test(expected = VectorPositionException.class)
  public void testPositionException() {
    new DoubleVector(5).position(9);
  }

  @Test
  public void testSetPosition() {
    DoubleVector v = new DoubleVector(3);
    v.setPosition(1.0, 1);
    assertEquals("setPosition() doesn't change other values", 0.0, v.position(0), 0.001);
    assertEquals("setPosition() changes the given position", 1.0, v.position(1), 0.0001);
    assertEquals("setPosition() doesn't change other values", 0.0, v.position(2), 0.0001);
  }

  @Test(expected = NullPointerException.class)
  public void testSetPositionException1() {
    new DoubleVector(4).setPosition(null, 0);
  }

  @Test(expected = VectorPositionException.class)
  public void testSetPositionException2() {
    new DoubleVector(3).setPosition(0.0, 5);
  }

  @Test
  public void testGetMin() {
    Double[] arr = {1.0, 2.0, 4.0, 0.5};
    assertEquals("Normal getMin()", 0.5, new DoubleVector(arr).getMin(), 0.0001);

    Double[] arr1 = {1.0, 1.0, 1.0, 1.0};
    assertEquals("getMin() with all same values", 1.0, new DoubleVector(arr1).getMin(), 0.0001);

    Double[] arr2 = {};
    assertNull("getMin() with empty array", new DoubleVector(arr2).getMin());
  }

  @Test
  public void testGetMax() {
    Double[] arr = {1.0, 2.0, 4.0, 0.5};
    assertEquals("Normal getMax()", 4.0, new DoubleVector(arr).getMax(), 0.0001);

    Double[] arr1 = {1.0, 1.0, 1.0, 1.0};
    assertEquals("getMax() with all same values", 1.0, new DoubleVector(arr1).getMax(), 0.0001);

    Double[] arr2 = {};
    assertNull("getMin() with empty array", new DoubleVector(arr2).getMax());
  }

  @Test
  public void testGetMinLocation() {
    Double[] arr = {1.0, 2.0, 4.0, 0.5};
    assertEquals("Normal getMinLocation()", 3, new DoubleVector(arr).getMinLocation());

    Double[] arr1 = {1.0, 1.0, 1.0, 1.0};
    assertEquals(
        "getMinLocation() with all same values", 0, new DoubleVector(arr1).getMinLocation());

    Double[] arr2 = {};
    assertEquals("getMinLocation() with empty array", -1, new DoubleVector(arr2).getMinLocation());
  }

  @Test
  public void testGetMaxLocation() {
    Double[] arr = {1.0, 2.0, 4.0, 0.5};
    assertEquals("Normal getMaxLocation()", 2, new DoubleVector(arr).getMaxLocation());

    Double[] arr1 = {1.0, 1.0, 1.0, 1.0};
    assertEquals(
        "getMaxLocation() with all same values", 0, new DoubleVector(arr1).getMaxLocation());

    Double[] arr2 = {};
    assertEquals("getMaxLocation() with empty array", -1, new DoubleVector(arr2).getMaxLocation());
  }

  @Test
  public void testFill() {
    DoubleVector v = new DoubleVector(10);

    for (int i = 0; i < 10; i++) {
      assertEquals("Vector initialised and filled with zeros", 0.0, v.position(i), 0.0001);
    }

    v.fill(1.5);

    for (int i = 0; i < 10; i++) {
      assertEquals("Vector fill", 1.5, v.position(i), 0.0001);
    }
  }

  @Test
  public void testScalarMultiplication() {
    Double[] arr = {1.0, 2.0, 3.0};
    Double[] arrClone = arr.clone();
    double alpha = 1.5;

    DoubleVector v = new DoubleVector(arr);
    v.scalarMultiplication(alpha);

    for (int i = 0; i < v.getDimension(); i++) {
      assertEquals("Scalar Multiplication test", alpha * arrClone[i], v.position(i), 0.0001);
    }
  }

  @Test(expected = NullPointerException.class)
  public void testScalarMultiplicationException() {
    new DoubleVector(5).scalarMultiplication(null);
  }

  @Test
  public void testAdd() {
    Double[] arr1 = {0.0, 1.0, 2.0};
    Double[] arr2 = {1.0, 0.0, -1.0};
    Double[] arrExp = {1.0, 1.0, 1.0};

    assertEquals(
        "Normal add() test",
        new DoubleVector(arrExp),
        new DoubleVector(arr1).add(new DoubleVector(arr2)));
  }

  @Test(expected = NullPointerException.class)
  public void testAddException1() {
    new DoubleVector(5).add(null);
  }

  @Test(expected = VectorException.class)
  public void testAddException2() {
    new DoubleVector(5).add(new DoubleVector(6));
  }

  @Test
  public void testSubtract() {
    Double[] arr1 = {0.0, 1.0, 2.0};
    Double[] arr2 = {-1.0, 0.0, 1.0};
    Double[] arrExp = {1.0, 1.0, 1.0};

    assertEquals(
        "Normal add() test",
        new DoubleVector(arrExp),
        new DoubleVector(arr1).subtract(new DoubleVector(arr2)));
  }

  @Test(expected = NullPointerException.class)
  public void testSubtractException1() {
    new DoubleVector(5).subtract(null);
  }

  @Test(expected = VectorException.class)
  public void testSubtractException2() {
    new DoubleVector(5).subtract(new DoubleVector(6));
  }

  @Test
  public void testDotProduct() {
    Double[] arr1 = {1.0, 2.0, 3.0};
    Double[] arr2 = {1.0, 1.0, 1.0};
    Double[] arr3 = {1.0, 1.0, 1.0, 1.0};
    Double[] arr4 = {1.0, 1.0};

    assertEquals(
        "Dot product with same size vectors",
        6.0,
        new DoubleVector(arr1).dotProduct(new DoubleVector(arr2)),
        0.0001);
    assertEquals(
        "Dot product with larger vector",
        6.0,
        new DoubleVector(arr1).dotProduct(new DoubleVector(arr3)),
        0.0001);
    assertEquals(
        "Dot product with smaller vector",
        3.0,
        new DoubleVector(arr1).dotProduct(new DoubleVector(arr4)),
        0.0001);
  }

  @Test(expected = NullPointerException.class)
  public void testDotProductException() {
    new DoubleVector(5).dotProduct(null);
  }

  @Test
  public void testCrossProduct() {
    Double[] arr1 = {1.0, 1.0, 1.0};
    Double[] exp1 = {0.0, 0.0, 0.0};

    assertEquals(
        "Cross product of a vector with itself",
        new DoubleVector(exp1),
        new DoubleVector(arr1).crossProduct(new DoubleVector(arr1)));

    Double[] arr2 = {1.0, 2.0, 1.0};
    Double[] exp2 = {-1.0, 0.0, 1.0};

    assertEquals(
        "Cross product of two vectors",
        new DoubleVector(exp2),
        new DoubleVector(arr1).crossProduct(new DoubleVector(arr2)));
  }

  @Test(expected = NullPointerException.class)
  public void testCrossProductException1() {
    new DoubleVector(3).crossProduct(null);
  }

  @Test(expected = VectorException.class)
  public void testCrossProductException2() {
    new DoubleVector(4).crossProduct(new DoubleVector(5));
  }
}

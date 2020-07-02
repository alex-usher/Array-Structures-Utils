package tests;

import Exceptions.MatrixException;
import Exceptions.MatrixMultiplicationException;
import Exceptions.MatrixPositionException;
import Matrix.DoubleMatrix2D;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTests {

  @Test
  public void testInitialisation() {
    DoubleMatrix2D matrix1 = new DoubleMatrix2D(5);
    assertEquals("Number of columns correct for square matrix", 5, matrix1.getNumberOfColumns());
    assertEquals("Number of rows correct for square matrix", 5, matrix1.getNumberOfRows());

    DoubleMatrix2D matrix2 = new DoubleMatrix2D(10, 2);
    assertEquals(
        "Number of columns correct for non-square matrix", 2, matrix2.getNumberOfColumns());
    assertEquals("Number of rows correct for non-square matrix", 10, matrix2.getNumberOfRows());
  }

  @Test
  public void testEquality() {
    Double[][] matrix = {{1.0, 2.0, 3.0}};
    assertEquals(
        "Matrix equality for equal matrices",
        new DoubleMatrix2D(matrix),
        new DoubleMatrix2D(matrix));

    Double[][] matrix2 = {{1.5, 2.5, 3.5}};
    assertNotEquals(
        "Matrix equality for unequal matrices",
        new DoubleMatrix2D(matrix),
        new DoubleMatrix2D(matrix2));
  }

  @Test
  public void testTranspose() {
    Double[][] matrix = {{1.5, 2.5, 3.5}};
    Double[][] matrixTransposed = {{1.5}, {2.5}, {3.5}};

    DoubleMatrix2D mat = new DoubleMatrix2D(matrix);
    DoubleMatrix2D matTranspose = new DoubleMatrix2D(matrixTransposed);
    DoubleMatrix2D transposed = (DoubleMatrix2D) mat.transpose();

    assertEquals(
        "Dimensions swapped around for transpose matrix",
        matTranspose.getNumberOfColumns(),
        transposed.getNumberOfColumns());
    assertEquals(
        "Dimensions swapped around for transpose matrix",
        matTranspose.getNumberOfRows(),
        transposed.getNumberOfRows());

    assertEquals("Transpose normal case", matTranspose, transposed);

    Double[][] squareMatrix = {
      {1.0, 2.0, 1.0}, {2.0, 1.0, 2.0}, {1.0, 2.0, 1.0}
    }; // this matrix tranposed will be the same
    assertEquals(
        "Transposing a matrix where the transpose is the same",
        new DoubleMatrix2D(squareMatrix),
        new DoubleMatrix2D(squareMatrix).transpose());
  }

  @Test
  public void testAdd() {
    Double[][] mat1 = {{1.0, 1.0, 1.0}, {0.0, 0.0, 0.0}, {2.0, 2.0, 2.0}};
    Double[][] mat2 = {{0.0, 0.0, 0.0}, {1.0, 1.0, 1.0}, {-1.0, -1.0, -1.0}};
    Double[][] exp1 = {{1.0, 1.0, 1.0}, {1.0, 1.0, 1.0}, {1.0, 1.0, 1.0}};

    assertEquals(
        "Addition test 1",
        new DoubleMatrix2D(exp1),
        new DoubleMatrix2D(mat1).add(new DoubleMatrix2D(mat2)));

    assertEquals(
        "Addition test 2",
        new DoubleMatrix2D(4, 5),
        new DoubleMatrix2D(4, 5).add(new DoubleMatrix2D(5, 4).transpose()));
  }

  @Test(expected = MatrixException.class)
  public void testAddException() {
    DoubleMatrix2D mat1 = new DoubleMatrix2D(5, 4);
    DoubleMatrix2D mat2 = new DoubleMatrix2D(4, 5);

    mat1.add(mat2);
  }

  @Test
  public void testSubtract() {
    Double[][] mat1 = {{1.0, 1.0, 1.0}, {0.0, 0.0, 0.0}, {2.0, 2.0, 2.0}};
    Double[][] mat2 = {{0.0, 0.0, 0.0}, {-1.0, -1.0, -1.0}, {1.0, 1.0, 1.0}};
    Double[][] exp1 = {{1.0, 1.0, 1.0}, {1.0, 1.0, 1.0}, {1.0, 1.0, 1.0}};

    assertEquals(
        "Subtraction test 1",
        new DoubleMatrix2D(exp1),
        new DoubleMatrix2D(mat1).subtract(new DoubleMatrix2D(mat2)));

    assertEquals(
            "Subtraction test 2",
            new DoubleMatrix2D(4, 5),
            new DoubleMatrix2D(4, 5).subtract(new DoubleMatrix2D(5, 4).transpose()));
  }

  @Test(expected = MatrixException.class)
  public void testSubtractException(){
    DoubleMatrix2D mat1 = new DoubleMatrix2D(5, 4);
    DoubleMatrix2D mat2 = new DoubleMatrix2D(4, 5);

    mat1.subtract(mat2);
  }

  @Test
  public void testMultiply() {
    Double[][] identity2 = {{1.0, 0.0}, {0.0, 1.0}};
    Double[][] identity3 = {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};

    Double[][] matrixR2 = {{1.0, 1.0}, {0.0, 1.0}};
    Double[][] matrixR3 = {{1.0, 0.0, 1.0}, {0.0, 1.0, 0.0}, {1.0, 0.0, 1.0}};

    DoubleMatrix2D matrix2 = new DoubleMatrix2D(matrixR2);
    DoubleMatrix2D matrix3 = new DoubleMatrix2D(matrixR3);

    assertEquals(
        "Multiplication with 2x2 Identity",
        matrix2,
        matrix2.multiply(new DoubleMatrix2D(identity2)));
    assertEquals(
        "Multiplication with 3x3 identity",
        matrix3,
        matrix3.multiply(new DoubleMatrix2D(identity3)));

    Double[][] expected = {{1.0, 2.0}, {0.0, 1.0}};
    assertEquals(
        "2x2 Matrix Multiplication", new DoubleMatrix2D(expected), matrix2.multiply(matrix2));

    Double[][] expected1 = {{2.0, 0.0, 2.0}, {0.0, 1.0, 0.0}, {2.0, 0.0, 2.0}};
    assertEquals(
        "3x3 Matrix Multiplication", new DoubleMatrix2D(expected1), matrix3.multiply(matrix3));

    Double[][] m1 = {{1.0, 0.0}, {0.0, 1.0}, {1.0, 0.0}};
    Double[][] m2 = {{1.0, 1.0}, {1.0, 1.0}};
    Double[][] exp = {{1.0, 1.0}, {1.0, 1.0}, {1.0, 1.0}};

    assertEquals(
        "Non-square Matrix Multiplication",
        new DoubleMatrix2D(exp),
        new DoubleMatrix2D(m1).multiply(new DoubleMatrix2D(m2)));
  }

  @Test(expected = MatrixMultiplicationException.class)
  public void testMultiplyException() {
    Double[][] matrixR2 = {{1.0, 1.0}, {0.0, 1.0}};
    Double[][] matrixR3 = {{1.0, 0.0, 1.0}, {0.0, 1.0, 0.0}, {1.0, 0.0, 1.0}};

    new DoubleMatrix2D(matrixR2).multiply(new DoubleMatrix2D(matrixR3));
  }

  @Test
  public void testDotProduct() {
    Double[][] v1 = {{1.0}, {2.0}, {3.0}};
    Double[][] v2 = {{4.0}, {5.0}, {6.0}};

    assertEquals(
        "Testing normal case for dot product",
        new Double(32.0),
        new DoubleMatrix2D(v1).dotProduct(new DoubleMatrix2D(v2)));
  }

  @Test(expected = MatrixMultiplicationException.class)
  public void testDotProductException() {
    Double[][] v1 = {{1.0, 2.0}, {1.0, 2.0}};

    new DoubleMatrix2D(v1).dotProduct(new DoubleMatrix2D(v1));
  }

  @Test
  public void testIdentity() {
    Double[][] identity2 = {{1.0, 0.0}, {0.0, 1.0}};
    DoubleMatrix2D mat2 = new DoubleMatrix2D(2);
    mat2.identity();
    assertEquals("2x2 identity test", new DoubleMatrix2D(identity2), mat2);

    Double[][] identity3 = {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0, 1.0}};
    DoubleMatrix2D mat3 = new DoubleMatrix2D(3);
    mat3.identity();
    assertEquals("3x3 identity test", new DoubleMatrix2D(identity3), mat3);

    Double[][] identity4 = {
      {1.0, 0.0, 0.0, 0.0}, {0.0, 1.0, 0.0, 0.0}, {0.0, 0.0, 1.0, 0.0}, {0.0, 0.0, 0.0, 1.0}
    };
    DoubleMatrix2D mat4 = new DoubleMatrix2D(4);
    mat4.identity();
    assertEquals("4x4 identity test", new DoubleMatrix2D(identity4), mat4);
  }

  @Test(expected = MatrixException.class)
  public void testIdentityException() {
    DoubleMatrix2D mat = new DoubleMatrix2D(3, 5);
    mat.identity();
  }

  @Test
  public void testCofactor() {
    Double[][] matrix = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
    Double[][] cofactor1 = {{5.0, 6.0}, {8.0, 9.0}};

    assertEquals(
        "Cofactor Normal test 1",
        new DoubleMatrix2D(cofactor1),
        new DoubleMatrix2D(matrix).cofactor(0, 0));

    Double[][] matrix1 = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};
    Double[][] cofactor2 = {{1.0}, {3.0}};

    assertEquals(
        "Cofactor normal test 2",
        new DoubleMatrix2D(cofactor2),
        new DoubleMatrix2D(matrix1).cofactor(2, 1));
  }

  @Test
  public void testDeterminant() {
    Double[][] matrix1 = {{1.0, 0.0, 1.0}, {0.0, 1.0, 0.0}, {1.0, 0.0, 1.0}};
    Double[][] matrix2 = {{1.0, 1.0}, {2.0, 1.0}};
    Double[][] matrix3 = {
      {1.0, 0.0, 0.0, 0.0}, {0.0, 1.0, 0.0, 0.0}, {0.0, 0.0, 1.0, 1.0}, {0.0, 0.0, 2.0, 1.0}
    };

    assertEquals("Determinant Test 1", new Double(0), new DoubleMatrix2D(matrix1).determinant());
    assertEquals("Determinant Test 2", new Double(-1), new DoubleMatrix2D(matrix2).determinant());
    assertEquals("Determinant Test 3", new Double(-1), new DoubleMatrix2D(matrix3).determinant());
  }

  @Test(expected = MatrixException.class)
  public void testDeterminantException() {
    Double[][] matrix2 = {{1.0, 3.0}};

    new DoubleMatrix2D(matrix2).determinant();
  }

  @Test
  public void testCrossProduct() {
    Double[][] matrixVertical = {{1.0}, {1.0}, {1.0}};
    Double[][] expVertical = {{0.0}, {0.0}, {0.0}};

    assertEquals(
        "Cross Product Vertical",
        new DoubleMatrix2D(expVertical),
        new DoubleMatrix2D(matrixVertical).crossProduct(new DoubleMatrix2D(matrixVertical)));

    Double[][] matrixHorizontal = {{1.0, 1.0, 1.0}};
    Double[][] expHorizontal = {{0.0, 0.0, 0.0}};

    assertEquals(
        "Cross Product Horizontal",
        new DoubleMatrix2D(expHorizontal),
        new DoubleMatrix2D(matrixHorizontal).crossProduct(new DoubleMatrix2D(matrixHorizontal)));
  }

  @Test(expected = MatrixException.class)
  public void testCrossProductSameDimension() {
    Double[][] matrix = {{2.0, 0.0}, {2.0, 0.0}, {2.0, 0.0}};

    new DoubleMatrix2D(matrix).crossProduct(new DoubleMatrix2D(matrix));
  }

  @Test(expected = MatrixException.class)
  public void testCrossProductDifferentDimension() {
    DoubleMatrix2D mat1 = new DoubleMatrix2D(5);
    DoubleMatrix2D mat2 = new DoubleMatrix2D(6);

    mat1.crossProduct(mat2);
  }

  @Test(expected = MatrixPositionException.class)
  public void testCheckValidPosition() {
    DoubleMatrix2D matrix = new DoubleMatrix2D(5, 3);
    matrix.checkValidPosition(6, 3);
  }

  @Test
  public void testIsSquare() {
    DoubleMatrix2D matrixSquare = new DoubleMatrix2D(10);
    assertTrue("isSquare() returns true for square matrix", matrixSquare.isSquare());

    DoubleMatrix2D matrixNotSquare = new DoubleMatrix2D(4, 3);
    assertFalse("isSquare() returns false for non-square matrix", matrixNotSquare.isSquare());
  }

  @Test
  public void testSameSize() {
    DoubleMatrix2D matrix = new DoubleMatrix2D(10);
    assertTrue("Matrix is the same size as itself", matrix.sameSize(matrix));

    DoubleMatrix2D sameSize = new DoubleMatrix2D(10, 10);
    assertTrue("Same size matrix", matrix.sameSize(sameSize));

    DoubleMatrix2D differentSize = new DoubleMatrix2D(2);
    assertFalse("Different size matrix", matrix.sameSize(differentSize));
  }
}

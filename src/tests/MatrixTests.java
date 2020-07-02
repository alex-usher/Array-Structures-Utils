package tests;

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
    assertEquals("Number of columns correct for non-square matrix", 2, matrix2.getNumberOfColumns());
    assertEquals("Number of rows correct for non-square matrix", 10, matrix2.getNumberOfRows());
  }

  @Test
  public void testEquality() {
    Double[][] matrix = {{1.0, 2.0, 3.0}};
    assertEquals("Matrix equality for equal matrices", new DoubleMatrix2D(matrix), new DoubleMatrix2D(matrix));

    Double[][] matrix2 = {{1.5, 2.5, 3.5}};
    assertNotEquals("Matrix equality for unequal matrices", new DoubleMatrix2D(matrix), new DoubleMatrix2D(matrix2));
  }

  @Test
  public void testTranspose() {
    Double[][] matrix = {{1.5, 2.5, 3.5}};
    Double[][] matrixTransposed = {{1.5}, {2.5}, {3.5}};

    DoubleMatrix2D mat = new DoubleMatrix2D(matrix);
    DoubleMatrix2D matTranspose = new DoubleMatrix2D(matrixTransposed);
    DoubleMatrix2D transposed = (DoubleMatrix2D) mat.transpose();

    assertEquals("Dimensions swapped around for transpose matrix", matTranspose.getNumberOfColumns(), transposed.getNumberOfColumns());
    assertEquals("Dimensions swapped around for transpose matrix", matTranspose.getNumberOfRows(), transposed.getNumberOfRows());

    assertTrue("Transpose normal case", matTranspose.equals(transposed));
  }
}

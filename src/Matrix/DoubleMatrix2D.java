package Matrix;

import Exceptions.MatrixException;
import Exceptions.MatrixMultiplicationException;

public class DoubleMatrix2D extends AbstractMatrix2D<Double> {

  public DoubleMatrix2D(int rows, int columns) {
    super(rows, columns);
    fill(0.0);
  }

  public DoubleMatrix2D(int dimension) {
    super(dimension);
    fill(0.0);
  }

  public DoubleMatrix2D(Double[][] matrix) {
    super(matrix);
    fill(0.0);
  }

  @Override
  public MatrixType<Double> multiply(MatrixType<Double> m) {
    if(getNumberOfColumns() != m.getNumberOfRows()) {
      throw new MatrixMultiplicationException();
    }

    AbstractMatrix2D<Double> result = new DoubleMatrix2D(getNumberOfRows(), m.getNumberOfColumns());

    for(int i = 0; i < getNumberOfRows(); i++) {
      for(int j = 0; j < getNumberOfColumns(); j++) {
        for(int k = 0; k < m.getNumberOfColumns(); k++) {
          result.setPosition(result.position(i, k) + matrix[i][j] * m.position(j, k), i, k);
        }
      }
    }

    return result;
  }

  @Override
  public MatrixType<Double> transpose() {
    AbstractMatrix2D<Double> result = new DoubleMatrix2D(getNumberOfColumns(), getNumberOfRows());

    for(int i = 0; i < getNumberOfRows(); i++) {
      for(int j = 0; j < getNumberOfColumns(); j++) {
        result.setPosition(position(i, j), j, i);
      }
    }

    return result;
  }

  @Override
  public Double dotProduct(MatrixType<Double> m) {
    if(!(getNumberOfRows() == 1 && m.getNumberOfRows() == 1) || !(getNumberOfColumns() == 1 || m.getNumberOfColumns() == 1)) {
      throw new MatrixMultiplicationException("One of the dimensions must be 1");
    }

    double result = 0;

    for(int i = 0; i < Math.min(getNumberOfColumns(), m.getNumberOfColumns()); i++) {
      for(int j = 0; j < Math.min(getNumberOfRows(), m.getNumberOfRows()); j++) {
        result += matrix[i][j] * m.position(i, j);
      }
    }

    return result;
  }

  @Override
  public MatrixType<Double> cofactor(int i, int j) {
    checkValidPosition(i, j);
    AbstractMatrix2D<Double> cofactor = new DoubleMatrix2D(getNumberOfRows() - 1, getNumberOfColumns() - 1);

    int k = 0;
    int l = 0;

    for(int p = 0; p < getNumberOfRows(); p++) {
      if(p != i) {
        for (int q = 0; q < getNumberOfColumns(); q++) {
          if (q != j) {
            cofactor.matrix[k][l] = matrix[p][q];
            l++;
          }
        }
        k++;
      }
    }

    return cofactor;
  }

  @Override
  public Double determinant() {
    if(!isSquare()) {
      throw new MatrixException("Operation not supported for this dimension");
    }

    if(getNumberOfRows() == 1) {
      return matrix[0][0];
    }

    double det = 0;

    for(int i = 0; i < getNumberOfColumns(); i++) {
      det += Math.pow(-1, i) * matrix[0][i] * cofactor(0, i).determinant();
    }

    return det;
  }
}

package Matrix;

import Exceptions.MatrixException;
import Exceptions.MatrixMultiplicationException;

import java.util.Random;

public class IntegerMatrix2D extends AbstractMatrix2D<Integer> {

  public IntegerMatrix2D(int rows, int cols) {
    super(rows, cols);
    fill(0);
  }

  public IntegerMatrix2D(int dimension) {
    super(dimension);
    fill(0);
  }

  public IntegerMatrix2D(Integer[][] matrix) {
    super(matrix);
  }

  @Override
  public void identity() {
    if (isSquare()) {
      for (int i = 0; i < getNumberOfRows(); i++) {
        for (int j = 0; j < getNumberOfColumns(); j++) {
          if (i == j) {
            setPosition(1, i, j);
          } else {
            setPosition(0, i, j);
          }
        }
      }
    } else {
      throw new MatrixException("Matrix must be square");
    }
  }

  @Override
  public void randomFill(Integer lower, Integer upper) {
    Random random = new Random();

    for(int i = 0; i < getNumberOfRows(); i++) {
      for(int j = 0 ; j < getNumberOfColumns(); j++) {
        setPosition(random.nextInt(upper - lower) + lower, i, j);
      }
    }
  }

  @Override
  public MatrixType<Integer> transpose() {
    AbstractMatrix2D<Integer> result = new IntegerMatrix2D(getNumberOfColumns(), getNumberOfRows());

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        result.setPosition(position(i, j), j, i);
      }
    }

    return result;
  }

  @Override
  public MatrixType<Integer> add(MatrixType<Integer> m) {
    if (!sameSize(m)) {
      throw new MatrixException("Matrices must be the same size");
    }

    AbstractMatrix2D<Integer> result = new IntegerMatrix2D(getNumberOfRows(), getNumberOfColumns());

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        result.setPosition(position(i, j) + m.position(i, j), i, j);
      }
    }

    return result;
  }

  @Override
  public MatrixType<Integer> subtract(MatrixType<Integer> m) {
    if (!sameSize(m)) {
      throw new MatrixException("Matrices must be the same size");
    }

    AbstractMatrix2D<Integer> result = new IntegerMatrix2D(getNumberOfRows(), getNumberOfColumns());

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        result.setPosition(position(i, j) - m.position(i, j), i, j);
      }
    }

    return result;
  }

  @Override
  public MatrixType<Integer> multiply(MatrixType<Integer> m) {
    if (getNumberOfColumns() != m.getNumberOfRows()) {
      throw new MatrixMultiplicationException();
    }

    AbstractMatrix2D<Integer> result = new IntegerMatrix2D(getNumberOfRows(), m.getNumberOfColumns());

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        for (int k = 0; k < m.getNumberOfColumns(); k++) {
          result.setPosition(result.position(i, k) + position(i, j) * m.position(j, k), i, k);
        }
      }
    }

    return result;
  }

  @Override
  public Integer dotProduct(MatrixType<Integer> m) {
    if (getNumberOfRows() == 1 && m.getNumberOfRows() == 1
            || getNumberOfColumns() == 1 && m.getNumberOfColumns() == 1) {

      int result = 0;

      for (int i = 0; i < Math.min(getNumberOfColumns(), m.getNumberOfColumns()); i++) {
        for (int j = 0; j < Math.min(getNumberOfRows(), m.getNumberOfRows()); j++) {
          result += position(j, i) * m.position(j, i);
        }
      }

      return result;
    }

    throw new MatrixMultiplicationException("One of the dimensions must be 1");
  }

  @Override
  public MatrixType<Integer> cofactor(int i, int j) {
    checkValidPosition(i, j);
    AbstractMatrix2D<Integer> cofactor =
            new IntegerMatrix2D(getNumberOfRows() - 1, getNumberOfColumns() - 1);

    int k = 0;
    int l = 0;

    for (int p = 0; p < getNumberOfRows(); p++) {
      if (p != i) {
        for (int q = 0; q < getNumberOfColumns(); q++) {
          if (q != j) {
            cofactor.setPosition(position(p, q), k, l);
            l++;
          }
        }
        l = 0;
        k++;
      }
    }

    return cofactor;
  }

  @Override
  public Integer determinant() {
    if (!isSquare()) {
      throw new MatrixException("Operation not supported for this dimension");
    }

    if (getNumberOfRows() == 1) {
      return position(0, 0);
    }

    int det = 0;

    for (int i = 0; i < getNumberOfColumns(); i++) {
      det += Math.pow(-1, i) * position(0, i) * cofactor(0, i).determinant();
    }

    return det;
  }

  @Override
  public MatrixType<Integer> crossProduct(MatrixType<Integer> m) {
    if (sameSize(m)) {
      if (getNumberOfRows() == 3 && getNumberOfColumns() == 1) {
        AbstractMatrix2D<Integer> result =
                new IntegerMatrix2D(getNumberOfRows(), getNumberOfColumns());
        result.setPosition(
                position(1, 0) * m.position(2, 0) - position(2, 0) * m.position(1, 0), 0, 0);
        result.setPosition(
                position(2, 0) * m.position(0, 0) - position(0, 0) * m.position(2, 0), 1, 0);
        result.setPosition(
                position(0, 0) * m.position(1, 0) - position(1, 0) * m.position(0, 0), 2, 0);
        return result;
      } else if (getNumberOfRows() == 1 && getNumberOfColumns() == 3) {
        AbstractMatrix2D<Integer> result =
                new IntegerMatrix2D(getNumberOfRows(), getNumberOfColumns());
        result.setPosition(
                position(0, 1) * m.position(0, 2) - position(0, 2) * m.position(0, 1), 0, 0);
        result.setPosition(
                position(0, 2) * m.position(0, 0) - position(0, 0) * m.position(0, 2), 0, 1);
        result.setPosition(
                position(0, 0) * m.position(0, 1) - position(0, 1) * m.position(0, 0), 0, 2);
        return result;
      }

      throw new MatrixException("Matrices must have one dimension = 3 and one dimension = 1");
    }

    throw new MatrixException("Matrices must be of the same dimension");
  }

  @Override
  public void scalarMultiplication(Integer scalar) {
    for(int i = 0; i < getNumberOfRows(); i++) {
      for(int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(scalar * position(i, j), i, j);
      }
    }
  }

  @Override
  public void power(int power) {
    for(int i = 0; i < getNumberOfRows(); i++) {
      for(int j = 0; j < getNumberOfColumns(); j++) {
        setPosition((int) Math.pow(position(i, j), power), i, j);
      }
    }
  }
}

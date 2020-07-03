package Matrix;

import Exceptions.MatrixException;
import Exceptions.MatrixMultiplicationException;
import Exceptions.NullMatrixException;

import java.util.Random;

public class DoubleMatrix2D extends AbstractMatrix2D<Double> implements FloatingPointMatrix {

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
  }

  @Override
  public MatrixType<Double> multiply(MatrixType<Double> m) {
    checkNull(m);

    if (getNumberOfColumns() != m.getNumberOfRows()) {
      throw new MatrixMultiplicationException();
    }

    AbstractMatrix2D<Double> result = new DoubleMatrix2D(getNumberOfRows(), m.getNumberOfColumns());

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
  public void identity() {
    if (isSquare()) {
      for (int i = 0; i < getNumberOfRows(); i++) {
        for (int j = 0; j < getNumberOfColumns(); j++) {
          if (i == j) {
            setPosition(1.0, i, j);
          } else {
            setPosition(0.0, i, j);
          }
        }
      }
    } else {
      throw new MatrixException("Matrix must be square");
    }
  }

  @Override
  public void randomGaussianFill(Double lower, Double upper) {
    Random random = new Random();

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(random.nextGaussian() * (upper - lower) + lower, i, j);
      }
    }
  }

  @Override
  public void randomFill(Double lower, Double upper) {
    Random random = new Random();

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(random.nextDouble() * (upper - lower) + lower, i, j);
      }
    }
  }

  @Override
  public MatrixType<Double> transpose() {
    AbstractMatrix2D<Double> result = new DoubleMatrix2D(getNumberOfColumns(), getNumberOfRows());

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        result.setPosition(position(i, j), j, i);
      }
    }

    return result;
  }

  @Override
  public MatrixType<Double> add(MatrixType<Double> m) {
    checkNull(m);

    if (!sameSize(m)) {
      throw new MatrixException("Matrices must be the same size");
    }

    AbstractMatrix2D<Double> result = new DoubleMatrix2D(getNumberOfRows(), getNumberOfColumns());

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        result.setPosition(position(i, j) + m.position(i, j), i, j);
      }
    }

    return result;
  }

  @Override
  public MatrixType<Double> subtract(MatrixType<Double> m) {
    checkNull(m);

    if (!sameSize(m)) {
      throw new MatrixException("Matrices must be the same size");
    }

    AbstractMatrix2D<Double> result = new DoubleMatrix2D(getNumberOfRows(), getNumberOfColumns());

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        result.setPosition(position(i, j) - m.position(i, j), i, j);
      }
    }

    return result;
  }

  @Override
  public Double dotProduct(MatrixType<Double> m) {
    checkNull(m);

    if (getNumberOfRows() == 1 && m.getNumberOfRows() == 1
        || getNumberOfColumns() == 1 && m.getNumberOfColumns() == 1) {

      //      if(!sameSize(m)) {
      //        throw new MatrixMultiplicationException("Must be the same dimension");
      //      }
      double result = 0;

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
  public MatrixType<Double> cofactor(int i, int j) {
    checkValidPosition(i, j);
    AbstractMatrix2D<Double> cofactor =
        new DoubleMatrix2D(getNumberOfRows() - 1, getNumberOfColumns() - 1);

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
  public Double determinant() {
    if (!isSquare()) {
      throw new MatrixException("Operation not supported for this dimension");
    }

    if (getNumberOfRows() == 1) {
      return position(0, 0);
    }

    double det = 0;

    for (int i = 0; i < getNumberOfColumns(); i++) {
      det += Math.pow(-1, i) * position(0, i) * cofactor(0, i).determinant();
    }

    return det;
  }

  @Override
  public MatrixType<Double> crossProduct(MatrixType<Double> m) {
    checkNull(m);

    if (sameSize(m)) {
      if (getNumberOfRows() == 3 && getNumberOfColumns() == 1) {
        AbstractMatrix2D<Double> result =
            new DoubleMatrix2D(getNumberOfRows(), getNumberOfColumns());
        result.setPosition(
            position(1, 0) * m.position(2, 0) - position(2, 0) * m.position(1, 0), 0, 0);
        result.setPosition(
            position(2, 0) * m.position(0, 0) - position(0, 0) * m.position(2, 0), 1, 0);
        result.setPosition(
            position(0, 0) * m.position(1, 0) - position(1, 0) * m.position(0, 0), 2, 0);
        return result;
      } else if (getNumberOfRows() == 1 && getNumberOfColumns() == 3) {
        AbstractMatrix2D<Double> result =
            new DoubleMatrix2D(getNumberOfRows(), getNumberOfColumns());
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
  public void scalarMultiplication(Double scalar) {
    for(int i = 0; i < getNumberOfRows(); i++) {
      for(int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(scalar * position(i, j), i, j);
      }
    }
  }

  @Override
  public void normalise() {
    // avoid using getMax() and getMin() individually to increase efficiency
    Double currentMax = null;
    Double currentMin = null;

    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        if (currentMax == null || currentMax < position(i, j)) {
          currentMax = position(i, j);
        }

        if (currentMin == null || currentMin > position(i, j)) {
          currentMin = position(i, j);
        }
      }
    }

    // normalise
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition((position(i, j) - currentMin) / (currentMax - currentMin), i, j);
      }
    }
  }

  @Override
  public void power(int power) {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.pow(position(i, j), power), i, j);
      }
    }
  }

  @Override
  public void sin() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.sin(position(i, j)), i, j);
      }
    }
  }

  @Override
  public void cos() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.cos(position(i, j)), i, j);
      }
    }
  }

  @Override
  public void tan() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.tan(position(i, j)), i, j);
      }
    }
  }

  @Override
  public void arcsin() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        if (inInverseRange(position(i, j))) {
          setPosition(Math.asin(position(i, j)), i, j);
        } else {
          throw new MatrixException("Values out of range [-1, 1]");
        }
      }
    }
  }

  @Override
  public void arccos() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        if (inInverseRange(position(i, j))) {
          setPosition(Math.acos(position(i, j)), i, j);
        } else {
          throw new MatrixException("Values of of range [-1, 1]");
        }
      }
    }
  }

  private boolean inInverseRange(double x) {
    return x >= -1 && x <= 1;
  }

  @Override
  public void arctan() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.atan(position(i, j)), i, j);
      }
    }
  }

  @Override
  public void sinh() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.sinh(position(i, j)), i, j);
      }
    }
  }

  @Override
  public void cosh() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.cosh(position(i, j)), i, j);
      }
    }
  }

  @Override
  public void tanh() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.sinh(position(i, j)), i, j);
      }
    }
  }

  @Override
  public void arsinh() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        setPosition(Math.log(position(i, j) + Math.sqrt(Math.pow(position(i, j), 2) + 1)), i, j);
      }
    }
  }

  @Override
  public void arcosh() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        if (position(i, j) >= 1) {
          setPosition(Math.log(position(i, j) + Math.sqrt(Math.pow(position(i, j), 2) - 1)), i, j);
        } else {
          throw new MatrixException("Values outside of range");
        }
      }
    }
  }

  @Override
  public void artanh() {
    for (int i = 0; i < getNumberOfRows(); i++) {
      for (int j = 0; j < getNumberOfColumns(); j++) {
        if (position(i, j) > -1 && position(i, j) < 1) {
          setPosition(0.5 * Math.log((position(i, j) + 1) / (position(i, j) - 1)), i, j);
        } else {
          throw new MatrixException("Values outside of range");
        }
      }
    }
  }
}

package Matrix;

import Exceptions.MatrixPositionException;
import Exceptions.NullMatrixException;

import java.util.Arrays;

public abstract class AbstractMatrix2D<T extends Number & Comparable<T>> implements MatrixType<T> {
  private final int columns;
  private final int rows;

  private final T[][] matrix;

  @SuppressWarnings("unchecked")
  public AbstractMatrix2D(int rows, int columns) {
    this.columns = columns;
    this.rows = rows;

    matrix = (T[][]) new Number[rows][columns];
  }

  public AbstractMatrix2D(int dimension) {
    this(dimension, dimension);
  }

  public AbstractMatrix2D(T[][] matrix) {
    if(matrix == null) {
      throw new NullMatrixException();
    }

    this.columns = matrix[0].length;
    this.rows = matrix.length;
    this.matrix = matrix;
  }

  @Override
  public int getNumberOfRows() {
    return rows;
  }

  @Override
  public int getNumberOfColumns() {
    return columns;
  }

  @Override
  public void fill(T item) {
    for(T[] row : matrix) {
      Arrays.fill(row, item);
    }
  }

  @Override
  public T position(int i, int j) {
    checkValidPosition(i, j);

    return matrix[i][j];
  }

  public void setPosition(T item, int i, int j) {
    checkValidPosition(i, j);

    if(item == null) {
      throw new NullPointerException("Item cannot be null");
    }

    this.matrix[i][j] = item;
  }

  public void checkValidPosition(int i, int j) {
    if(i < 0 || i >= rows || j < 0 || j >= columns) {
      throw new MatrixPositionException();
    }
  }

  @Override
  public boolean isSquare() {
    return rows == columns;
  }

  @Override
  public boolean sameSize(MatrixType<T> that) {
    checkNull(that);

    return columns == that.getNumberOfColumns()
            && rows == that.getNumberOfRows();
  }

  @Override
  public T getMin() {
    T currentMin = null;

    for(T[] items : matrix) {
      for(T item : items) {
        if(currentMin == null || item.compareTo(currentMin) < 0) {
          currentMin = item;
        }
      }
    }

    return currentMin;
  }

  @Override
  public T getMax() {
    T currentMax = null;

    for(T[] items : matrix) {
      for(T item : items) {
        if(currentMax == null || item.compareTo(currentMax) > 0) {
          currentMax = item;
        }
      }
    }

    return currentMax;
  }

  void checkNull(MatrixType<T> m) {
    if(m == null) {
      throw new NullMatrixException();
    }
  }

  @Override
  public boolean equals(Object that) {
    if(that instanceof AbstractMatrix2D<?>) {
      if(sameSize((AbstractMatrix2D) that)) {
        for(int i = 0; i < rows; i++) {
          for(int j = 0; j < columns; j++) {
            if(!position(i, j).equals(((AbstractMatrix2D<?>) that).position(i, j))) {
              return false;
            }
          }
        }

        return true;
      }

      return false;
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(matrix);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("{ ");

    for(int i = 0; i < rows; i++) {
      sb.append("[");
      for(int j = 0; j < columns; j++) {
        sb.append(position(i, j).toString());

        if(j < rows - 1) {
          sb.append(", ");
        }
      }
      sb.append("]");

      if(i < rows - 1) {
        sb.append(", \n  ");
      }
    }

    sb.append(" }");
    return sb.toString();
  }
}

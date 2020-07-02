package Matrix;

import Exceptions.MatrixException;

public interface MatrixType<T extends Number> {

  /**
   * Returns the number of columns in the matrix
   *
   * @return - the number of columns in the matrix
   */
  int getNumberOfColumns();

  /**
   * Returns the number of rows in the matrix
   *
   * @return - the number of rows in the matrix
   */
  int getNumberOfRows();

  /**
   * sets the stored matrix equal to the identity matrix for its dimension
   * if the matrix is not square, throws a MatrixException
   */
  void identity();

  /**
   * Fills the matrix with the given value
   *
   * @param item - the value to fill the matrix with
   */
  void fill(T item);

  /**
   * Fills the matrix with randomly generated numbers from a Gaussian
   * distribution, between the two bounds given.
   * Overwrites anything currently stored in the matrix
   *
   * @param lower - the lower bound
   * @param upper - the upper bound
   */
  void randomGaussianFill(T lower, T upper);

  /**
   * Fills the matrix with random numbers, between the two bounds given.
   *
   * @param lower - the lower bound
   * @param upper - the upper bound
   */
  void randomFill(T lower, T upper);

  /**
   * Returns the transpose of the object's matrix.
   * i.e. a number in position (i, j) will be at (j, i) in the returned matrix.
   *
   * @return the transpose of the stored matrix.
   */
  MatrixType<T> transpose();

  /**
   * Adds the matrix to the given parameter
   * If they are not the same size, throws a MatrixException
   *
   * @param m - the matrix to add
   * @return - the matrix addition of the two matrices
   */
  MatrixType<T> add(MatrixType<T> m);

  /**
   * Subtracts the given parameter from the matrix
   * If they are not the same size, throws a MatrixException
   *
   * @param m - the matrix to subtract
   * @return - the matrix subtraction of the two matrices
   */
  MatrixType<T> subtract(MatrixType<T> m);

  /**
   * Returns the object's matrix multiplied by the parameter. If the matrices cannot
   * be multiplied, a MatrixMultiplicationException is thrown.
   *
   * @param m - the matrix to be multiplied with that stored.
   * @return the stored matrix multiplied by m.
   */
  MatrixType<T> multiply(MatrixType<T> m);

  /**
   * Returns the result of the dot product on the current matrix and the
   * parameter m.
   * For this to work, the column dimension of both matrices must be 1, or the
   * row dimension of both matrices must be 1 - otherwise a MatrixMultiplicationException
   * is thrown.
   *
   * @param m - the matrix to complete the dot product with
   * @return - the value of the dot product between the two matrices.
   */
  T dotProduct(MatrixType<T> m);

  /**
   * Retrieves the cofactor from the matrix, where i and j are the row/column
   * to be missed.
   *
   * @param i - the row to be omitted
   * @param j - the column to be omitted
   * @return - a matrix of dimension (rows - 1, columns - 1) which is the same
   * as the stored matrix, except without row i and column j
   */
  MatrixType<T> cofactor(int i, int j);

  /**
   * Returns the object in the matrix at position (i, j)
   * Throws a MatrixPositionException if i or j are not valid coordinates within
   * the matrix.
   *
   * @param i - the row index of the object to be returned
   * @param j - the column index of the object to be returned
   * @return - the object at position (i, j) in the matrix.
   */
  T position(int i, int j);

  /**
   * Returns the determinant of the matrix
   * If the matrix is not square, a MatrixException is thrown.
   *
   * @return the determinant of the matrix
   */
  T determinant();

  /**
   * Returns true iff the matrix is square
   *
   * @return - true iff the number of rows is equal to the number of columns
   */
  boolean isSquare();

  /**
   * Throws a MatrixPositionException if matrix[i][j] is an invalid
   * array reference
   *
   * @param i - the row index
   * @param j - the column index
   */
  void checkValidPosition(int i, int j);

  /**
   * Returns true iff the matrices have the same dimensions
   *
   * @param that - the matrix to compare dimensions with
   * @return - true iff the two matrices have the same dimensions.
   */
  boolean sameSize(MatrixType<T> that);

  /**
   * Returns the cross product between the matrix and m
   * Throws a MatrixException if the matrices are not vectors, i.e. of dimension
   * n x 1.
   *
   * @param m - the matrix to perform the cross product with
   * @return - the cross product of the two matrices.
   */
  MatrixType<T> crossProduct(MatrixType<T> m);gi
}

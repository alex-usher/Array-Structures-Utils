package Vector;

public interface VectorType<T extends Number & Comparable<T>> {

  /**
   * Returns the dimension of the vector, given by the length of the vector array.
   *
   * @return - the dimension of the vector
   */
  int getDimension();

  /**
   * Calculates the length of the vector, as the square root of the sum of
   * the elements squared (Pythagorus).
   *
   * @return - the length of the vector
   */
  double getLength();

  /**
   * Returns true iff the given vector is the same size as the vector
   *
   * @param vector - the vector to compare size against
   * @return - true iff the vectors are the same size
   */
  boolean sameSize(VectorType<T> vector);

  /**
   * Returns true iff the two vectors have the same length
   * Uses getLength() to calculate the length of the vectors
   *
   * @param vector - the vector to compare lengths for
   * @return - true iff the vectors have the same length
   */
  boolean sameLength(VectorType<T> vector);

  /**
   * Returns the element at the given position.
   * If the position is invalid, a VectorPositionException is thrown
   *
   * @param pos - the position to retrieve
   * @return - the element at the given position
   */
  T position(int pos);

  /**
   * Sets the element at the given location to the given item.
   * If the position is invalid, a VectorPositionException is thrown
   *
   * @param elem - the value to place in the given position
   * @param pos - the position to place the given element in
   */
  void setPosition(T elem, int pos);

  /**
   * Returns the minimum value stored in the vector
   *
   * @return - the minimum value stored
   */
  T getMin();

  /**
   * Returns the maximum value stored in the vector
   *
   * @return - the maximum value stored
   */
  T getMax();

  /**
   * Returns the index of the minimum value in the vector
   *
   * @return - the index of the minimum value
   */
  int getMinLocation();

  /**
   * Returns the index of the maximum value in the vector
   *
   * @return - the index of the maximum value
   */
  int getMaxLocation();

  /**
   * Fills the vector with the given item
   *
   * @param item - the item to fill the vector with
   */
  void fill(T item);

  /**
   * Fills the vector with randomly generated numbers, between the given bounds
   *
   * @param lower - the lower bound
   * @param upper - the upper bound
   */
  void randomFill(T lower, T upper);

  /**
   * Multiplies each element in the vector by the given scalar
   *
   * @param scalar - the scalar to multiply each element by
   */
  void scalarMultiplication(T scalar);

  /**
   * Performs and returns the addition of the vector and the vector given as parameter.
   * The vectors must be the same size - if not, a VectorException is thrown
   *
   * @param vector - the vector to add
   * @return - a new vector representing the addition of the two vectors
   */
  VectorType<T> add(VectorType<T> vector);

  /**
   * Performs and returns the subtraction of the vector and the vector given as
   * parameter.
   * The vectors must be the same size - if not, a VectorException is thrown
   *
   * @param vector - the vector to subtract
   * @return - a new vector representing the subtraction of the two vectors
   */
  VectorType<T> subtract(VectorType<T> vector);

  /**
   * Calculates the dot product between the vector and the given parameter
   * If the vectors are of different lengths, the longest vector is truncated
   * to be the same length as the smaller one
   *
   * @param vector - the vector to calculate the dot product with
   * @return - the dot product between the two vectors
   */
  T dotProduct(VectorType<T> vector);

  /**
   * Calculates and returns the cross product between the two vectors, which
   * must be of size 3.
   *
   * @param vector - the vector to calculate the cross product with
   * @return - the vector representing the cross product between the two vectors
   */
  VectorType<T> crossProduct(VectorType<T> vector);
}

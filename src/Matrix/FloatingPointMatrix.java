package Matrix;

public interface FloatingPointMatrix {
  /**
   * Normalises all the data in the matrix to within the range [0, 1]
   * Uses the Min-Max feature scaling approach
   */
  void normalise();

  /**
   * Fills the matrix with randomly generated numbers from a Gaussian
   * distribution, between the two bounds given.
   * Overwrites anything currently stored in the matrix
   *
   * @param lower - the lower bound
   * @param upper - the upper bound
   */
  void randomGaussianFill(Double lower, Double upper);

  /**
   * An element-wise operation, applying the sine function
   */
  void sin();

  /**
   * An element-wise operation, applying the cosine function
   */
  void cos();

  /**
   * An element-wise operation, applying the tangent function
   */
  void tan();

  /**
   * An element-wise operation, applying the inverse sine function
   */
  void arcsin();

  /**
   * An element-wise operation, applying the inverse cosine function
   */
  void arccos();

  /**
   * An element-wise operation, applying the inverse tangent function
   */
  void arctan();

  /**
   * An element-wise operation, applying the hyperbolic sine function
   */
  void sinh();

  /**
   * An element-wise operation, applying the hyperbolic cosine function
   */
  void cosh();

  /**
   * An element-wise operation, applying the hyperbolic tangent function
   */
  void tanh();

  /**
   * An element-wise operation, applying the inverse hyperbolic sine function
   */
  void arsinh();

  /**
   * An element-wise operation, applying the inverse hyperbolic cosine function
   */
  void arcosh();

  /**
   * An element-wise operation, applying the inverse hyperbolic tangent function
   */
  void artanh();
}

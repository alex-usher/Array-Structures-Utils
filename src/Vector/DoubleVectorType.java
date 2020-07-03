package Vector;

public interface DoubleVectorType extends VectorType<Double> {

  /**
   * Turns the vector into a unit vector.
   * i.e. each element is divided by the length of the vector
   */
  void unit();

  /**
   * Fills the vector with numbers randomly generated using a Gaussian
   * distribution, between the bounds given
   *
   * @param lower - the lower bound
   * @param upper - the upper bound
   */
  void randomGaussianFill(Double lower, Double upper);
}

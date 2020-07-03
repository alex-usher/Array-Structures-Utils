package Vector;

import Exceptions.VectorException;

import java.util.Random;

public class DoubleVector extends AbstractVector<Double> implements DoubleVectorType {

  public DoubleVector(int dimension) {
    super(dimension);
    fill(0.0);
  }

  public DoubleVector(Double[] vector) {
    super(vector);
  }

  @Override
  public void unit() {
    for(int i = 0; i < getDimension(); i++) {
      setPosition(position(i) / getLength(), i);
    }
  }

  @Override
  public void randomGaussianFill(Double lower, Double upper) {
    Random random = new Random();

    for(int i = 0; i < getDimension(); i++) {
      setPosition(random.nextGaussian() * (upper - lower) + lower, i);
    }
  }

  @Override
  public double getLength() {
    double sum = 0;

    for(int i = 0; i < getDimension(); i++) {
      sum += Math.pow(position(i), 2);
    }

    return Math.sqrt(sum);
  }

  @Override
  public void randomFill(Double lower, Double upper) {
    Random random = new Random();

    for(int i = 0; i < getDimension(); i++) {
      setPosition(random.nextDouble() * (upper - lower) + lower, i);
    }
  }

  @Override
  public void scalarMultiplication(Double scalar) {
    if(scalar == null) {
      throw new NullPointerException();
    }

    for(int i = 0; i < getDimension(); i++) {
      setPosition(scalar * position(i), i);
    }
  }

  @Override
  public VectorType<Double> add(VectorType<Double> vector) {
    checkNull(vector);

    if(!sameSize(vector)) {
      throw new VectorException("Vectors are not the same size");
    }

    VectorType<Double> result = new DoubleVector(getDimension());

    for(int i = 0; i < getDimension(); i++) {
      setPosition(position(i) + vector.position(i), i);
    }

    return result;
  }

  @Override
  public VectorType<Double> subtract(VectorType<Double> vector) {
    checkNull(vector);

    if(!sameSize(vector)) {
      throw new VectorException("Vectors are not the same size");
    }

    VectorType<Double> result = new DoubleVector(getDimension());

    for(int i = 0; i < getDimension(); i++) {
      setPosition(position(i) - vector.position(i), i);
    }

    return result;
  }

  @Override
  public Double dotProduct(VectorType<Double> vector) {
    checkNull(vector);

    double dotProduct = 0.0;

    for(int i = 0; i < Math.min(getDimension(), vector.getDimension()); i++) {
      dotProduct += position(i) * vector.position(i);
    }

    return dotProduct;
  }

  @Override
  public VectorType<Double> crossProduct(VectorType<Double> vector) {
    checkNull(vector);

    if(getDimension() == 3 && vector.getDimension() == 3) {
      VectorType<Double> result = new DoubleVector(getDimension());

      result.setPosition(position(1) * vector.position(2) - position(2) * vector.position(1), 0);
      result.setPosition(position(2) * vector.position(0) - position(0) * vector.position(2), 1);
      result.setPosition(position(0) * vector.position(1) - position(1) * vector.position(0), 2);
    }

    throw new VectorException("Vectors must be of dimension 3");
  }
}

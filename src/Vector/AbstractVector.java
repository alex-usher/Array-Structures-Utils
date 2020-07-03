package Vector;

import Exceptions.NullVectorException;
import Exceptions.VectorPositionException;

import java.util.Arrays;

public abstract class AbstractVector<T extends Number & Comparable<T>> implements VectorType<T> {
  private final T[] vector;

  @SuppressWarnings("unchecked")
  public AbstractVector(int size) {
    this.vector = (T[]) new Number[size];
  }

  public AbstractVector(T[] vector) {
    this.vector = vector;
  }

  @Override
  public int getDimension() {
    return vector.length;
  }

  @Override
  public boolean sameSize(VectorType<T> vector) {
    checkNull(vector);

    return getDimension() == vector.getDimension();
  }

  @Override
  public boolean sameLength(VectorType<T> vector) {
    checkNull(vector);

    return getLength() == vector.getLength();
  }

  @Override
  public T position(int pos) {
    checkValidPosition(pos);

    return vector[pos];
  }

  @Override
  public void setPosition(T elem, int pos) {
    checkValidPosition(pos);

    if (elem == null) {
      throw new NullPointerException("Element cannot be null");
    }

    this.vector[pos] = elem;
  }

  @Override
  public T getMin() {
    if (getDimension() > 0) {

      T[] sorted = vector.clone();
      Arrays.sort(sorted);

      return sorted[0];
    }

    return null;
  }

  @Override
  public T getMax() {
    if (getDimension() > 0) {
      T[] sorted = vector.clone();
      Arrays.sort(sorted);

      return sorted[sorted.length - 1];
    }

    return null;
  }

  @Override
  public int getMinLocation() {
    T currentMin = null;
    int minLocation = 0;

    for (int i = 0; i < getDimension(); i++) {
      if (currentMin == null || position(i).compareTo(currentMin) < 0) {
        currentMin = position(i);
        minLocation = i;
      }
    }

    return minLocation;
  }

  @Override
  public int getMaxLocation() {
    T currentMax = null;
    int maxLocation = 0;

    for (int i = 0; i < getDimension(); i++) {
      if (currentMax == null || position(i).compareTo(currentMax) > 0) {
        currentMax = position(i);
        maxLocation = i;
      }
    }

    return maxLocation;
  }

  @Override
  public void fill(T item) {
    for (int i = 0; i < getDimension(); i++) {
      setPosition(item, i);
    }
  }

  void checkValidPosition(int pos) {
    if (pos < 0 || pos >= vector.length) {
      throw new VectorPositionException("Position out of bounds");
    }
  }

  void checkNull(VectorType<T> vector) {
    if (vector == null) {
      throw new NullVectorException();
    }
  }

  @Override
  public boolean equals(Object that) {
    if(that instanceof AbstractVector<?>) {
      if(sameSize((AbstractVector) that)) {
        for(int i = 0; i < getDimension(); i++) {
          if(!vector[i].equals(((AbstractVector<?>) that).position(i))) {
            return false;
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
    return Arrays.hashCode(vector);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("[");

    for(int i = 0; i < getDimension(); i++) {
      sb.append(vector[i].toString());

      if(i < getDimension() - 1){
        sb.append(", ");
      }
    }

    sb.append("]");

    return sb.toString();
  }
}

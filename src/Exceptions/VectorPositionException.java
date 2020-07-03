package Exceptions;

public class VectorPositionException extends ArrayIndexOutOfBoundsException {

  public VectorPositionException() {
    super();
  }

  public VectorPositionException(String message) {
    super(message);
  }
}

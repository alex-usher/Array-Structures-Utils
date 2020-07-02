package Exceptions;

public class MatrixPositionException extends ArrayIndexOutOfBoundsException {

  public MatrixPositionException() {
    super();
  }

  public MatrixPositionException(String message) {
    super(message);
  }
}

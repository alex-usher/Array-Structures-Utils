# Array-Utils-Structures

Array-Utils-Structures is a Java library intended to make it easier to implement arrays and array-based structures in maths-based contexts.

## Structure

The library is separated into 3 sections:
1. **Matrix** - an implementation of the Matrix structure, given with two types - Integer and Double - but written generically such that it can be extended. Most common matrix operations have been included, such as:
    1. Identity
    1. Random fills, including Gaussian - intended for use in Neural Network applications
    1. Transpose
    1. Standard Addition, Subtraction and Multiplication
    1. Scalar Multiplication
    1. Determinants and Co-factors
1. **Vector** - an implementation of the Vector structure, given in the same format as **Matrix**. Functions implemented include:
    1. Addition and Subtraction
    1. Dot and Cross Product
    1. Vector Length Calculation
1. **ArrayUtils** - a utility library designed to be an extension to Java's built-in Arrays class. It implements several common maths-based array operations for the same data types as implemented for in the Arrays class: `Integer`, `Double`, `Float`, `Short`, `Long`, `Byte`.

All implementations include test suites for their functions.
 
## Installation

To use the library, first clone this repository. Then you can use this location to import the library as an external library for your project, using your IDE's project settings section.

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

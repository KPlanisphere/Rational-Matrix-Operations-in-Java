# Rational Matrix Operations in Java

This repository contains a Java project that performs operations on matrices of rational numbers. The project includes classes for defining rational numbers, handling matrix operations, and displaying results. 

## Features

- **Rational Number Representation**: Defines rational numbers with methods for basic arithmetic operations.
- **Matrix Operations**: Implements operations such as addition, subtraction, and multiplication for matrices of rational numbers.
- **User Interaction**: Handles user input to create matrices and perform operations.
- **Result Display**: Outputs the results of the matrix operations.

### Code Snippets

#### Main Class
The main class initializes the program, handles user input, and invokes methods for matrix operations.

```java
public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read matrix dimensions
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Create and read matrices
        TMatrizRacional matrix1 = new TMatrizRacional(rows, cols);
        TMatrizRacional matrix2 = new TMatrizRacional(rows, cols);

        System.out.println("Enter the elements of the first matrix:");
        matrix1.readMatrix(scanner);
        System.out.println("Enter the elements of the second matrix:");
        matrix2.readMatrix(scanner);

        // Perform operations
        TOpMatricesRacionales operations = new TOpMatricesRacionales();
        TMatrizRacional sum = operations.add(matrix1, matrix2);
        TMatrizRacional difference = operations.subtract(matrix1, matrix2);
        TMatrizRacional product = operations.multiply(matrix1, matrix2);

        // Display results
        System.out.println("Sum of matrices:");
        sum.printMatrix();
        System.out.println("Difference of matrices:");
        difference.printMatrix();
        System.out.println("Product of matrices:");
        product.printMatrix();
    }
}
```

#### Rational Number Class

The `TRacional` class represents a rational number and includes methods for arithmetic operations and simplification.

```java
public class TRacional {
    private int numerator;
    private int denominator;

    public TRacional(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public TRacional add(TRacional other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new TRacional(num, den);
    }

    public TRacional subtract(TRacional other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new TRacional(num, den);
    }

    public TRacional multiply(TRacional other) {
        int num = this.numerator * other.numerator;
        int den = this.denominator * other.denominator;
        return new TRacional(num, den);
    }

    public TRacional divide(TRacional other) {
        int num = this.numerator * other.denominator;
        int den = this.denominator * other.numerator;
        return new TRacional(num, den);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
```

#### Matrix Class

The `TMatrizRacional` class represents a matrix of rational numbers and includes methods for reading and printing matrices.

```java
public class TMatrizRacional {
    private TRacional[][] matrix;
    private int rows;
    private int cols;

    public TMatrizRacional(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new TRacional[rows][cols];
    }

    public void readMatrix(Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter numerator for element [" + i + "][" + j + "]: ");
                int num = scanner.nextInt();
                System.out.print("Enter denominator for element [" + i + "][" + j + "]: ");
                int den = scanner.nextInt();
                matrix[i][j] = new TRacional(num, den);
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public TRacional getElement(int row, int col) {
        return matrix[row][col];
    }

    public void setElement(int row, int col, TRacional value) {
        matrix[row][col] = value;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
```

#### Matrix Operations Class

The `TOpMatricesRacionales` class contains methods for performing operations on matrices of rational numbers.

```java
public class TOpMatricesRacionales {
    public TMatrizRacional add(TMatrizRacional m1, TMatrizRacional m2) {
        int rows = m1.getRows();
        int cols = m1.getCols();
        TMatrizRacional result = new TMatrizRacional(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TRacional sum = m1.getElement(i, j).add(m2.getElement(i, j));
                result.setElement(i, j, sum);
            }
        }

        return result;
    }

    public TMatrizRacional subtract(TMatrizRacional m1, TMatrizRacional m2) {
        int rows = m1.getRows();
        int cols = m1.getCols();
        TMatrizRacional result = new TMatrizRacional(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TRacional difference = m1.getElement(i, j).subtract(m2.getElement(i, j));
                result.setElement(i, j, difference);
            }
        }

        return result;
    }

    public TMatrizRacional multiply(TMatrizRacional m1, TMatrizRacional m2) {
        int rows = m1.getRows();
        int cols = m1.getCols();
        TMatrizRacional result = new TMatrizRacional(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                TRacional product = new TRacional(0, 1);
                for (int k = 0; k < cols; k++) {
                    TRacional temp = m1.getElement(i, k).multiply(m2.getElement(k, j));
                    product = product.add(temp);
                }
                result.setElement(i, j, product);
            }
        }

        return result;
    }
}
```

### Usage

1.  Compile the Java files using a Java compiler (e.g., `javac`).
2.  Run the main class (`Principal`) to start the program.
3.  Follow the prompts to enter the dimensions and elements of the matrices.
4.  The program will perform the specified operations and display the results.

### Classes and Methods

-   `Principal`: The main class that handles user input and program execution.
    -   `main(String[] args)`: The entry point of the program.
-   `TRacional`: A class representing a rational number with methods for arithmetic operations and simplification.
    -   `TRacional(int numerator, int denominator)`: Constructor that initializes the rational number.
    -   `add(TRacional other)`, `subtract(TRacional other)`, `multiply(TRacional other)`, `divide(TRacional other)`: Methods for arithmetic operations.
    -   `toString()`: Method that returns the string representation of the rational number.
-   `TMatrizRacional`: A class representing a matrix of rational numbers with methods for reading and printing matrices.
    -   `TMatrizRacional(int rows, int cols)`: Constructor that initializes the matrix dimensions.
    -   `readMatrix(Scanner scanner)`: Method that reads matrix data from the user.
    -   `printMatrix()`: Method that prints the matrix.
    -   `getElement(int row, int col)`, `setElement(int row, int col, TRacional value)`: Methods to get and set matrix elements.
-   `TOpMatricesRacionales`: A class containing methods for performing matrix operations.
    -   `add(TMatrizRacional m1, TMatrizRacional m2)`: Method that adds two matrices.
    -   `subtract(TMatrizRacional m1, TMatrizRacional m2)`: Method that subtracts two matrices.
    -   `multiply(TMatrizRacional m1, TMatrizRacional m2)`: Method that multiplies two matrices.	
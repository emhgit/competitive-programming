# Competitive Programming

This repository contains my solutions, templates, and utilities for competitive programming in C++ and Java.

## Structure

- `/java/`: Contains solutions, templates, and testing for java files.
  - `/java/src/main/java/solutions/`: Java solutions.
  - `/java/src/test/`: Unit tests for problems (optional).
  - `/java/src/main/java/templates/`: Java templates for quick problem setup.
  - `/java/src/input/` and `/java/src/output/`: Sample input/output files for local java testing.
  - `/java/pom.xml`: Maven build file for dependency management.

- `/cpp/`: Conains solutions and templates for C++ files.
  - `/cpp/solutions/`: C++ solutions.
  - `/cpp/templates/`: C++ templates for quick problem setup

## Local I/O testing for Java

1. Configure the following lines at the top of your ProblemName.java file and set **LOCAL** to **_true_** to allow for local testing:

```java
    boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("java/src/input/problemname.in"));
            out = new PrintWriter(new FileWriter("java/src/output/problemname.out"));
        } else {
            br = new BufferedReader(new FileReader("problemname.in"));
            out = new PrintWriter(new FileWriter("problemname.out"));
        }
```

2. Create the `problemname.in` file in the `java/src/input` dir and leave your empty `problemname.out` file in the `java/src/output`

3. Run your `problemname.java` file and check the `problemname.out` file for results

## JUnit Testing

Prerequisites: **Maven** installed, **Debugger for Java** Extension installed (this is a VSCode setup)

1. Create a `[problemname]Test.java` file inside the `src/test/java` dir

2. Copy and paste the template from `src/main/java/templates/TestTemplate.java` and configure it to your liking

3. Run the test using the Testing sidebar or:

```bash
mvn test
```

## Usage

1. **Clone the repository:**
   ```sh
   git clone <repo-url>
   cd competitive-programming
   ```
2. **Compile a solution in C++:**
   ```sh
     g++ -std=c++17 -O2 name.cpp -o name -Wall
   ```
3. **Run a solution in C++:**
   ```sh
   ./name
   ```
4. **Compile a solution in java:**
   ```sh
   javac src/solutions/path/to/ProblemName.java
   ```
5. **Run a solution in java:**
   ```sh
   java -cp src/main/java path.to.ProblemName
   ```

## Contributing

Contributions are welcome! Please follow the existing structure and naming conventions. Submit a pull request with your changes.

## License

This project is licensed under the MIT License.

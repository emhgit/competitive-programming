# Competitive Programming in Java

This repository contains my solutions, templates, and utilities for competitive programming in Java.

## Structure

- `src/solutions` — Solution code, organized by site/category.
- `src/test/` — Unit tests for problems (optional).
- `templates/` — Java templates for quick problem setup.
- `lib/` — External libraries (e.g., JUnit).
- `input/` and `output/` — Sample input/output files for local testing.
- `pom.xml` — Maven build file for dependency management.

## Local testing

Configure the following lines at the top of your ProblemName.java file and set **LOCAL** to **_true_** to allow for local testing:

```java
    boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/MixingMilk.in"));
            out = new PrintWriter(new FileWriter("src/output/MixingMilk.out"));
        } else {
            br = new BufferedReader(new FileReader("problemname.in"));
            out = new PrintWriter(new FileWriter("problemname.out"));
        }
```

## Usage

1. **Clone the repository:**
   ```sh
   git clone <repo-url>
   cd competitive-programming
   ```
2. **Compile a solution:**
   ```sh
   javac src/solutions/path/to/ProblemName.java
   ```
3. **Run a solution:**
   ```sh
   java -cp src/main/java path.to.ProblemName
   ```
4. **(Optonal) Run tests (if using Maven):**
   ```sh
   mvn test
   ```

## Templates

Copy a template from `templates/Template.java` to start a new problem quickly.

## Contributing

Contributions are welcome! Please follow the existing structure and naming conventions. Submit a pull request with your changes.

## License

This project is licensed under the MIT License.

# Competitive Programming in Java

This repository contains my solutions, templates, and utilities for competitive programming in Java.

## Structure

- `src/solutions` — Solution code, organized by site/category.
- `src/test/` — Unit tests for problems (optional).
- `templates/` — Java templates for quick problem setup.
- `lib/` — External libraries (e.g., JUnit).
- `input/` and `output/` — Sample input/output files for local testing.
- `pom.xml` — Maven build file for dependency management.

## Templates

Copy a template from `templates/Template.java` to start a new problem quickly.

## Local I/O testing

1. Configure the following lines at the top of your ProblemName.java file and set **LOCAL** to **_true_** to allow for local testing:

```java
    boolean LOCAL = true;

        BufferedReader br;
        PrintWriter out;

        if (LOCAL) {
            br = new BufferedReader(new FileReader("src/input/problemname.in"));
            out = new PrintWriter(new FileWriter("src/output/problemname.out"));
        } else {
            br = new BufferedReader(new FileReader("problemname.in"));
            out = new PrintWriter(new FileWriter("problemname.out"));
        }
```

2. Create the `problemname.in` file in the `src/input` dir and leave your empty `problemname.out` file in the `src/output`

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
2. **Compile a solution:**
   ```sh
   javac src/solutions/path/to/ProblemName.java
   ```
3. **Run a solution:**
   ```sh
   java -cp src/main/java path.to.ProblemName
   ```

## Contributing

Contributions are welcome! Please follow the existing structure and naming conventions. Submit a pull request with your changes.

## License

This project is licensed under the MIT License.

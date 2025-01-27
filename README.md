# Final_Project
This project is an automated testing suite for the Biletebi.ge website using Java, Selenium, and TestNG.
Also this project an automated testing suite for GET request of endpoint: https://reqres.in/api/users?page=2 

## Project Structure

- `src/main/java/ge/example/pages/`: Contains page object classes for different pages of the Biletebi.ge website and of endpoint: https://reqres.in/api/users?page=2
- `src/test/java/ge/automation/`: Contains base test class and test classes.
- `src/test/resources/`: Contains TestNG configuration files.

## Prerequisites

- Java 8 or higher
- Maven
- IntelliJ IDEA

## Setup

1. Clone the repository:
    ```sh
    git clone <repository-url>
    ```
2. Navigate to the project directory:
    ```sh
    cd <project-directory>
    ```
3. Install dependencies:
    ```sh
    mvn clean install
    ```

## Running Tests

To run the tests, use the following command:
```sh
mvn test

# Spring Boot Custom Authentication Project

This project demonstrates custom authentication using a Spring Boot application. It includes a custom authentication filter to intercept incoming HTTP requests and retrieve a specific header value, as well as a controller to handle GET requests and retrieve the value of the authentication header.

## Project Details
- Spring Boot Version: 3.2.4
- Java Version: 17

## Dependencies
- Spring Web


## Project Structure
src
├── main
│ ├── java
│ │ └── com
│ │ └── example
│ │ ├── MyApplication.java
│ │ ├── MyController.java
│ │ ├── CustomAuthenticationFilter.java
│ │ └── FilterConfig.java (optional if not using Spring Boot auto-configuration)
│ └── resources
│ └── application.properties 
└── test
└── java
└── com
└── example
└── MyApplicationTests.java (optional for testing)


## Implementation Details
### Custom Authentication Filter
- Intercepts incoming HTTP requests.
- Checks for the presence of the "PinggyAuthHeader" header.
- Stores the header value in a ThreadLocal variable if present.
- Responds with HTTP status code 401 (Unauthorized) if the header is not present or empty.

### Controller Implementation
- Implements a Spring MVC controller to handle a GET request on path "/".
- Retrieves the value of the "PinggyAuthHeader" header from the ThreadLocal storage.
- Returns the header value as the response body.

### Filter Configuration (optional)
- Configures the custom authentication filter.
- Applies the filter to all URLs.

## Instructions to Run the Application
1. Clone this repository.
2. Ensure you have Java and Maven installed.
3. Navigate to the project directory.
4. Build the project using Maven .
5. Run the application.

## Testing with Postman
1. Open Postman.
2. Create a new request.
3. Choose the appropriate HTTP request type (e.g., GET).
4. Enter the URL of the endpoint you want to test (e.g., `http://localhost:8080/`) or preferred port
5. Add the required headers, such as "PinggyAuthHeader", if necessary.
6. Send the request and observe the response.
7. Test different scenarios, such as sending requests with different header values or testing error handling by sending requests without the required headers.

## Contact Information
For any questions or concerns regarding this project, please contact [Akalya] at [aknivi1430@gmail.com].


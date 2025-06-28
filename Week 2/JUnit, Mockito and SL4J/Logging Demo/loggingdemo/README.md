# SLF4J Logging Demo

This project demonstrates logging error messages and warning levels using SLF4J (Simple Logging Facade for Java) with Logback as the implementation.

## Project Structure

- `LoggingExample.java` - Standalone Java class demonstrating basic SLF4J logging
- `LoggingdemoApplication.java` - Spring Boot application with enhanced logging
- `logback.xml` - Logback configuration for customizing log output

## Dependencies

The project uses Spring Boot's built-in logging dependencies:
- **SLF4J API** - Logging facade (managed by Spring Boot)
- **Logback Classic** - SLF4J implementation (managed by Spring Boot)
- **Spring Boot Starter** - Includes spring-boot-starter-logging by default

Spring Boot automatically manages compatible versions of SLF4J and Logback, ensuring there are no version conflicts.

## How to Run

### Option 1: Run the Standalone LoggingExample
```bash
mvn compile exec:java -Dexec.mainClass="com.anuragbytes.loggingdemo.LoggingExample"
```

### Option 2: Run the Spring Boot Application
```bash
mvn spring-boot:run
```

## Expected Output

When you run the application, you should see log messages in the console with the following format:
```
HH:mm:ss.SSS [thread] LEVEL LoggerName - Message
```

Example output:
```
14:30:25.123 [main] INFO  c.a.l.LoggingdemoApplication - Starting Logging Demo Application...
14:30:25.124 [main] WARN  c.a.l.LoggingdemoApplication - This is a warning message from Spring Boot application
14:30:25.125 [main] ERROR c.a.l.LoggingdemoApplication - This is an error message from Spring Boot application
14:30:25.126 [main] INFO  c.a.l.LoggingdemoApplication - Logging Demo Application started successfully!
```

## Log Files

Logs are also written to the `logs/` directory:
- `logs/loggingdemo.log` - Current log file
- `logs/loggingdemo.YYYY-MM-DD.log` - Daily rotated log files

## Logging Levels Demonstrated

1. **ERROR** - For error messages that indicate serious problems
2. **WARN** - For warning messages that indicate potential issues
3. **INFO** - For informational messages about application status

## Configuration

The `logback.xml` file configures:
- Console output with timestamp and log level
- File output with daily rotation
- Custom log format for better readability
- Application-specific logging levels

## Note on Dependencies

This project leverages Spring Boot's dependency management to automatically include compatible versions of SLF4J and Logback. This approach ensures:
- No version conflicts between logging components
- Automatic updates when Spring Boot versions are upgraded
- Consistent logging behavior across the application 
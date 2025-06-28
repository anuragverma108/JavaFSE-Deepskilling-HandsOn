# Exercise 2: Verifying Interactions with Mockito

**Date:** 2024

## Overview

This exercise demonstrates how to verify interactions with mocked objects using Mockito. The goal is to ensure that methods are called with specific arguments and that the interactions occur as expected.

## Project Structure

```
src/
├── main/java/com/anuragbytes/mockitodemo/
│   ├── ExternalApi.java          # Interface to be mocked
│   ├── MyService.java            # Service class under test
│   └── MockitodemoApplication.java
└── test/java/com/anuragbytes/mockitodemo/
    └── MyServiceTest.java        # Test class with interaction verifications
```

## Key Components

### 1. ExternalApi Interface
- **Purpose:** Represents an external API that will be mocked in tests
- **Methods:**
  - `getData()`: Retrieves data from external API
  - `sendData(String data, int priority)`: Sends data with specific priority

### 2. MyService Class
- **Purpose:** Service class that depends on ExternalApi
- **Methods:**
  - `fetchData()`: Calls external API to get data
  - `processAndSendData()`: Processes and sends data with priority
  - `performComplexOperation()`: Performs multiple API calls

### 3. MyServiceTest Class
- **Purpose:** Demonstrates various interaction verification techniques
- **Test Methods:**
  - `testVerifyInteraction()`: Basic interaction verification
  - `testVerifyInteractionWithSpecificArguments()`: Verification with exact arguments
  - `testVerifyMultipleInteractions()`: Multiple method call verification
  - `testVerifyInteractionCount()`: Verification of call count
  - `testVerifyMethodNeverCalled()`: Verification that method was not called
  - `testVerifyWithArgumentMatchers()`: Verification with flexible argument matching
  - `testVerifyInteractionOrder()`: Verification of call order
  - `testVerifyWithTimeout()`: Verification with timeout

## Core Exercise Steps

### Step 1: Create a Mock Object
```java
ExternalApi mockApi = Mockito.mock(ExternalApi.class);
```

### Step 2: Call the Method with Specific Arguments
```java
service.fetchData();  // Calls externalApi.getData()
```

### Step 3: Verify the Interaction
```java
verify(mockApi).getData();
```

## Running the Tests

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Mockito 5.12.0 (already included in pom.xml)

### Command to Run Tests
```bash
# Navigate to the project directory
cd mockitodemo

# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=MyServiceTest

# Run specific test method
mvn test -Dtest=MyServiceTest#testVerifyInteraction
```

## Verification Techniques Demonstrated

### 1. Basic Verification
```java
verify(mockApi).getData();
```

### 2. Verification with Specific Arguments
```java
verify(mockApi).sendData("test data", 1);
```

### 3. Verification of Call Count
```java
verify(mockApi, times(3)).getData();
```

### 4. Verification with Argument Matchers
```java
verify(mockApi).sendData(anyString(), eq(5));
```

### 5. Verification of Call Order
```java
InOrder inOrder = inOrder(mockApi);
inOrder.verify(mockApi).getData();
inOrder.verify(mockApi).sendData(anyString(), eq(1));
```

### 6. Verification with Timeout
```java
verify(mockApi, timeout(1000)).getData();
```

## Best Practices

1. **Test Isolation:** Use `@BeforeEach` to create fresh mocks for each test
2. **Clear Naming:** Use descriptive test method names with `@DisplayName`
3. **Arrange-Act-Assert:** Structure tests with clear sections
4. **Specific Verification:** Verify exact arguments when possible
5. **Documentation:** Add comprehensive comments explaining the purpose of each test

## Expected Test Results

All tests should pass, demonstrating successful interaction verification:
- ✅ Basic interaction verification
- ✅ Verification with specific arguments
- ✅ Multiple interaction verification
- ✅ Interaction count verification
- ✅ Never-called verification
- ✅ Argument matcher verification
- ✅ Interaction order verification
- ✅ Timeout verification

## Learning Objectives

After completing this exercise, you should understand:
- How to create and configure mock objects
- How to verify that methods are called on mocks
- How to verify method calls with specific arguments
- How to verify the number of times methods are called
- How to verify the order of method calls
- How to use argument matchers for flexible verification
- How to verify interactions with timeouts

## Additional Resources

- [Mockito Documentation](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html)
- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [Mockito Verification](https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html#verification) 
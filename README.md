# http-post-method-using-java
Computer Networking Lab

# HTTP POST Request in Java

## Description
This project demonstrates how to send an HTTP POST request in Java using the `HttpURLConnection` class. The program sends a JSON payload to the `FakeStoreAPI` endpoint and retrieves the server response.

## Features
- Establishes a connection with an API endpoint
- Sends JSON-formatted data using an HTTP POST request
- Handles server responses and displays them in the console
- Implements error handling for network-related issues


## API Endpoint
**URL:** `https://fakestoreapi.com/products`

**JSON Payload:**
```json
{
    "title": "test product",
    "price": 13.5,
    "description": "lorem ipsum set",
    "image": "https://i.pravatar.cc",
    "category": "electronic"
}
```

## How to Run
1. Clone this repository or copy the `PostRequestExample.java` file.
2. Open the project in your favorite IDE (e.g., IntelliJ IDEA, Eclipse, VS Code).
3. Compile and run the Java program:
   ```sh
   javac PostRequestExample.java
   java PostRequestExample
   ```
4. Observe the response in the console.

## Expected Output
Example output when the request is successful:
```
Response Code: 201
Response Message: Created
Response Content:
{"id":21,"title":"test product","price":13.5,"description":"lorem ipsum set","image":"https://i.pravatar.cc","category":"electronic"}
```

## Error Handling
- If the API endpoint is incorrect, an `IOException` will be thrown.
- If the JSON format is invalid, the API will return an error message.
- Proper exception handling is implemented to catch and log errors.

## License
This project is open-source and available for educational purposes.


# Calculator Application with Client-Server Model

This project demonstrates a calculator application implemented using Java for the server-side logic and HTML, CSS, and JavaScript for the client-side interface. The client-server model is used to allow multiple clients to perform calculations through a web-based interface.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Usage](#usage)
- [Server](#server)
- [Client](#client)
- [Technologies Used](#technologies-used)

## Features

- Basic arithmetic calculations (addition, subtraction, multiplication, division).
- Web-based user interface for the calculator.
- Server-side processing of calculations using Java.
- Client-server communication using HTTP requests.
- Responsive design with HTML and CSS.
- Real-time updates using JavaScript.

## Requirements

- Java Development Kit (JDK) 8 or higher.
- Web browser with JavaScript enabled.

## Usage

1. Start the server to handle incoming client requests.
2. Open a web browser and navigate to the client interface.
3. Perform calculations using the web-based calculator.
4. The server will process the calculations and send back the results to the client in real-time.


## Server
The server-side logic is implemented in Java, using the ServerSocket class to handle incoming client connections. The server processes calculation requests and sends back the results to the clients.

## Client
The client-side interface is built using HTML, CSS, and JavaScript. The interface provides buttons for numbers and operations, and it sends HTTP requests to the server for processing calculations.

## Technologies Used
- Java for server-side logic.
- HTML for creating the structure of the calculator interface.
- CSS for styling the interface.
- JavaScript for client-side interactivity and communication with the server.

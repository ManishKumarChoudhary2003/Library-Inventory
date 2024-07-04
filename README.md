# Library Inventory 

A library inventory system built using Spring Boot and Kafka. Kafka ensures efficient message handling and real-time data processing, 
while Spring Boot powers the backend with its powerful framework capabilities. The project leverages H2 database, Hibernate, and JPA for seamless data management.

## Features

- **Kafka Integration:** Enables efficient message handling and real-time data processing.
- **Spring Boot:** Powers the backend with its powerful framework capabilities.
- **Database:** Utilizes H2 database, Hibernate, and JPA for seamless data management.

## Requirements

- Java 8 or higher
- Maven

## Installation and Setup

   ```bash
   git clone https://github.com/ManishKumarChoudhary2003/Library-Inventory.git
   cd Library-Inventory
   mvn clean install
   ```

## Use Case

### Scenario

The Library Inventory System is designed to manage the inventory of books and resources in a library. It allows librarians and administrators to add new books, update existing records,
and search for books based on various criteria such as title and author. Additionally, the system provides real-time updates on inventory changes using Kafka for 
communication between components.

### Use Cases

1. **Add New Book:**
   - **Description:** Librarians can add new books to the inventory.
   - **Steps:**
     - Log in to the system.
     - Navigate to the "Add Book" section.
     - Enter book details such as title, author
     - Save the record.

2. **Update Book Details:**
   - **Description:** Update existing book information.
   - **Steps:**
     - Search for the book using title
     - Edit the book details.
     - Save the changes.

3. **Real-time Updates:**
   - **Description:** Receive real-time notifications of inventory changes.
   - **Steps:**
     - Receive updates instantly when new books are added or existing books are updated.



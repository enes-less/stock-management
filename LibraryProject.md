# Library Management System API Documentation

## Book Endpoints
Base Path: /book

### 1) Save a Book
Method: POST  
URL: http://localhost:8080/books + Body

### 2) Get All Books
Method: GET  
URL: http://localhost:8080/books

### 3) Get a Book by ID
Method: GET  
URL: http://localhost:8080/books/{id}  
Example: http://localhost:8080/books/2

### 4) Delete a Book by ID
Method: DELETE  
URL: http://localhost:8080/books/{id}  
Example: http://localhost:8080/books/2

### 5) Get a Book by ID (RequestParam)
Method: GET  
URL: http://localhost:8080/books/q?id={id}  
Example: http://localhost:8080/books/q?id=2

### 6) Get a Book by Title (RequestParam)
Method: GET  
URL: http://localhost:8080/books/search?title={title}  
Example: http://localhost:8080/books/search?title=Atomic Habits

### 7) Get Books With Pagination
Method: GET  
URL: http://localhost:8080/books/s?page={page}&size={size}&sort={field}&direction={ASC|DESC}  
Example: http://localhost:8080/books/s?page=1&size=2&sort=publicationDate&direction=ASC

### 8) Update a Book (Using DTO)
Method: PUT  
URL: http://localhost:8080/books/update/{id}  
Example: http://localhost:8080/books/update/2

### 9) Get Books by Author (JPQL)
Method: GET  
URL: http://localhost:8080/books/author?author={authorName}  
Example: http://localhost:8080/books/author?author=AB

### 10) Add a Book to a Borrower
Method: POST or PUT  
URL: http://localhost:8080/books/add?book={bookId}&borrower={borrowerId}  
Example: http://localhost:8080/books/add?book=3&borrower=1


## Borrower Endpoints

### 1) Save a Borrower
Method: POST  
URL: http://localhost:8080/borrower/save + Body

### 2) Get All Borrowers
Method: GET  
URL: http://localhost:8080/borrowers

### 3) Find Borrower by ID
Method: GET  
URL: http://localhost:8080/borrower/{id}  
Example: http://localhost:8080/borrower/2

### 4) Update Borrower by ID
Method: PUT  
URL: http://localhost:8080/borrower/{id}

### 5) Delete Borrower by ID
Method: DELETE  
URL: http://localhost:8080/borrower/{id}

### 6) Filter Borrower by Name
Method: GET  
URL: http://localhost:8080/borrowers?name={name}


## Entity Structure

### Book
id  
title  
author  
publicationYear  
borrower

### Borrower
id  
name  
lastname  
phone  
email  
registrationDate  
bookList

# FinanZen API 💸

![Status](https://img.shields.io/badge/status-in%20progress-yellow)
![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring](https://img.shields.io/badge/Spring%20Boot-3.x-green)

A RESTful API for personal finance management, designed to manage transactions, categorize expenses and income, and provide financial summaries. This is a portfolio project to showcase backend development skills using the Java ecosystem.

## ✨ Features

* **Category Management:** Full CRUD to create, list, update, and delete categories (e.g., Food, Transport, Salary).
* **Transaction Management:** Full CRUD to log income and expenses, associating them with a category.
* **Simple Reporting:** An endpoint to provide a monthly summary with total income, total expenses, and the final balance.

## 🛠️ Tech Stack

Below are the main technologies and tools used in the construction of this API:

* **Backend:**
    * Java 17+
    * Spring Boot 3
    * Spring Data JPA
    * Maven
* **Database:**
    * PostgreSQL
* **Tools & Others:**
    * Docker (for the database environment)
    * Lombok
    * Swagger (OpenAPI) for documentation

## 🚀 How to Run the Project

To run the API locally, please follow the steps below.

### Prerequisites

* [Git](https://git-scm.com)
* [Java JDK 17](https://www.oracle.com/java/technologies/downloads/#java17) or later
* [Docker](https://www.docker.com/products/docker-desktop/) and Docker Compose

### Steps

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/YourUsername/finanzen-api.git](https://github.com/YourUsername/finanzen-api.git)
    cd finanzen-api
    ```

2.  **Start the database with Docker:**
    ```bash
    docker-compose up -d
    ```
    This command will start a PostgreSQL container with the settings defined in the `docker-compose.yml` file.

3.  **Run the application:**
    * You can run it from your IDE (IntelliJ, Eclipse) by finding the main `FinanZenApiApplication` class and running it.
    * Alternatively, you can run it via the terminal using Maven:
    ```bash
    ./mvnw spring-boot:run
    ```

4.  **Access the documentation:**
    * With the application running, access `http://localhost:8080/swagger-ui.html` to see the interactive Swagger documentation.

## 📝 API Endpoints

Below is a list of the main available endpoints.

#### Categories
| HTTP Verb | Endpoint      | Description              |
| :-------- | :------------ | :----------------------- |
| `POST`    | `/categories` | Creates a new category.  |
| `GET`     | `/categories` | Lists all categories.    |

#### Transactions
| HTTP Verb | Endpoint          | Description                                    |
| :-------- | :---------------- | :--------------------------------------------- |
| `POST`    | `/transactions`   | Logs a new transaction.                        |
| `GET`     | `/transactions`   | Lists transactions (date filters to be implemented). |
| `PUT`     | `/transactions/{id}` | Updates an existing transaction.             |
| `DELETE`  | `/transactions/{id}` | Deletes a transaction.                         |


## 🔮 Next Steps

This project is under continuous development. Planned future features include:
- [ ] Implement authentication and authorization with Spring Security and JWT.
- [ ] Add advanced filters for transactions (by date range, category, type).
- [ ] Develop an Angular frontend to consume this API.

## 👨‍💻 Author

**Fernando Souza De Riggi**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/fernandoriggi/)

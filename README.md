# FinanZen API 💸

![Status](https://img.shields.io/badge/status-active%20development-green)
![Java](https://img.shields.io/badge/Java-21-blue)
![Spring](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)

A RESTful API for personal finance management, designed to manage transactions, categorize expenses and income, and provide financial summaries. This is a portfolio project to showcase backend development skills using the Java ecosystem.

## ✨ Features

* **Category Management:** Full CRUD (Create, Read, Update, Delete) to manage expense and income categories (e.g., Food, Transport, Salary).
* **Transaction Management:** Full CRUD to log income and expenses, associating them with a category.
* **Simple Reporting:** An endpoint to provide a monthly summary with total income, total expenses, and the final balance.

## 🛠️ Tech Stack

Below are the main technologies and tools used in the construction of this API:

* **Backend:**
    * Java 21
    * Spring Boot 3
    * Spring Data JPA
    * Maven
* **Database:**
    * PostgreSQL
* **Tools & Others:**
    * Docker (for the database environment)
    * Lombok

## 🚀 How to Run the Project

To run the API locally, please follow the steps below.

### Prerequisites

* [Git](https://git-scm.com)
* [Java JDK 21](https://www.oracle.com/java/technologies/downloads/#java21) or later
* [Docker](https://www.docker.com/products/docker-desktop/) and Docker Compose

### Steps

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/FernandoRiggi/finanzen-api.git](https://github.com/FernandoRiggi/finanzen-api.git)
    cd finanzen-api
    ```

2.  **Configure environment variables for the database:**
    * Create a `.env` file in the root of the project with your PostgreSQL credentials:
        ```dotenv
        # .env
        DB_USERNAME=your_db_username
        DB_PASSWORD=your_db_password
        ```
    * Add `.env` to your `.gitignore` to prevent it from being committed.

3.  **Start the database with Docker Compose:**
    ```bash
    docker compose up -d
    ```
    This command will start a PostgreSQL container with the settings defined in the `docker-compose.yml` file, using the credentials from your `.env` file.

4.  **Run the application:**
    * You can run it from your IDE (IntelliJ, Eclipse) by finding the main `FinanZenApiApplication` class and running it. Ensure your IDE is configured to load environment variables (e.g., from `.env` or directly in run configurations).
    * Alternatively, you can run it via the terminal using Maven:
    ```bash
    # Make sure DB_USERNAME and DB_PASSWORD are set as environment variables in your shell
    ./mvnw spring-boot:run
    ```

5.  **Access the application:**
    The API will be running on `http://localhost:8080`.

## 📝 API Endpoints

Below is a list of the main available endpoints.

#### Categories
| HTTP Verb | Endpoint         | Description                         |
| :-------- | :--------------- | :---------------------------------- |
| `POST`    | `/categories`    | Creates a new category.             |
| `GET`     | `/categories`    | Lists all categories.               |
| `GET`     | `/categories/{id}` | Retrieves a category by its ID.    |
| `PUT`     | `/categories/{id}` | Updates an existing category.       |
| `DELETE`  | `/categories/{id}` | Deletes a category.                 |

#### Transactions
| HTTP Verb | Endpoint          | Description                                    |
| :-------- | :---------------- | :--------------------------------------------- |
| `POST`    | `/transactions`   | Logs a new transaction.                        |
| `GET`     | `/transactions`   | Lists transactions (date filters to be implemented). |
| `PUT`     | `/transactions/{id}` | Updates an existing transaction.               |
| `DELETE`  | `/transactions/{id}` | Deletes a transaction.                         |

## 🔮 Next Steps

This project is under continuous development. Planned future features include:
- [ ] Implement API documentation with Swagger (OpenAPI).
- [ ] Implement authentication and authorization with Spring Security and JWT.
- [ ] Add advanced filters for transactions (by date range, category, type).
- [ ] Develop an Angular frontend to consume this API.

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Fernando Souza De Riggi**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/fernandoriggi/)

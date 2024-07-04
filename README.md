# Authentication API


Este projeto é uma API construída usando Java, Spring Framework, e H2 como banco de dados.


## Table of Contents

- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Database](#database)

## Installation

1. Clone o repositório:


```bash
git clone https://github.com/gVieiraX/PicPaySimplficado.git
```

2. Instale as dependências com Maven

## Usage

1. Inicie a aplicação com Maven
2.A API estará acessível em: http://localhost:8080


## API Endpoints
A API fornece os seguintes endpoints:


**GET USERS**
```markdown
GET /users - Retorna uma lista de todos os usuários.
```
```json
[
    {
        "id": 1,
        "firstName": "Gabriel",
        "lastName": "Vieira",
        "document": "12345678",
        "email": "gabriel@example.com",
        "password": "senha",
        "balance": 20,
        "userType": "MERCHANT"
    },
    {
        "id": 2,
        "firstName": "Pedro",
        "lastName": "Vieira",
        "document": "123456783",
        "email": "pedro@example.com",
        "password": "senha",
        "balance": 10,
        "userType": "COMMON"
    }
]
```

**POST USERS**
```markdown
POST /users - Registra um novo usuário na aplicação.
```
```json
{
    "firstName": "Gabriel",
    "lastName": "Vieira",
    "document": "12345678",
    "email": "gabriel@example.com",
    "password": "senha",
    "balance": 20,
    "userType": "MERCHANT"
}
```

**POST TRANSACTIONS**
```markdown
POST /transactions - Registra uma nova transação entre usuários (COMMON para COMMON ou COMMON para MERCHANT)
```

```json
{
  "senderId": 2,
  "receiverId": 1,
  "value": 5
}
```

## Database
Esse projeto [H2 Database](https://www.h2database.com/html/tutorial.html) como banco de dados. 







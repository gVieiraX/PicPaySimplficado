# Authentication API


Este projeto teve como base o [Desafio Back-end PicPay](https://github.com/PicPay/picpay-desafio-backend ), o PicPay Simplficado (plataforma de  pagamentos simplificada) , é uma API construída usando Java, Spring Framework, e H2 como banco de dados.

## Instalação

1. Clone o repositório:


```bash
git clone https://github.com/gVieiraX/PicPaySimplficado.git
```

2. Instale as dependências com Maven

## Uso

1. Inicie a aplicação com Maven

2. A API estará acessível em: http://localhost:8080


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







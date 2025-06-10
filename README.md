# Back-End Challenge - Contas Correntes

Projeto RESTful desenvolvido em **Java 17 + Spring Boot**, simulando uma instituição financeira com suporte a:


- Cadastro de clientes (PF ou PJ)
- Abertura de contas
- Transferências entre contas
- Reversão de transferências
- Envio de notificações externas via `RestTemplate`

---

## Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven
- RestTemplate (para notificações HTTP)

## 🧱 Estrutura de pacotes

com.borges.backaccount

├── controller

├── service

├── model

├── repository

├── dto

├── config

└── exception


---

## ⚙️ Configuração do banco de dados

O banco H2 roda em memória e é acessível via navegador.

### `application.properties`

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
```

## ✅ Funcionalidades
✅ Cadastro de clientes (Pessoa Física ou Jurídica)

✅ Abertura de contas para clientes

✅ Transferência de valores entre contas

✅ Reversão de transferências específicas

✅ Verificação de saldo e status da conta

✅ Notificação individual para ambos os clientes após transferência

✅ Log da resposta da notificação no console


##  Fluxo de uso com exemplos
### Criar Cliente

post: http://localhost:8080/clientes
```
 {
  "name": "João da Silvo",
  "document": "12345678901",
  "address": "Rua A, 100",
  "password": "1234",
  "type": "PF"
}
```

response:
```
{
    "id": 1,
    "document": "12345678901",
    "name": "João da Silvo",
    "address": "Rua A, 100",
    "password": "1234",
    "type": "PF"
}
```

### Abrir conta 

post: http://localhost:8080/contas
```
{
  "id": 1,
  "agency": "1236",
  "balance": 100.00,
  "status": "ACTIVE"
}
```
response: 

```
{
    "id": 1,
    "agency": "1236",
    "customer": {
        "id": 1,
        "document": "12345678901",
        "name": "João da Silvo",
        "address": "Rua A, 100",
        "password": "1234",
        "type": "PF"
    },
    "balance": 100.00,
    "status": "ACTIVE"
}
```

### Realizar Transferência

post: http://localhost:8080/transferencias

```
{
  "senderId": 1,
  "receiverId": 2,
  "value": 50.00
}
```

Retorna a mensagem 
```
Transferência feita com sucesso
```
### Reverter transação

post: http://localhost:8080/transferencias/{id}/reversal

retorna a mensagem 
```
Transação revertida com sucesso
```

## Como executar o projeto

### 1.Clone o repositório: 
git clone https://github.com/RafaelRhrx/bankaccount.git

### 2.Utilize uma IDE. As mais recomendadas são IntelliJ ou Eclipse.

### 3. Acesse o sistema:
```
API: http://localhost:8080

H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (deixe em branco)
```


## Testes funcionais recomendados
Use ferramentas como Postman ou Insomia para validar os endpoints descritos acima.

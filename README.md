# Concessionária API

## Descrição do projeto

A Concessionária API é uma ferramenta de gerenciamento para concessionárias de veículos, projetada para facilitar o controle preciso de carros e modelos disponíveis.
Esta aplicação é construída com base no framework Spring Boot, usando Java, e é complementada com um banco de dados MySQL. Sua principal proposta é garantir que os dados estejam sempre estruturados de maneira consistente, com regras de negócios estritas que impedem o cadastro de carros sem modelos previamente registrados e de modelos sem marcas associadas.

## Requisitos

Certifique-se de ter o seguinte instalado na sua máquina:

- Java 11 ou superior
- Spring Boot
- Banco de dados MySQL

## Como configurar

1. Configure o banco de dados MySQL no arquivo application.properties:

    ```
    spring.datasource.url=jdbc:mysql://localhost:3306/concessionaria
    spring.datasource.username=seu-usuario
    spring.datasource.password=sua-senha
    ```

2. Inicie a sua aplicação e acesse [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) para acessar a interface do Swagger e testar a sua API.

3. Verificação do CORS :lock:

    Certifique-se de que o CORS (Cross-Origin Resource Sharing) está configurado corretamente para permitir solicitações de origens específicas. Isso é fundamental para garantir que seu aplicativo da web possa acessar a API da Concessionária.
    
    1. Abra o arquivo `WebMvcConfig.java` em `src/main/java/dev/rudzzz/concessionaria/config`.
    
    2. Verifique se as configurações CORS estão corretas no método `addCorsMappings`. No exemplo fornecido, está configurado para permitir origens apenas de `http://localhost:5173`. Certifique-se de que a origem listada corresponda à origem de onde seu aplicativo da web será acessado.
    
    3. Verifique se os métodos permitidos (`GET`, `POST`, `PUT`, `DELETE`, `HEAD`, `OPTIONS`) estão configurados corretamente para as necessidades da sua aplicação.
    
    4. Certifique-se de que `allowCredentials` esteja configurado de acordo com suas necessidades de autenticação.

## Instruções de Uso

Aqui estão algumas instruções básicas sobre como usar a API:

- Para cadastrar uma nova marca, faça uma solicitação POST para `/marcas` com os detalhes da marca.
- Para cadastrar um novo modelo, faça uma solicitação POST para `/modelos` com os detalhes do modelo e o ID da marca associada.
- Para cadastrar um novo carro, faça uma solicitação POST para `/carros` com os detalhes do carro e o ID do modelo associado.
- Para visualizar a listagem completa de modelos disponíveis, faça uma solicitação para `/carros/modelos`.
- **Exemplo de Resposta:**
    ```json
   {
    "cars": [
        {
            "id": 1,
            "ano": 2015,
            "combustivel": "GASOLINA",
            "cor": "BRANCO",
            "valor": "40.000",
            "timestamp_cadastro": 1697559546,
            "modelo_id": 2,
            "num_portas": 2,
            "nome_modelo": "ONIX"
        },
        {
            "id": 2,
            "ano": 2023,
            "combustivel": "FLEX",
            "cor": "PRETO",
            "valor": "35.000",
            "timestamp_cadastro": 1697559566,
            "modelo_id": 1,
            "num_portas": 4,
            "nome_modelo": "PALIO"
        }
    ]
  }
    ```

Lembre-se de que um modelo só pode ser cadastrado se a marca estiver previamente cadastrada e um carro só pode ser cadastrado se um modelo estiver previamente cadastrado.

## Exemplos de Requisições

Aqui estão alguns exemplos de solicitações HTTP:

- Cadastrar uma marca:
  ```
  POST /marcas
  {
    "nome": "Chevrolet"
  }
  ```
- Cadastrar um modelo:
  ```
  POST /modelos
  {
    "marca_id": 1,
    "nome": "Onix",
    "valor_fipe": 40000.0
  }
  ```
- Cadastrar um carro:
  ```
  POST /carros
  {
    "modelo_id": 1,
    "ano": 2023,
    "combustivel": "Flex",
    "num_portas": 4,
    "cor": "Azul"
  }
  ```
  
## Linguagens e Frameworks Utilizados :books:

- **Java 11:** A linguagem de programação principal para o desenvolvimento do back-end da aplicação.

- **Spring Boot:** Um framework que simplifica o desenvolvimento de aplicativos Java, incluindo a criação de APIs RESTful.

- **MySQL:** Um sistema de gerenciamento de banco de dados relacional usado para armazenar os dados da aplicação.

- **Swagger:** Uma ferramenta para documentação de APIs e teste interativo, facilitando a interação com a API.

- **Spring Data JPA:** Uma parte do projeto Spring que simplifica o acesso a bancos de dados relacionais usando a tecnologia JPA (Java Persistence API).

- **Jakarta Persistence (antigo JPA):** Uma API do Java que descreve o gerenciamento de dados em aplicativos Java.

Esta lista representa uma visão geral das principais tecnologias usadas na Concessionária API. Tenha em mente que, dependendo do seu projeto, pode haver outras tecnologias e dependências específicas para atender às necessidades de desenvolvimento.


## Licença

Copyright © 2023 - Concessionária API
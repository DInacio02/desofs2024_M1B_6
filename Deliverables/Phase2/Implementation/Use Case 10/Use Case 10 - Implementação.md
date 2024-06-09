# Implementação - Caso de Uso "Criar Novos Produtos"

## Descrição do Caso de Uso

```
As a Manager/Admin
I want to be able to create new products
So that way it is possible to easily update our latest realeases
```

## Casos de Abuso

- **Inserção de Informações Falsas:** Um gestor mal-intencionado pode inserir produtos com informações incorretas ou enganosas para prejudicar a reputação da empresa ou enganar os utilizadores.

- **Ataques de Sobrecarga:** Um atacante pode tentar sobrecarregar o sistema enviando um grande número de pedidos de criação de produtos, causando uma negação de serviço ou tornando o sistema indisponível para os gestores legítimos.

## ASVS Associados

- **Inserção de Informações Falsas:**

  - Não foi possível identificar nenhum ASVS que mitigue este caso de abuso, no entanto, existem outros que ajudam a identificar se o comportamento é normal ou malicioso, como, por exemplo, a existência de logs.  

- **Ataques de Sobrecarga:**

1. ASVS 8.1.4: Verify the application can detect and alert on abnormal numbers of requests, such as by IP, user, total per hour or day, or whatever makes sense for the application.


## Implementação da UC

Para implementar a criação de produtos na aplicação foi adicionado um novo endpoint `/product` na classe *ProductController*.

![CreateProductEndpoint.png](img%2FCreateProductEndpoint.png)

Este endpoint utiliza um *CreateProductRequest* (produto construído no front-end) que é passado depois para o *ProductService* para criar o produto na base de dados.

![CreateProductRequest.png](img%2FCreateProductRequest.png)

## Implementação dos ASVS

Tal como já foi descrito no [Use Case 3 - Implementação.md](..%2FUse%20Case%203%2FUse%20Case%203%20-%20Implementa%E7%E3o.md),
para implementar o ASVS 8.1.4 na aplicação, foi criado o componente *RateLimiterInterceptor*, responsável por controlar a quantidade de solicitações recebidas por IP.

Para permitir que aplicacão seja capaz de detectar e alertar sobre números anormais de solicitações, basta
adicionar o endpoint que é chamado no momento da criação de um novo produto `/product`, ao ficheiro de configuração
que define quais os endpoints que devem ser monitorados pelo interceptor:

![Interceptor.png](img%2FInterceptor.png)
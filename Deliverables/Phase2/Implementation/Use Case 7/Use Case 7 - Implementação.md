# Implementação - Caso de Uso "Criar uma conta com os meus credenciais"

## Descrição do Caso de Uso

```
As a User
I want to be able to create an account with my credentials
So that I can use the application
```

## Casos de Abuso:

- **Injeção de Código Malicioso:** Um atacante pode tentar injetar código malicioso nos campos de entrada, explorando 
vulnerabilidades de XSS, para comprometer a segurança do sistema ou obter acesso não autorizado a informações sensíveis.

- **Ataques de Sobrecarga:** Um atacante pode tentar sobrecarregar o sistema enviando uma grande quantidade de pedidos 
de criação de conta (POST) de forma maliciosa, causando uma negação de serviço/aumento do tempo de resposta temporária 
para os utilizadores legítimos.

- **Interceção de pedidos:** Um atacante pode intercetar pedidos de criação de conta e guardar os credenciais do utilizador,
podendo aceder a informação sensível.

## ASVS Associados

- **Injeção de Código Malicioso:**

ASVS 5.3.3: Verificar que a aplicação, de preferência de forma automática ou, em último caso, manual, efetua a escape adequada de saída para proteger contra XSS refletido, armazenado e baseado em DOM.

- **Ataques de Sobrecarga:**

ASVS 8.1.4: Verify the application can detect and alert on abnormal numbers of requests, such as by IP, user, total per hour or day, or whatever makes sense for the application.

- **Interceção de pedidos:**

ASVS 5.3.8: Verify that the application protects against OS command injection and that operating system calls use parameterized OS queries or use contextual command line output encoding.

## Implementação da UC

Esta UC já se encontra desenvolvida. Apenas a aplicação dos ASVS foram necessários.

## Implementação dos ASVS
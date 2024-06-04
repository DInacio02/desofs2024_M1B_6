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

1. ASVS X:
2. ASVS Y:

- **Ataques de Sobrecarga:**

1. ASVS X:
2. ASVS Y:

- **Interceção de pedidos:**

1. ASVS X:
2. ASVS Y:

## Implementação da UC


## Implementação dos ASVS
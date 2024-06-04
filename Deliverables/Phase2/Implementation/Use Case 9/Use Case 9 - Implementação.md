# Implementação - Caso de Uso "Fazer pedido de recuperação de palavra-passe"

## Descrição do Caso de Uso

```
As a User
I want to be able to request a password forgot request
So that I can recover my account
```

## Casos de Abuso:

- **Ataques de Sobrecarga:** Um atacante pode tentar sobrecarregar o sistema enviando uma grande quantidade de pedidos
de recuperação de palavra-passe de forma maliciosa, causando uma negação de serviço/aumento do tempo de resposta temporária
para os utilizadores legítimos.

- **Injeção de Código Malicioso:** Um atacante pode tentar injetar código malicioso nos campos de entrada, explorando
vulnerabilidades de XSS, para comprometer a segurança do sistema ou obter acesso não autorizado a informações sensíveis.

- **Interceção de pedidos:** Um atacante pode intercetar pedidos de recuperação de palavra-passe e enviar um e-mail que
possa ser confundido com o de recuperação de palavra-passe para um ataque de phishing.

## ASVS Associados

- **Ataques de Sobrecarga:**

1. ASVS X:
2. ASVS Y:

- **Injeção de Código Malicioso:**

1. ASVS X:
2. ASVS Y:

- **Interceção de pedidos:**

1. ASVS X:
2. ASVS Y:


## Implementação da UC


## Implementação dos ASVS
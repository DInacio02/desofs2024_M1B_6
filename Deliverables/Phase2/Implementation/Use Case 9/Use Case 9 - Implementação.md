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

ASVS 8.1.4: Verificar se a aplicação pode detetar e alertar sobre um número anormal de pedidos, como por IP, utilizador, total por hora ou dia, ou qualquer que seja sensato para a aplicação.

- **Injeção de Código Malicioso:**

ASVS 5.3.3: Verificar que a aplicação, de preferência de forma automática ou, em último caso, manual, efetua a escape adequada de saída para proteger contra XSS refletido, armazenado e baseado em DOM.

- **Interceção de pedidos:**

ASVS 9.1.1: Verificar se todas as credenciais, tokens de autenticação e informações sensíveis são transportadas apenas através de um canal criptografado (TLS).


## Implementação da UC

Esta UC já se encontra desenvolvida. Apenas a aplicação dos ASVS foram necessários.

## Implementação dos ASVS
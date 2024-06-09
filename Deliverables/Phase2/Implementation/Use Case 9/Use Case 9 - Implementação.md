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

### ASVS 8.1.4

Tal como já foi descrito no [Use Case 3 - Implementação.md](..%2FUse%20Case%203%2FUse%20Case%203%20-%20Implementa%E7%E3o.md) e [Use Case 7 - Implementação.md](..%2FUse%20Case%207%2FUse%20Case%207%20-%20Implementa%E7%E3o.md),
para implementar o ASVS 8.1.4 na aplicação, foi criado o componente RateLimiterInterceptor, responsável por controlar a quantidade de solicitações recebidas por IP.

Para permitir que aplicacão seja capaz de detectar e alertar sobre números anormais de solicitações, basta
adicionar o endpoint que é chamado no momento em que é feito o pedido de recuperação de password ("/account/password/forgot"), ao ficheiro de configuração
que define quais os endpoints que deve ser monitorados pelo interceptor:

![interceptor.png](img%2Finterceptor.png)
</br>
</br>

### ASVS 5.3.3

Tal como na implementação feita no [Use Case 7 - Implementação.md](..%2FUse%20Case%207%2FUse%20Case%207%20-%20Implementa%E7%E3o.md), no momento em que o utilizador introduz um e-mails
é feito primeiro uma validação do texto introduzido utilizando uma gramática que valida se o texto tem o formato de um e-mails:

![passwordGrammar.png](img%2FpasswordGrammar.png)

Caso o texto introduzido não tenha o formato de e-mails, não lhe é permitida a sumbissão, e uma mensagem de erro é mostrada.

![error.png](img%2Ferror.png)

Além disso, todos os e-mails e senhas são apenas armazenados na base de dados e nunca são exibidos na UI, o que ajuda a proteger a aplicação. 
No entanto, a proteção contra XSS refletido, armazenado e baseado em DOM é garantida principalmente pelas medidas de sanitização e validação implementadas tanto no front-end quanto no back-end, estando assim de acordo com o ASVS 5.3.3.
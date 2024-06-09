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

### ASVS 5.3.3

No momento em que o utilizador introduz um e-mails é feito primeiro uma validação desse texto introduzido 
utilizando uma gramática que valida se o texto tem o formato de um e-mail:

![passwordGrammar.png](img%2FpasswordGrammar.png)

Caso o texto introduzido não tenha o formato de e-mails, não lhe é permitida a sumbissão, e uma mensagem de erro é mostrada.

![error.png](img%2Ferror.png)

Quanto à Pasword, está não é validada no front-end, mas sim no back-end, através da utilização
do Encoder, da biblioteca OWASP Java Encoder, que faz a sanitização tanto do email como a password.

![ecoder.png](img%2Fecoder.png)

Além disso, todos os e-mails e senhas são apenas armazenados na base de dados e nunca são exibidos na UI, o que ajuda a proteger a aplicação.
No entanto, a proteção contra XSS refletido, armazenado e baseado em DOM é garantida principalmente pelas medidas de sanitização e validação implementadas tanto no front-end quanto no back-end, estando assim de acordo com o ASVS 5.3.3.

### ASVS 8.1.4

Tal como já foi descrito no [Use Case 3 - Implementação.md](..%2FUse%20Case%203%2FUse%20Case%203%20-%20Implementa%E7%E3o.md),
para implementar o ASVS 8.1.4 na aplicação, foi criado o componente RateLimiterInterceptor, responsável por controlar a quantidade de solicitações recebidas por IP. 

Para permitir que aplicacão seja capaz de detectar e alertar sobre números anormais de solicitações, basta
adicionar o endpoint que é chamado no momento do registo ("/account/registration"), ao ficheiro de configuração
que define quais os endpoints que deve ser monitorados pelo interceptor:

![interceptor.png](img%2Finterceptor.png)
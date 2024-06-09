# Implementação - Caso de Uso "Login"

## Descrição do Caso de Uso

```
As a User
I want to be able to login with my credentials
So that I can use the application
```

## Casos de Abuso

- **Forçar entrada por tentativa e erro:** Um atacante pode abusar de a aplicação não ter nenhuma forma de para a tentativa consecutiva de login.

## ASVS Associados

- **Forçar entrada por tentativa e erro:**

ASVS 2.2.1: Verificar se a aplicação bloqueia uma conta de utilizador após um número especificado de tentativas de autenticação malsucedidas dentro de um período de tempo especificado.

**Nota:** Para cada caso de abuso foi analisado qual o ASVS que melhor se relaciona com o caso de abuso, tendo em conta que com a implementação deste, outros ASVS são também abordados.
Este estudo foi feito no Excel a entregar.

## Implementação da UC

Esta UC já se encontra desenvolvida. Apenas a aplicação dos ASVS foram necessários.

## Implementação dos ASVS

### ASVS 2.2.1

Para a implemtação desta ASVS na aplicação, podemos reutilizar o componente RateLimiterInterceptor, introduzido no [Use Case 3 - Implementação.md](..%2FUse%20Case%203%2FUse%20Case%203%20-%20Implementa%E7%E3o.md),
responsável por controlar a quantidade de solicitações recebidas por IP para o "resource_serever". 

Embora este componente tenha sido desenvolvido com a finalidade de assegurar o ASVS 8.1.4, ele é 
também capaz de assegurar o ASVS 2.2.1 pois consegue bloquear o IP de um utilizador 
após um número especificado de tentativas de autenticação malsucedidas num período de tempo especificado.

Posto isto, o RateLimiterInterceptor foi implementado no componente de autenticação da aplicação
"authorization_server".

Assim, basta configuarar o intercetor com o número de pedidos/tempo desejado para permitir mitigar
tentativas de login por bruteforce.

![bruteforce.png](img%2Fbruteforce.png)

# Implementação - Caso de Uso "Ver e Filtrar uma Lista de Produtos"

## Descrição do Caso de Uso

```
As a User
I want to be able to see and filter a list of products
So that I can easily search for the product I want to buy
```

## Casos Abuso

- **Injeção de Código Malicioso:** Um atacante pode tentar injetar código malicioso na barra de pesquisa, explorando vulnerabilidades de XSS, para comprometer a segurança do sistema ou obter acesso não autorizado a informações sensíveis.

- **Ataques de Sobrecarga:** Um atacante pode tentar sobrecarregar o sistema enviando uma grande quantidade de solicitações de pesquisa ou filtragem de forma maliciosa, causando uma negação de serviço temporária para os utilizadores legítimos.

## ASVS Associados

- **Injeção de Código Malicioso:**

ASVS 5.3.3: Verificar se a saída é corretamente codificada para prevenir ataques de XSS refletidos, armazenados e baseados em DOM.

- **Ataques de Sobrecarga:**

ASVS 8.1.4: Verificar se a aplicação pode detetar e alertar sobre números anormais de solicitações, como por IP, utilizador, total por hora ou dia, ou o que faz sentido para o aplicativo.

**Nota:** Para cada caso de abuso foi analisado qual o ASVS que melhor se relaciona com o caso de abuso, tendo em conta que com a implementação deste, outros ASVS são também abordados.
Este estudo foi feito no Excel a entregar.

## Implementação da UC

Esta UC já se encontra desenvolvida. Apenas a aplicação dos ASVS foram necessários.

## Implementação dos ASVS

### ASVS 5.3.3

O ASVS 5.3.3 exige que a saída seja corretamente codificada para prevenir ataques de XSS refletidos, armazenados e baseados em DOM. 
Assim, existe dois pontos importantes a considerar para garantir o ASVS 5.3.3:

#### 1. Validação de Entrada:

Quando o utilizador filtra a lista de produtos utilizando a barra de pesquisa, a informação escrita na barra de pesquisa é enviada para
o endpoint "product/search" do "resource_server".

![searchbar.png](img%2Fsearchbar.png)

![endpointcall.png](img%2Fendpointcall.png)

O "resource_server" é responsável por encontrar os produtos que contenham o o texto pesquisado e enviar de volta para o frontend (client).

Para garantir a validação de entrada, a informação enviada do frontend para o backend deve ser sanitizada no momento de recebimento para garantir que não contenha caracteres maliciosos:

![validacao.png](img%2Fvalidacao.png)

Ao adicionar esta validação realizada pelo Encoder, da biblioteca OWASP Java Encoder, garantimos a sanitização da entrada fornecida pelo utilizador.
</br>
</br>
#### 2. Codificação de Saída:

A saída da pesquisa (ProductResponse) deve ser corretamente codificada antes de ser renderizada no front-end.

O código Angular já está estruturado para prevenir XSS, pois o Angular automaticamente limpa os caracteres perigosos ao usar interpolação ( {{}} ).

Ex:
![exDeInterpolacao.png](img%2FexDeInterpolacao.png)
</br>
</br>
</br>

### ASVS 8.1.4

Para implementar o ASVS 8.1.4 na aplicação, foi criado o componente RateLimiterInterceptor, responsável por controlar a quantidade de solicitações recebidas por IP. 

![interceptor.png](img%2Finterceptor.png)

Na prática, este componente utiliza um cache em memória para armazenar contadores de solicitações por endereço IP e aplicar limites de taxa, prevenindo ataques de sobrecarga (DoS).

Junto com a implementação deste componente foram adicionadas duas classes de configuração que 
complementam o trabalho do RateLimiterInterceptor.

![configs.png](img%2Fconfigs.png)

1. WebConfiguration: Esta configuração configura o RateLimiterInterceptor e garante que o interceptor seja aplicado às rotas específicas onde a limitação de taxa é necessária.
(neste caso foi adicionado ao endpoint "/products/search")

![webConfigEndpoints.png](img%2FwebConfigEndpoints.png)

2. CacheConfig: Esta configuração define as propriedades do cache utilizado pelo RateLimiterInterceptor. A biblioteca Caffeine é utilizada para criar um cache eficiente, com um tempo de expiração configurado para 1 hora e um tamanho máximo de 1000 entradas.

![cache.png](img%2Fcache.png)

Com estas implementações, a aplicação é capaz de detectar e alertar sobre números anormais de solicitações, atendendo ao requisito do ASVS 8.1.4 e protegendo a aplicação contra ataques de sobrecarga (DoS).
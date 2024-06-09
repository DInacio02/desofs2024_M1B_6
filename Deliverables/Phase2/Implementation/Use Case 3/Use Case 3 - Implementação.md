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
o endpoint "api/public/product/search" do "resource_server".

![searchbar.png](img%2Fsearchbar.png)

![endpointcall.png](img%2Fendpointcall.png)

O "resource_server" é responsável por encontrar os produtos que contenham o texto pesquisado e enviar de volta para o frontend (client).

Para garantir a validação de entrada, a informação enviada do frontend para o backend deve ser sanitizada no momento de recebimento para garantir que não contenha caracteres maliciosos:

![validacao.png](img%2Fvalidacao.png)

Ao adicionar esta validação realizada pelo Encoder, da biblioteca OWASP Java Encoder, garantimos a sanitização da entrada fornecida pelo utilizador.
</br>
</br>
#### 2. Codificação de Saída:

Como é possível observar ao utilizar a aplicação, toda a pesquisa feita na barra de pesquisa é envaida no url para o backend, 
o que pode constituir um perigo de ataques XSS. 

No entanto, o front-end tem implementado no processo de envio de pedidos https uma verificação para este tipo de ataques, bloqueando a pesquisa,
e reencaminhando o pedido para uma página de erro default definida na aplicação:

![pagDeErro.png](img%2FpagDeErro.png)

Para além disso, todas as respostas do backend que devolvam um objeto de Produto a ser mostrado na UI (ProductResponse) são corretamente codificadas antes de serem renderizada no front-end.

O código Angular já está estruturado para prevenir XSS, pois limpa automaticamente os caracteres perigosos ao usar interpolação ( {{}} ).

Ex:
![exDeInterpolacao.png](img%2FexDeInterpolacao.png)
</br>
</br>
</br>

### ASVS 8.1.4

Para implementar o ASVS 8.1.4 na aplicação, foi criado o componente RateLimiterInterceptor, responsável por controlar a quantidade de solicitações recebidas por IP. 

![interceptor.png](img%2Finterceptor.png)

Este componente verifica cada pedido recebido do frontend e analisa quantas vezes este foi feito pelo
IP que o está a executar. Caso esse pedido exceda um número predefinido de vezes que foi executado por tempo,
o IP é bloqueado de executar esse pedido por um tempo também predefinido, prevenindo assim ataques de sobrecarga (DoS).

Para efeitos demonstrativos, o intercetor foi configurado para bloquear um IP de fazer pedidos durante 1 minuto após
executar 10x o mesmo pedido. No entanto, este número deve ser ajustado conforme o endpoint e a quantidade de pedidos 
espectáveis para a aplicação.

![interceptorConfigs.png](img%2FinterceptorConfigs.png)

Junto com o componente RateLimiterInterceptor foi adicionado ao sistema um compoennte de configuração WebMvcConfig, que define
quais os endpoints que o intercetor deve monitorar.

![config.png](img%2Fconfig.png)

Assim, caso o utilizador execute mais de dez pesquisas por produtos na barra de pesquisa no perioido de 1 minuto, ele ficará bloquado durante 1 minuto de utilizar a aplicação:

![tooManyReq.png](img%2FtooManyReq.png)

Com estas implementações (configurando adequandamente os tresholds de número máximo de pedidos por tempo), 
a aplicação é capaz de detectar e alertar sobre números anormais de solicitações, atendendo ao requisito do ASVS 8.1.4 e protegendo a aplicação contra ataques de sobrecarga (DoS).
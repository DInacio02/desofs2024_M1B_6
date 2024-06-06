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

1. ASVS 5.3.3: Verificar se a saída é corretamente codificada para prevenir ataques de XSS refletidos, armazenados e baseados em DOM.

- **Ataques de Sobrecarga:**

1. ASVS 8.1.4: Verificar se a aplicação pode detetar e alertar sobre números anormais de solicitações, como por IP, utilizador, total por hora ou dia, ou o que faz sentido para o aplicativo.

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

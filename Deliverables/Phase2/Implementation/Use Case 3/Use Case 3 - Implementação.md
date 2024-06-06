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
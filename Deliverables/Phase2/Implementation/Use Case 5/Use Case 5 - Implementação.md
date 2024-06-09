# Implementação - Caso de Uso "Visualizar o Perfil do Utilizador"

## Descrição do Caso de Uso

```
As a User
I want to be able to see a my user information
So that I can easily change it if needed
```

## Casos Abuso

- **Mudar o endereço de entrega de uma encomenda:** Um atacante com acesso aos dados do utilizador pode mudar o endereço de entrega do utilizador e receber as encomendas do mesmo.

## ASVS Associados

ASVS 4.3.1: Verificar se as interfaces administrativas utilizam a autenticação multifactor adequada para evitar a utilização não autorizada.

**Nota:** Para cada caso de abuso foi analisado qual o ASVS que melhor se relaciona com o caso de abuso, tendo em conta que com a implementação deste, outros ASVS são também abordados.
Este estudo foi feito no Excel a entregar.


## Implementação da UC

Esta UC já se encontra desenvolvida. Apenas a aplicação dos ASVS foram necessários.

## Implementação dos ASVS


### 4.3.1
Para a implementação desta ASVS o grupo pensou em implementar uma funcionalidade extra no processo de update das informações, que fornecesse uma
autenticação de dois fatores através do envio de um email para o utilizador. 

O objetivo seria a aplicação emviar um código por email, no momento em que o utilziador clicasse no butão "Update", para ele introduzir na aplicação,
e validar a sua identidade.

![popup.png](img%2Fpopup.png)

Esta validação, que constitui uma validação multifator, iria implementar com sucesso o ASVS 4.3.1. 
No entanto, apesar dos esforços, a equipa não conseguiu terminar esta implementação.


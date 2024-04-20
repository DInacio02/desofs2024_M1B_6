# Threat Modeling para "Criar uma conta com os meus credenciais"

## Descrição do Caso de Uso

```
As a User
I want to be able to create an account with my credentials
So that I can use the application
```

## Determinar Ameaças

## Análise de Ameaças

### Compreensão das Ameaças

- **(Denial Of Service):** Sobrecarregar o sistema com uma grande quantidade de pedidos de criação de conta ao servidor,
tornando-o lento ou indisponível.
- **(Tampering):** Injetar código SQL nos campos de entrada de dados, aproveitando-se de falhas de validação ou sanitização.
- **(Spoofing/Tampering):** Inserir scripts maliciosos, comprometendo a segurança do sistema ou roubando informações 
confidenciais dos utilizadores.
- **(Spoofing/Information Disclosure):** Interceção do pedido de forma a conseguir ver os credenciais do utilizador que está a 
criar a conta.

### Casos de Uso e Abuso

#### Casos de Uso:

- **Criar uma conta com credenciais:** O utilizador utiliza três campos de entrada de dados (E-mail, Password e Repetir 
Password) para criar uma conta com os credenciais introduzidos.

#### Casos de Abuso:

- **Injeção de Código Malicioso:** Um atacante pode tentar injetar código malicioso nos campos de entrada, explorando 
vulnerabilidades de XSS, para comprometer a segurança do sistema ou obter acesso não autorizado a informações sensíveis.
- **Ataques de Sobrecarga:** Um atacante pode tentar sobrecarregar o sistema enviando uma grande quantidade de pedidos 
de criação de conta (POST) de forma maliciosa, causando uma negação de serviço/aumento do tempo de resposta temporária 
para os utilizadores legítimos.
- **Interceção de pedidos:** Um atacante pode intercetar pedidos de criação de conta e guardar os credenciais do utilizador,
podendo aceder a informação sensível.

## Contramedidas e Mitigação

| Tipo de Ameaça                                                            | Técnicas de Mitigação                                                                                                                                   | Critério de ameaça  |
|---------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| Sobrecarga do sistema com pedidos maliciosas                              | 1. Implementar rate limiting ou throttling para limitar o número de pedidos por utilizador.                                                             | Totalmente Mitigada |
|                                                                           | 2. Utilizar serviços de proteção contra ataques DDoS para detectar e mitigar ataques em larga escala.                                                   | Totalmente Mitigada |
| Injeção de código SQL nas barras de entrada de dados                      | 1. Implementar validação e sanitização rigorosas dos dados de entrada no cliente e no servidor para garantir que apenas caracteres válidos são aceites. | Totalmente Mitigada |
| Inserção de scripts maliciosos na barra de pesquisa                       | 1. Aplicar filtragem de entrada para remover caracteres especiais e evitar a execução de scripts maliciosos.                                            | Totalmente Mitigada |
|                                                                           | 2. Implementar Content Security Policy (CSP) no lado do servidor para restringir o tipo de conteúdo executável em uma página da web.                    | Totalmente Mitigada |
| Interceção do pedido de forma a guardar os credenciais do novo utilizador | 1. Utilizar SSL para autenticação com o servidor e a encriptação dos dados que são passados nos pedidos.                                                | Totalmente Mitigada |

## Threat Tree

![US 7 - Threat Tree.svg](US7ThreatTree.svg)
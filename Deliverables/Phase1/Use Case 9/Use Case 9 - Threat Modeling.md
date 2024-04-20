# Threat Modeling para "Fazer pedido de recuperação de palavra-passe"

## Descrição do Caso de Uso

```
As a User
I want to be able to request a password forgot request
So that I can recover my account
```

## Determinar Ameaças

### Lista de Ameaças STRIDE

| Tipo                   | Descrição                                                                                                                 | Controlo de Segurança |
|------------------------|---------------------------------------------------------------------------------------------------------------------------|-----------------------|
| Spoofing               | Ação de ameaça destinada a aceder e usar credenciais de outro utilizador, como nome de utilizador e palavra-passe.        | Autenticação          |
| Tampering              | Ação de ameaça com a intenção de alterar ou modificar maliciosamente dados persistentes.                                  | Integridade           |
| Repudiation            | Ação de ameaça destinada a realizar operações proibidas num sistema que não possui a capacidade de rastrear as operações. | Não Repúdio           |
| Information Disclosure | Ação de ameaça com a intenção de ler um ficheiro ao qual não foi concedido acesso, ou ler dados em trânsito.              | Confidencialidade     |
| Denial of Service      | Ação de ameaça que tenta negar acesso a utilizadores válidos.                                                             | Disponibilidade       |
| Elevation of Privilege | Ação de ameaça com a intenção de obter acesso privilegiado a recursos.                                                    | Autorização           |

## Análise de Ameaças

### Compreensão das Ameaças

- **(Denial Of Service):** Sobrecarregar o sistema com uma grande quantidade de pedidos ao servidor, tornando-o lento ou
indisponível.
- **(Information Disclosure/Tampering):** Pode ser intercetado de forma a ter conhecimento do e-mail do utilizador e 
tentar replicar o e-mail de recuperação de palavra-passe para ataques de phishing por exemplo.
- **(Tampering):** Injetar código SQL no campo de e-mail, aproveitando-se de falhas de validação ou sanitização.
- **(Spoofing/Tampering):** Inserir scripts maliciosos, comprometendo a segurança do sistema ou roubando informações 
confidenciais dos utilizadores.

### Casos de Uso e Abuso

#### Casos de Uso:

- **Fazer pedido de recuperação de palavra-passe:** O utilizador introduz o seu e-mail para fazer pedido de recuperação
de palavra-passe.

#### Casos de Abuso:

- **Ataques de Sobrecarga:** Um atacante pode tentar sobrecarregar o sistema enviando uma grande quantidade de pedidos
de recuperação de palavra-passe de forma maliciosa, causando uma negação de serviço/aumento do tempo de resposta temporária
para os utilizadores legítimos.
- **Injeção de Código Malicioso:** Um atacante pode tentar injetar código malicioso nos campos de entrada, explorando
vulnerabilidades de XSS, para comprometer a segurança do sistema ou obter acesso não autorizado a informações sensíveis.
- **Interceção de pedidos:** Um atacante pode intercetar pedidos de recuperação de palavra-passe e enviar um e-mail que
possa ser confundido com o de recuperação de palavra-passe para um ataque de phishing.

## Contramedidas e Mitigação

| Tipo de Ameaça                                                                          | Técnicas de Mitigação                                                                                                                          | Critério de ameaça  |
|-----------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| Sobrecarga do sistema com solicitações maliciosas                                       | 1. Implementar rate limiting ou throttling para limitar o número de solicitações por utilizador.                                               | Totalmente Mitigada |
|                                                                                         | 2. Utilizar serviços de proteção contra ataques DDoS para detectar e mitigar ataques em larga escala.                                          | Totalmente Mitigada |
| Injeção de código SQL ou scripts no campo de e-mail                                     | 1. Implementar validação e sanitização rigorosas dos dados de entrada no cliente e no servidor para garantir que apenas e-mails sejam aceites. | Totalmente Mitigada |
|                                                                                         | 2. Implementar Content Security Policy (CSP) no lado do servidor para restringir o tipo de conteúdo executável em uma página da web.           | Totalmente Mitigada |
| Interceção do pedido de forma a imitar o e-mail de recuperação para ataques de phishing | 1. Utilizar SSL para autenticação com o servidor e a encriptação dos dados que são passados nos pedidos.                                       | Totalmente Mitigada |

## Threat Tree

![US 9 - Threat Tree.svg](US9ThreatTree.svg)
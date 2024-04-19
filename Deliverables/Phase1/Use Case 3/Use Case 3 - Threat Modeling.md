# Threat Modeling para "Ver e Filtrar uma Lista de Produtos"

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

- **(Denial Of Service)** Sobrecarregar o sistema com uma grande quantidade de solicitações de pesquisa maliciosas, tornando-o lento ou indisponível.
- **(Tampering)** Injetar código SQL na barra de pesquisa, aproveitando-se de falhas de validação ou sanitização.
- **(Spoofing/Tampering)** Inserir scripts maliciosos, comprometendo a segurança do sistema ou roubando informações confidenciais dos utilizadores.


### Casos de Uso e Abuso



## Contramedidas e Mitigação

| Tipo de Ameaça                                      | Técnicas de Mitigação                                                                                                                | Critério de ameaça  |
|-----------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| Sobrecarga do sistema com solicitações maliciosas   | 1. Implementar rate limiting ou throttling para limitar o número de solicitações por utilizador.                                     | Totalmente Mitigada |
|                                                     | 2. Utilizar serviços de proteção contra ataques DDoS para detectar e mitigar ataques em larga escala.                                | Totalmente Mitigada |
|                                                     |                                                                                                                                      |                     |
| Injeção de código SQL na barra de pesquisa          | 1. Utilizar prepared statements ou consultas parametrizadas para evitar a execução de comandos SQL não autorizados.                  | Totalmente Mitigada |
|                                                     | 2. Implementar validação e sanitização rigorosas dos dados de entrada para garantir que apenas caracteres válidos sejam aceites.     | Totalmente Mitigada |
|                                                     |                                                                                                                                      |                     |
| Inserção de scripts maliciosos na barra de pesquisa | 1. Aplicar filtragem de entrada para remover caracteres especiais e evitar a execução de scripts maliciosos.                         | Totalmente Mitigada |
|                                                     | 2. Implementar Content Security Policy (CSP) no lado do servidor para restringir o tipo de conteúdo executável em uma página da web. | Totalmente Mitigada |

## Threat Tree

![US 3 - Threat Tree.svg](US%203%20-%20Threat%20Tree.svg)
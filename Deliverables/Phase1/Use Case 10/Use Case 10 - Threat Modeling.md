# Threat Modeling para "Criar Novos Produtos"

## Descrição do Caso de Uso

```
As a Manager/Admin
I want to be able to create new products
So that way it is possible to easily update our latest realeases
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

- **(Tampering)** Inserir produtos com informações falsas ou maliciosas que podem enganar os utilizadores ou comprometer a integridade dos dados.
- **(Information Disclosure)** Expor detalhes sensíveis ou estratégicos dos produtos que podem ser utilizados por concorrentes.
- **(Denial of Service)** Sobrecarregar o sistema com um grande número de pedidos de criação de produtos, tornando-o lento ou indisponível.

### Casos de Uso e Abuso

**Casos de Uso:**

- **Criar novo produto:** O gestor/administrador insere detalhes do novo produto, como nome, descrição, preço e imagem, para adicionar ao catálogo.

**Abusos:**

- **Inserção de Informações Falsas:** Um gestor mal-intencionado pode inserir produtos com informações incorretas ou enganosas para prejudicar a reputação da empresa ou enganar os utilizadores.
- **Ataques de Sobrecarga:** Um atacante pode tentar sobrecarregar o sistema enviando um grande número de pedidos de criação de produtos, causando uma negação de serviço ou tornando o sistema indisponível para os gestores legítimos.

## Contramedidas e Mitigação

| Tipo de Ameaça                                                | Técnicas de Mitigação                                                                                                                         | Critério de ameaça  |
|---------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| Inserção de produtos com informações falsas                   | 1. Implementar validações rigorosas dos dados de entrada para garantir que apenas informações válidas e legítimas sejam aceites.              | Totalmente Mitigada |
|                                                               | 2. Realizar revisões e aprovações dos produtos criados por gestores/administradores antes de serem publicados no catálogo.                    | Totalmente Mitigada |
| Sobrecarga do sistema com pedidos maliciosos                  | 1. Implementar rate limiting ou throttling para limitar o número de pedidos de criação de produtos por utilizador.                            | Totalmente Mitigada |
|                                                               | 2. Utilizar serviços de monitorização e alerta para detetar e mitigar tentativas de sobrecarga ou ataques de negação de serviço.              | Totalmente Mitigada |

## Threat Tree

![US10ThreatTree.svg](US10ThreatTree.svg)
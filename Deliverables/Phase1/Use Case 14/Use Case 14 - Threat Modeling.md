# Threat Modeling para "Gestão de Contas de Utilizador e Permissões"

## Descrição do Caso de Uso

```
As an Admin
I want to manage user accounts and permissions
So that I can control access to sensitive information and functionalities within the website.
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

- **(Spoofing)** Administradores mal-intencionados tentam obter acesso a funcionalidades de gestão de contas e permissões utilizando credenciais de outros utilizadores.
- **(Tampering)** Administradores podem alterar informações de utilizadores para os prejudicar ou para benefício próprio.
- **(Information Disclosure)** Exposição não autorizada de informações de utilizadores, como endereço de e-mail, nome completo, e outras informações pessoais.
- **(Denial of Service)** Administradores mal-intencionados eliminam contas de utilizadores ou alteram permissões para negar o acesso a funcionalidades ou informações, causando uma negação de serviço.
- **(Elevation of Privilege)** Administradores com acesso privilegiado alteram as suas próprias permissões ou as de outros utilizadores para obter acesso a funcionalidades ou informações restritas.

### Casos de Uso e Abuso

**Casos de Uso:**

- **Gerir Contas de Utilizador:** O administrador cria, atualiza ou remove contas de utilizador, definindo informações como nome, e-mail, e papel.
- **Gerir Permissões de Utilizador:** O administrador define e atualiza as permissões de acesso para diferentes utilizadores, determinando quais funcionalidades e informações cada um pode aceder.

**Abusos:**

- **Exposição de Informações Sensíveis:** Um administrador pode alterar e expor informações sensíveis de utilizadores.
- **Elevação de Privilégios:** Um administrador pode alterar as suas próprias permissões ou as de outros utilizadores para obterem acesso indevido a funcionalidades ou informações restritas.
- **Negar Acesso de Utilizadores:** Um administrador pode eliminar contas de utilizadores ou alterar as suas permissões para negar o acesso a funcionalidades ou informações.
- **Spoofing de Credenciais de Utilizadores:** Um administrador pode utilizar credenciais de outros utilizadores para aceder fazer login em nome deles, roubando-lhes a sua conta.

## Contramedidas e Mitigação

| Tipo de Ameaça                          | Técnicas de Mitigação                                                                                                                                                      | Critério de ameaça    |
|-----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------|
| Exposição de Informações Sensíveis      | 1. Aplicar princípios de mínimo privilégio, garantindo que apenas as permissões necessárias são concedidas aos administradores.                                            | Totalmente Mitigada   |
|                                         | 2. Utilizar encriptação para proteger dados sensíveis armazenados ou em trânsito.                                                                                          | Totalmente Mitigada   |
| Elevação de Privilégios                 | 1. Implementar controlos rigorosos de acesso baseados em função (RBAC) para garantir que os administradores só possam alterar permissões dentro dos limites estabelecidos. | Parcialmente Mitigada |
|                                         | 2. Realizar revisões periódicas das permissões de administrador para identificar e corrigir potenciais elevações de privilégios.                                           | Parcialmente Mitigada |
| Negar Acesso de Utilizadores            | 1. Implementar backups regulares e procedimentos de recuperação para restaurar contas e permissões em caso de alterações maliciosas.                                       | Parcialmente Mitigada |
|                                         | 2. Estabelecer políticas claras e procedimentos de revisão para assegurar que as alterações de permissões sejam justificadas e documentadas.                               | Parcialmente Mitigada |
| Spoofing de Credenciais de Utilizadores | 1. Implementar autenticação multifatorial para evitar o uso indevido de credenciais de outros utilizadores.                                                                | Totalmente Mitigada   |

## Threat Tree

![US14ThreatTree.svg](US14ThreatTree.svg)
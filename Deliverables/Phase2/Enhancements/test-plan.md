# Plano de testes para a aplicação Keyist

## 1. Introdução

### 1.1 Propósito

O objetivo deste documento é definir um plano de testes que nos permita validar que os casos de abuso identificados para cada caso de uso na fase de análise foram total ou parcialmente mitigados.

Primeiramente vamos enunciar quais os itens de teste seguida da abordagem a ser reallizada para validar se os casos de abuso foram mitigados com sucesso.
## 2. Itens de teste

### 2.1 Casos de uso a serem testados

- [Caso de Uso 3 - Threat Modeling.md](..%2F..%2FPhase1%2FUse%20Case%203%2FUse%20Case%203%20-%20Threat%20Modeling.md)
- [Caso de Uso 5 - Threat Modeling.md](..%2F..%2FPhase1%2FUse%20Case%205%2FUse%20Case%205%20-%20Threat%20Modeling.md)
- [Caso de Uso 7 - Threat Modeling.md](..%2F..%2FPhase1%2FUse%20Case%207%2FUse%20Case%207%20-%20Threat%20Modeling.md)
- [Caso de Uso 8 - Threat Modeling.md](..%2F..%2FPhase1%2FUse%20Case%208%2FUse%20Case%208%20-%20Threat%20Modeling.md)
- [Caso de Uso 9 - Threat Modeling.md](..%2F..%2FPhase1%2FUse%20Case%209%2FUse%20Case%209%20-%20Threat%20Modeling.md)
- [Caso de Uso 10 - Threat Modeling.md](..%2F..%2FPhase1%2FUse%20Case%2010%2FUse%20Case%2010%20-%20Threat%20Modeling.md)
- [Caso de Uso 14 - Threat Modeling.md](..%2F..%2FPhase1%2FUse%20Case%2014%2FUse%20Case%2014%20-%20Threat%20Modeling.md)

## 3. Plano de testes

### 3.1 Caso de Uso 3

**Pré-Condições:** Sistema iniciado e autenticado no sistema

**Passos:**
1. Aceder à página de listagem de produtos
2. Inserir o script malicioso no campo de pesquisa
3. Submeter a pesquisa

**Resultado esperado:** O sistema deteta um script malicioso e não executa a pesquisa

### 3.2 Caso de Uso 5

**Pré-Condições:** Sistema iniciado e autenticado no sistema

**Passos:**
1. Aceder aos detalhes pessoais do utilizador
2. Inserir o script malicioso no campo de informação a ser alterado
3. Submeter alterações

**Resultado esperado:** O sistema deteta um script malicioso e não executa o pedido de alteração

### 3.3 Caso de Uso 7

**Pré-Condições:** Sistema iniciado

**Passos:**
1. Aceder à página de criação de conta 
2. Inserir o script malicioso no campo do email ou password
3. Submeter criação de conta

**Resultado esperado:** O sistema deteta um script malicioso e não executa o pedido de criação de conta


**Pré-Condições:** Sistema iniciado

**Passos:**
1. Aceder à página de criação de conta
2. Enviar mais de 30 pedidos de criação de conta (posts)

**Resultado esperado:** O sistema deteta um elevado(>30) número de pedidos do mesmo host e recusa-os

### 3.4 Caso de Uso 8

**Pré-Condições:** Sistema iniciado

**Passos:**
1. Aceder à página de iniciar sessão
2. Inserir o script malicioso no campo do email ou palavra passe
3. Submeter início de sessão

**Resultado esperado:** O sistema deteta um script malicioso e não executa o pedido de início de sessão


**Pré-Condições:** Sistema iniciado

**Passos:**
1. Aceder à página de início de sessão
2. Tentar iniciar sessão mais de 5 vezes para o mesmo email

**Resultado esperado:** O sistema deteta um elevado número (>5) de pedidos de início de sessão para o mesmo email e recusa-os

### 3.5 Caso de Uso 9

**Pré-Condições:** Sistema iniciado

**Passos:**
1. Aceder à página de iniciar sessão
2. Pedir para alterar a palavra passe
3. Inserir o script malicioso no campo da nova palavra passe
4. Submeter alteração

**Resultado esperado:** O sistema deteta um script malicioso e não executa o pedido de alteração de palavra passe


**Pré-Condições:** Sistema iniciado

**Passos:**
1. Aceder à página de iniciar sessão
2. Pedir para alterar a palavra passe
3. Tentar alterar a palavra passe mais de 5 vezes para o mesmo email

**Resultado esperado:** O sistema deteta um elevado número (>5) de pedidos de alteração da palavra passe para o mesmo email e recusa-os

### 3.6 Caso de Uso 10

**Pré-Condições:** Sistema iniciado e autenticado no sistema como administrador

**Passos:**
1. Aceder à página de criar produtos
2. Enviar pedido de criação de mais de 10 produtos num espaço de 10 segundos

**Resultado esperado:** O sistema deteta um elevado número (>10) de pedidos de criação de produtos num curto espaço de tempo (10 segundos) e recusa-os

### 3.7 Caso de Uso 14

Todos os casos de abuso identificados para este caso de uso são consequências de ataques **Man-in-the-Middle** motivo pelo qual a equipa não conseguiu identificar testes que permitissem validar a mitigação deste caso de abuso.


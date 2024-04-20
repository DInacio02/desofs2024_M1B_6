# Modelo de Ameaças

## Decomposição do Sistema

### Dependências Externas

Na tabela que se segue, são apresentadas todas as dependências externas que poderão ser  utilizadas como pontos de ataque. A sua identificação será feita com recurso a:

1. ID - Um identificador único para cada dependência
2. Descrição - Explicação da dependência

| ID | Descrição |
|----|-----------|
| 1  |           |
| 2  |           |

### Pontos de Entrada

Os pontos de entrada representam interfaces com que os atacantes poderão interagir de forma a atacar a aplicação. Na table seguinte, são apresentados os pontos de entrada do sistema em estudo, organizando a informação destes da seguinte forma:

1. ID - Um identificador único para cada ponto de entrada
2. Nome - Um nome que identifica o ponto de entrada
3. Descrição - Descrição que fornece alguns detalhes sobre o ponto de entrada
4. Nivel de Confiança - Nível de acesso necessário para cada ponto de entrada

| ID | Nome | Descrição | Nível de Confiança |
|----|------|-----------|--------------------|
| 1  |      |           |                    |
| 2  |      |           |                    |

### Ativos

Na tabela seguinte são apresentados todos os ativos que foram possíveis identificar como fontes de interesse no caso de um ataque. Estes ativos podem ser tanto fisicos como abstratos e a sua informação está organizada da seguinte forma:

1. ID - Um identificador único para cada ativo
2. Nome - Um nome que identificada cada ativo
3. Descrição - Descrição que fornece alguns detalhes sobre o ativo e o porquê de ser importante a proteção deste.
4. Nível de Confiança - Nível de acesso necessário para o ativo

| ID    | Nome                                | Descrição                                                                                                                                                                                                   | Níveis de Confiança                                                                                                                         |
|-------|-------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| **1** | **Utilizadores**                    | **Ativos relacionados com os utilizadores.**                                                                                                                                                                |                                                                                                                                             |
| 1.1   | Dados de login dos utilizadores     | As credenciais de início de sessão que um cliente utilizará para entrar no website.                                                                                                                         | Utilizador com Credenciais Válidas (2) <br> Cliente (4) <br> Manager (5) <br> Administrador do Sistema (6) <br> Processo de Serviço Web (7) |
| 1.2   | Informações pessoais                | Dados pessoais dos utilizadores.                                                                                                                                                                            | Administrador do Sistema (6) <br> Processo de Serviço Web (7)                                                                               |
| **2** | **Sistema**                         | **Activos relacionados com o sistema subjacente.**                                                                                                                                                          |                                                                                                                                             |
| 2.1   | Disponibilidade do website          | O website deve estar disponível 24 horas por dia e pode ser acedido pelos clientes.                                                                                                                         | Administrador do Sistema (6)                                                                                                                |
| 2.2   | Capacidade de execução de código    | Esta é a capacidade de executar código fonte no servidor web.                                                                                                                                               | Administrador do Sistema (6) <br> Processo de Serviço Web (7)                                                                               |
| 2.3   | Capacidade de execução de SQL       | Esta é a capacidade de executar consultas SQL. <br> Selecionar, inserir e atualizar consultas na base de dados e, assim, ter acesso de leitura e escrita a qualquer informação armazenada na base de dados. | Administrador do Sistema (6)                                                                                                                |
| **3** | **Website**                         | **Ativos relacionados com website.**                                                                                                                                                                        |                                                                                                                                             |
| 3.1   | Sessão                              | Esta é a sessão de um utilizador no website. Este utilizador pode ser um cliente, um manager ou um admin.                                                                                                   | Cliente (4) <br> Manager (5) <br> Administrador do Sistema (6)                                                                              |
| 3.2   | Acesso ao servidor de base de dados | O acesso ao servidor da base de dados permite-lhe administrar a base de dados, tendo acesso total aos utilizadores da base de dados e a todos os dados nela contidos.                                       | Administrador do Sistema (6)                                                                                                                |
| 3.3   | Capacidade de criar produtos        | A capacidade de criar novos produtos no sistema.                                                                                                                                                            | Manager (5) <br> Administrador do Sistema (6)                                                                                               |
| 3.4   | Capacidade de criar utilizadores    | A capacidade de criar novos utilizadores no sistema.                                                                                                                                                        | Administrador do Sistema (6)                                                                                                                |


### Níveis de Confiança

Os níveis de confiança representam os tipos de acesso ao sistema que diferentas entidades externas podem ter, definindo privilégios e direitos de acesso necessários para cada ativo. Os níveis de confiança serão apresentados segundos os seguintes parâmetros:

1. ID - Identificador único para cada nível de confiança.
2. Nome - Nome descritivo para identificar cada nível de confiança.
3. Descrição - Descrição acerca da entidade a quem o nível é concedido.

| ID | Nome                                 | Descrição                                                                                                                             |
|----|--------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| 1  | Utilizador anónimo                   | Utilizador que interage com o sistema mas nao forneceu credenciais de login                                                           |
| 2  | Utilizador com credenciais válidas   | Utilizador que interage e se conecta com o sistema após um login com sucesso                                                          |
| 3  | Utilizador com credenciais inválidas | Utilizador que interage com o sistema e tenta se conectar com o mesmo mas não fornece credenciais válidas                             |
| 4  | Cliente                              | O cliente que possui permissões para procurar/comprar produtos e fazer encomendas                                                     |
| 5  | Manager                              | O manager que possui permissões especificas para adicionar criar/remover produtos e promoçoes tal como ver todas as vendas do sistema |
| 6  | Administrador do sistema             | O administrador que possui permissões para qualquer tipo de operação no sistema                                                       |
| 7  | Processo de serviço web              | O processo de serviço web que tem acesso a todas as componentes do sistema                                                            |


## Data Flow

Nesta secção, é apresentado o Data Flow Diagram que explica como os dados são transmitidos pelos diferentes componentes do sistema.

![DataFlowDiagram.png](../Design/DataFlowDiagram.png)

Assim sendo, tal como é possível observar existem 5 componentes no sistema: o Client Server, o Resource Server, o Authentication Server, a base de dados (SQL Server) e o sistema de gestão de ficheiros (File API).
Adicionalmente é possível identificar que os diferentes utilizadores fazem pedidos ao Client Server que por sua vez irá fazer pedidos ao Authentication Server e ao Resource Server que se necessário irão fazer pedidos ao SQL Server para armazenamento de dados ou no caso do Resource Server à File API para gestão de ficheiros.
Cada um destes por sua vez irá enviar resposta a cada componente que fez o pedido, ou seja, o SQL Server irá responder ao Authentication Sercer e ao Resource Server, a File API ao Resource Server, o Resource Server e o Authentication Server ao Client Server que por fim devolverá a resposta ao cliente.

## Determinação de Ameaças

Nesta secção será apresentada como a determinação de ameaças foi realizada.

### Ranking de Ameaças e Modelo de Risco Qualitativo
# Modelo de Ameaças

## Decomposição do Sistema

### Dependências Externas

Na tabela que se segue, são apresentadas todas as dependências externas que poderão ser utilizadas como pontos de ataque. A sua identificação será feita com recurso a:

1. ID - Um identificador único para cada dependência
2. Descrição - Explicação da dependência

| ID | Descrição                                                                                                                                                                                                                                                                        |
|----|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | A aplicação será executada em servidores baseados na Cloud, pelo que se perderá o controlo global sobre a segurança do sistema operativo e da aplicação. Por conseguinte, o serviço baseado na Cloud escolhido deve ser fiável, a fim de satisfazer as necessidades dos clientes |
| 2  | A ligação entre os servidores de resources, de autorização e da base de dados deve ser efectuada através de uma rede privada                                                                                                                                                     |
| 3  | A comunicação entre o cliente e o backend deve utilizar certificados TLS/SSL                                                                                                                                                                                                     |

### Pontos de Entrada

Os pontos de entrada representam interfaces com que os atacantes poderão interagir de forma a atacar a aplicação. Na tabela seguinte, são apresentados os pontos de entrada do sistema em estudo, organizando a informação destes da seguinte forma:

1. ID - Um identificador único para cada ponto de entrada
2. Nome - Um nome que identifica o ponto de entrada
3. Descrição - Descrição que fornece alguns detalhes sobre o ponto de entrada
4. Nivel de Confiança - Nível de acesso necessário para cada ponto de entrada

| ID    | Nome                                  | Descrição                                                                                                           | Nível de Confiança                                                                                                                                                        |
|-------|---------------------------------------|---------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1     | Porta HTTPS                           | A aplicação só pode ser acessada via HTTPS. Todas as páginas da aplicação estão disponíveis neste ponto de entrada. | (1) Utilizador anónimo da Web <br> (2) Utilizador com credenciais de login válidas <br> (3) Utilizador com credenciais de login inválidas                                 |
| 1.1   | Página principal                      | A página inicial da aplicação é o ponto de entrada principal para todos os utilizador.                              | (1) Utilizador anónimo da Web <br> (2) Utilizador com credenciais de login válidas <br> (3) Utilizador com credenciais de login inválidas <br> (4) Manager <br> (5) Admin |
| 1.2   | Página de Login                       | Utilizadores devem fazer login antes de realizar qualquer ação na aplicação.                                        | (1) Utilizador anónimo da Web <br> (2) Utilizador com credenciais de login <br> (3) Utilizador com credenciais de login inválidas <br> (4) Manager <br> (5) Admin         |
| 1.2.1 | Função de Login                       | A função de login valida as credenciais do utilizador comparando com os dados na base de dados.                     | (2) Utilizador com credenciais de login válidas <br> (3) Utilizador com credenciais de login inválidas <br> (4) Manager <br> (5) Admin                                    |
| 1.2.2 | Função de Pedido de Reset de Password | Função para solicitar um token de redefinição de password em caso de esquecimento.                                  | (1) Utilizador anônimo da Web <br> (2) Utilizador com credenciais de login válidas                                                                                        |
| 1.3   | Página de Registo                     | Utilizadores devem fazer registo antes de realizar qualquer ação na aplicação.                                      | (1) Utilizador anónimo da Web <br> (2) Utilizador com credenciais de login <br> (3) Utilizador com credenciais de login inválidas <br> (4) Manager <br> (5) Admin         |
| 1.3.1 | Função de Registo                     | A função de registo permite que novos utilizadores criem uma conta na aplicação.                                    | (1) Utilizador anônimo da Web <br> (2) Utilizador com credenciais de login válidas <br> (3) Utilizador com credenciais de login inválidas <br> (4) Manager <br> (5) Admin |
| 1.4   | Página com Dados Pessoais             | Página onde os utilizadores podem visualizar e editar os seus dados pessoais.                                       | (2) Utilizador com credenciais de login válidas <br> (4) Manager <br> (5) Admin                                                                                           |
| 1.5   | Página de Catálogo                    | Página usada para inserir consultas de pesquisa de produtos.                                                        | (2) Utilizador com credenciais de login válidas <br> (4) Manager <br> (5) Admin                                                                                           |
| 1.6   | Página de Carrinho                    | Página onde é possível visualizar e editar o carrinho.                                                              | (2) Utilizador com credenciais de login válidas                                                                                                                           |
| 1.6.1 | Função de Cupons/Descontos            | Função que permite aplicar cupons ou descontos durante a compra.                                                    | (2) Utilizador com credenciais de login válidas                                                                                                                           |
| 1.7   | Página de Gestão Produtos             | Página onde é possível adicionar, remover ou atualizar produtos no catálogo.                                        | (4) Manager <br> (5) Admin                                                                                                                                                |
| 1.8   | Página de Gestão Utilizadores         | Página onde é possível gerir contas de utilizadores, incluindo permissões e informações.                            | (5) Admin                                                                                                                                                                 |

### Pontos de Saída

Os pontos de saída podem ser úteis ao atacar o cliente: por exemplo, vulnerabilidades de script entre sites e vulnerabilidades de divulgação de informações exigem um ponto de saída para que o ataque seja concluído. Na table seguinte, são apresentados os pontos de entrada do sistema em estudo, organizando a informação destes da seguinte forma:

1. ID - Um identificador único para cada ponto de entrada
2. Nome - Um nome que identifica o ponto de entrada
3. Descrição - Descrição que fornece alguns detalhes sobre o ponto de entrada
4. Nivel de Confiança - Nível de acesso necessário para cada ponto de entrada

| ID | Nome                                      | Descrição                                                                                                                                            | Nível de Confiança                                                                                                                                                               |
|----|-------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1  | Mensagens de Erro                         | Mensagens de erro que podem revelar informações sensíveis ou auxiliar ataques de coleta de conta (por exemplo, "nome de utilizador não encontrado"). | (1) Utilizador anónimo da Web <br> (2) Utilizador com credenciais de login válidas <br> (3) Utilizador com credenciais de login inválidas <br> (4) Gestor <br> (5) Administrador |
| 2  | Email de Token de Recuperação de Password | Solicitações de tokens para recuperação de password, que podem ser usadas para alterar a password do utilizador.                                     | (1) Utilizador anónimo da Web <br> (2) Utilizador com credenciais de login válidas <br> (3) Utilizador com credenciais de login inválidas <br> (4) Gestor <br> (5) Administrador |
| 3  | Informações do Carrinho                   | Informações sobre o conteúdo do carrinho de compras, que podem revelar preferências ou interesses do utilizador.                                     | (2) Utilizador com credenciais de login válidas                                                                                                                                  |
| 4  | Dados Pessoais                            | Dados pessoais do utilizador, incluindo nome, morada, email, etc.                                                                                    | (1) Utilizador anónimo da Web <br> (2) Utilizador com credenciais de login válidas <br> (3) Utilizador com credenciais de login inválidas <br> (4) Gestor <br> (5) Administrador |
| 5  | Histórico de Compras                      | Informações sobre compras anteriores, incluindo produtos adquiridos e datas de compra.                                                               | (2) Utilizador com credenciais de login válidas                                                                                                                                  |
| 6  | Dados de Pagamento                        | Informações de cartões de crédito, contas bancárias ou outros métodos de pagamento.                                                                  | (2) Utilizador com credenciais de login válidas                                                                                                                                  |
| 7  | Dados de Outros Utilizadores              | Dados pessoais de outros utilizadores, como nome, email, morada, etc.                                                                                | (5) Administrador                                                                                                                                                                |
| 8  | Logs e Registos                           | Registos de atividades, que podem incluir informações sobre ações realizadas pelos utilizadores ou pelo sistema.                                     | (5) Administrador                                                                                                                                                                |
| 9  | Configurações Globais da Aplicação        | Configurações globais da aplicação, que podem afetar o comportamento e segurança do sistema.                                                         | (5) Administrador                                                                                                                                                                |


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

![Use Case Diagram - Desofs.svg](..%2FAnalysis%20and%20Requirements%2FUse%20Case%20Diagram%20-%20Desofs.svg)

Os casos de uso a vermelho são os casos de uso com riscos associados, e a sua análise foi feita através mnemônica STRIDE
e foram desenvolvidos relatórios individuais para cada caso de uso.

### Lista de Ameaças STRIDE

<br>

| Tipo                   | Descrição                                                                                                                 | Controlo de Segurança |
|------------------------|---------------------------------------------------------------------------------------------------------------------------|-----------------------|
| Spoofing               | Ação de ameaça destinada a aceder e usar credenciais de outro utilizador, como nome de utilizador e palavra-passe.        | Autenticação          |
| Tampering              | Ação de ameaça com a intenção de alterar ou modificar maliciosamente dados persistentes.                                  | Integridade           |
| Repudiation            | Ação de ameaça destinada a realizar operações proibidas num sistema que não possui a capacidade de rastrear as operações. | Não Repúdio           |
| Information Disclosure | Ação de ameaça com a intenção de ler um ficheiro ao qual não foi concedido acesso, ou ler dados em trânsito.              | Confidencialidade     |
| Denial of Service      | Ação de ameaça que tenta negar acesso a utilizadores válidos.                                                             | Disponibilidade       |
| Elevation of Privilege | Ação de ameaça com a intenção de obter acesso privilegiado a recursos.                                                    | Autorização           |

<br>

- [Caso de uso 3 - Threat Modeling](..%2FUse%20Case%203%2FUse%20Case%203%20-%20Threat%20Modeling.md)
- [Caso de uso 5 - Threat Modeling](..%2FUse%20Case%205%2FUse%20Case%205%20-%20Threat%20Modeling.md)
- [Caso de uso 7 - Threat Modeling](..%2FUse%20Case%207%2FUse%20Case%207%20-%20Threat%20Modeling.md)
- [Caso de uso 8 - Threat Modeling](..%2FUse%20Case%208%2FUse%20Case%208%20-%20Threat%20Modeling.md)
- [Caso de uso 9 - Threat Modeling](..%2FUse%20Case%209%2FUse%20Case%209%20-%20Threat%20Modeling.md)
- [Use Case 10 - Threat Modeling.md](..%2FUse%20Case%2010%2FUse%20Case%2010%20-%20Threat%20Modeling.md)
- [Use Case 14 - Threat Modeling.md](..%2FUse%20Case%2014%2FUse%20Case%2014%20-%20Threat%20Modeling.md)

### Ranking de Ameaças e Modelo de Risco Qualitativo

<br>

| Ameaça                                              | Nível de Risco |
|-----------------------------------------------------|----------------|
| Sobrecarga do sistema com solicitações maliciosas   | Alto           |
| Injeção de código SQL na barra de pesquisa          | Alto           |
| Inserção de scripts maliciosos na barra de pesquisa | Alto           |
| Elevação de privilégios                             | Alto           |
| Acesso a permissões de administrador                | Alto           |
| Acesso a dados privados do utilizador               | Médio          |
| Negar acesso de utilizadores                        | Médio          |
| Inserção de produtos com informações falsas         | Baixo          |
| Phishing                                            | Baixo          |

<sup>Para maiores detalhes sobre cada ameaça, consultar os documentos de análise individual de cada caso de uso</sup>


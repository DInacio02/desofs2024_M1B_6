# Pipeline

Na continuação do processo de SSDLC, após as fases de análise e design, é crucial criar uma pipeline que assegure a possibilidade de construir, testar e implementar a aplicação de maneira contínua e automatizada. Através desta pipeline, podemos verificar, a cada nova implementação no processo de desenvolvimento, se a aplicação permanece íntegra, funcional, testada e pronta para ser implantada. Esta prática não só melhora a eficiência do desenvolvimento como também garante a qualidade e a estabilidade do software.

## Build

A fase de build na nossa pipeline é responsável por compilar os diferentes componentes do projeto, garantindo que todos os artefatos necessários são gerados corretamente. Especificamente, a pipeline executa os seguintes passos:

1. **Checkout do código:** Clona o repositório para a máquina de build.
2. **Configuração do JDK:** Configura o JDK 1.11 para compilar os servidores.
3. **Build dos Servidores:** Utiliza o Maven para construir os artefatos do Resource Server e do Authorization Server.
4. **Configuração do Node.js:** Configura o Node.js na versão 18.20.2 para preparar o ambiente do frontend.
5. **Instalação de dependências:** Instala todas as dependências necessárias do projeto frontend usando npm.
6. **Build do Frontend:** Compila o frontend utilizando o Angular, garantindo que a aplicação cliente está pronta para ser deployada.
7. **Upload dos Artefatos:** Faz o upload dos artefatos gerados (JARs dos servidores e arquivos do frontend) para serem utilizados nas fases subsequentes da pipeline.

## Tests

A fase de testes é essencial para garantir que as mudanças introduzidas não quebram funcionalidades existentes e que a aplicação se comporta conforme o esperado. Nesta pipeline, são executados os seguintes passos:

1. **Checkout do código:** Clona o repositório para a máquina de testes.
2. **Configuração do JDK:** Configura o JDK 1.11 para executar os testes nos servidores.
3. **Configuração do Node.js:** Configura o Node.js na versão 18.20.2 para preparar o ambiente do frontend.
4. **Instalação de dependências:** Instala todas as dependências necessárias do projeto frontend usando npm.
5. **Execução do Linter:** Executa o linter no código do frontend para garantir a qualidade e conformidade do código com os padrões estabelecidos.
6. **Download dos Artefatos:** Baixa os artefatos gerados na fase de build para serem testados.
7. **Execução dos Testes Unitários e de Integração:** Utiliza o Maven para executar os testes unitários e de integração no Resource Server e no Authorization Server, garantindo que todas as funcionalidades estão operacionais e que os diferentes módulos da aplicação interagem corretamente entre si.

Esses testes abrangem uma ampla gama de cenários para assegurar que o software mantém sua integridade e funcionalidade ao longo do ciclo de desenvolvimento.


## Deployment

Por fim, mas também de grande importância um deploy automático das imagens construidas para o DockerHub de forma a garantir um controle de versões, segurança e acesso centralizado do software.
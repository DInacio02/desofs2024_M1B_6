# Pipeline

Na continuação do processo de SSDLC, após as fases de análise e design, é crucial criar uma pipeline que assegure a possibilidade de construir, testar e implementar a aplicação de maneira contínua e automatizada. Através desta pipeline, podemos verificar, a cada nova implementação no processo de desenvolvimento, se a aplicação permanece íntegra, funcional, testada e pronta para ser colocada em produção. Esta prática não só melhora a eficiência do desenvolvimento como também garante a qualidade e a estabilidade do software.

## Build

A fase de build na nossa pipeline é responsável por compilar os diferentes componentes do projeto, garantindo que todos os artefactos necessários são gerados corretamente. Especificamente, a pipeline executa os seguintes passos:

1. **Checkout do código:** Clona o repositório para a máquina de build.
2. **Configuração do JDK:** Configura o JDK 1.11 para compilar os servidores.
3. **Build dos Servidores:** Utiliza o Maven para construir os artefactos do Resource Server e do Authorization Server.
4. **Configuração do Node.js:** Configura o Node.js na versão 18.20.2 para preparar o ambiente do frontend.
5. **Instalação de dependências:** Instala todas as dependências necessárias do projeto frontend usando npm.
6. **Build do Frontend:** Compila o frontend utilizando o Angular, garantindo que a aplicação cliente está pronta para ser colocada em produção.
7. **Upload dos Artefactos:** Faz o upload dos artefactos gerados (JARs dos servidores e arquivos do frontend) para serem utilizados nas fases subsequentes da pipeline.

## Tests

A fase de testes é essencial para garantir que as mudanças introduzidas não quebram funcionalidades existentes e que a aplicação se comporta conforme o esperado. Nesta pipeline, são executados os seguintes passos:

1. **Checkout do código:** Clona o repositório para a máquina de testes.
2. **Configuração do JDK:** Configura o JDK 1.11 para executar os testes nos servidores.
3. **Configuração do Node.js:** Configura o Node.js na versão 18.20.2 para preparar o ambiente do frontend.
4. **Cache dos módulos do Node.js:** Utiliza caching para acelerar a instalação de dependências.
5. **Instalação de dependências:** Instala todas as dependências necessárias do projeto frontend usando npm e o Angular CLI globalmente.
6. **Instalação do Chrome:** Instala o navegador Chrome para execução dos testes no frontend.
7. **Execução do Linter:** Executa o linter no código do frontend para garantir a qualidade e conformidade do código com os padrões estabelecidos.
8. **Download dos Artefactos:** Baixa os artefactos gerados na fase de build para serem testados.
9. **Execução dos Testes Unitários e de Integração nos Servidores:** Utiliza o Maven para executar os testes unitários e de integração no Resource Server e no Authorization Server.
10. **Execução dos Testes no Frontend:** Utiliza o Chrome Headless para rodar os testes no frontend, assegurando que todas as funcionalidades estão operacionais.
11. **Upload dos Resultados dos Testes:** Faz o upload dos resultados dos testes para posterior análise.

Esta abordagem garante uma cobertura ampla e efetiva dos cenários de uso da aplicação, assegurando que o software mantém a sua integridade e funcionalidade ao longo do ciclo de desenvolvimento.

## Deploy

A fase de deploy é responsável por colocar a aplicação em produção, garantindo que todas as alterações passaram pelas fases de build e testes com sucesso. Especificamente, a pipeline executa os seguintes passos:

1. **Checkout do código:** Clona o repositório para a máquina de deploy.
2. **Download dos Artefactos:** Baixa os artefactos gerados na fase de build (servidores e frontend) para a máquina de deploy.
3. **Build das Imagens Docker:** Constrói as imagens Docker para os servidores e o frontend utilizando os Dockerfiles correspondentes.
4. **Criação de Tags Docker:** Cria tags para as imagens Docker construídas, preparando-as para envio ao repositório Docker.
5. **Login no DockerHub:** Faz login no DockerHub utilizando credenciais seguras armazenadas nos secrets do GitHub.
6. **Push das Imagens Docker:** Envia as imagens Docker para o repositório Docker, tornando-as disponíveis para deploy em ambientes de produção.

Esta fase garante que a aplicação está pronta para ser colocada em produção, com todas as dependências corretamente configuradas e as últimas alterações devidamente integradas.

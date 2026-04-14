# 🚀 Automação do Zero

Projeto para iniciantes aprenderem automação de testes.

## 📚 Etapas

1. [Setup](./01-setup/README.md)  
2. [Git e GitHub](./02-git-github/README.md)  
3. [Java API](./03-java-api/README.md)  
4. [Java Web](./04-java-web/README.md)  
5. [Cypress API](./05-cypress-api/README.md)  
6. [Cypress Web](./06-cypress-web/README.md)

## 🛠️ Configuração do Ambiente

### Pré-requisitos

- **Java JDK 17 ou superior**: Baixe e instale o JDK do [Eclipse Adoptium](https://adoptium.net/) ou [OpenJDK](https://openjdk.java.net/).
- **Apache Maven 3.9+**: Baixe e instale o Maven do [site oficial](https://maven.apache.org/download.cgi).

### Configuração no Windows

1. **Instalar JDK**:
   - Baixe o JDK 17+ (ex: `jdk-17.x.x`) e extraia para `C:\Program Files\Java\` ou similar.
   - Adicione ao PATH: `C:\Program Files\Java\jdk-17.x.x\bin`

2. **Instalar Maven**:
   - Baixe o Maven (ex: `apache-maven-3.9.x-bin.zip`) e extraia para `C:\maven\` ou similar.
   - Adicione ao PATH: `C:\maven\apache-maven-3.9.x\bin`

3. **Configurar variáveis de ambiente**:
   - Defina `JAVA_HOME` como o caminho do JDK (ex: `C:\Program Files\Java\jdk-17.x.x`).
   - Defina `MAVEN_HOME` como o caminho do Maven (ex: `C:\maven\apache-maven-3.9.x`).
   - Reinicie o terminal ou execute `source ~/.bashrc` (se configurado).

4. **Para Git Bash (MINGW64)**:
   - Edite `~/.bashrc` e adicione:
     ```
     export JAVA_HOME=/c/Program\ Files/Java/jdk-17.x.x
     export PATH=$PATH:$JAVA_HOME/bin
     export PATH=$PATH:/c/maven/apache-maven-3.9.x/bin
     ```
   - Execute `source ~/.bashrc` para carregar.

### Verificação

- `java -version`: Deve mostrar JDK 17+.
- `javac -version`: Deve mostrar o compilador.
- `mvn -version`: Deve mostrar Maven 3.9+.

## 🔧 Executando os Testes

Cada etapa tem seu próprio `README.md` com instruções detalhadas de execução. Navegue para a pasta correspondente e siga as orientações lá.

Para um exemplo rápido:
- **Java Web**: `cd 04-java-web && mvn test`
- **Cypress API**: `cd 05-cypress-api && npm install && npm test`

Consulte os READMEs específicos para pré-requisitos e comandos completos.



Feito com ❤️ por [CodeFlow]



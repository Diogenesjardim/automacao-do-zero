# 🚀 Automação do Zero

Projeto para iniciantes aprenderem automação de testes.

## 📚 Etapas

1. Setup → /01-setup  
2. Git e GitHub → /02-git-github  
3. Java API → /03-java-api  
4. Java Web → /04-java-web  
5. Cypress API → /05-cypress-api  
6. Cypress Web → /06-cypress-web

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

### Java Web (/04-java-web)

1. Navegue para a pasta: `cd 04-java-web`
2. Execute: `mvn test`
   - O WebDriverManager baixará automaticamente o ChromeDriver.
   - O teste abrirá o Chrome e acessará https://example.com.

### Possíveis Erros e Correções

- **Erro: "mvn: command not found"**: Instale o Maven e adicione ao PATH.
- **Erro: "No compiler is provided"**: Configure o JAVA_HOME corretamente.
- **Erro: "TestEngine with ID 'junit-jupiter' failed to discover tests"**: Certifique-se de que a classe de teste está em um pacote (ex: `com.estudo`).
- **Erro: "class file version"**: Use JDK 17+ e configure o pom.xml com `<maven.compiler.source>17</maven.compiler.source>`.
- **Erro: ChromeDriver não encontrado**: O WebDriverManager cuida disso; certifique-se de que o Chrome está instalado.

### Dependências do Projeto

- Selenium WebDriver 4.18.1
- JUnit 5.9.2
- WebDriverManager 5.6.2

Para mais detalhes, consulte o `pom.xml` em cada módulo.


Feito com ❤️ por [CodeFlow]
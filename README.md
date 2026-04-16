# 🚀 Automação do Zero

Projeto para iniciantes aprenderem automação de testes do zero, passando por Git, Java e Cypress.

---

## 📚 Etapas

| # | Etapa | Tecnologia | Descrição |
|---|-------|------------|-----------|
| 1 | [Setup](./01-setup/README.md) | — | Instalação do ambiente |
| 2 | [Git e GitHub](./02-git-github/README.md) | Git | Versionamento de código |
| 3 | [Java API](./03-java-api/README.md) | Java + Maven | Testes de API com Java |
| 4 | [Java Web](./04-java-web/README.md) | Java + Maven | Testes Web com Java |
| 5 | [Cypress API](./05-cypress-api/README.md) | JavaScript | Testes de API com Cypress |
| 6 | [Cypress Web](./06-cypress-web/README.md) | JavaScript | Testes E2E com Cypress |

---

## 🛠️ Pré-requisitos

### Java (Etapas 3 e 4)

- **Java JDK 17+** → [Eclipse Adoptium](https://adoptium.net/) ou [OpenJDK](https://openjdk.java.net/)
- **Apache Maven 3.9+** → [maven.apache.org](https://maven.apache.org/download.cgi)

Configuração no Windows (Git Bash):

```bash
# Adicione ao ~/.bashrc
export JAVA_HOME=/c/Program\ Files/Java/jdk-17.x.x
export PATH=$PATH:$JAVA_HOME/bin
export PATH=$PATH:/c/maven/apache-maven-3.9.x/bin
```

Verifique:

```bash
java -version   # JDK 17+
mvn -version    # Maven 3.9+
```

### JavaScript (Etapas 5 e 6)

- **Node.js 18+** → [nodejs.org](https://nodejs.org)
- **Git** → [git-scm.com](https://git-scm.com)

Verifique:

```bash
node -v
npm -v
```

---

## ▶️ Executando os Testes

### Java API

```bash
cd 03-java-api
mvn test
```

### Java Web

```bash
cd 04-java-web
mvn test
```

### Cypress API

```bash
cd 05-cypress-api
npm install
npm test
```

### Cypress Web

```bash
cd 06-cypress-web
npm install
npm test
```

---

## 📁 Estrutura do Projeto

```
automacao-do-zero/
├── 01-setup/          # Guia de instalação do ambiente
├── 02-git-github/     # Comandos Git e GitHub
├── 03-java-api/       # Testes de API com Java
├── 04-java-web/       # Testes Web com Java
├── 05-cypress-api/    # Testes de API com Cypress
└── 06-cypress-web/    # Testes E2E Web com Cypress
```

---

Feito com ❤️ por [CodeFlow](https://github.com/Diogenesjardim)

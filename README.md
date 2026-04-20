# 🚀 Automação do Zero — Java

Projeto para iniciantes aprenderem automação de testes com **Java**, cobrindo testes de API e testes Web com Page Object Model.

---

## 📚 Etapas

| # | Etapa | Tecnologia | Descrição |
|---|-------|------------|-----------|
| 1 | [Setup](./01-setup/README.md) | — | Instalação do ambiente |
| 2 | [Git e GitHub](./02-git-github/README.md) | Git | Versionamento de código |
| 3 | [Java API](./03-java-api/README.md) | Java + Maven | Testes de API com Java |
| 4 | [Java Web](./04-java-web/README.md) | Java + Maven + Selenium | Testes Web com Page Object Model |

---

## 🛠️ Pré-requisitos

- **Java JDK 17+** → [Eclipse Adoptium](https://adoptium.net/) ou [OpenJDK](https://openjdk.java.net/)
- **Apache Maven 3.9+** → [maven.apache.org](https://maven.apache.org/download.cgi)
- **Git** → [git-scm.com](https://git-scm.com)

### Configuração no Windows (Git Bash)

```bash
# Adicione ao ~/.bashrc
export JAVA_HOME=/c/Program\ Files/Java/jdk-17.x.x
export PATH=$PATH:$JAVA_HOME/bin
export PATH=$PATH:/c/maven/apache-maven-3.9.x/bin
```

```bash
source ~/.bashrc
```

### Verificação

```bash
java -version   # JDK 17+
mvn -version    # Maven 3.9+
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

### Gerar Allure Report (Java Web)

```bash
cd 04-java-web
mvn allure:report
```

O relatório será gerado em `target/site/allure-maven-plugin/index.html`.

---

## 📁 Estrutura do Projeto

```
automacao-do-zero/
├── 01-setup/          # Guia de instalação do ambiente
├── 02-git-github/     # Comandos Git e GitHub
├── 03-java-api/       # Testes de API com Java
└── 04-java-web/       # Testes Web com Java (Page Object Model)
```

---

Feito com ❤️ por [CodeFlow](https://github.com/Diogenesjardim)

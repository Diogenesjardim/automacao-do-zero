# 🚀 Automação do Zero

Projeto para iniciantes aprenderem automação de testes com **JavaScript e Cypress**.

---

## 📚 Etapas

| # | Etapa | Descrição |
|---|-------|-----------|
| 1 | [Setup](./01-setup/README.md) | Instalação do ambiente |
| 2 | [Git e GitHub](./02-git-github/README.md) | Versionamento de código |
| 3 | [Cypress API](./05-cypress-api/README.md) | Testes de API com Cypress |
| 4 | [Cypress Web](./06-cypress-web/README.md) | Testes E2E com Cypress |

---

## 🛠️ Pré-requisitos

Antes de começar, instale:

- **Node.js 18+** → [nodejs.org](https://nodejs.org)
- **Git** → [git-scm.com](https://git-scm.com)
- **VS Code** → [code.visualstudio.com](https://code.visualstudio.com)

Verifique as instalações:

```bash
node -v
npm -v
git --version
```

---

## ▶️ Executando os Testes

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
├── 05-cypress-api/    # Testes de API com Cypress
└── 06-cypress-web/    # Testes E2E Web com Cypress
```

---

## ✅ Status dos Testes

| Suite | Testes | Status |
|-------|--------|--------|
| Cypress API | Retorna 200 | ✅ Passando |
| Cypress Web | Abre o site e valida a página | ✅ Passando |

---

Feito com ❤️ por [CodeFlow](https://github.com/Diogenesjardim)

# Cypress Web

Projeto de testes web usando Cypress.

## Requisitos

- Node.js (recomendado 18+)
- npm

## Como configurar

1. Abra um terminal na pasta `06-cypress-web`
2. Inicialize o projeto (se ainda não tiver `package.json`):
   ```bash
   npm init -y
   ```
3. Instale o Cypress:
   ```bash
   npm install cypress --save-dev
   ```

## Como executar

- Para abrir a interface do Cypress:
  ```bash
  npx cypress open
  ```
- Para rodar os testes em modo headless:
  ```bash
  npx cypress run
  ```

## O que está aqui

- `cypress.config.js` — configuração do Cypress
- `cypress/e2e/teste.cy.js` — teste web

## Observações

- Se preferir, crie scripts no `package.json` para rodar `npx cypress open` e `npx cypress run` com comandos mais curtos.

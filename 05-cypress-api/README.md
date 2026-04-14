# Cypress API

Projeto de testes de API usando Cypress.

## Requisitos

- Node.js (recomendado 18+)
- npm

## Como executar

1. Abra um terminal na pasta `05-cypress-api`
2. Instale dependências:
   ```bash
   npm install
   ```
3. Para abrir o Cypress:
   ```bash
   npm run cypress:open
   ```
4. Para executar os testes em modo headless:
   ```bash
   npm test
   ```

## O que está aqui

- `package.json` — scripts e dependências
- `teste.cy.js` — teste de API

## Observações

- Use `npx cypress open` se quiser abrir a interface gráfica.
- Caso já tenha Cypress instalado globalmente, também é possível usar `cypress open`.

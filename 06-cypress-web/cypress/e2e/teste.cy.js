      // nome do teste
describe('Teste simples - Site', () => { 
  
      // cenário do teste
  it('Deve abrir o site e validar a página', () => { 

    // Abre o site
    cy.visit('https://codefloments.base44.app/')

    // Valida que existe um elemento na tela
    cy.get('body').should('be.visible')
    

  })

})
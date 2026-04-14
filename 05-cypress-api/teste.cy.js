describe('Teste API', () => {
  it('Retorna 200', () => {
    cy.request('https://jsonplaceholder.typicode.com/users')
      .then((res) => {
        expect(res.status).to.eq(200)
      })
  })
})
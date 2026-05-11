Feature: Página demo.nopcommerce.com

  Scenario: Abrir a página NopCommerce e validar conteúdo principal
    Given que acesso a pagina NopCommerce
    When aceito cookies se aparecer na NopCommerce
    Then devo ver o logo na pagina NopCommerce
    And devo ver o menu de navegacao na NopCommerce
    And o titulo da pagina NopCommerce deve estar preenchido

Feature: Página https://www.youtube.com/

  Scenario: Abrir a página YouTube e validar elementos principais
    Given que acesso a pagina YouTube
    When aceito cookies se aparecer no YouTube
    Then devo ver o logo no YouTube
    And devo ver o campo de busca no YouTube
    And o titulo da pagina YouTube deve estar preenchido


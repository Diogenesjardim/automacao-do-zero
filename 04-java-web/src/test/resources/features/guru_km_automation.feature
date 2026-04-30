Feature: Página de Knowledge Management Automation (Guru)

  Scenario: Abrir a página e validar conteúdo principal
    Given que acesso a pagina de KM Automation do Guru
    When aceito cookies se aparecer
    Then devo ver o conteudo principal da pagina
    And o titulo da pagina deve estar preenchido


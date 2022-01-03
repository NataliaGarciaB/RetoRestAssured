Feature: funciones get y delete
  como un usuario quiero hacer la petición de obtener datos de una persona que no existe
  y tambien quiero borrar un usuario

  Scenario: SINGLE USER NOT FOUND
    Given el usuario está en la página get
    When cuando el usuario hace una petición get
    Then el usuario deberá ver un mensaje con llaves vacias

  Scenario: DELETE
    Given el usuario está en la página delete
    When cuando el usuario hace una petición delete
    Then el usuario deberá ver un codigo de código de respuesta
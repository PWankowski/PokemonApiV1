Aplikacja komunikujaca się z serwisem zewnętrznym z którego pobiera informacje o Pokemonach znajdujacych się w bazie danych i po przefiltrowaniu otrzymanych danych zwraca informacje do uzytkownika na temat pokemonów. 
Zewnętrzny serwis: https://pokeapi.co/api/v2/pokemon?limit=100&offset=0 
Deployment na heroku:
Zapytanie po listę: https://pokemonapplication-v1.herokuapp.com/pokemon/list?limit=20&offset=0 
Zapytanie o detale wybranych pokemonów np: https://pokemonapplication-v1.herokuapp.com/pokemon?names=bulbasaur,pikachu
Dane przechowywane sa w bazie danych H2: http://localhost:8080/h2-console username=pokemon_user password=pokemon 
Część frontendowa w react, wyświetlanie listy pokemonow wraz z paginacją : https://pokemonapifrontendv1.herokuapp.com/


English version below:
Application to communicate with external service from which is getting information about pokemons from database, after filtering data, user receive answer about pokemons Externall service: https://pokeapi.co/api/v2/pokemon?limit=100&offset=0 
Deployment on heroku: 
List of Pokemons: https://pokemonapplication-v1.herokuapp.com/pokemon/list?limit=20&offset=0 
Pokemons details for selected pokemons names, example: https://pokemonapplication-v1.herokuapp.com/pokemon?names=bulbasaur,pikachu 
Data saving in data base H2: http://localhost:8080/h2-console username=pokemon_user password=pokemon 
Frontend in React, displaying pokemon list including pagination : https://pokemonapifrontendv1.herokuapp.com/




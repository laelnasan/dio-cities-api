# dio-cities-api
Projeto de estudo desenvolvido no bootcamp Java TQI da Digital Innovation One.

Minha primeira implementação de uma API REST em Java e com Spring. Tudo novo pra mim =P
Achei bem suave a introdução graças ao Spring Boot, mas mesmo assim me senti as vezes um
pouco perdido principalmente com conceitos da arquitetura REST que não estou muito 
familiarizado ainda. Achei interessante a abordagem de interfaceamento do ORM Hibernate.
Vou procurar entender como se dá esse interfaceamento em bancos não relacionais.

Minha primeira vez também com o Gradle, achei bem prático de usar, principalmente pelo
suporte do Spring boot, mas devo olhar também o Maven para entender direito como funciona.

## Endpoints
### GET /countries
Retorna um json paginado contendo as informações de países cadastrados
### GET /states
Retorna um json paginado contendo as informações de estados brasileiros cadastrados.
### GET /cities
Retorna um json paginado contendo as informações de cidades brasileiras cadastradas (localização inclusa).

### GET /countries/{id}; /states/{id}; /cities/{id}
Se id for passado no método GET, retorna um json contendo o conteúdo da entrada.

### GET /cities/{id}/distance-to/{toId}
Parametro opcional: showcities=true -> inlcui informações das cidades.
retorna a distância em milhas entra as cidades.

## Instância no heroku
https://nasan-cities-api.herokuapp.com/

## Mais informações
https://github.com/andrelugomes/digital-innovation-one/tree/master/cities-api

## TODO
 - [ ] adicionar JavaDoc
 - [ ] Criar testes.
 - [ ] Refatorar para uma interface mais RESTful.
 - [ ] Adicionar opções no método de distancia:
   - [ ] por default recebe um post com a localização do cliente e retorna a distância.
   - [ ] ?cityid={id} distância entre cidades cadastradas
   - [ ] ?unity={u} unidade de medida para retornar a distância [km por padrão].
 - [ ] Adicionar serviços de busca de cidades próximas.

# Base Relacional D
## Enunciadao: 

fai un  resulset sobre unha  taboa calquera ,para   obter e amosar os  nomes ,tipos e tamaños das columnas de dito  resulset utilizando  a clase ResulSetMetaData

notas:

* como obter un obxecto ResultSetMetaData dende un resultSet:
  debe aplicarse o metodo getMetaData() ao resultSet
* como obter informacion dos metadatos dende o obxecto ResultSetMetaData:
  deben aplicarse calquera de estes metodos segun a informacion que quera obter:
  getColumnCount()-- devolta o numero de columnas da taboa
  getColumnName(int)-- devolta o nome da columna cuxa posicion se pase
  getColumnTypeName(int)-- devolta o tipo de columna cuxa posicion se pase
 
 
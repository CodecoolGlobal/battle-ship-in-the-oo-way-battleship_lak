### `Ocean.java`

This file contains the create ocean logic.

### Class Ocean

__Attributes__

* `scanner`
  - data: Scanner object
  - description: object to get inputs from user

* `WIDTH`
  - data: Integer
  - description: contains dimension of board

* `HEIGHT`
  - data: Integer
  - description: contains dimension of board

* `letters`
  - data: String list
  - description: contains letters to print board

* `strNumbers`
  - data: String list
  - description: contains numbers to print board

* `squares`
  - data: two dimensional object list
  - description: contains two dimensional list of ocean squares

* `ships`
  - data: Object list
  - description: contains a list of ocean ships

__Instance methods__

* ##### `Ocean(List<Ship> ships)`

  Constructs a Ocean object

* `clearScreen()`

  clear screen in terminal

* `putShipsOnBoard(List<Ship> ships, Ocean ocean)`

  Puts all ships on ocean

* `getShipSettings(Ocean ocean, Ship ship)`

  Invokes methods to gain ship settings 

* `setUpTheShip(Ocean ocean, Ship ship)`

  Sets up a ship depending to input from user.

* `printShipSetup(boolean isVertical)`

  Prints information of ship setup

* `inputCoordinates(Ocean ocean, Ship ship)`

  Gets coordinate X and Y depending to input from user

* `checkIfInRange(Ship ship, int coordinate, String numLetter)`

  Checks if gained coordinates are in range of board dimensions. Return boolean value

* `checkIfInRadius(Ocean ocean, Ship ship)`

  Check the ship's position and calls for auxiliary methods. Return boolean value 

* `ifInRadiusVertical(Ocean ocean, Ship ship)`

  Checks if gained coordinates are in range other ship by vertical setup. Return boolean value

* `ifInRadiusVertical(Ocean ocean, Ship ship)`

  Checks if gained coordinates are in range other ship by horizontal setup. Return boolean value

* `putOneShipOnBoard(Ocean ocean, Ship ship)`

  Changes ocean squares into ship squares depending on coordinates and setup

* `generateEnemyOcean(List<Ship> ships, Ocean ocean)`

  Generates radon ocean for enemy

* `getRandomShipSettings(Ocean ocean, Ship ship)`

  Generates random layout by all ships on ocean

* `deepCopyOcean(List<Ship> hiddenShips, List<Ship> ships)`
  
  Makes a hidden ocean by copy cordinates from ships list to hidden ships list. Return Ocean object

* `getSquares()`

  Getter for the * sqaures * list

* `getShips()`

  Getter for the * ships * list

* `getLetters()`

  Getter for the * letters * list

* `getStrNumbers()`

  Getter for the * strNumbers * list

* `getSqare(Coordinates sqareCoordinates)`

  Getter for the * square * object by coordinates

* `toString()`

  Prints the ocean to add all the ships

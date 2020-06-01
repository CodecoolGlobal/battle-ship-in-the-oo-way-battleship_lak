### `Ship.java`

This file contains parametrs of ship.

### Class Ship

__Attributes__

* `squares`
  - data: Squares list
  - description: contains squares of ship

* `isVertical`
  - data: boolean
  - description: contains true if ship have vertical setup, otherwise contains false

* `isSunk`
  - data: boolean
  - description: contains true if ship is sunk, otherwise contains false. Default value is false

* `coordinateX`
  - data: Integer
  - description: contains horizontal coordinate

* `coordinateY`
  - data: Integer
  - description: contains vertical coordinate

* `nameOfShip`
  - data: String
  - description: contains Name of ship

__Instance methods__

* ##### `Ship(String nameOfShip, int shipLength, boolean isVertical, int coordinateX, int coordinateY)`

  Constructs a Ship object

* `getNameOfShip()`

  Getter for the * nameOfShip * field

* `getIsVertical()`

  Getter for the * isVertical * field

* `setVertical()`

  Sets the object's * isVertical * attribute to True

* `setHorizontal()`

  Sets the object's * isVertical * attribute to False

* `getCoordinateX()`

  Getter for the * coordinateX * field

* `setCoordinateX(int coordinateX)`

  Sets the object's * coordinateX * attribute to Value

* `getCoordinateY()`

  Getter for the * coordinateY * field

* `setCoordinateY(int coordinateY)`

  Sets the object's * coordinateY * attribute to Value

* `getShipLength()`

  Getter for the * shipLenght * field

* `getIsSunk()`

  Getter for the * isSunk * field

* `setIsSunk()`

  Sets the object's * isSunk * attribute to True

* `getSqareByIndex(int index)`

  Getter for the * Square * object by index

* `getSquaresOfShip()`

  Getter for the * squares * list

* `updateIsSunk()`

  check if all squares of ship are hit. If yes, sets the object's * isSunk * to True

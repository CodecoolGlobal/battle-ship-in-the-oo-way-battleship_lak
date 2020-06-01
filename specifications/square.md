### `Square.java`

This file created single square of every board or ship.

### Class Square

__Attributes__

* `SYMBOL`
  - data: String
  - description: symbol to print hit

* `SHIP`
  - data: String
  - description: symbol to print ship

* `isHit`
  - data: boolean
  - description: contains true if square is hit or miss. Default value is false

* `isShip`
  - data: boolean
  - description: contains true if square is part of ship. Default value is false

* `isHidden`
  - data: boolean
  - description: contains true if square is part of ocean enemy. Default value is false

__Instance methods__

* ##### `Square()`

  Constructs a Square object

* `hit()`

  Sets the object's * isHit * attribute to True

* `changeToAShip()`

  Sets the object's * isShip * attribute to True

* `getIsHit()`

  Getter for the * isHit * field

* `getIsShip()`

  Getter for the * isShip * field

* `setHidden()`

  Sets the object's * isHidden * attribute to True


* `toString()`

  Returns a formatted string with details about Square.

  Expecting output, for example, isn't hit and is a ship:

  `$`

  Expecting output, for example, is hit and is a ship:

  `X`
Expecting output, for example, is hit and isn't a ship:

  `O`
Expecting output, for example, isn' hit and isn't a ship:

  ` `

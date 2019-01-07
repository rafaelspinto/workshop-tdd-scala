# Payment Broker

Implement a payment broker that supports the pay operation with a wallet and a payment provider.


## Acceptance Criteria

* if wallet has funds and provider is available and deposit succeeds should return true.
* if wallet does not have funds should throw InsufficientFundsException.
* if provider is not available should throw ProviderNotAvailableException.


# Custom wallet

Implement a wallet that allows to add or remove amounts of currency.

## Acceptance Criteria

### add

* if amount is negative should throw NegativeAmountException.
* if amount is positive should return positive balance.
* if amount is greater than allowed should throw MaxAmountExceededException.
* if amount is greater than balance should throw NotEnoughFundsException.

### remove

* if amount is lower or equal than balance should return positive balance.
* if amount is lower or equal than balance should return positive balance.


# Currency Broker

## Acceptance Criteria

### convertToBitcoin

* if amount is greater than balance throws InsufficientFundsException.
* if amount is lower or equal than balance true.

## Uses

* [JUnit](https://junit.org/junit4/)
* [ScalaTest](http://www.scalatest.org/)
* [ScalaMock](https://scalamock.org/)
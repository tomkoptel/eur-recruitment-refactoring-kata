package com.tigerspike.refactoring

class Customer(val name: String) {

    private val rentals: MutableList<Rental> = mutableListOf()

    fun addRental(rental: Rental) {
        this.rentals.add(rental)
    }

    fun statement(): String {
        var totalAmount = 0.0
        var frequentRenterPoints = 0
        var result = "Rental Record for $name\n"

        rentals.forEach {
            var thisAmount = 0.0

            // determine amounts for each line
            when (it.movie.priceCode) {
                Movie.REGULAR -> {
                    thisAmount += 2.0
                    if (it.daysRented > 2)
                        thisAmount += (it.daysRented - 2) * 1.5
                }
                Movie.NEW_RELEASE -> thisAmount += (it.daysRented * 3).toDouble()
                Movie.CHILDRENS -> {
                    thisAmount += 1.5
                    if (it.daysRented > 3)
                        thisAmount += (it.daysRented - 3) * 1.5
                }
            }

            // add frequent renter points
            frequentRenterPoints++
            // add bonus for a two day new release rental
            if (it.movie.priceCode == Movie.NEW_RELEASE && it.daysRented > 1) {
                frequentRenterPoints++
            }
            //show figures for this rental
            result += ("\t" + it.movie.title + "\t"
                    + thisAmount.toString() + "\n")
            totalAmount += thisAmount
        }

        //add footer lines
        result += "You owed $totalAmount\n"
        result += "You earned $frequentRenterPoints frequent renter points\n"

        return result
    }
}
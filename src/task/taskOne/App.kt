package task.taskOne

import task.taskOne.source.Fruit
import task.taskOne.source.FruitData

class App{

    private var selectedMenu : Fruit? = null
    private val fruitData = FruitData().fruitData()

    fun showList(){
        println("=======================")
        println("Welcome to fruit store!")
        println("=======================")
        println("Our fruit today : ")
        fruitData.forEachIndexed { index, fruit ->
            println("${index+1}. ${fruit.name}")
        }
        println("=======================")
    }

    fun chooseMenu(){
        try {
            println("What do you want to buy? 1/2/3/4/5")
            print("Input what you want : ")
            val chooseMenu = readln().toInt()
            if (chooseMenu in 1..fruitData.size){
                selectedMenu = fruitData.elementAt(chooseMenu - 1)
                println("You select ${selectedMenu?.name}")
                println("----------------------")
                buyFruit(selectedMenu?.price)
            } else {
                println("You input wrong value")
                showList()
                chooseMenu()
            }
        } catch (e : NumberFormatException){
            println("You input wrong value")
            showList()
            chooseMenu()
        }
    }

    private fun buyFruit(price: Int?){
        println("How many melon you wanna buy? ")
        print("Input how much you want : ")
        val howMuch = readln().toInt()
        val totalPrice = howMuch * price!!
        println("Total price : $totalPrice")
        bonus(totalPrice)
    }

    private fun bonus(bonus : Int){
        if (bonus > 250000){
            val apple = fruitData.get(1)
            println("You got 1 kg $apple")
        } else if (bonus in 200000..250000){
            println("You got 6 Avocado")
        } else if (bonus in 150000..199999){
            println("You got 2 Melon")
        } else if (bonus in 100000..149999){
            println("You got 1 Watermelon")
        } else {
            println("You not got anything!")
        }
    }

    fun test(){
        val fruits = FruitData().fruitData()
        val index = fruits.indexOfFirst { it.name == "Apple" }

        if (index != -1) {
            println("Indeks dari Apple: $index")
        } else {
            println("Apple tidak ditemukan dalam daftar.")
        }
    }

}
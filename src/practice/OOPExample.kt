package practice

//Encapsulation
private class AClass{
    private fun run(){
        println("This is from class A")
    }
    fun runPublic(){

    }
}
class BClass{
    fun run(){
        //we cannot call run because it's private
        //AClass().run()
        AClass().runPublic()
        println("This is from class A")
    }
}

//Abstraction interface
interface Balloon {
    fun blow()
    fun pop()
}

//polymorphism
class RedBalloon(): Balloon{ //wajib mengimplementasi semua function di interface
    override fun blow() {
        println("Meniup balon merah ...")
    }

    override fun pop() {
        println("Balon merah meledak")
    }
}
class BlueBalloon(): Balloon{
    override fun blow() {
        println("Meniup balon biru ...")
    }

    override fun pop() {
        println("Balon biru meledak")
    }

}

//Abstraction abstract
abstract class HotAirBalloon(): Balloon{ //bisa implementasi salah satu function di interface
    override fun blow() {
        println("Blow the ballon using hot air")
    }

    override fun pop() {
        println("Danger !!!")
    }

    fun moveLeft(){
        println("Move the balloon to the left")
    }

    //wajib diimplemen di turunan class
    abstract fun carryPassenger()
}

//anaknya si bapak
class RedHotAirBallon(): HotAirBalloon(){
    override fun carryPassenger() {
        println("Carrying 5 passengers")
    }

    override fun blow() {
        println("Blow the ballon using doa")
    }

    fun blow(name: String){ //overloading

    }

}

class BlueHotAirBallon(): HotAirBalloon(){
    override fun carryPassenger() {
        println("Carrying 5 passengers")
    }

    override fun blow() {
        println("Blow the ballon using doa")
    }

    fun blow(name: String){ //overloading

    }

}

//inheritance using open class
open class Processor(val name: String){
    fun initProcessor(){
        println("Initializa ... $name")
    }
}

class AMDProcessor(): Processor("Ryzen 3")
class IntelProcessor(): Processor("i3")

fun main(args: Array<String>) {
    RedHotAirBallon().let {
        //Sifat kakek
        it.blow()
        it.pop()
        //sifat bapak
        it.moveLeft()
        it.carryPassenger()
    }

    AMDProcessor().initProcessor()
    IntelProcessor().initProcessor()
}
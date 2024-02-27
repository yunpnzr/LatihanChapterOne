package practice

//Single responsibility
class CalculatorWrong(){
    fun plus (a: Int, b: Int){
        val result = a+b
        println("Result is : $result")
    }
}
class CalculatorRight(){
    fun plus (a: Int, b: Int): Int {
        return a+b
    }
}
fun printResult(result: Number){
    println("The Result is $result")
}

//Single responsibility
class RockPapperScissor(){

    private var playerOne: Int = -1
    private var playerTwo: Int = -1

    private fun printOptions(){
        println("""
            ====================================
            GUNTING BATU KERTAS
            ====================================
            OPTION
            0. GUNTING
            1. BATU
            2. KERTAS
        """.trimIndent())
    }

    private fun shwoResult(playerOne : Int, playerTwo : Int): String{
        return if (((playerOne + 1) % 3) == playerTwo){
            "Player 2 menang"
        } else if (playerOne == playerTwo) {
            "Seri"
        } else {
            "Player 1 menang"
        }
    }

    private fun inputPlayerOne(){
        println("Masukkan pilihan 1 (0/1/2): ")
        playerOne = readln().toInt()
    }

    private fun inputPlayerTwo(){
        println("Masukkan pilihan 2 (0/1/2): ")
        playerTwo = readln().toInt()
    }

    fun suit(){
        printOptions()
        inputPlayerOne()
        inputPlayerTwo()
        println(shwoResult(playerOne,playerTwo))
    }
}

//open closed
open class IronManSuit{
    open fun blast(){
        println("Blast using laser powered by Arc Reactor")
    }
    fun activateAI(){
        println("Jarvis is active")
    }
}

class WarMachineSuit() : IronManSuit(){
    override fun blast() {
        //super.blast()
        println("Blast from war machine suit")
    }
}

//liskov subtitution
//using hot air balloon
class Capadocia(){
    private lateinit var balloon : HotAirBalloon
    fun run(){
        //balloon = RedHotAirBalloon()
        //balloon = BlueHotAirBalloon() (harusnya bukan dikomen)
        balloon.apply {
            carryPassenger()
            blow()
            pop()
        }
    }
}

//interface segregation
interface Animal{
    fun eat()
    fun hunt()
    fun walking()
    //fun fly()
    //fun swim()
    fun sleep()
    fun jump()
    fun breath()
    fun reproduction()
}
interface Aves : Animal {
    fun fly()
    fun twit()
}
interface Fish : Animal {
    fun swim()
}

class Bird() : Aves{
    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun twit() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    //override fun swim() {
    //    TODO("Not yet implemented")
    //}

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }

}
class Catfish() : Fish{
    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    //override fun fly() {
    //    TODO("Not yet implemented")
    //}

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }

}

//Dependency inversion (ini liskov juga)
class FirebaseAnalytics(){
    fun log(event: String){
        println("Logging to Firebase : Event name in $event")
        Thread.sleep(2000)
        println("Logging success!")
    }
}
class NewRelicAnalytics(){
    fun log(event: String){
        println("Logging to NewRelic : Event name in $event")
        Thread.sleep(2000)
        println("Logging success!")
    }
}
class NoEngageAnalytics(){
    fun log(event: String){
        println("Logging to NoEngage : Event name in $event")
        Thread.sleep(2000)
        println("Logging success!")
    }
}

//agnostic classs
interface Analytics {
    fun logEvent(event: String)
}
class AppAnalytics: Analytics{
    private var firebaseAnalytics = FirebaseAnalytics()
    private var noEngageAnalytics = NoEngageAnalytics()
    private var newRelicAnalytics = NewRelicAnalytics()
    override fun logEvent(event: String) {
        firebaseAnalytics.log(event)
        newRelicAnalytics.log(event)
        noEngageAnalytics.log(event)
    }

}

//page
class SplashScreen(private val analytics: Analytics){
    fun openPage(){
        println("Open page splashscreen...")
        analytics.logEvent("SplashScreen")
    }
}
class HomePage(private val analytics: Analytics){
    fun openPage(){
        println("Open page home page...")
        analytics.logEvent("HomePage")
    }
}
class LoginPage(private val analytics: Analytics){
    fun openPage(){
        println("Open page login page...")
        analytics.logEvent("LoginPage")
    }
}

class App(){

    private val analytics = AppAnalytics()

    fun run(){
        SplashScreen(analytics).openPage()
        HomePage(analytics).openPage()
        LoginPage(analytics).openPage()
    }
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}

//fun main(args: Array<String>) {
    //printResult(CalculatorRight().plus(7,8))
    //RockPapperScissor().suit()
    //RockPapperScissor().suit()
    //WarMachineSuit().blast()
    //Capadocia().run()
//}


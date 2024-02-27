package practice

import app.model.ComputerData

class ControlFlowExample {

    //val name: String? = null

    private val computerData = listOf(
        ComputerData(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRAMInGB = 32,
            EGPUName = "RTX 4060"
        ),
        ComputerData(
            processorName = "AMD Ryzen 3",
            processorTotalCore = 2,
            isHaveIGPU = false,
            totalRAMInGB = 16,
            EGPUName = "RTX 3060"
        )
    )

    fun run(){
        println(checkName("Megawati"))
        println(checkNameUsingWhen(("Agus")))
        exampleWhen()
        checkName()
        printSomething()
        coba()
    }

    //if else
    private fun checkName(name: String?): String{
        return if (name == null){
            "Your name still empty"
        }else if(name.contains("Megawati", ignoreCase = true)){
            "Lu sape?"
        }else if(name.contains("Prabowo", ignoreCase = true)){
            "Lu juga sape?"
        }else{
            "Abc"
        }
    }

    //when
    private fun checkNameUsingWhen(name: String?): String{
        return when (name){
            "Agus" -> "Abcd"
            "Hari" -> "Efgh"
            else -> "Data kamu tidak ada"
        }
    }
    private fun exampleWhen(){
        val contenType = ContenType.REELS
        when(contenType){
            ContenType.PHOTO -> {
                println("Konten foto")
            }
            ContenType.VIDEO -> println("Konten Video")
            ContenType.REELS -> println("Konten reels")
        }
    }

    private var name : String? = null

    private fun checkName(){
        //escape condition, untuk single if
        if (name == null) return
        println("Nama anda adalah $name")
        println("Anda adalah manusia")
    }

    fun coba(){
        for (index in computerData.indices){
            println("$index ${computerData.indices}")
        }
    }

    //loop
    fun printSomething() {
        //for loop 1
        for (index in 0..3){
            //if (index == 5) continue //continue itu ngeskip sebuah nilai atau data sesuai dengan perintah
            println("Ini loop ke $index")
        }
        println()
        //step looping
        for (index in 1..10 step 2){
            println("Ini loop ke $index")
        }
        println()
        //downTo
        for (index in 10 downTo 1 step 2){
            println("Ini loop ke $index")
        }
        //for loop manual
        for (index in computerData.indices){
            println("$index ${computerData[index]}")
        }
        //equivalent
        computerData.forEach {
            println("$it")
        }
        //with index
        computerData.forEachIndexed { index, computerData ->
            println("${index+1}$computerData")
        }

        //do while
        var index = 0
        do {
            println(index)
            index++
        } while (index < 5)

        index = 0
        while (index < 5){
            println(index)
            index++
        }

        //escape && continue
        for (index in 0..3){
            if (index == 5) continue //continue itu ngeskip sebuah nilai atau data sesuai dengan perintah
            println("Ini loop ke $index")
        }
        //destroy loop
        for (index in 0..3){
            if (index == 5) break //stop di index tertentu
            println("Ini loop ke $index")
        }
    }

    companion object{
        @JvmStatic
        fun main(args : Array<String>){
            ControlFlowExample().run()
        }
    }


}

//adalah suatu kelas yang digunakan untuk identify sesuatu yang sudah fix
enum class ContenType{
    PHOTO, VIDEO, REELS
}
package app

import app.model.ComputerData

class App (var creatorName : String?){ //default value constructor

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
        ),
        ComputerData(
            processorName = "AMD i3",
            processorTotalCore = 6,
            isHaveIGPU = false,
            totalRAMInGB = 16,
            EGPUName = "RTX 2080"
        )
    )

    private var selectedComputer : ComputerData? = null

    fun run(){
        printHeader()
        getSelectedComputer()
    }

    fun printHeader(){
        //println(computerData.firstOrNull()?.processorName)
        println("==========================")
        println("Created by : $creatorName")
        println("==========================")
        println("OrderPC")
        println("==========================")
        computerData.forEachIndexed() {index,data -> //lamda function
            println("${index+1}. ${data.processorName} : ${data.EGPUName}")
        }
        println("==========================")
    }

    private fun getSelectedComputer(){
        print("Masukkan pilihan : ")
        try {
            val selectedIndex = readln().toInt()
            if (selectedIndex in 1..computerData.size){
                selectedComputer = computerData[selectedIndex-1]
                println("Pilihan anda = $selectedComputer")
            } else {
                println("Pilihan salah silahkan coba lagi")
                getSelectedComputer()
            }
            // println("Pilihan anda adalah $userPick")
        } catch (e : NumberFormatException){
            println("Menu salah")
            getSelectedComputer()
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>){
            val app = App("Suharto") //object of app
            app.run()
        }
    }
}
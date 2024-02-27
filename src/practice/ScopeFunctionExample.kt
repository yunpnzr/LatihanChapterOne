package practice

import app.model.ComputerData

class ScopeFunctionExample{
    private val creatorName : String? = null
    private var computerData : ComputerData? = null

    fun run() {
        //let
        creatorName?.let {
            println("Created by : $creatorName")
        } ?: run{
            println("This program is open source")
        }

        //equals
        /*if (creatorName != null){
            println("Created by : $creatorName")
        } else {
            println("This program is open source")
        }*/

        //apply
        println(computerData)
        computerData?.apply {
            this.processorName = "Intel Pentium"
        } ?: run{ println("Computer data is null") }
        ComputerData(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRAMInGB = 32,
            EGPUName = "RTX 4060"
        )
        computerData?.apply {
            this.processorName = "Intel Pentium"
        } ?: run{ println("Computer data is null") }
        println(computerData)

        //with
        //before
        println(computerData?.processorName)
        println(computerData?.totalRAMInGB)
        println(computerData?.isHaveIGPU)

        //after
        with(computerData){
            println(this?.processorName)
            println(this?.totalRAMInGB)
            println(this?.isHaveIGPU)
        }
    }

    companion object{ //companion object akan menjadikan semua menjadi final object
        @JvmStatic
        fun main(args: Array<String>) {
            ScopeFunctionExample().run()
        }
    }
}
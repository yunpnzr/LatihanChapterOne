package app.model

data class ComputerData(
    var processorName : String,
    val processorTotalCore : Int,
    val isHaveIGPU : Boolean,
    val totalRAMInGB : Int,
    val EGPUName : String
)
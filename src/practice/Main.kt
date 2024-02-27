package practice
//public variable
//define with data type
val index : Int = 0 //imutable -> tidak bisa diubah nilainya
var aString : String = "11/100" //mutable -> bisa diubah nilainya

//define without data type
val anotherString = "Lorem ipsum"
val aNumber = 19
val aNumber2 = 19.2
//constanta
const val aNumber3 = 19.2512323123123
val aNumber4 = 1234567890123456

val arrayData : Array<String> = arrayOf("1","2","3")
val arrData = arrayOf("1","2","3")

//gabisa tambah data
val listData : List<String> = listOf("1","2","3")
val lstData = listOf("1","2","3")
//bisa tambah data
val mutableListData = mutableListOf<String>("12","13","14")

fun printHeader(){
    println("==========================")
    println("OrderPC")
    println("==========================")
    println("1. A")
    println("2. B")
    println("3. C")
    println("4. D")
    println("==========================")
    print("Masukkan pilihan : ")
    try {
        val userPick = readln().toInt()
        println("Pilihan anda adalah $userPick")
    } catch (e : NumberFormatException){
        println("Menu salah")
        printHeader()
    }
}

fun main(arg: Array<String>) {
    val menu = "Ayam" //local variable

    println(menu)
    println(index)
    println(aString)
    aString = "Kucing oren"
    println(aString)
    println("=========================")
    println(anotherString)
    println(aNumber)
    println(aNumber2)
    println(aNumber3)
    println(aNumber4)
    println("=========================")
    println(arrData)
    println(arrayData)
    println("=========================")
    println(listData)
    println(lstData)

    try { //try untuk error handling
        println(mutableListData)
        mutableListData.add("15")
        mutableListData.add(2,"10")
        println(mutableListData)
        mutableListData.removeAt(0)
        println(mutableListData)
        mutableListData.remove("13")
        println(mutableListData)
    }catch (e : Exception){
        println("kode error")
    }

    printHeader()
}
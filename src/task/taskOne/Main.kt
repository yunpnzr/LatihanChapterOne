package task.taskOne

class Main {
    companion object{

        fun run(){

            App().showList()
            App().chooseMenu()

            //App().test()
        }

        @JvmStatic
        fun main(args: Array<String>) {
            run()
        }
    }
}
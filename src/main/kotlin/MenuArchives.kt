import java.util.Scanner

class MenuArchives(var archivesList: MutableList<Archive>?) {
    fun show() {
        var index = 0
        println("-------------------------------------------------")
        println("$index. Создать архив")
        for (archive in archivesList!!) {
            println("${++index}. ${archive.archiveName}")
        }
        println("${++index}. Выйти из программы")
        println("-------------------------------------------------")
    }

    fun getFromUser (): Int {
        val scanner = Scanner(System.`in`)
        val select = scanner.nextLine().toIntOrNull()
        return select ?: -1
    }
}

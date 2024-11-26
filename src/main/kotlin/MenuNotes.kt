import java.util.Scanner

class MenuNotes(var currentArchive: Archive) {
    fun show() {
        var index = 0
        println("$index. Создать заметку")
        for (currentNote in currentArchive.notesList) {
            println("${++index}. ${currentNote.noteName}")
        }
        println("${++index}. Выйти в предыдущее меню")
    }

    fun getFromUser (): Int {
        val scanner = Scanner(System.`in`)
        val select = scanner.nextLine().toIntOrNull()
        return select ?: -1
    }
}

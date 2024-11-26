import java.util.Scanner

fun main() {
    val archivesList = mutableListOf<Archive>()
    val scanner = Scanner(System.`in`)

    while (true) {
        MenuArchives(archivesList).show()
        val userSelect1 = MenuArchives(archivesList).getFromUser ()

        if (!isValidSelection(userSelect1, archivesList.size + 1)) {
            println("Ошибка: Повторите выбор")
            continue
        }

        when (userSelect1) {
            0 -> createArchive(archivesList, scanner)
            archivesList.size + 1 -> {
                scanner.close()
                return
            }
            else -> manageArchive(archivesList[userSelect1 - 1], scanner)
        }
    }
}

fun isValidSelection(selection: Int, max: Int): Boolean {
    return selection in 0..max
}

fun createArchive(archivesList: MutableList<Archive>, scanner: Scanner) {
    println("Введите название нового архива")
    val newArchName = scanner.nextLine()

    if (newArchName.isBlank()) {
        println("Ошибка: Имя архива не должно быть пустым")
    } else if (archivesList.any { it.archiveName.equals(newArchName, true) }) {
        println("Ошибка: Архив с таким названием уже существует")
    } else {
        archivesList.add(Archive(newArchName))
    }
}

fun manageArchive(currentArchive: Archive, scanner: Scanner) {
    while (true) {
        MenuNotes(currentArchive).show()
        val userSelect2 = MenuNotes(currentArchive).getFromUser ()

        if (!isValidSelection(userSelect2, currentArchive.notesList.size + 1)) {
            println("Ошибка ввода. Повторите выбор.")
            continue
        }

        when (userSelect2) {
            0 -> createNote(currentArchive, scanner)
            currentArchive.notesList.size + 1 -> break
            else -> showNoteDetails(currentArchive.notesList[userSelect2 - 1])
        }
    }
}

fun createNote(currentArchive: Archive, scanner: Scanner) {
    println("Введите имя заметки")
    val newNoteName = scanner.nextLine()

    if (newNoteName.isBlank()) {
        println("Ошибка: Имя заметки не должно быть пустым")
    } else if (currentArchive.notesList.any { it.noteName.equals(newNoteName, true) }) {
        println("Ошибка: Заметка с таким именем уже существует")
    } else {
        println("Введите содержание заметки")
        val newNoteContent = scanner.nextLine()
        if (newNoteContent.isNotBlank()) {
            currentArchive.notesList.add(Note(newNoteName, newNoteContent))
        } else {
            println("Ошибка: Текст заметки не должен быть пустым")
        }
    }
}

fun showNoteDetails(note: Note) {
    println("Заметка: ${note.noteName}")
    println(note.noteContent)
}

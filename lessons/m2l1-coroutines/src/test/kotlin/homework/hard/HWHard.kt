package homework.hard

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import java.io.File
import kotlin.test.Test

class HWHard {
    @Test
    fun hardHw() {
        val dictionaryApi = DictionaryApi()
        val words = FileReader.readFile().split(" ", "\n").toSet()

        val dictionaries = findWords(dictionaryApi, words, Locale.EN)

        var countDef = 0
        dictionaries.filterNotNull().forEach{
            it.meanings.forEach{ meaning ->
                countDef += meaning.definitions.count()
            }
        }

        println("count words = ${words.size}")
        println("count definitions = $countDef")

        dictionaries.filterNotNull().map { dictionary ->
            print("For word ${dictionary.word} i found examples: ")
            println(
                dictionary.meanings
                    .mapNotNull { definition ->
                        val r = definition.definitions
                            .mapNotNull { it.example.takeIf { it?.isNotBlank() == true } }
                            .takeIf { it.isNotEmpty() }
                        r
                    }
                    .takeIf { it.isNotEmpty() }
            )
        }
    }

    private fun findWords(
        dictionaryApi: DictionaryApi,
        words: Set<String>,
        @Suppress("SameParameterValue") locale: Locale
    ) = runBlocking(Dispatchers.IO) {
        words.map {
            async { dictionaryApi.findWord(locale, it) }
        }.awaitAll()
    }


    object FileReader {
        fun readFile(): String =
            File(
                this::class.java.classLoader.getResource("words.txt")?.toURI()
                    ?: throw RuntimeException("Can't read file")
            ).readText()
    }
}

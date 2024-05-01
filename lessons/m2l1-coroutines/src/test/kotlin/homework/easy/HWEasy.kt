package homework.easy

import findNumberInList
import kotlin.test.Test
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class HWEasy {
    @Test
    fun easyHw() = runBlocking {
        val numbers = generateNumbers()
        val toFind = 10
        val toFindOther = 1000

        val foundNumbers = listOf(
            async { findNumberInList(toFind, numbers) },
            async { findNumberInList(toFindOther, numbers) }
        )

        foundNumbers.forEach { resultAsync ->
            val searchedNum = resultAsync.await()
            if (searchedNum != -1) {
                println("Your number $searchedNum found!")
            } else {
                println("Not found number $toFind || $toFindOther")
            }
        }
    }
}

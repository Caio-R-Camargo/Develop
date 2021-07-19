package com.example.develop.repository

import com.example.develop.infra.DevelopConstants
import java.util.*

data class Phrase(val description: String, val category: Int)

class Mock {

    private val ALL = DevelopConstants.PHRASEFILTER.ALL
    private val DEV = DevelopConstants.PHRASEFILTER.DEV
    private val DAY = DevelopConstants.PHRASEFILTER.DAY

    private val mListPhrases: List<Phrase> = listOf(

            Phrase("Finalizando uma Activity \n finish()", DEV),
            Phrase("Utilizando números aleatórios \n" +
                    "val random = Random().nextInt() <-- até o numero desejado", DEV),
            Phrase("Se estiver usando Kotlin, não é nescessário ; \n" +
                    "Já em Java, não se esqueça de utilizar!", DEV),
            Phrase("Quando estiver com problemas, pare por uns minutos e descanse a mente", DAY),
            Phrase("Não é indicado ficar em frente a uma tela por mais de 20 minutos", DAY),

            )

    fun getPhrase(categoryId: Int): String {

        val filtered = mListPhrases.filter { (it.category == categoryId || categoryId == ALL) }

        val rand = Random().nextInt(filtered.size)

        return filtered[rand].description


    }

}
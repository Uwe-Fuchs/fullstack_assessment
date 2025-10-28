package com.uwefuchs.demo.assecor_assessment.assecor_assessment.backend.color

enum class Color(val colorId: Int, val colorStr: String) {
    BLAU(1, "blau"),
    GRUEN(2, "grün"),
    VIOLETT(3, "violett"),
    ROT(4, "rot"),
    GELB(5, "gelb"),
    TUERKIS(6, "türkis"),
    WEISS(7, "weiß");

    companion object {
        fun findColorById(colorId: Int): Color? {
            return try {
                Color.entries.first { it.colorId == colorId }
            } catch(e: NoSuchElementException) {
                null
            }
        }

        fun findColorByColorStr(colorStr: String) : Color? {
            return try {
                Color.entries.first { it.colorStr == colorStr }
            } catch(e: NoSuchElementException) {
                null
            }
        }
    }
}
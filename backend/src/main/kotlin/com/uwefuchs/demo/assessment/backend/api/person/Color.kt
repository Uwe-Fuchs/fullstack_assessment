package com.uwefuchs.demo.assessment.backend.api.person

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
            return Color.entries
                .stream()
                .filter { it.colorId == colorId }
                .findFirst()
                .orElse(null)
        }

        fun findColorByColorStr(colorStr: String) : Color? {
            return Color.entries
                .stream()
                .filter { it.colorStr == colorStr }
                .findFirst()
                .orElse(null)
        }
    }
}
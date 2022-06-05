package tech.vhrd.vhl


import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

object VhlColors {
    private fun r(id: String, attrKey: TextAttributesKey) =
        TextAttributesKey.createTextAttributesKey(id, attrKey)

    val KEY = r("vhl.KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
    val STRING = r("vhl.STRING", DefaultLanguageHighlighterColors.STRING)
    val NUMBER = r("vhl.NUMBER", DefaultLanguageHighlighterColors.NUMBER)
    val BOOLEAN = r("vhl.BOOLEAN", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL)

    val LINE_COMMENT = r("vhl.LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

    val BRACKETS = r("vhl.BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
    val BRACES = r("vhl.BRACES", DefaultLanguageHighlighterColors.BRACES)

    val COMMA = r("vhl.COMMA", DefaultLanguageHighlighterColors.COMMA)
}
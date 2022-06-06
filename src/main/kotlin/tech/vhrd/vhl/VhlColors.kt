package tech.vhrd.vhl


import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default
import com.intellij.openapi.editor.colors.TextAttributesKey

object VhlColors {
    private fun r(id: String, attrKey: TextAttributesKey) =
        TextAttributesKey.createTextAttributesKey(id, attrKey)

    val KEY = r("vhl.KEYWORD", Default.KEYWORD)
    val STRING = r("vhl.STRING", Default.STRING)
    val NUMBER = r("vhl.NUMBER", Default.NUMBER)
    val BOOLEAN = r("vhl.BOOLEAN", Default.PREDEFINED_SYMBOL)

    val LINE_COMMENT = r("vhl.LINE_COMMENT", Default.LINE_COMMENT)

    val BRACKETS = r("vhl.BRACKETS", Default.BRACKETS)
    val BRACES = r("vhl.BRACES", Default.BRACES)

    val COMMA = r("vhl.COMMA", Default.COMMA)

    val XPI_URI_SEGMENT = r("vhl.XPI_URI_SEGMENT", Default.IDENTIFIER)
}
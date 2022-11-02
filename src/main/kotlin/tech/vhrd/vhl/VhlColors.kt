package tech.vhrd.vhl


import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as Default
import com.intellij.openapi.editor.colors.TextAttributesKey

object VhlColors {
    private fun r(id: String, attrKey: TextAttributesKey) =
        TextAttributesKey.createTextAttributesKey(id, attrKey)

    val KEYWORD = r("vhl.KEYWORD", Default.KEYWORD)
    val STRING = r("vhl.STRING", Default.STRING)
    val NUMBER = r("vhl.NUMBER", Default.NUMBER)
    val CONSTANT = r("vhl.CONSTANT", Default.CONSTANT)
    val BOOLEAN = r("vhl.BOOLEAN", Default.PREDEFINED_SYMBOL)

    val EOL_COMMENT = r("vhl.LINE_COMMENT", Default.LINE_COMMENT)
    val BLOCK_COMMENT = r("vhl.BLOCK_COMMENT", Default.BLOCK_COMMENT)

    val DOC_COMMENT = r("vhl.DOC_COMMENT", Default.DOC_COMMENT)

    val BRACKETS = r("vhl.BRACKETS", Default.BRACKETS)
    val BRACES = r("vhl.BRACES", Default.BRACES)

    val COMMA = r("vhl.COMMA", Default.COMMA)

    val XPI_URI_IDENT = r("vhl.URI_IDENT", Default.INSTANCE_METHOD)
    val XPI_RS_TRANSFORM = r("vhl.XPI_RS_TRANSFORM", Default.KEYWORD)

    val ENUM_ITEM = r("vhl.ENUM_ITEM", Default.CONSTANT)
    val STRUCT_ITEM = r("vhl.STRUCT_ITEM", Default.CONSTANT)
    val BUILTIN_TYPE = r("vhl.BUILTIN_TYPE", Default.KEYWORD)
    val ATTRIBUTE = r("vhl.ATTRIBUTE", Default.METADATA)
    val UNIT = r("vhl.UNIT", Default.METADATA)
}
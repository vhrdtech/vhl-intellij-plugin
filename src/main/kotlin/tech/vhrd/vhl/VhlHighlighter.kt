package tech.vhrd.vhl
import com.intellij.lexer.Lexer
//import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import gnu.trove.THashMap
import tech.vhrd.vhl.lexer.VhlLexerAdapter
import tech.vhrd.vhl.psi.VhlTypes

class VhlHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = VhlLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> =
        pack(tokenMap[tokenType])

    private val tokenMap: Map<IElementType, TextAttributesKey> = makeTokenMap()
}


private fun makeTokenMap(): Map<IElementType, TextAttributesKey> {
    val result = THashMap<IElementType, TextAttributesKey>()

    result[VhlTypes.IDENT] = VhlColors.KEY

//    result[VhlTypes.COMMENT] = VhlColors.LINE_COMMENT

//    result[VhlTypes.STRING] = VhlColors.STRING
//
//    result[VhlTypes.NUMBER] = VhlColors.NUMBER
//
//    result[VhlTypes.BOOLEAN] = VhlColors.BOOLEAN
//
//    result[VhlTypes.LBRACKET] = VhlColors.BRACKETS
//    result[VhlTypes.RBRACKET] = VhlColors.BRACKETS
    result[VhlTypes.LBRACE] = VhlColors.BRACES
    result[VhlTypes.RBRACE] = VhlColors.BRACES

    return result;
}
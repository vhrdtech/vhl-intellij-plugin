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

    //result[VhlTypes.IDENT] = VhlColors.KEY
    result[VhlTypes.STRUCT_KW] = VhlColors.KEYWORD
    result[VhlTypes.ENUM_KW] = VhlColors.KEYWORD
    result[VhlTypes.RS_KW] = VhlColors.KEYWORD
    result[VhlTypes.CONST_KW] = VhlColors.KEYWORD
    result[VhlTypes.TYPE_KW] = VhlColors.KEYWORD
    result[VhlTypes.FN_KW] = VhlColors.KEYWORD
    result[VhlTypes.IMPL_KW] = VhlColors.KEYWORD
    result[VhlTypes.XPI_IMPL] = VhlColors.KEYWORD

    result[VhlTypes.DISCRETE_SIGNED_TY_IMPLICIT] = VhlColors.BUILTIN_TYPE
    result[VhlTypes.DISCRETE_UNSIGNED_TY_IMPLICIT] = VhlColors.BUILTIN_TYPE
    result[VhlTypes.FIXED_SIGNED_TY_IMPLICIT] = VhlColors.BUILTIN_TYPE
    result[VhlTypes.FIXED_UNSIGNED_TY_IMPLICIT] = VhlColors.BUILTIN_TYPE
    result[VhlTypes.BOOL] = VhlColors.BUILTIN_TYPE
    result[VhlTypes.CHAR] = VhlColors.BUILTIN_TYPE
    result[VhlTypes.STR] = VhlColors.BUILTIN_TYPE
    result[VhlTypes.FLOAT_TY_IMPLICIT] = VhlColors.BUILTIN_TYPE

    result[VhlTypes.EOL_COMMENT] = VhlColors.EOL_COMMENT
    result[VhlTypes.BLOCK_COMMENT] = VhlColors.BLOCK_COMMENT
    result[VhlTypes.OUTER_EOL_DOC_COMMENT] = VhlColors.DOC_COMMENT
    result[VhlTypes.OUTER_BLOCK_DOC_COMMENT] = VhlColors.DOC_COMMENT
    result[VhlTypes.INNER_EOL_DOC_COMMENT] = VhlColors.DOC_COMMENT
    result[VhlTypes.INNER_BLOCK_DOC_COMMENT] = VhlColors.DOC_COMMENT

    result[VhlTypes.STRING_LITERAL] = VhlColors.STRING
    result[VhlTypes.CHAR_LITERAL] = VhlColors.CHAR
    result[VhlTypes.DEC_LIT_RAW] = VhlColors.NUMBER
    result[VhlTypes.HEX_LIT_RAW] = VhlColors.NUMBER
    result[VhlTypes.OCT_LIT_RAW] = VhlColors.NUMBER
    result[VhlTypes.BIN_LIT_RAW] = VhlColors.NUMBER
    result[VhlTypes.FLOAT_LIT_RAW] = VhlColors.NUMBER

//
//    result[VhlTypes.LBRACKET] = VhlColors.BRACKETS
//    result[VhlTypes.RBRACKET] = VhlColors.BRACKETS
    result[VhlTypes.LBRACE] = VhlColors.BRACES
    result[VhlTypes.RBRACE] = VhlColors.BRACES


//    result[VhlTypes.XPI_URI_SEGMENT] = VhlColors.XPI_URI_IDENT
//    result[VhlTypes.XPI_ACCESS_MODE] = VhlColors.XPI_RS_TRANSFORM
//    result[VhlTypes.XPI_MOD_OBSERVE] = VhlColors.XPI_RS_TRANSFORM
//    result[VhlTypes.XPI_MOD_STREAM] = VhlColors.XPI_RS_TRANSFORM

    return result
}
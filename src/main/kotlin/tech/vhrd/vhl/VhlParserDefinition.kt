package tech.vhrd.vhl

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import tech.vhrd.vhl.VhLanguage
import tech.vhrd.vhl.lexer.VhlLexerAdapter
import tech.vhrd.vhl.psi.VhlFile
import tech.vhrd.vhl.psi.VhlTypes

public class VhlParserDefinition : ParserDefinition {
    override fun createParser(project: Project?): PsiParser =
        VhlParser()

    override fun createFile(viewProvider: FileViewProvider): PsiFile =
        VhlFile(viewProvider)

    override fun spaceExistanceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun getStringLiteralElements(): TokenSet =
        TokenSet.EMPTY;

    override fun getWhitespaceTokens(): TokenSet =
        WHITE_SPACES

    override fun getCommentTokens(): TokenSet =
        COMMENTS;

    override fun getFileNodeType(): IFileElementType =
        FILE

    override fun createLexer(project: Project?): Lexer =
        VhlLexerAdapter()

    override fun createElement(node: ASTNode?): PsiElement =
        VhlTypes.Factory.createElement(node)

    companion object {
        val FILE: IFileElementType = IFileElementType(VhLanguage)
        val WHITE_SPACES: TokenSet = TokenSet.create(TokenType.WHITE_SPACE);
        val COMMENTS: TokenSet = TokenSet.create(VhlTypes.EOL_COMMENT, VhlTypes.BLOCK_COMMENT);
    }

}
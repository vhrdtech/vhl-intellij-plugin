package tech.vhrd.vhl.lexer

import com.intellij.lexer.FlexAdapter
import tech.vhrd.vhl.lexer.VhlLexer
import java.io.Reader

class VhlLexerAdapter : FlexAdapter(VhlLexer(null as Reader?))
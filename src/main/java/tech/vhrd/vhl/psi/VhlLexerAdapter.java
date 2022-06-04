package tech.vhrd.vhl.psi;

import com.intellij.lexer.FlexAdapter;
import tech.vhrd.vhl.psi.VhlLexer;

public class VhlLexerAdapter extends FlexAdapter {
    public VhlLexerAdapter() {
        super(new VhlLexer(null));
    }
}

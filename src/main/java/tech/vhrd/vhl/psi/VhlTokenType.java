package tech.vhrd.vhl.psi;

import com.intellij.psi.tree.IElementType;
import tech.vhrd.vhl.VhlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class VhlTokenType extends IElementType {

    public VhlTokenType(@NotNull @NonNls String debugName) {
        super(debugName, VhlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "VhlTokenType." + super.toString();
    }

}
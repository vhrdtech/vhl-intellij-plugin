package tech.vhrd.vhl.psi;

import com.intellij.psi.tree.IElementType;
import tech.vhrd.vhl.VhlLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class VhlElementType extends IElementType {

    public VhlElementType(@NotNull @NonNls String debugName) {
        super(debugName, VhlLanguage.INSTANCE);
    }

}
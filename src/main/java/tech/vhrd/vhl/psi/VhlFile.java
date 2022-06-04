package tech.vhrd.vhl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import tech.vhrd.vhl.VhlFileType;
import tech.vhrd.vhl.VhlLanguage;
import org.jetbrains.annotations.NotNull;

public class VhlFile extends PsiFileBase {
    public VhlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, VhlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return VhlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Vhl File";
    }
}

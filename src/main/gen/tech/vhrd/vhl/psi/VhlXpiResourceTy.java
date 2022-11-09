// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VhlXpiResourceTy extends PsiElement {

  @Nullable
  VhlTy getTy();

  @Nullable
  VhlXpiResourceCellTy getXpiResourceCellTy();

  @Nullable
  VhlXpiResourceTransform getXpiResourceTransform();

  @NotNull
  List<VhlXpiSerial> getXpiSerialList();

}

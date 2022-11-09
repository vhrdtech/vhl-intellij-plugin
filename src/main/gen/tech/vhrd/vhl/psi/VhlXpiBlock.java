// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VhlXpiBlock extends PsiElement {

  @NotNull
  List<VhlOuterAttr> getOuterAttrList();

  @Nullable
  VhlXpiBody getXpiBody();

  @Nullable
  VhlXpiResourceTy getXpiResourceTy();

  @Nullable
  VhlXpiUriSegment getXpiUriSegment();

}

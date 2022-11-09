// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VhlEnumDef extends PsiElement {

  @NotNull
  List<VhlEnumItem> getEnumItemList();

  @NotNull
  List<VhlOuterAttr> getOuterAttrList();

  @NotNull
  PsiElement getIdent();

}

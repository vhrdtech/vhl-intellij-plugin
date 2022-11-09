// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VhlEnumItem extends PsiElement {

  @Nullable
  VhlBlockFields getBlockFields();

  @Nullable
  VhlEnumItemDiscriminant getEnumItemDiscriminant();

  @Nullable
  VhlTupleTy getTupleTy();

  @NotNull
  PsiElement getIdent();

}

// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tech.vhrd.vhl.psi.VhlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import tech.vhrd.vhl.psi.*;

public class VhlEnumItemImpl extends ASTWrapperPsiElement implements VhlEnumItem {

  public VhlEnumItemImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitEnumItem(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VhlBlockFields getBlockFields() {
    return findChildByClass(VhlBlockFields.class);
  }

  @Override
  @Nullable
  public VhlEnumItemDiscriminant getEnumItemDiscriminant() {
    return findChildByClass(VhlEnumItemDiscriminant.class);
  }

  @Override
  @Nullable
  public VhlTupleTy getTupleTy() {
    return findChildByClass(VhlTupleTy.class);
  }

  @Override
  @NotNull
  public PsiElement getIdent() {
    return findNotNullChildByType(IDENT);
  }

}

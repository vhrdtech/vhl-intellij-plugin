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

public class VhlDiscreteUnsignedTyImpl extends ASTWrapperPsiElement implements VhlDiscreteUnsignedTy {

  public VhlDiscreteUnsignedTyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitDiscreteUnsignedTy(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getDiscreteUnsignedTyImplicit() {
    return findNotNullChildByType(DISCRETE_UNSIGNED_TY_IMPLICIT);
  }

}

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

public class VhlXpiFieldImpl extends ASTWrapperPsiElement implements VhlXpiField {

  public VhlXpiFieldImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitXpiField(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VhlExpr getExpr() {
    return findChildByClass(VhlExpr.class);
  }

  @Override
  @NotNull
  public PsiElement getIdent() {
    return findNotNullChildByType(IDENT);
  }

}

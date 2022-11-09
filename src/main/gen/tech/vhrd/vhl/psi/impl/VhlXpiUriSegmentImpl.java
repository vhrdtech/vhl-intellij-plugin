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

public class VhlXpiUriSegmentImpl extends ASTWrapperPsiElement implements VhlXpiUriSegment {

  public VhlXpiUriSegmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitXpiUriSegment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VhlExprTicked getExprTicked() {
    return findChildByClass(VhlExprTicked.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentContinue() {
    return findChildByType(IDENT_CONTINUE);
  }

}

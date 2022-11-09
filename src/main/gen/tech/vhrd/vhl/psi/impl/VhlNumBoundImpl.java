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

public class VhlNumBoundImpl extends ASTWrapperPsiElement implements VhlNumBound {

  public VhlNumBoundImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitNumBound(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VhlNumBoundList getNumBoundList() {
    return findChildByClass(VhlNumBoundList.class);
  }

  @Override
  @Nullable
  public VhlNumBoundMax getNumBoundMax() {
    return findChildByClass(VhlNumBoundMax.class);
  }

  @Override
  @Nullable
  public VhlNumBoundMin getNumBoundMin() {
    return findChildByClass(VhlNumBoundMin.class);
  }

  @Override
  @Nullable
  public VhlNumUnbound getNumUnbound() {
    return findChildByClass(VhlNumUnbound.class);
  }

}

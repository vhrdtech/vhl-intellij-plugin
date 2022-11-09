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

public class VhlXpiResourceTransformImpl extends ASTWrapperPsiElement implements VhlXpiResourceTransform {

  public VhlXpiResourceTransformImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitXpiResourceTransform(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VhlXpiAccessMode getXpiAccessMode() {
    return findNotNullChildByClass(VhlXpiAccessMode.class);
  }

  @Override
  @Nullable
  public VhlXpiModObserve getXpiModObserve() {
    return findChildByClass(VhlXpiModObserve.class);
  }

  @Override
  @Nullable
  public VhlXpiModStream getXpiModStream() {
    return findChildByClass(VhlXpiModStream.class);
  }

}

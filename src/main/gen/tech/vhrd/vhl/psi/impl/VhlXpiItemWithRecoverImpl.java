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

public class VhlXpiItemWithRecoverImpl extends ASTWrapperPsiElement implements VhlXpiItemWithRecover {

  public VhlXpiItemWithRecoverImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitXpiItemWithRecover(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VhlXpiBlock getXpiBlock() {
    return findChildByClass(VhlXpiBlock.class);
  }

  @Override
  @Nullable
  public VhlXpiField getXpiField() {
    return findChildByClass(VhlXpiField.class);
  }

  @Override
  @Nullable
  public VhlXpiImpl getXpiImpl() {
    return findChildByClass(VhlXpiImpl.class);
  }

}

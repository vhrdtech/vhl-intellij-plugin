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

public class VhlXpiBlockImpl extends ASTWrapperPsiElement implements VhlXpiBlock {

  public VhlXpiBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitXpiBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VhlOuterAttr> getOuterAttrList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VhlOuterAttr.class);
  }

  @Override
  @Nullable
  public VhlXpiBody getXpiBody() {
    return findChildByClass(VhlXpiBody.class);
  }

  @Override
  @Nullable
  public VhlXpiResourceTy getXpiResourceTy() {
    return findChildByClass(VhlXpiResourceTy.class);
  }

  @Override
  @Nullable
  public VhlXpiUriSegment getXpiUriSegment() {
    return findChildByClass(VhlXpiUriSegment.class);
  }

}

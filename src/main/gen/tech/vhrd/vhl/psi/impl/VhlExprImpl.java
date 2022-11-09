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

public class VhlExprImpl extends ASTWrapperPsiElement implements VhlExpr {

  public VhlExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<VhlBinOp> getBinOpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VhlBinOp.class);
  }

  @Override
  @NotNull
  public List<VhlCallExpr> getCallExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VhlCallExpr.class);
  }

  @Override
  @NotNull
  public List<VhlIndexIntoExpr> getIndexIntoExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VhlIndexIntoExpr.class);
  }

  @Override
  @NotNull
  public List<VhlLit> getLitList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VhlLit.class);
  }

  @Override
  @NotNull
  public List<VhlPath> getPathList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VhlPath.class);
  }

  @Override
  @NotNull
  public List<VhlTy> getTyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, VhlTy.class);
  }

}

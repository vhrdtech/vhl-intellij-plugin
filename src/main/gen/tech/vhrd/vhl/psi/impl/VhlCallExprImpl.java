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

public class VhlCallExprImpl extends ASTWrapperPsiElement implements VhlCallExpr {

  public VhlCallExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitCallExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public VhlCallArguments getCallArguments() {
    return findNotNullChildByClass(VhlCallArguments.class);
  }

  @Override
  @Nullable
  public VhlIndexArguments getIndexArguments() {
    return findChildByClass(VhlIndexArguments.class);
  }

  @Override
  @NotNull
  public VhlPath getPath() {
    return findNotNullChildByClass(VhlPath.class);
  }

}

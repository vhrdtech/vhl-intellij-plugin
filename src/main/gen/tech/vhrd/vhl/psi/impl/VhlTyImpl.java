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

public class VhlTyImpl extends ASTWrapperPsiElement implements VhlTy {

  public VhlTyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitTy(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VhlArrayTy getArrayTy() {
    return findChildByClass(VhlArrayTy.class);
  }

  @Override
  @Nullable
  public VhlBoolTy getBoolTy() {
    return findChildByClass(VhlBoolTy.class);
  }

  @Override
  @Nullable
  public VhlDerive getDerive() {
    return findChildByClass(VhlDerive.class);
  }

  @Override
  @Nullable
  public VhlDiscreteTy getDiscreteTy() {
    return findChildByClass(VhlDiscreteTy.class);
  }

  @Override
  @Nullable
  public VhlFixedTy getFixedTy() {
    return findChildByClass(VhlFixedTy.class);
  }

  @Override
  @Nullable
  public VhlFloatingTy getFloatingTy() {
    return findChildByClass(VhlFloatingTy.class);
  }

  @Override
  @Nullable
  public VhlFnTy getFnTy() {
    return findChildByClass(VhlFnTy.class);
  }

  @Override
  @Nullable
  public VhlGenerics getGenerics() {
    return findChildByClass(VhlGenerics.class);
  }

  @Override
  @Nullable
  public VhlPath getPath() {
    return findChildByClass(VhlPath.class);
  }

  @Override
  @Nullable
  public VhlTextualTy getTextualTy() {
    return findChildByClass(VhlTextualTy.class);
  }

  @Override
  @Nullable
  public VhlTupleTy getTupleTy() {
    return findChildByClass(VhlTupleTy.class);
  }

}

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

public class VhlDiscreteLitImpl extends ASTWrapperPsiElement implements VhlDiscreteLit {

  public VhlDiscreteLitImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitDiscreteLit(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VhlDiscreteTy getDiscreteTy() {
    return findChildByClass(VhlDiscreteTy.class);
  }

  @Override
  @Nullable
  public PsiElement getBinLitRaw() {
    return findChildByType(BIN_LIT_RAW);
  }

  @Override
  @Nullable
  public PsiElement getDecLitRaw() {
    return findChildByType(DEC_LIT_RAW);
  }

  @Override
  @Nullable
  public PsiElement getHexLitRaw() {
    return findChildByType(HEX_LIT_RAW);
  }

  @Override
  @Nullable
  public PsiElement getOctLitRaw() {
    return findChildByType(OCT_LIT_RAW);
  }

}

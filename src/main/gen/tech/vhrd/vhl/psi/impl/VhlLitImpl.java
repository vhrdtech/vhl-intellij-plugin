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

public class VhlLitImpl extends ASTWrapperPsiElement implements VhlLit {

  public VhlLitImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull VhlVisitor visitor) {
    visitor.visitLit(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof VhlVisitor) accept((VhlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public VhlArrayLit getArrayLit() {
    return findChildByClass(VhlArrayLit.class);
  }

  @Override
  @Nullable
  public VhlBoolLit getBoolLit() {
    return findChildByClass(VhlBoolLit.class);
  }

  @Override
  @Nullable
  public VhlCharLit getCharLit() {
    return findChildByClass(VhlCharLit.class);
  }

  @Override
  @Nullable
  public VhlDiscreteLit getDiscreteLit() {
    return findChildByClass(VhlDiscreteLit.class);
  }

  @Override
  @Nullable
  public VhlFloatLit getFloatLit() {
    return findChildByClass(VhlFloatLit.class);
  }

  @Override
  @Nullable
  public VhlStringLit getStringLit() {
    return findChildByClass(VhlStringLit.class);
  }

  @Override
  @Nullable
  public VhlXpiSerial getXpiSerial() {
    return findChildByClass(VhlXpiSerial.class);
  }

}

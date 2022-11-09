// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VhlExpr extends PsiElement {

  @NotNull
  List<VhlBinOp> getBinOpList();

  @NotNull
  List<VhlCallExpr> getCallExprList();

  @NotNull
  List<VhlIndexIntoExpr> getIndexIntoExprList();

  @NotNull
  List<VhlLit> getLitList();

  @NotNull
  List<VhlPath> getPathList();

  @NotNull
  List<VhlTy> getTyList();

}

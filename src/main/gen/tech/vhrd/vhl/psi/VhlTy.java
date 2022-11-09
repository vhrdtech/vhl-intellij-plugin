// This is a generated file. Not intended for manual editing.
package tech.vhrd.vhl.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface VhlTy extends PsiElement {

  @Nullable
  VhlArrayTy getArrayTy();

  @Nullable
  VhlBoolTy getBoolTy();

  @Nullable
  VhlDerive getDerive();

  @Nullable
  VhlDiscreteTy getDiscreteTy();

  @Nullable
  VhlFixedTy getFixedTy();

  @Nullable
  VhlFloatingTy getFloatingTy();

  @Nullable
  VhlFnTy getFnTy();

  @Nullable
  VhlGenerics getGenerics();

  @Nullable
  VhlPath getPath();

  @Nullable
  VhlTextualTy getTextualTy();

  @Nullable
  VhlTupleTy getTupleTy();

}

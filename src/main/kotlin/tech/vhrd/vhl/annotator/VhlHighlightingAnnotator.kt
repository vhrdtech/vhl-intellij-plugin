package tech.vhrd.vhl.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.elementType
import tech.vhrd.vhl.VhlColors
import tech.vhrd.vhl.psi.*
import tech.vhrd.vhl.psi.VhlTypes.*

class VhlHighlightingAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (holder.isBatchMode) return
        val color = when (element) {
            is LeafPsiElement -> highlightLeaf(element, holder)
            is VhlXpiAccessMode -> VhlColors.XPI_RS_TRANSFORM
            is VhlXpiModObserve -> VhlColors.XPI_RS_TRANSFORM
            is VhlXpiModStream -> VhlColors.XPI_RS_TRANSFORM

            is VhlDiscreteTy -> VhlColors.BUILTIN_TYPE
            is VhlFixedTy -> VhlColors.BUILTIN_TYPE
            is VhlFloatingTy -> VhlColors.BUILTIN_TYPE
            is VhlTextualTy -> VhlColors.BUILTIN_TYPE
            is VhlBoolTy -> VhlColors.BUILTIN_TYPE

            is VhlXpiSerial -> VhlColors.NUMBER
            is VhlOuterAttr -> VhlColors.ATTRIBUTE
            is VhlInnerAttr -> VhlColors.ATTRIBUTE
            is VhlUnitExprTicked -> VhlColors.UNIT
            is VhlNumBound -> VhlColors.BOUND
            is VhlNumBoundBraced -> VhlColors.BOUND
            else -> null
        } ?: return

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION).textAttributes(color).create()
    }

}

private fun highlightLeaf(element: PsiElement, holder: AnnotationHolder): TextAttributesKey? {
    val parent = element.parent ?: return null
    return when (element.elementType) {
        IDENT -> highlightIdentifier(element, parent, holder)
        else -> null
    }
}

private fun highlightIdentifier(element: PsiElement, parent: PsiElement, holder: AnnotationHolder): TextAttributesKey? {
    return when (parent) {
        is VhlNamedFieldDecl -> VhlColors.STRUCT_ITEM
        is VhlEnumItem -> VhlColors.ENUM_ITEM
        is VhlXpiUriSegment -> VhlColors.XPI_URI_IDENT
        is VhlXpiResourceTransform -> VhlColors.XPI_RS_TRANSFORM
        is VhlXpiField -> VhlColors.STRUCT_ITEM
        is VhlPath -> highlightIdentifierInPath(element, parent, holder)
        else -> null
    }
}

private fun highlightIdentifierInPath(element: PsiElement, parent: PsiElement, holder: AnnotationHolder): TextAttributesKey? {
    return when (element.text) {
        "Self" -> VhlColors.KEYWORD
        "self" -> VhlColors.KEYWORD
        "super" -> VhlColors.KEYWORD
        "indexof" -> VhlColors.KEYWORD
        "autonum" -> VhlColors.KEYWORD
//        "str" -> VhlColors.KEYWORD
//        "bool" -> VhlColors.KEYWORD
        "chunks" -> VhlColors.KEYWORD
        else -> null
    }
}
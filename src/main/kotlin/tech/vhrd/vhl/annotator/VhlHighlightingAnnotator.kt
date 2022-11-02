package tech.vhrd.vhl.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.util.elementType
import tech.vhrd.vhl.VhlColors
import tech.vhrd.vhl.psi.VhlAttribute
import tech.vhrd.vhl.psi.VhlDiscreteTy
import tech.vhrd.vhl.psi.VhlEnumItem
import tech.vhrd.vhl.psi.VhlInnerAttr
import tech.vhrd.vhl.psi.VhlNamedFieldDecl
import tech.vhrd.vhl.psi.VhlOuterAttr
import tech.vhrd.vhl.psi.VhlTypes.IDENT
import tech.vhrd.vhl.psi.VhlTypes.IMPL_KW
import tech.vhrd.vhl.psi.VhlUnitExprTicked
import tech.vhrd.vhl.psi.VhlXpiAccessMode
import tech.vhrd.vhl.psi.VhlXpiModObserve
import tech.vhrd.vhl.psi.VhlXpiModStream
import tech.vhrd.vhl.psi.VhlXpiResourceTransform
import tech.vhrd.vhl.psi.VhlXpiSerial
import tech.vhrd.vhl.psi.VhlXpiUriSegment

class VhlHighlightingAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (holder.isBatchMode) return
        val color = when (element) {
            is LeafPsiElement -> highlightLeaf(element, holder)
            is VhlXpiAccessMode -> VhlColors.XPI_RS_TRANSFORM
            is VhlXpiModObserve -> VhlColors.XPI_RS_TRANSFORM
            is VhlXpiModStream -> VhlColors.XPI_RS_TRANSFORM
            is VhlDiscreteTy -> VhlColors.BUILTIN_TYPE
            is VhlXpiSerial -> VhlColors.NUMBER
            is VhlOuterAttr -> VhlColors.ATTRIBUTE
            is VhlInnerAttr -> VhlColors.ATTRIBUTE
            is VhlUnitExprTicked -> VhlColors.UNIT
            else -> null
        } ?: return

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION).textAttributes(color).create()
    }

}

private fun highlightLeaf(element: PsiElement, holder: AnnotationHolder): TextAttributesKey? {
    val parent = element.parent ?: return null
    return when (element.elementType) {
        IDENT -> highlightIdentifier(element, parent, holder)
        IMPL_KW -> VhlColors.KEYWORD
        else -> null
    }
}

private fun highlightIdentifier(element: PsiElement, parent: PsiElement, holder: AnnotationHolder): TextAttributesKey? {
    return when (parent) {
        is VhlNamedFieldDecl -> VhlColors.STRUCT_ITEM
        is VhlEnumItem -> VhlColors.ENUM_ITEM
        is VhlXpiUriSegment -> VhlColors.XPI_URI_IDENT
        is VhlXpiResourceTransform -> VhlColors.XPI_RS_TRANSFORM
        else -> null
    }
}
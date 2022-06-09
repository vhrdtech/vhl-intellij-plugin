package tech.vhrd.vhl.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import tech.vhrd.vhl.VhlColors
import tech.vhrd.vhl.psi.VhlXpiUriSegment

class VhlHighlightingAnnotator : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        val color = when (element) {
            is VhlXpiUriSegment -> VhlColors.XPI_URI_IDENT
            else -> null
        } ?: return

        holder.newSilentAnnotation(HighlightSeverity.INFORMATION).textAttributes(color).create()
    }

}
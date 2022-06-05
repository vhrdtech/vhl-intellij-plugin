package tech.vhrd.vhl.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import tech.vhrd.vhl.VhLanguage
import tech.vhrd.vhl.VhlFileType

class VhlFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, VhLanguage) {
    override fun getFileType(): FileType = VhlFileType
    override fun toString(): String = "Vhl file"
}
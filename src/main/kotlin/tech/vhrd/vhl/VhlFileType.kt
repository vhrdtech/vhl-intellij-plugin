package tech.vhrd.vhl

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile

public object VhlFileType : LanguageFileType(VhLanguage) {
    public object DEFAULTS {
        val EXTENSION = "vhl";
        val DESCRIPTION = "Vhl file";
    }

    override fun getName() = DEFAULTS.DESCRIPTION
    override fun getDescription() = DEFAULTS.DESCRIPTION
    override fun getDefaultExtension() = DEFAULTS.EXTENSION
    override fun getIcon() = VhlIcons.VHL
    override fun getCharset(file: VirtualFile, content: ByteArray) = "UTF-8"
}
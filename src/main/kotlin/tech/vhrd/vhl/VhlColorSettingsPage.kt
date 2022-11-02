package tech.vhrd.vhl

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.io.StreamUtil

class VhlColorSettingsPage : ColorSettingsPage {
    private fun d(displayName: String, key: TextAttributesKey) = AttributesDescriptor(displayName, key)
    private val ATTRS = arrayOf(
        d("Key", VhlColors.KEYWORD),
        d("String", VhlColors.STRING),
        d("Number", VhlColors.NUMBER),
        d("Boolean", VhlColors.BOOLEAN),
        d("Line comment", VhlColors.EOL_COMMENT),
        d("Block comment", VhlColors.BLOCK_COMMENT),
        d("Doc comment", VhlColors.DOC_COMMENT),
        d("Brackets", VhlColors.BRACKETS),
        d("Braces", VhlColors.BRACES),
        d("Comma", VhlColors.COMMA),
        d("xPI path", VhlColors.XPI_URI_IDENT),
        d("xPI transform", VhlColors.XPI_RS_TRANSFORM),
    )

    // This tags should be kept in sync with RustAnnotator highlighting logic
    private val DEMO_TEXT by lazy {
        val stream = javaClass.classLoader.getResourceAsStream("tech/vhrd/vhl/colorscheme/highlighterDemoText.vhl")
        StreamUtil.readText(stream, "UTF-8")
    }

    override fun getDisplayName() = "Vhl"
    override fun getIcon() = VhlIcons.VHL
    override fun getAttributeDescriptors() = ATTRS
    override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY
    override fun getHighlighter() = VhlHighlighter()
    override fun getAdditionalHighlightingTagToDescriptorMap() = null
    override fun getDemoText() = DEMO_TEXT
}
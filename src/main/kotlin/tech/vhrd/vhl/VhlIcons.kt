package tech.vhrd.vhl

import com.intellij.icons.AllIcons
import com.intellij.openapi.util.IconLoader
import com.intellij.ui.LayeredIcon
import com.intellij.ui.RowIcon
import com.intellij.util.PlatformIcons
import com.intellij.util.ui.EmptyIcon
import javax.swing.Icon

public object VhlIcons {

    public val VHL = IconLoader.getIcon("/icons/toml.png", VhlIcons.javaClass)
//    public val VHL_BIG = IconLoader.getIcon("/org/toml/lang/icons/toml@2x.png")

    public val MODULE   = AllIcons.Nodes.Package

    public val TRAIT    = AllIcons.Nodes.Interface
    public val CLASS    = AllIcons.Nodes.Class
    public val IMPL     = AllIcons.Nodes.AbstractClass
    public val ENUM     = AllIcons.Nodes.Enum

    public val FIELD    = AllIcons.Nodes.Field
    public val FUNCTION = AllIcons.Nodes.Function
    public val METHOD   = AllIcons.Nodes.Method

    public val ABSTRACT_METHOD = AllIcons.Nodes.AbstractMethod

    public val STATIC_MARK  = AllIcons.Nodes.StaticMark
    public val TEST_MARK    = AllIcons.Nodes.JunitTestMark
}

fun Icon.addStaticMark(): Icon {
    return LayeredIcon(this, VhlIcons.STATIC_MARK);
}

fun Icon.addTestMark(): Icon {
    return LayeredIcon(this, VhlIcons.TEST_MARK);
}

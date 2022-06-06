package tech.vhrd.vhl

import com.intellij.icons.AllIcons
import com.intellij.openapi.util.IconLoader
import com.intellij.ui.LayeredIcon
import com.intellij.ui.RowIcon
import com.intellij.util.PlatformIcons
import com.intellij.util.ui.EmptyIcon
import javax.swing.Icon

object VhlIcons {

    val VHL = IconLoader.getIcon("/icons/icon.png", VhlIcons.javaClass)
//    public val VHL_BIG = IconLoader.getIcon("/org/toml/lang/icons/toml@2x.png")

    val MODULE   = AllIcons.Nodes.Package

    val TRAIT    = AllIcons.Nodes.Interface
    val CLASS    = AllIcons.Nodes.Class
    val IMPL     = AllIcons.Nodes.AbstractClass
    val ENUM     = AllIcons.Nodes.Enum

    val FIELD    = AllIcons.Nodes.Field
    val FUNCTION = AllIcons.Nodes.Function
    val METHOD   = AllIcons.Nodes.Method

    val ABSTRACT_METHOD = AllIcons.Nodes.AbstractMethod

    val STATIC_MARK  = AllIcons.Nodes.StaticMark
    val TEST_MARK    = AllIcons.Nodes.JunitTestMark
}

//fun Icon.addStaticMark(): Icon {
//    return LayeredIcon(this, VhlIcons.STATIC_MARK);
//}
//
//fun Icon.addTestMark(): Icon {
//    return LayeredIcon(this, VhlIcons.TEST_MARK);
//}

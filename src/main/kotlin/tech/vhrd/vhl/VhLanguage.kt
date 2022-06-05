package tech.vhrd.vhl
import com.intellij.lang.Language

object VhLanguage : Language("Vhl", "text/vhl") {
    override fun isCaseSensitive() = true
}
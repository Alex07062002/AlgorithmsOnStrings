import KMP.KMP
import ZBlocks.Zblocks

fun main(args: Array<String>) {
    KMP().searchInputKMP("abababababababababccccccabababab","abc").forEach { print("$it ") }
   // Zblocks().suffixBorderArray("ababa").forEach{print("$it ")}
}
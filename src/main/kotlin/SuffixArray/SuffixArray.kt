package SuffixArray

data class Suffix(
    var index: Int, // начальная позиция суффикса в исходной строке
    var suffix: String // суффикс строки
)


class SuffixArray {

fun buildSuffixArray(str: String, n: Int) {
    val suffixes = Array(n) { Suffix(0, "") }
    for (i in 0..< n) {
        suffixes[i].index = i
        suffixes[i].suffix = str.substring(i, n)
    }
    suffixes.sortWith(compareBy{ it.suffix })
    for (i in 0 ..< n) {
        println("${suffixes[i].index} ")
    }
}
}
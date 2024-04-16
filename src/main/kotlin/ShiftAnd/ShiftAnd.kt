package ShiftAnd

//используется для поиска вхождений подстроки в тексте. основан на битовых операциях. использует эфективные побитовые операции.
class ShiftAnd {

   /* fun shiftAnd(pattern : String, text : String) : Int { // FIXME check workability -> need fixed
        val lengthText = text.length
        val lengthPattern = pattern.length
        val startCharacter = '0'
        val endCharacter = 'z'
        val lengthAlphabet = endCharacter-startCharacter+1
        val arrayIncluded = IntArray(lengthAlphabet){0}

        for (j in 0..< lengthPattern) arrayIncluded[pattern[j] - startCharacter] =
                arrayIncluded[pattern[j] - startCharacter] or (1 shl lengthPattern - 1 - j)
        val higherDigit = 1 shl lengthPattern - 1 // Константа для установки 1 в старший разряд
        var checkIncluded = 0

        for (j in 0..<lengthText){
            checkIncluded =(checkIncluded shr 1 or higherDigit) and arrayIncluded[text[j]-startCharacter]
            if (checkIncluded > 1){
                return j-lengthPattern+1
            }
        }
        return -1
    }
*/
    // search substring
    fun SearchString(text: String, pattern: String): Int { //FIXME Don't effective
        val m: Int = pattern.length
        var R: Int
        val patternMask = IntArray(128)
        var i: Int
        if (pattern.isEmpty()) return 0
        R = 1.inv()
        i = 0
       //init mask matrix
        while (i <= 127) {
            patternMask[i] = 0.inv()
            ++i
        }
        i = 0
       // stand bit in mask for each symbol
        while (i < m) {
            patternMask[pattern[i].code] = patternMask[pattern[i].code] and (1 shl i).inv()
            ++i
        }
        i = 0
       //serach substring in text
        while (i < text.length) {
            R = R or patternMask[text[i].code]
            R = R shl 1
            if (0 == R and (1 shl m)) return i - m + 1
            ++i
        }
        return -1
    }


  /*  fun shiftAndFz(pattern: String, text : String) : Int { //FIXME add some code
        val lengthText = text.length
        val lengthPattern = pattern.length
        val startCharacter = '0'
        val endCharacter = 'z'
        val lengthAlphabet = endCharacter-startCharacter+1
        val arrayIncluded = IntArray(lengthAlphabet){0}
        for (i in 0..<lengthPattern) arrayIncluded[pattern[i]-startCharacter] += 1 shl (lengthPattern-1-i)
        val higherDigit = 1 shl (lengthPattern-1)
        var checkIncluded = 0

        return -1
    }*/
}


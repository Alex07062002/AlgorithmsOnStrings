package SuffixTreeUkkonen


    private class Node {
        var sub = "" // a substring of the input string
        var ch: MutableList<Int> = ArrayList() // list of child nodes
    }

    class SuffixTree(str: String) {
        private val nodes: MutableList<Node> = ArrayList()

        init {
            nodes.add(Node())
            for (i in str.indices) {
                addSuffix(str.substring(i))
            }
        }

        private fun addSuffix(suf: String) {
            var n = 0
            var i = 0
            while (i < suf.length) {
                val b = suf[i]
                val children = nodes[n].ch
                var x2 = 0
                var n2: Int
                while (true) {
                    if (x2 == children.size) {
                        // no matching child, remainder of suf becomes new node.
                        n2 = nodes.size
                        val temp = Node()
                        temp.sub = suf.substring(i)
                        nodes.add(temp)
                        children.add(n2)
                        return
                    }
                    n2 = children[x2]
                    if (nodes[n2].sub[0] == b) break
                    x2++
                }
                // find prefix of remaining suffix in common with child
                val sub2 = nodes[n2].sub
                var j = 0
                while (j < sub2.length) {
                    if (suf[i + j] != sub2[j]) {
                        // split n2
                        val n3 = n2
                        // new node for the part in common
                        n2 = nodes.size
                        val temp = Node()
                        temp.sub = sub2.substring(0, j)
                        temp.ch.add(n3)
                        nodes.add(temp)
                        nodes[n3].sub = sub2.substring(j) // old node loses the part in common
                        nodes[n].ch[x2] = n2
                        break // continue down the tree
                    }
                    j++
                }
                i += j // advance past part in common
                n = n2 // continue down the tree
            }
        }

        fun visualize() {
            if (nodes.isEmpty()) {
                println("")
                return
            }
            visualizeF(0, "")
        }

        private fun visualizeF(n: Int, pre: String) {
            val children: List<Int> = nodes[n].ch
            if (children.isEmpty()) {
                println("- " + nodes[n].sub)
                return
            }
            println("+ " + nodes[n].sub)
            for (i in 0..<children.size - 1) {
                val c = children[i]
                print("$pre+-")
                visualizeF(c, "$pre|")
            }
            print("$pre+-")
            visualizeF(children[children.size - 1], "$pre  ")
        }
    }
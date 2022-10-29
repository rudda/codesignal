import kotlin.collections.*

/**
 * @author: Ruddá Beltrão
 * @email: beltrao.rudah@gmail.com
 */

class Graph {
  lateinit var mNodes: HashMap<Int, Graph.Node>

  init {
    mNodes = HashMap<Int, Graph.Node>()
  }

  fun getNode(id: Int): Graph.Node = mNodes.get(id)!!
  
  fun add(value: Int) {
    //println("Adding $value ")
    mNodes.put(value, Graph.Node(value))
  }
  
  fun addChilds(parent: Int, child : Int)  {
    val parentNode = getNode(parent)
    val childNode = getNode(child)
    parentNode?.childs?.add(childNode!!)
  }

  /**
   * @description it is a recursive function that inspect node by node
   *            with childs if there`s a correspondent search
   * DFS means Depth First Search 
   * for more details check the following video at youtube
   * https://www.youtube.com/watch?v=zaBhtODEL0w&t=548s
   */
  fun hasPathDFS( source : Int,  destination : Int) : Boolean {
    val sourceNode = getNode(source)
    val destNode = getNode(destination)
    var visited = HashSet<Int>()

    return hasPathDFS(sourceNode, destNode, visited)
  }

  private fun hasPathDFS( sourceNode : Graph.Node,  
                          destNode : Graph.Node,  
                          visited : HashSet<Int>) : Boolean {

     if( visited.contains(sourceNode.id))  return false 
     visited.add(sourceNode.id)

     if(sourceNode.id == destNode.id) return true

     sourceNode.childs.forEach {
        if(hasPathDFS(it, destNode, visited)) {
          return true
        }
     }
     return false
  }
  
// begin BFS
// busca por camadas ou por lagura do node
  fun hasPathBFS( source : Int,  destination : Int) : Boolean {
    val sourceNode = getNode(source)
    val destNode = getNode(destination)
    return hasPathBFS(sourceNode, destNode)
  }

  private fun hasPathBFS( sourceNode : Graph.Node, destNode : Graph.Node) : Boolean {
    var visited = HashSet<Int>()
    var myNodeList = ArrayList<Graph.Node>()
    myNodeList.add(sourceNode)
    var layers = 0
    while( myNodeList.isNotEmpty()) {
      layers += 1
      var parent = myNodeList.removeAt(0)

      if( parent.id == destNode.id) {
        print("layers: $layers") 
        return true
      } 
      
      if(visited.contains(sourceNode.id)) continue
      visited.add(parent.id)

      parent.childs.forEach {
        myNodeList.add(it)
      }
    }
    print("layers: $layers")          
    return false               
  }

  // inner, sealed, nested
  class Node(val  id : Int)  {
    lateinit var childs: ArrayList<Node>
    
    init {
      childs = ArrayList<Node>()
    }
  }
}


fun addNodes(graph : Graph) {
  for (i in 0..200) {
    graph.add(i)
  }
}

// fun add Childs(layers: Int, node : Int) {
//   var last = 201
  
//   for ( i in 0..layers) {

//     for( j in 0 .. 5) {
//       val child = 
//     }

//   }
// }

fun main() {
  var myGraph = Graph()
  addNodes(myGraph)

  myGraph.addChilds(1, 2)
  myGraph.addChilds(2, 3)
  myGraph.addChilds(3, 4)
  myGraph.addChilds(4, 5)
  myGraph.addChilds(5, 6)
  myGraph.addChilds(6, 7)
  myGraph.addChilds(6, 8)
  myGraph.addChilds(6, 9)
  myGraph.addChilds(6, 10)

  print(myGraph.hasPathBFS(1,100))
}
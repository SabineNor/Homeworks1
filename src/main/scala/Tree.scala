object Tree extends App {
  val height = args(0).toInt
  var blankSpace = height - 1
  var fillIn = 1
  for(i<- 0 until height) {
    println(" " * blankSpace + "*" * fillIn + " " * blankSpace)
    blankSpace -= 1
    fillIn += 2}
}

import java.io.FileWriter

val filename = "C:\\Users\\tobia\\IdeaProjects\\GutenbergRecipes.txt"
//for (line <- Source.fromFile(filename).getLines.mkString) {
def openSource(fName: String) = {
  val filePointer = scala.io.Source.fromFile(filename)
  val myLines = filePointer.getLines.toSeq
  filePointer.close()
  myLines
}
val openAndZipped = openSource(filename).zipWithIndex
val start = openAndZipped.filter(t => t._1 == "Recipes Specially Prepared _by_ Miss Elizabeth Kevill Burr").map(t => t._2).mkString.toInt
val end = openAndZipped.filter(t=> t._1 == "cut in short lengths and wrap in waxed paper.").map(t=> t._2).mkString.toInt
val reduced = openSource(filename).slice(start, end).zipWithIndex

val titles = reduced.filter(n=> n._1 == n._1.toUpperCase && n._1.length > 0)
val ingredients = reduced.filter (p => p._1.startsWith("    "))
val x = titles ++ ingredients
val sortedx = x.sortBy(f=>f._2)
println(sortedx)


def saveSeq(destName:String, mySeq:Seq[String]) = {
  println(s"Saving my Sequence to file $destName")
  scala.util.Success
  mySeq.foreach(println) //we are good up to here
  val fw = new FileWriter(destName)
  mySeq.map(_ + "\n").foreach(fw.write) // adding new line to each line before writing
  fw.close()}







//reduced.filter(n=> n.startsWith("    ")).

//for (i<- reduced) {
//  if (i == i.toUpperCase && i.length >1) {


 // }
//}
//
//val startRec = reduced.zipWithIndex.filter(n => n._1 == n._1.toUpperCase && n._1.length > 1).map(n => n._2).toSeq
//val Rec = reduced.zipWithIndex.filter(m=>m._1.startsWith("    ") && m._1.endsWith(".")).map(m=>m._2+1).toSeq

//for (i<- 0 to endRec.length){
 // var x = reduced.slice(startRec(i), endRec(i))
//println(x)







//val endingSeq = opened.zipWithIndex.filter(t => t._1.startsWith("    ") && t._1.endsWith(".")).map(t => t._2).toSeq
//val startingSeq =
//val t = opened.foreach(n=>n.splitAt(punctuation(0))
////for (i<-opened) {
  //val t = opened.splitAt(endingSeq(0))
//println(t)









//val recipe = opened.filter(t => t == t.toUpperCase() && t!= t.isEmpty)

//val Upper = opened.contains(U)
//Upper.foreach(println)




//val x = lines.filter(t=> t == t.toUpperCase())





//def openSource(fName:String) = {
 // val filePointer = Source.fromFile(filename)
  //val myLines = filePointer.getLines.toSeq
  //filePointer.close()
  //myLines
//}
//def openSource(fName:String) = {
  //var text = Seq[String]()
  //try{
    //val filePointer = scala.io.Source.fromFile(filename)
    //val myLines = filePointer.getLines()
    //text = myLines.toSeq
    //filePointer.close()
 // }}



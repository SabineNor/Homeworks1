import java.io.FileWriter

import scala.io.Source

object CookBook1 extends App{
  val srcName = "C:\\Users\\tobia\\IdeaProjects\\GutenbergRecipes.txt"
  val dstName = "C:\\Users\\tobia\\IdeaProjects\\GutenbergRecipes_cut.txt"

  def openSource(fName: String) = {
    val filePointer = Source.fromFile(srcName)
    val myLines = filePointer.getLines.toSeq
    filePointer.close()
    myLines
  }
  def processSeq(mySeq:Seq[String])= {
    // reduced .txt for filtering
    val openAndZipped = mySeq.zipWithIndex
    val start = openAndZipped.filter(t => t._1 == "Recipes Specially Prepared _by_ Miss Elizabeth Kevill Burr").map(t => t._2).mkString.toInt
    val end = openAndZipped.filter(t => t._1 == "cut in short lengths and wrap in waxed paper.").map(t => t._2).mkString.toInt
    val reduced = mySeq.slice(start, end).zipWithIndex
    val titles = reduced.filter(n=> n._1 == n._1.toUpperCase && n._1.length > 0)
    val ingredients = reduced.filter(p => p._1.startsWith("    "))
    val recipes = titles ++ ingredients
    val sortedRecipes = recipes.sortBy(f => f._2).map(t=> t._1)
    sortedRecipes}

  def saveSeq(destName:String, mySeq:Seq[String]) = {
    println(s"Saving my Sequence to file $destName")
    scala.util.Success
    mySeq.foreach(println) //we are good up to here
    val fw = new FileWriter(destName)
    mySeq.map(_ + "\n").foreach(fw.write) // adding new line to each line before writing
    fw.close()
  }
  val mySeq = openSource(srcName)
  val filteredSeq = processSeq(mySeq)
  saveSeq(dstName,filteredSeq)



}

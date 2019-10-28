package lectures.part1basics

object  DefaultArgs extends App {

  /**
    *
    * @param n
    * @param accumulator - default accumulator = 1
    * @return
    */
  def trFactorial(n: Int, accumulator: Int = 1): Int = {
    if(n <=1) accumulator
    else trFactorial(n-1, n* accumulator)
  }

  var fact = trFactorial(10)
  var factorWithAccParam = trFactorial(5, 1)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = print("saving picture...")
  savePicture()
  savePicture("png")
  savePicture(width = 800)

  savePicture(height = 600, width = 600, format = "bmp")

}

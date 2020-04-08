package za.co.absa.spline.producer.model

case class Operations(
  write: WriteOperation,
  reads: Seq[ReadOperation] = Nil,
  other: Seq[DataOperation] = Nil) {

  def all: Seq[OperationLike] = reads ++ other :+ write
}

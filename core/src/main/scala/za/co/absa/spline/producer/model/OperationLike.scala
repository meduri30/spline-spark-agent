package za.co.absa.spline.producer.model

sealed trait OperationLike {
  val id: Int
  val childIds: Seq[Int]
  val schema: Option[Any]
  val params: Map[String, Any]
  val extra: Map[String, Any]
}

case class ReadOperation(
                          inputSources: Seq[String],
                          override val id: Int,
                          override val schema: Option[Any] = None,
                          override val params: Map[String, Any] = Map.empty,
                          override val extra: Map[String, Any] = Map.empty
                        ) extends OperationLike {
  override val childIds: Seq[Int] = Seq.empty // Read operation is always a terminal node in a DAG
}

case class WriteOperation(
                           outputSource: String,
                           append: Boolean,
                           override val id: Int,
                           override val childIds: Seq[Int],
                           override val params: Map[String, Any] = Map.empty,
                           override val extra: Map[String, Any] = Map.empty
                         ) extends OperationLike {
  override val schema: Option[Any] = None // Being a side-effect only, Write operation never changes the schema
}

case class DataOperation(
                          override val id: Int,
                          override val childIds: Seq[Int] = Seq.empty,
                          override val schema: Option[Any] = None, // None means that that the schema is either the same as in the child operation, or unknown.
                          override val params: Map[String, Any] = Map.empty,
                          override val extra: Map[String, Any] = Map.empty
                        ) extends OperationLike
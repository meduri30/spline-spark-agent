package za.co.absa.spline.producer.model

import java.util.UUID

case class ExecutionEvent(
  planId: UUID,
  timestamp: Long,
  error: Option[Any] = None,
  extra: Map[String, Any] = Map.empty
)
